package net.voxiot.voxpgmlite.Adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.voxiot.voxpgmlite.R;
import net.voxiot.voxpgmlite.model.Device;

import java.util.ArrayList;

public class ListsAdapter extends BaseAdapter {

    private  Context context;
    private static ArrayList<Device> devices;


    public ListsAdapter(Context context, ArrayList<Device> devices) {
        this.context = context;
        ListsAdapter.devices = devices;

    }

    @Override
    public int getCount() {
        return devices.size();
    }


    @Override
    public Object getItem(int position) {
        return devices.get(position);
    }


    /** Stable IDs allow the ListView to optimize for the case when items remain the same between notifyDataSetChanged calls.
     * The IDs it refers to are the ones returned from getItemId. */
    @Override
    public boolean hasStableIds() {
        return true;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }


    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null){
            convertView = View.inflate(context, R.layout.list_items2, null);
        }

        TextView codigo = convertView.findViewById(R.id.item_codigo);
        TextView name  = convertView.findViewById(R.id.item_name2);
        TextView outputsQty  = convertView.findViewById(R.id.item_status2);

        Device device = devices.get(position);
        codigo.setId(device.getCodigo());
        name.setText(device.getName());
        outputsQty.setText("Acionamentos: " + device.getQty());


        return convertView;
    }

}
