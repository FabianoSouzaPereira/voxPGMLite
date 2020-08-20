package net.voxiot.voxpgmlite.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import net.voxiot.voxpgmlite.R;
import net.voxiot.voxpgmlite.database.Database;
import net.voxiot.voxpgmlite.model.Device;

import java.util.ArrayList;
import java.util.Objects;



public class CadastroDevices extends AppCompatActivity {
    Database db = new Database(this);
    //listeners variables
    private Spinner model;
    private String nameOuput1,nameOuput2,nameOuput3,nameOuput4,nameOuput5,nameOuput6,nameOuput7,nameOuput8;
    private Spinner icon1,icon2,icon3,icon4,icon5,icon6,icon7,icon8;
    protected Spinner type1,type2,type3,type4,type5,type6,type7,type8;
    private ArrayList<Spinner> spinlist = new ArrayList<Spinner>();
    private Switch btnSwitchOutPut1;
    private Switch btnSwitchOutPut2;
    private Switch btnSwitchOutPut3;
    private Switch btnSwitchOutPut4;
    private Switch btnSwitchOutPut5;
    private Switch btnSwitchOutPut6;
    private Switch btnSwitchOutPut7;
    private Switch btnSwitchOutPut8;
    //Text variables
    private TextView texttime1;
    private TextView texttime2;
    private TextView texttime3;
    private TextView texttime4;
    private TextView texttime5;
    private TextView texttime6;
    private TextView texttime7;
    private TextView texttime8;
    private TextView time1;
    private TextView time2;
    private TextView time3;
    private TextView time4;
    private TextView time5;
    private TextView time6;
    private TextView time7;
    private TextView time8;
    private View btnSave;
    private View btnEdit;
    private View btnCancel;
    private EditText editNameDevice;
    private EditText editIpDevice;
    private EditText editPortControll;
    private EditText editPortConfig;
    private EditText nameOutput1;
    private EditText nameOutput2;
    private EditText nameOutput3;
    private EditText nameOutput4;
    private EditText nameOutput5;
    private EditText nameOutput6;
    private EditText nameOutput7;
    private EditText nameOutput8;
    // getters from EditTexts
    String name, mModel, ip;
    int portcontroll = 0, portconfig = 0, Qty = 0;
    String mIcon1, mIcon2,mIcon3,mIcon4,mIcon5,mIcon6,mIcon7,mIcon8;
    String mType1,mType2,mType3,mType4,mType5,mType6,mType7,mType8;
    int mTime1,mTime2,mTime3,mTime4,mTime5,mTime6,mTime7,mTime8;
    int mOutput1,mOutput2,mOutput3,mOutput4,mOutput5,mOutput6,mOutput7,mOutput8;
    String mNameoutput1 = "";
    String mNameoutput2 = "";
    String mNameoutput3 = "";
    String mNameoutput4 = "";
    String mNameoutput5 = "";
    String mNameoutput6 = "";
    String mNameoutput7 = "";
    String mNameoutput8 = "";
    private TextView txtTitlecad;
    private static String mvalidate;
    String title;
    int codigo;
    private View linlayoutInclude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                title = null;
                codigo= -1;
            } else {
                title = extras.getString("Title");
                codigo = extras.getInt("Codigo");
            }
        } else {
            title = (String) savedInstanceState.getSerializable("Vox PGM Lite");
        }
        setContentView(R.layout.activity_cadastro_device);
        init();
        txtTitlecad.setText(title);

        if(title .equals("Editar")){
            btnSave.setVisibility(View.GONE);
            btnEdit.setVisibility(View.VISIBLE);
            Device dev = db.selectDevice(codigo);

            editNameDevice.setText(dev.getName());
            editIpDevice.setText(dev.getIp());
            editPortControll.setText(String.valueOf(dev.getPortcontroll()));
            editPortConfig.setText(String.valueOf(dev.getPortconfig()));
            model.setSelection(0);

            nameOutput1.setText(dev.getNameOutput1());
            nameOutput2.setText(dev.getNameOutput2());
            nameOutput3.setText(dev.getNameOutput3());
            nameOutput4.setText(dev.getNameOutput4());
            nameOutput5.setText(dev.getNameOutput5());
            nameOutput6.setText(dev.getNameOutput6());
            nameOutput7.setText(dev.getNameOutput7());
            nameOutput8.setText(dev.getNameOutput8());

            icon1.setSelection(switchImg(dev.getIcon1()));
            icon2.setSelection(switchImg(dev.getIcon2()));
            icon3.setSelection(switchImg(dev.getIcon3()));
            icon4.setSelection(switchImg(dev.getIcon4()));
            icon5.setSelection(switchImg(dev.getIcon5()));
            icon6.setSelection(switchImg(dev.getIcon6()));
            icon7.setSelection(switchImg(dev.getIcon7()));
            icon8.setSelection(switchImg(dev.getIcon8()));

            type1.setSelection(switchType(dev.getType1()));
            type2.setSelection(switchType(dev.getType2()));
            type3.setSelection(switchType(dev.getType3()));
            type4.setSelection(switchType(dev.getType4()));
            type5.setSelection(switchType(dev.getType5()));
            type6.setSelection(switchType(dev.getType6()));
            type7.setSelection(switchType(dev.getType7()));
            type8.setSelection(switchType(dev.getType8()));

            time1.setText(String.valueOf(dev.getTime1()));
            time2.setText(String.valueOf(dev.getTime2()));
            time3.setText(String.valueOf(dev.getTime3()));
            time4.setText(String.valueOf(dev.getTime4()));
            time5.setText(String.valueOf(dev.getTime5()));
            time6.setText(String.valueOf(dev.getTime6()));
            time7.setText(String.valueOf(dev.getTime7()));
            time8.setText(String.valueOf(dev.getTime8()));

            if(dev.getStatusOutput1() == 1){ btnSwitchOutPut1.setChecked(true); }else{ btnSwitchOutPut1.setChecked(false);}
            if(dev.getStatusOutput2() == 1){ btnSwitchOutPut2.setChecked(true); }else{ btnSwitchOutPut2.setChecked(false);}
            if(dev.getStatusOutput3() == 1){ btnSwitchOutPut3.setChecked(true); }else{ btnSwitchOutPut3.setChecked(false);}
            if(dev.getStatusOutput4() == 1){ btnSwitchOutPut4.setChecked(true); }else{ btnSwitchOutPut4.setChecked(false);}
            if(dev.getStatusOutput5() == 1){ btnSwitchOutPut5.setChecked(true); }else{ btnSwitchOutPut5.setChecked(false);}
            if(dev.getStatusOutput6() == 1){ btnSwitchOutPut6.setChecked(true); }else{ btnSwitchOutPut6.setChecked(false);}
            if(dev.getStatusOutput7() == 1){ btnSwitchOutPut7.setChecked(true); }else{ btnSwitchOutPut7.setChecked(false);}
            if(dev.getStatusOutput8() == 1){ btnSwitchOutPut8.setChecked(true); }else{ btnSwitchOutPut8.setChecked(false);}

        }else{
            btnSave.setVisibility(View.VISIBLE);
            btnEdit.setVisibility(View.GONE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataValues();
                if( validations() ) {
                    try {
                        if (db != null) {
                            db.addDBDevice(new Device(name, mModel, ip, portcontroll,portconfig, Qty,
                                    mNameoutput1,mNameoutput2,mNameoutput3,mNameoutput4,mNameoutput5,mNameoutput6,mNameoutput7,mNameoutput8,
                                    mOutput1, mOutput2, mOutput3, mOutput4, mOutput5, mOutput6, mOutput7, mOutput8,
                                    mIcon1, mIcon2, mIcon3, mIcon4, mIcon5, mIcon6, mIcon7, mIcon8,
                                    mType1, mType2, mType3, mType4, mType5, mType6, mType7, mType8,
                                    mTime1, mTime2, mTime3, mTime4, mTime5, mTime6, mTime7, mTime8));
                        }
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        Toast.makeText(CadastroDevices.this, "Salvo com sucesso.", Toast.LENGTH_LONG).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Snackbar.make(v, "Insira um valor de " + mvalidate + " válido", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });


        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataValues();
                if( validations() ) {
                    try {
                        if (db != null) {
                            db.updateDevice(new Device(codigo,name, mModel, ip, portcontroll, portconfig, Qty,
                                    mNameoutput1,mNameoutput2,mNameoutput3,mNameoutput4,mNameoutput5,mNameoutput6,mNameoutput7,mNameoutput8,
                                    mOutput1, mOutput2, mOutput3, mOutput4, mOutput5, mOutput6, mOutput7, mOutput8,
                                    mIcon1, mIcon2, mIcon3, mIcon4, mIcon5, mIcon6, mIcon7, mIcon8,
                                    mType1, mType2, mType3, mType4, mType5, mType6, mType7, mType8,
                                    mTime1, mTime2, mTime3, mTime4, mTime5, mTime6, mTime7, mTime8));
                        }
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        Toast.makeText(CadastroDevices.this, "Alterado com sucesso.", Toast.LENGTH_SHORT).show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else{
                    Snackbar.make(v, "Insira um valor de " + mvalidate + " válido", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });
    }

    private View.OnClickListener canceldismiss = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
            Intent i= new Intent(getApplicationContext(), MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
            finish();
        }
    };


    Boolean validations(){

        if (name .equals("") ){
            mvalidate = "nome";
            return false;
        }
        if (ip .equals("") ){
            mvalidate = "ip/Dns";
            return false;
        }

        if (!(portcontroll >= 1 && portcontroll <= 65565)){
            mvalidate = "porta 1";
            return false;
        }

        if (!(portconfig >= 1 && portconfig  <= 65565)){
            mvalidate = "porta 2";
            return false;
        }

        if (!(mTime1 >= 1 && mTime1 <= 65565) && mType1.equals("Pulso")){
            mvalidate = "tempo saída 1";
            return false;
        }
        if (!(mTime2 >= 1 && mTime2 <= 65565) && mType2.equals("Pulso")){
            mvalidate = "tempo saída 2";
            return false;
        }
        if (!(mTime3 >= 1 && mTime3 <= 65565) && mType3.equals("Pulso")){
            mvalidate = "tempo saída 3";
            return false;
        }
        if (!(mTime4 >= 1 && mTime4 <= 65565) && mType4.equals("Pulso")){
            mvalidate = "tempo saída 4";
            return false;
        }
        if (!(mTime5 >= 1 && mTime5 <= 65565) && mType5.equals("Pulso")){
            mvalidate = "tempo saída 5";
            return false;
        }
        if (!(mTime6 >= 1 && mTime6 <= 65565) && mType6.equals("Pulso")){
            mvalidate = "tempo saída 6";
            return false;
        }
        if (!(mTime7 >= 1 && mTime7 <= 65565) && mType7.equals("Pulso")){
            mvalidate = "tempo saída 7";
            return false;
        }
        if (!(mTime8 >= 1 && mTime8 <= 65565) && mType8.equals("Pulso")){
            mvalidate = "tempo saída 8";
            return false;
        }

        return true;

    }

    private void getDataValues() {
        name = editNameDevice.getText().toString().trim();
        ip = editIpDevice.getText().toString().trim();
        portcontroll = isEmpty(editPortControll.getText());
        portconfig = isEmpty(editPortConfig.getText());
        mModel = model.getSelectedItem().toString();

        mNameoutput1 = nameOutput1.getText().toString().trim();
        if(mNameoutput1 .equals("")){ mNameoutput1 = "Comando 1"; }
        mNameoutput2 = nameOutput2.getText().toString().trim();
        if(mNameoutput2 .equals("")){ mNameoutput2 = "Comando 2"; }
        mNameoutput3 = nameOutput3.getText().toString().trim();
        if(mNameoutput3 .equals("")){ mNameoutput3 = "Comando 3"; }
        mNameoutput4 = nameOutput4.getText().toString().trim();
        if(mNameoutput4 .equals("")){ mNameoutput4 = "Comando 4"; }
        mNameoutput5 = nameOutput5.getText().toString().trim();
        if(mNameoutput5 .equals("")){ mNameoutput5 = "Comando 5"; }
        mNameoutput6 = nameOutput6.getText().toString().trim();
        if(mNameoutput6 .equals("")){ mNameoutput6 = "Comando 6"; }
        mNameoutput7 = nameOutput7.getText().toString().trim();
        if(mNameoutput7 .equals("")){ mNameoutput7 = "Comando 7"; }
        mNameoutput8 = nameOutput8.getText().toString().trim();
        if(mNameoutput8 .equals("")){ mNameoutput8 = "Comando 8"; }

        mIcon1 = icon1.getSelectedItem().toString();
        mIcon2 = icon2.getSelectedItem().toString();
        mIcon3 = icon3.getSelectedItem().toString();
        mIcon4 = icon4.getSelectedItem().toString();
        mIcon5 = icon5.getSelectedItem().toString();
        mIcon6 = icon6.getSelectedItem().toString();
        mIcon7 = icon7.getSelectedItem().toString();
        mIcon8 = icon8.getSelectedItem().toString();

        mType1 = type1.getSelectedItem().toString();
        mType2 = type2.getSelectedItem().toString();
        mType3 = type3.getSelectedItem().toString();
        mType4 = type4.getSelectedItem().toString();
        mType5 = type5.getSelectedItem().toString();
        mType6 = type6.getSelectedItem().toString();
        mType7 = type7.getSelectedItem().toString();
        mType8 = type8.getSelectedItem().toString();

        mTime1 = isEmpty(time1.getText().toString());
        mTime2 = isEmpty(time2.getText().toString());
        mTime3 = isEmpty(time3.getText().toString());
        mTime4 = isEmpty(time4.getText().toString());
        mTime5 = isEmpty(time5.getText().toString());
        mTime6 = isEmpty(time6.getText().toString());
        mTime7 = isEmpty(time7.getText().toString());
        mTime8 = isEmpty(time8.getText().toString());

        Qty = mOutput1+mOutput2+mOutput3+mOutput4+mOutput5+mOutput6+mOutput7+mOutput8;
    }


    /** start all objects from Views
     *  And set their listenner
     */
    private void init(){
        linlayoutInclude = findViewById(R.id.linLayoutInclude);
        txtTitlecad = findViewById(R.id.txtTitlecad);
        btnSave = findViewById(R.id.btnSavedevice);
        btnEdit = findViewById(R.id.btnUpdatedevice);
        btnCancel = findViewById(R.id.btnCancelDevice);
        btnCancel.setOnClickListener(canceldismiss);
        editNameDevice = findViewById(R.id.editNamedevice);
        nameOutput1 = findViewById(R.id.editNameDevice1);
        nameOutput2 = findViewById(R.id.editNameDevice2);
        nameOutput3 = findViewById(R.id.editNameDevice3);
        nameOutput4 = findViewById(R.id.editNameDevice4);
        nameOutput5 = findViewById(R.id.editNameDevice5);
        nameOutput6 = findViewById(R.id.editNameDevice6);
        nameOutput7 = findViewById(R.id.editNameDevice7);
        nameOutput8 = findViewById(R.id.editNameDevice8);
        editIpDevice = findViewById(R.id.editIpdevice);
        editPortControll = findViewById(R.id.editPortcontroll);
        editPortConfig = findViewById(R.id.editPortconfig);
        texttime1 = findViewById(R.id.txtTimedevice1);
        time1 = findViewById(R.id.editimedevice1);
        texttime2 = findViewById(R.id.txtTimedevice2);
        time2 = findViewById(R.id.editimedevice2);
        texttime3 = findViewById(R.id.txtTimedevice3);
        time3 = findViewById(R.id.editimedevice3);
        texttime4 = findViewById(R.id.txtTimedevice4);
        time4 = findViewById(R.id.editimedevice4);
        texttime5 = findViewById(R.id.txtTimedevice5);
        time5= findViewById(R.id.editimedevice5);
        texttime6 = findViewById(R.id.txtTimedevice6);
        time6 = findViewById(R.id.editimedevice6);
        texttime7 = findViewById(R.id.txtTimedevice7);
        time7 = findViewById(R.id.editimedevice7);
        texttime8 = findViewById(R.id.txtTimedevice8);
        time8 = findViewById(R.id.editimedevice8);
        btnSwitchOutPut1 = findViewById(R.id.btnSwitoutPut1);
        btnSwitchOutPut2 = findViewById(R.id.btnSwitoutPut2);
        btnSwitchOutPut3 = findViewById(R.id.btnSwitoutPut3);
        btnSwitchOutPut4 = findViewById(R.id.btnSwitoutPut4);
        btnSwitchOutPut5 = findViewById(R.id.btnSwitoutPut5);
        btnSwitchOutPut6 = findViewById(R.id.btnSwitoutPut6);
        btnSwitchOutPut7 = findViewById(R.id.btnSwitoutPut7);
        btnSwitchOutPut8 = findViewById(R.id.btnSwitoutPut8);
        btnSwitchOutPut1.setOnCheckedChangeListener(btnOutPut1Click);
        View linear1= findViewById(R.id.linearoutput1);
        linear1.setVisibility(View.GONE);
        btnSwitchOutPut2.setOnCheckedChangeListener(btnOutPut2Click );
        View linear2 = findViewById(R.id.linearoutput2);
        linear2.setVisibility(View.GONE);
        btnSwitchOutPut3.setOnCheckedChangeListener(btnOutPut3Click);
        View linear3 = findViewById(R.id.linearoutput3);
        linear3.setVisibility(View.GONE);
        btnSwitchOutPut4.setOnCheckedChangeListener(btnOutPut4Click);
        View linear4 = findViewById(R.id.linearoutput4);
        linear4.setVisibility(View.GONE);
        btnSwitchOutPut5.setOnCheckedChangeListener(btnOutPut5Click);
        View linear5 = findViewById(R.id.linearoutput5);
        linear5.setVisibility(View.GONE);
        btnSwitchOutPut6.setOnCheckedChangeListener(btnOutPut6Click);
        View linear6 = findViewById(R.id.linearoutput6);
        linear6.setVisibility(View.GONE);
        btnSwitchOutPut7.setOnCheckedChangeListener(btnOutPut7Click);
        View linear7 = findViewById(R.id.linearoutput7);
        linear7.setVisibility(View.GONE);
        btnSwitchOutPut8.setOnCheckedChangeListener(btnOutPut8Click);
        View linear8 = findViewById(R.id.linearoutput8);
        linear8.setVisibility(View.GONE);
        model = findViewById(R.id.spinModeldevice1);
        icon1 = findViewById(R.id.spinIcoDevice1);
        type1 = findViewById(R.id.spinTypedevice1);
        icon2 = findViewById(R.id.spinIcoDevice2);
        type2 = findViewById(R.id.spinTypedevice2);
        icon3 = findViewById(R.id.spinIcoDevice3);
        type3 = findViewById(R.id.spinTypedevice3);
        icon4 = findViewById(R.id.spinIcoDevice4);
        type4 = findViewById(R.id.spinTypedevice4);
        icon5 = findViewById(R.id.spinIcoDevice5);
        type5 = findViewById(R.id.spinTypedevice5);
        icon6 = findViewById(R.id.spinIcoDevice6);
        type6 = findViewById(R.id.spinTypedevice6);
        icon7 = findViewById(R.id.spinIcoDevice7);
        type7 = findViewById(R.id.spinTypedevice7);
        icon8 = findViewById(R.id.spinIcoDevice8);
        type8 = findViewById(R.id.spinTypedevice8);
        //For custom spinners
        spinlist.add(model);
        spinlist.add(icon1);
        spinlist.add(type1);
        spinlist.add(icon2);
        spinlist.add(type2);
        spinlist.add(icon3);
        spinlist.add(type3);
        spinlist.add(icon4);
        spinlist.add(type4);
        spinlist.add(icon5);
        spinlist.add(type5);
        spinlist.add(icon6);
        spinlist.add(type6);
        spinlist.add(icon7);
        spinlist.add(type7);
        spinlist.add(icon8);
        spinlist.add(type8);
        typeAppearance(this,spinlist);
    }

    private CompoundButton.OnCheckedChangeListener btnOutPut1Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut1Click, boolean isChecked) {
            if(btnOutPut1Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear1 = findViewById(R.id.linearoutput1);
                linear1.setVisibility(View.VISIBLE);
                nameOutput1.requestFocus();
                mOutput1 = 1;
            }else {
                View linear1 = findViewById(R.id.linearoutput1);
                linear1.setVisibility(View.GONE);
                mOutput1 = 0;
            }
        }
    };

    private CompoundButton.OnCheckedChangeListener btnOutPut2Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut2Click, boolean isChecked) {
            if(btnOutPut2Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear2 = findViewById(R.id.linearoutput2);
                linear2.setVisibility(View.VISIBLE);
                nameOutput2.requestFocus();
                mOutput2 = 1;
            }else {
                View linear2 = findViewById(R.id.linearoutput2);
                linear2.setVisibility(View.GONE);
                mOutput2 = 0;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener btnOutPut3Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut3Click, boolean isChecked) {
            if(btnOutPut3Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear3 = findViewById(R.id.linearoutput3);
                linear3.setVisibility(View.VISIBLE);
                nameOutput3.requestFocus();
                mOutput3 = 1;
            }else {
                View linear3 = findViewById(R.id.linearoutput3);
                linear3.setVisibility(View.GONE);
                mOutput3 = 0;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener btnOutPut4Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut4Click, boolean isChecked) {
            if(btnOutPut4Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear4 = findViewById(R.id.linearoutput4);
                linear4.setVisibility(View.VISIBLE);
                nameOutput4.requestFocus();
                mOutput4 = 1;
            }else {
                View linear4 = findViewById(R.id.linearoutput4);
                linear4.setVisibility(View.GONE);
                mOutput4= 0;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener btnOutPut5Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut5Click, boolean isChecked) {
            if(btnOutPut5Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear5 = findViewById(R.id.linearoutput5);
                linear5.setVisibility(View.VISIBLE);
                nameOutput4.requestFocus();
                mOutput5 = 1;
            }else {
                View linear5 = findViewById(R.id.linearoutput5);
                linear5.setVisibility(View.GONE);
                mOutput5 = 0;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener btnOutPut6Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut6Click, boolean isChecked) {
            if(btnOutPut6Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear6 = findViewById(R.id.linearoutput6);
                linear6.setVisibility(View.VISIBLE);
                nameOutput5.requestFocus();
                mOutput6 = 1;
            }else {
                View linear6 = findViewById(R.id.linearoutput6);
                linear6.setVisibility(View.GONE);
                mOutput6= 0;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener btnOutPut7Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut7Click, boolean isChecked) {
            if(btnOutPut7Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear7 = findViewById(R.id.linearoutput7);
                linear7.setVisibility(View.VISIBLE);
                nameOutput7.requestFocus();
                mOutput7 = 1;
            }else {
                View linear7 = findViewById(R.id.linearoutput7);
                linear7.setVisibility(View.GONE);
                mOutput7 = 0;
            }
        }
    };
    private CompoundButton.OnCheckedChangeListener btnOutPut8Click = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton btnOutPut8Click, boolean isChecked) {
            if(btnOutPut8Click.isChecked()){
                InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                View linear8 = findViewById(R.id.linearoutput8);
                linear8.setVisibility(View.VISIBLE);
                nameOutput8.requestFocus();
                mOutput8 = 1;
            }else {
                View linear8 = findViewById(R.id.linearoutput8);
                linear8.setVisibility(View.GONE);
                mOutput8 = 0;
            }
        }
    };

    protected void typeAppearance(Context context, ArrayList<Spinner> spinners) {

        for (Spinner spinner: spinners) {
            if(spinner.getTag() .equals("modeltype")) {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                        .createFromResource(context, R.array.modeltype, android.R.layout.simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
                spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ((TextView) view).setTextSize(1, 20);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
            if(spinner.getTag() .equals("outputs_icons")) {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                        .createFromResource(context, R.array.outputs_icons, android.R.layout.simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
                spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ((TextView) view).setTextSize(1, 22);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
            if(spinner.getTag() .equals("type_array")) {
                ArrayAdapter<CharSequence> adapter = ArrayAdapter
                        .createFromResource(context, R.array.type_array, android.R.layout.simple_spinner_dropdown_item);
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                spinner.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
                spinner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        ((TextView) view).setTextSize(1, 22);
                        if (Objects.equals(type1.getSelectedItem(), "Pulso")) {
                            texttime1.setVisibility(View.GONE);
                            time1.setVisibility(View.GONE);
                        } else {
                            texttime1.setVisibility(View.VISIBLE);
                            time1.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type2.getSelectedItem(), "Pulso")) {
                            texttime2.setVisibility(View.GONE);
                            time2.setVisibility(View.GONE);
                        } else {
                            texttime2.setVisibility(View.VISIBLE);
                            time2.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type3.getSelectedItem(), "Pulso")) {
                            texttime3.setVisibility(View.GONE);
                            time3.setVisibility(View.GONE);
                        } else {
                            texttime3.setVisibility(View.VISIBLE);
                            time3.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type4.getSelectedItem(), "Pulso")) {
                            texttime4.setVisibility(View.GONE);
                            time4.setVisibility(View.GONE);
                        } else {
                            texttime4.setVisibility(View.VISIBLE);
                            time4.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type5.getSelectedItem(), "Pulso")) {
                            texttime5.setVisibility(View.GONE);
                            time5.setVisibility(View.GONE);
                        } else {
                            texttime5.setVisibility(View.VISIBLE);
                            time5.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type6.getSelectedItem(), "Pulso")) {
                            texttime6.setVisibility(View.GONE);
                            time6.setVisibility(View.GONE);
                        } else {
                            texttime6.setVisibility(View.VISIBLE);
                            time6.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type7.getSelectedItem(), "Pulso")) {
                            texttime7.setVisibility(View.GONE);
                            time7.setVisibility(View.GONE);
                        } else {
                            texttime7.setVisibility(View.VISIBLE);
                            time7.setVisibility(View.VISIBLE);
                        }
                        if (Objects.equals(type8.getSelectedItem(), "Pulso")) {
                            texttime8.setVisibility(View.GONE);
                            time8.setVisibility(View.GONE);
                        } else {
                            texttime8.setVisibility(View.VISIBLE);
                            time8.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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

    @Override
    public void onBackPressed() {
        Intent i= new Intent(getApplicationContext(), MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }

    /** CharSequence and return int  */
    int isEmpty(CharSequence t){
        String tempo = t.toString();
        if(tempo.equals("")){
            return 0;
        }
        return Integer.parseInt(t.toString());
    }

    private int switchImg(String ico){
        int icon = 0;
        switch (ico){
            case "Lâmpada": icon = 0;
                return icon;

            case "Serviço": icon = 1;
                return icon;

            case "Ar Condicionado": icon = 2;
                return icon;

            case "Ligar": icon = 3;
                return icon;

            case "Semáfaro": icon = 4;
                return icon;

            case "Dispositivo Elétrico": icon = 5;
                return icon;

            case "Flash": icon = 6;
                return icon;

            case "Bateria Carregada": icon = 7;
                return icon;

            case "": default : icon = 8;
                return icon;
        }
    }

    private int switchType(String mtype){
        int type = -1;
        switch (mtype){
            case "Retenção": type = 0;
                return type;

            case "Pulso": type = 1;
                return type;

        }
        return type;
    }

    private void moveToBack(View myCurrentView)
    {
        ViewGroup myViewGroup = ((ViewGroup) myCurrentView.getParent());
        int index = myViewGroup.indexOfChild(myCurrentView);
        for(int i = 0; i<index; i++)
        {
            myViewGroup.bringChildToFront(myViewGroup.getChildAt(i));
        }
    }

    public void clear(ViewGroup group) {

        int count = group.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = group.getChildAt(i);
            if (view instanceof ViewGroup) {
                clear((ViewGroup) view);
                continue;
            }
            if (view instanceof EditText) {
                ((EditText)view).setText("");
            }
        }
    }
}