package net.voxiot.voxpgmlite.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import net.voxiot.voxpgmlite.R;
import net.voxiot.voxpgmlite.database.Database;
import net.voxiot.voxpgmlite.model.Device;


import java.util.ArrayList;
import java.util.Objects;

public class BottomSheetDialog extends com.google.android.material.bottomsheet.BottomSheetDialog {
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    TextView output1;
    TextView output2;
    TextView output3;
    TextView output4;
    TextView output5;
    TextView output6;
    TextView output7;
    TextView output8;
    TextView nameDevice;
    TextView outputname1;
    private View btnCloseSheet;
    private Context context;
    private int code;
    private int theme;
    private int color;


    public BottomSheetDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public BottomSheetDialog(@NonNull Context context, int theme) { super(context, theme); }

    protected BottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    /** Custom contructor for get codigo from caller class */
    public BottomSheetDialog(Context context, int code, int theme, int color){
        super(context);
        this.context = context;
        this.code = code;
        this.theme = theme;
        this.color = color;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Database db = new Database(context);
        Device dev = db.selectDevice(code);
        init();

        nameDevice.setText(dev.getName());
        final ArrayList<TextView> list = new ArrayList<TextView>();
        list.add(output1);
        list.add(output2);
        list.add(output3);
        list.add(output4);
        list.add(output5);
        list.add(output6);
        list.add(output7);
        list.add(output8);

        final TextView[] output = {output1,output2,output3,output4,output5,output6,output7,output8};
        final int[] listArray = {
                dev.getStatusOutput1(), dev.getStatusOutput2(),dev.getStatusOutput3(),dev.getStatusOutput4(),
                dev.getStatusOutput5(), dev.getStatusOutput5(),dev.getStatusOutput7(),dev.getStatusOutput8()};
        final String[] nameArray = {
                dev.getNameOutput1(), dev.getNameOutput2(),dev.getNameOutput3(),dev.getNameOutput4(),
                dev.getNameOutput5(), dev.getNameOutput6(),dev.getNameOutput7(),dev.getNameOutput8()};
        final ImageView[] img = {image1,image2,image3,image4,image5,image6,image7,image8};
        final String[] icon = {dev.getIcon1(),dev.getIcon2(),dev.getIcon3(),dev.getIcon4(),dev.getIcon5(),
                dev.getIcon6(),dev.getIcon7(),dev.getIcon8(),};

        /* Get eatch outputs states available and filter that was enableds*/
        int y= 0;
        for (int value : listArray){
            if(value == 1) {
                img[y].setVisibility(View.VISIBLE);
                img[y].setImageResource(switchImg(icon[y]));
                list.get(y).setVisibility(View.VISIBLE);
                list.get(y).setText(nameArray[y]);
                ++y;
            }
        }


        if(dev.getQty() == 0){
            output1.setVisibility(View.VISIBLE);
            output1.setText(R.string.nenhuma_saida_ativada);
            output1.setTextSize(2,22);
            image1.setVisibility(View.VISIBLE);
            image1.setImageResource(R.drawable.ic_baseline_remove_circle_outline_24);
        }



    }

    private View.OnClickListener output1Click1 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 1 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click2 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 2 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click3 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 3 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click4 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 4 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click5 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 5 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click6 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 6 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click7 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 7 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener output1Click8 = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            Toast.makeText(context.getApplicationContext(),"Saída 8 Clicada!", Toast.LENGTH_SHORT).show();
        }
    };



    private View.OnClickListener closeSheet = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dismiss();

        }
    };


    private void init() {
        nameDevice = findViewById(R.id.textnameDevice);
        outputname1 = findViewById(R.id.editNameDevice1);
        btnCloseSheet = findViewById(R.id.btnClosesheet);
        Objects.requireNonNull(btnCloseSheet).setOnClickListener(closeSheet);
        image1 = findViewById(R.id.imgdevice1);
        image2 = findViewById(R.id.imgdevice2);
        image3 = findViewById(R.id.imgdevice3);
        image4 = findViewById(R.id.imgdevice4);
        image5 = findViewById(R.id.imgdevice5);
        image6 = findViewById(R.id.imgdevice6);
        image7 = findViewById(R.id.imgdevice7);
        image8 = findViewById(R.id.imgdevice8);


        output1 = findViewById(R.id.textOutput1);
        output2 = findViewById(R.id.textOutput2);
        output3 = findViewById(R.id.textOutput3);
        output4 = findViewById(R.id.textOutput4);
        output5 = findViewById(R.id.textOutput5);
        output6 = findViewById(R.id.textOutput6);
        output7 = findViewById(R.id.textOutput7);
        output8 = findViewById(R.id.textOutput8);

        output1.setOnClickListener(output1Click1);
        output2.setOnClickListener(output1Click2);
        output3.setOnClickListener(output1Click3);
        output4.setOnClickListener(output1Click4);
        output5.setOnClickListener(output1Click5);
        output6.setOnClickListener(output1Click6);
        output7.setOnClickListener(output1Click7);
        output8.setOnClickListener(output1Click8);
    }

    private int switchImg(String ico){
        int icon = 0;
        switch (ico){
            case "Lâmpada": icon = R.drawable.ic_baseline_wb_incandescent_24;
                return icon;

            case "Serviço": icon = R.drawable.ic_baseline_room_service_24;
                return icon;

            case "Ar Condicionado": icon = R.drawable.ic_ac_unit_black_24dp;
                return icon;

            case "Ligar": icon = R.drawable.ic_power_black_18dp;
                return icon;

            case "Semáfaro": icon = R.drawable.ic_baseline_traffic_24;
                return icon;

            case "Dispositivo Elétrico": icon = R.drawable.ic_electrical_services_black_18dp;
                return icon;

            case "Flash": icon = R.drawable.ic_baseline_flash_on_24;
                return icon;

            case "Bateria Carregada": icon = R.drawable.ic_baseline_battery_charging_full_24;
                return icon;

            case "": default : icon = R.drawable.ic_baseline_remove_circle_outline_24;
                return icon;
        }
    }


}
