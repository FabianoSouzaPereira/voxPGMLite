package net.voxiot.voxpgmlite.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.voxiot.voxpgmlite.R;
import net.voxiot.voxpgmlite.model.Device;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewholderDevices>
    implements  View.OnClickListener, View.OnTouchListener, View.OnLongClickListener{

    private View.OnClickListener clicklistener;
    private View.OnTouchListener touchListener;
    private View.OnLongClickListener longClickListener;
    private List<Device> devices;
    private Context context;

    public RecyclerAdapter(List<Device> devices) {
        this.devices = devices;
    }


    @NonNull
    @Override
    public ViewholderDevices onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items2,parent,false);
        view.setOnClickListener(this);
        view.setOnTouchListener(this);
        view.setOnLongClickListener(this);
        return new ViewholderDevices(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewholderDevices viewholder, int position) {
            Device device = devices.get(position);
            viewholder.codigo.setId(device.getCodigo());
            viewholder.name.setText(device.getName());
            viewholder.outputsQty.setText("Quantidade de saídas: " + device.getQty());
    }


    @Override
    public int getItemCount() {
        return devices.size();
    }

    public void setOnClickListener(View.OnClickListener clicklistener){
        this.clicklistener = clicklistener;
    }
    public void setOnTouchListener(View.OnTouchListener touchListener){
        this.touchListener = touchListener;
    }
    public void setOnLongClickListener(View.OnLongClickListener longClickListener){
        this.longClickListener = longClickListener;
    }

    @Override
    public void onClick(View v) {
        if(clicklistener != null){
            clicklistener.onClick(v);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(touchListener != null){
            touchListener.onTouch(v, event);
        }
        return false;
    }

    @Override
    public boolean onLongClick(View v) {
        if(longClickListener != null){
            longClickListener.onLongClick(v);
        }
        return false;
    }

    public void removeItem(int position) {
        devices.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Device item, int position) {
        devices.add(position, item);
        notifyItemInserted(position);
    }

    public List<Device> getData() {
        return devices;
    }

    /**  Classe interna Viewholder */
    public static class ViewholderDevices extends RecyclerView.ViewHolder {
        TextView codigo;
        TextView name;
        TextView outputsQty;

        public ViewholderDevices(@NonNull View view){
            super( view );
            codigo = view.findViewById(R.id.item_codigo);
            name  = view.findViewById(R.id.item_name2);
            outputsQty  = view.findViewById(R.id.item_status2);

        }

    }
// Fim viewholder


}
