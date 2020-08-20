package net.voxiot.voxpgmlite.app;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import net.voxiot.voxpgmlite.Adapters.ListsAdapter;
import net.voxiot.voxpgmlite.Adapters.RecyclerAdapter;
import net.voxiot.voxpgmlite.Adapters.SwipeToDeleteCallback;
import net.voxiot.voxpgmlite.R;
import net.voxiot.voxpgmlite.connection.CheckNetwork;
import net.voxiot.voxpgmlite.database.Database;
import net.voxiot.voxpgmlite.model.Device;
import java.util.ArrayList;
import java.util.List;

import static net.voxiot.voxpgmlite.connection.CheckNetwork.isConnected;


public class MainActivity extends AppCompatActivity {
    Database db = new Database(this);
    Context context = MainActivity.this;
    private RecyclerView recyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    BottomSheetDialog mBottomDialogNotificationAction;
    private ListView listView;
    private ArrayList<Device> devices;
    private ListsAdapter listsAdapter;
    private View btnInputDevice;
    static int codigo = -1;
    RelativeLayout relativeLayout;
    private boolean mItemPressed = false;
    private boolean itemReturned = false;
    int Permission_All = 1;
    public static final int PERMISSION_CODE = 3;
    String[] Permissions = { Manifest.permission.INTERNET };//internet options permission alread able for default.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listDevices();
        enableSwipeToDeleteAndUndo();
        btnInputDevice = findViewById(R.id.btnInputdevice);

        /* Insert Mode activation to add device */
        btnInputDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(), CadastroDevices.class);
                String cadastrar = "Cadastrar";
                i.putExtra("Title", cadastrar);
                startActivity(i);
            }
        });

    }

    /* Inition ids from xmls */
    private void init() {
        relativeLayout = findViewById(R.id.relativeLayout);
        recyclerView = findViewById(R.id.deviceList);
        recyclerView.setHasFixedSize(true);
    }

    /* Load devices list from DB */
    void listDevices() {
        final ArrayList<Device> devices = new ArrayList<>();

        List<Device> dev = db.listAllDevices();
        for (Device d : dev) {
            devices.add(d);
        }
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new RecyclerAdapter(devices);

        /* Open Botton sheet with item selected form recycleview */
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                codigo = devices.get(recyclerView.getChildAdapterPosition(v)).getCodigo();
                if (mItemPressed) {
                    // Multi-item swipes not handled
                    return;
                }
                Device device = db.selectDevice(codigo);
                showDialogNotificationAction(device,codigo);
            }
        });

        /* Open Editable Activity, sending Extra info to Activity about its your new state*/
        mAdapter.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
           codigo = devices.get(recyclerView.getChildAdapterPosition(v)).getCodigo();
                Intent i= new Intent(getApplicationContext(), CadastroDevices.class);
                String editar = "Editar";
                i.putExtra("Title", editar);
                i.putExtra("Codigo", codigo);
                startActivity(i);
                finish();
                return false;
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    /* Delete item from Recycle view and undo if until 3 seconds */
    private void enableSwipeToDeleteAndUndo () {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                final int position = viewHolder.getAdapterPosition();
                final Device item = mAdapter.getData().get(position);
                mAdapter.removeItem(position);
                Snackbar snackbar = Snackbar
                        .make(relativeLayout, "O item foi removido da lista.", Snackbar.LENGTH_LONG);
                snackbar.setAction("Cancelar", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        itemReturned = true;
                        mAdapter.restoreItem(item, position);
                        recyclerView.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();
                codigo = item.getCodigo();
                handler.postAtTime(runnable, System.currentTimeMillis()+interval);
                handler.postDelayed(runnable, interval);

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(recyclerView);
    }
    private final int interval = 3000; // 3 Second
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable(){
        public void run() {
            if(!itemReturned) {
                db.deleteDevice(codigo);
                listDevices();
                itemReturned = false;
            }
        }
    };

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder  = builder.setMessage( "Deseja encerrar o aplicativo mesmo ?" );
        builder.setTitle( "Encerrando o aplicativo..." )
                .setCancelable( false )
                .setNegativeButton( "cancelado", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton( "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            System.exit(0);
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                });

        AlertDialog alertDialog = builder . create () ;
        alertDialog.show();

    }

    /* Instaciate  Bottom dialog_bottom_notification_action about device has taped. */
    private void showDialogNotificationAction(Device device, int codigo) {
        try {
            View sheetView = this.getLayoutInflater().inflate(R.layout.bottom_sheet_dialog, null);
            mBottomDialogNotificationAction = new BottomSheetDialog(MainActivity.this, codigo,0,0);
            mBottomDialogNotificationAction.setContentView(sheetView);
            mBottomDialogNotificationAction.show();

            // Remove default white color background
            FrameLayout bottomSheet = mBottomDialogNotificationAction.findViewById(R.id.design_bottom_sheet);
            if (bottomSheet != null) {
                bottomSheet.setBackground(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!hasPhonePermissions( this, Permissions )) {
                ActivityCompat.requestPermissions( this,Permissions,Permission_All = 1 );
            }
        }

        hasInternet();



    }

    public void hasInternet() {
        // Register Callback - Call this in your app start!
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            CheckNetwork network = new CheckNetwork(getApplicationContext());
            network.registerNetworkCallback();
        }
        if (Build.VERSION_CODES.M >= Build.VERSION.SDK_INT) {
            CheckNetwork network = new CheckNetwork(getApplicationContext());
            network.checkConnection();
        }

        // Check network connection
        if (!(isConnected)){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder  = builder.setMessage( "Não ha conexão com a internet !" );
            builder.setTitle( "Conexão com a Internet" )
                    .setCancelable( false )
                    .setPositiveButton( "Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                //Ok
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }
                        }
                    });

            AlertDialog alertDialog = builder . create () ;
            alertDialog.show();
        }
    }


    @SuppressLint("InlinedApi")
    private static boolean hasPhonePermissions(Context context, String... permissions) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null){
            for(String permission: permissions){
                if(ActivityCompat.checkSelfPermission( context, permission ) != PackageManager.PERMISSION_GRANTED){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PERMISSION_CODE){
            if(grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText( MainActivity.this, "Permissão aceita" , Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText( MainActivity.this, "Permissão negada" , Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


}