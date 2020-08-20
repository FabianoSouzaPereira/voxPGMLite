package net.voxiot.voxpgmlite.connection;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.telecom.Connection;

import androidx.annotation.RequiresApi;

public class CheckNetwork extends Activity {
  //  public static NetworkInfo rede = null;
    public static boolean isConnected = false;
    public static boolean isWiFi = false;
    public static boolean isWiMax = false;
    public static boolean isBlueTooth = false;
    private final Context context;

    public CheckNetwork(Context context) {
        this.context = context;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            registerNetworkCallback();
        }

    }

    // Network Check
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void registerNetworkCallback() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkRequest.Builder builder = new NetworkRequest.Builder();

            if (connectivityManager != null) {
                connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback(){
                   @Override
                   public void onAvailable(Network network) {
                       isConnected = true; // Global Static Variable
                   }
                   @Override
                   public void onLost(Network network) {
                       isConnected = false; // Global Static Variable
                   }
               }

                );
            }
            isConnected= false;
        }catch (Exception e){
            isConnected = false;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void checkConnection() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }
        isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }
}
