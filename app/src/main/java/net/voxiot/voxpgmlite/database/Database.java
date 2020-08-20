package net.voxiot.voxpgmlite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import net.voxiot.voxpgmlite.model.Device;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final int BD_VERSION = 1;
    private static final String DB_VOXPGM = "db_VoxPgm";
    private static final String DEVICE_TABLE = "tb_device";
    private static final String CODE_COLUMN = "codigo";
    private static final String NAME_COLUMN = "name";
    private static final String MODEL_COLUMN = "model";
    private static final String IP_COLUMN = "ip";
    private static final String PORTCONTROLL_COLUMN = "portcontroll";
    private static final String PORTCONFIG_COLUMN = "portconfig";
    private static final String QTY_COLUMN = "qty";
    private static final String NAME_OUTPUT1_COLUMN = "nameOutput1";
    private static final String NAME_OUTPUT2_COLUMN = "nameOutput2";
    private static final String NAME_OUTPUT3_COLUMN = "nameOutput3";
    private static final String NAME_OUTPUT4_COLUMN = "nameOutput4";
    private static final String NAME_OUTPUT5_COLUMN = "nameOutput5";
    private static final String NAME_OUTPUT6_COLUMN = "nameOutput6";
    private static final String NAME_OUTPUT7_COLUMN = "nameOutput7";
    private static final String NAME_OUTPUT8_COLUMN = "nameOutput8";
    private static final String STATUS_OUTPUT1_COLUMN = "statusOutput1";
    private static final String STATUS_OUTPUT2_COLUMN = "statusOutput2";
    private static final String STATUS_OUTPUT3_COLUMN = "statusOutput3";
    private static final String STATUS_OUTPUT4_COLUMN = "statusOutput4";
    private static final String STATUS_OUTPUT5_COLUMN = "statusOutput5";
    private static final String STATUS_OUTPUT6_COLUMN = "statusOutput6";
    private static final String STATUS_OUTPUT7_COLUMN = "statusOutput7";
    private static final String STATUS_OUTPUT8_COLUMN = "statusOutput8";
    private static final String ICON1_COLUMN = "icon1";
    private static final String ICON2_COLUMN = "icon2";
    private static final String ICON3_COLUMN = "icon3";
    private static final String ICON4_COLUMN = "icon4";
    private static final String ICON5_COLUMN = "icon5";
    private static final String ICON6_COLUMN = "icon6";
    private static final String ICON7_COLUMN = "icon7";
    private static final String ICON8_COLUMN = "icon8";
    private static final String TYPE1_COLUMN = "type1";
    private static final String TYPE2_COLUMN = "type2";
    private static final String TYPE3_COLUMN = "type3";
    private static final String TYPE4_COLUMN = "type4";
    private static final String TYPE5_COLUMN = "type5";
    private static final String TYPE6_COLUMN = "type6";
    private static final String TYPE7_COLUMN = "type7";
    private static final String TYPE8_COLUMN = "type8";
    private static final String TIME1_COLUMN = "time1";
    private static final String TIME2_COLUMN = "time2";
    private static final String TIME3_COLUMN = "time3";
    private static final String TIME4_COLUMN = "time4";
    private static final String TIME5_COLUMN = "time5";
    private static final String TIME6_COLUMN = "time6";
    private static final String TIME7_COLUMN = "time7";
    private static final String TIME8_COLUMN = "time8";


    private static final String SQL_CREATE_DEVICE_TABLE =
            "CREATE TABLE " + DEVICE_TABLE + " (" +
                    CODE_COLUMN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                    NAME_COLUMN+ " TEXT NOT NULL," +
                    MODEL_COLUMN + " TEXT NOT NULL," +
                    IP_COLUMN + " TEXT NOT NULL," +
                    PORTCONTROLL_COLUMN  + " INTEGER NOT NULL DEFAULT 65565," +
                    PORTCONFIG_COLUMN  + " INTEGER NOT NULL DEFAULT 65565," +
                    QTY_COLUMN   + " INTEGER NOT NULL DEFAULT 0," +
                    NAME_OUTPUT1_COLUMN + " TEXT," +
                    NAME_OUTPUT2_COLUMN + " TEXT," +
                    NAME_OUTPUT3_COLUMN + " TEXT," +
                    NAME_OUTPUT4_COLUMN + " TEXT," +
                    NAME_OUTPUT5_COLUMN + " TEXT," +
                    NAME_OUTPUT6_COLUMN + " TEXT," +
                    NAME_OUTPUT7_COLUMN + " TEXT," +
                    NAME_OUTPUT8_COLUMN + " TEXT," +
                    STATUS_OUTPUT1_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT2_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT3_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT4_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT5_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT6_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT7_COLUMN + " INTEGER,"+
                    STATUS_OUTPUT8_COLUMN + " INTEGER,"+
                    ICON1_COLUMN + " TEXT,"+
                    ICON2_COLUMN + " TEXT,"+
                    ICON3_COLUMN + " TEXT,"+
                    ICON4_COLUMN + " TEXT,"+
                    ICON5_COLUMN + " TEXT,"+
                    ICON6_COLUMN + " TEXT,"+
                    ICON7_COLUMN + " TEXT,"+
                    ICON8_COLUMN + " TEXT,"+
                    TYPE1_COLUMN + " TEXT,"+
                    TYPE2_COLUMN + " TEXT,"+
                    TYPE3_COLUMN + " TEXT,"+
                    TYPE4_COLUMN + " TEXT,"+
                    TYPE5_COLUMN + " TEXT,"+
                    TYPE6_COLUMN + " TEXT,"+
                    TYPE7_COLUMN + " TEXT,"+
                    TYPE8_COLUMN + " TEXT,"+
                    TIME1_COLUMN + " INTEGER,"+
                    TIME2_COLUMN + " INTEGER,"+
                    TIME3_COLUMN + " INTEGER,"+
                    TIME4_COLUMN + " INTEGER,"+
                    TIME5_COLUMN + " INTEGER,"+
                    TIME6_COLUMN + " INTEGER,"+
                    TIME7_COLUMN + " INTEGER,"+
                    TIME8_COLUMN + " INTEGER)";


    private static final String[] Devicecol = { CODE_COLUMN,NAME_COLUMN,MODEL_COLUMN,IP_COLUMN,PORTCONTROLL_COLUMN,PORTCONFIG_COLUMN,QTY_COLUMN,
            NAME_OUTPUT1_COLUMN,NAME_OUTPUT2_COLUMN,NAME_OUTPUT3_COLUMN,NAME_OUTPUT4_COLUMN,NAME_OUTPUT5_COLUMN,
            NAME_OUTPUT6_COLUMN,NAME_OUTPUT7_COLUMN,NAME_OUTPUT8_COLUMN,
            STATUS_OUTPUT1_COLUMN,STATUS_OUTPUT2_COLUMN,STATUS_OUTPUT3_COLUMN,STATUS_OUTPUT4_COLUMN,STATUS_OUTPUT5_COLUMN,
            STATUS_OUTPUT6_COLUMN,STATUS_OUTPUT7_COLUMN,STATUS_OUTPUT8_COLUMN,
            ICON1_COLUMN,ICON2_COLUMN,ICON3_COLUMN,ICON4_COLUMN,ICON5_COLUMN,ICON6_COLUMN,ICON7_COLUMN,ICON8_COLUMN,
            TYPE1_COLUMN,TYPE2_COLUMN,TYPE3_COLUMN,TYPE4_COLUMN,TYPE5_COLUMN,TYPE6_COLUMN,TYPE7_COLUMN,TYPE8_COLUMN,
            TIME1_COLUMN,TIME2_COLUMN,TIME3_COLUMN,TIME4_COLUMN,TIME5_COLUMN,TIME6_COLUMN,TIME7_COLUMN,TIME8_COLUMN };

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + DEVICE_TABLE;
    private static final String SQL_UPDATE_ENTRIES = "UPDATE "  + DEVICE_TABLE;


    public Database(@Nullable Context context) {
        super(context, DB_VOXPGM, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_DEVICE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addDBDevice(Device device){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, device.getName());
        values.put(MODEL_COLUMN, device.getModel());
        values.put(IP_COLUMN, device.getIp());
        values.put(PORTCONTROLL_COLUMN, device.getPortcontroll());
        values.put(PORTCONFIG_COLUMN, device.getPortcontroll());
        values.put(QTY_COLUMN, device.getQty());

        values.put(NAME_OUTPUT1_COLUMN, device.getNameOutput1());
        values.put(NAME_OUTPUT2_COLUMN, device.getNameOutput2());
        values.put(NAME_OUTPUT3_COLUMN, device.getNameOutput3());
        values.put(NAME_OUTPUT4_COLUMN, device.getNameOutput4());
        values.put(NAME_OUTPUT5_COLUMN, device.getNameOutput5());
        values.put(NAME_OUTPUT6_COLUMN, device.getNameOutput6());
        values.put(NAME_OUTPUT7_COLUMN, device.getNameOutput7());
        values.put(NAME_OUTPUT8_COLUMN, device.getNameOutput8());

        values.put(STATUS_OUTPUT1_COLUMN, device.getStatusOutput1());
        values.put(STATUS_OUTPUT2_COLUMN, device.getStatusOutput2());
        values.put(STATUS_OUTPUT3_COLUMN, device.getStatusOutput3());
        values.put(STATUS_OUTPUT4_COLUMN, device.getStatusOutput4());
        values.put(STATUS_OUTPUT5_COLUMN, device.getStatusOutput5());
        values.put(STATUS_OUTPUT6_COLUMN, device.getStatusOutput6());
        values.put(STATUS_OUTPUT7_COLUMN, device.getStatusOutput7());
        values.put(STATUS_OUTPUT8_COLUMN, device.getStatusOutput8());

        values.put(ICON1_COLUMN, device.getIcon1());
        values.put(ICON2_COLUMN, device.getIcon2());
        values.put(ICON3_COLUMN, device.getIcon3());
        values.put(ICON4_COLUMN, device.getIcon4());
        values.put(ICON5_COLUMN, device.getIcon5());
        values.put(ICON6_COLUMN, device.getIcon6());
        values.put(ICON7_COLUMN, device.getIcon7());
        values.put(ICON8_COLUMN, device.getIcon8());

        values.put(TYPE1_COLUMN, device.getType1());
        values.put(TYPE2_COLUMN, device.getType2());
        values.put(TYPE3_COLUMN, device.getType3());
        values.put(TYPE4_COLUMN, device.getType4());
        values.put(TYPE5_COLUMN, device.getType5());
        values.put(TYPE6_COLUMN, device.getType6());
        values.put(TYPE7_COLUMN, device.getType7());
        values.put(TYPE8_COLUMN, device.getType8());

        values.put(TIME1_COLUMN, device.getTime1());
        values.put(TIME2_COLUMN, device.getTime2());
        values.put(TIME3_COLUMN, device.getTime3());
        values.put(TIME4_COLUMN, device.getTime4());
        values.put(TIME5_COLUMN, device.getTime5());
        values.put(TIME6_COLUMN, device.getTime6());
        values.put(TIME7_COLUMN, device.getTime7());
        values.put(TIME8_COLUMN, device.getTime8());

        db.insert(DEVICE_TABLE,null,values);
        db.close();
    }

    public Device selectDevice(int codigo){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(DEVICE_TABLE, Devicecol,CODE_COLUMN + " = ?",
                new String[]{String.valueOf(codigo)},null,null,null,null);

        if(cursor != null){ cursor.moveToFirst();  }
        Device device = new Device(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                Integer.parseInt(cursor.getString(4)),
                Integer.parseInt(cursor.getString(5)),
                Integer.parseInt(cursor.getString(6)),
                //8 outputs names
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14),
                //8 outputs status
                Integer.parseInt(cursor.getString(15)),
                Integer.parseInt(cursor.getString(16)),
                Integer.parseInt(cursor.getString(17)),
                Integer.parseInt(cursor.getString(18)),
                Integer.parseInt(cursor.getString(19)),
                Integer.parseInt(cursor.getString(20)),
                Integer.parseInt(cursor.getString(21)),
                Integer.parseInt(cursor.getString(22)),
                //8 icones
                cursor.getString(23),
                cursor.getString(24),
                cursor.getString(25),
                cursor.getString(26),
                cursor.getString(27),
                cursor.getString(28),
                cursor.getString(29),
                //8 types
                cursor.getString(30),
                cursor.getString(31),
                cursor.getString(32),
                cursor.getString(33),
                cursor.getString(34),
                cursor.getString(35),
                cursor.getString(36),
                cursor.getString(37),
                //8 times
                cursor.getString(38),
                Integer.parseInt(cursor.getString(39)),
                Integer.parseInt(cursor.getString(40)),
                Integer.parseInt(cursor.getString(41)),
                Integer.parseInt(cursor.getString(42)),
                Integer.parseInt(cursor.getString(43)),
                Integer.parseInt(cursor.getString(44)),
                Integer.parseInt(cursor.getString(45)),
                Integer.parseInt(cursor.getString(46))

        );
        cursor.close();
        db.close();
        return device;
    }

    public List<Device> listAllDevices(){
        List<Device> devices = new ArrayList<Device>();
        String query = "SELECT * FROM " + DEVICE_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(query,null);

        if(c.moveToFirst()){
            do {
                Device device = new Device();
                device.setCodigo(Integer.parseInt(c.getString(0)));
                device.setName(c.getString(1));
                device.setModel(c.getString(2));
                device.setIp(c.getString(3));
                device.setPortcontroll(Integer.parseInt(c.getString(4)));
                device.setPortcontroll(Integer.parseInt(c.getString(5)));
                device.setQty(Integer.parseInt(c.getString(6)));

                device.setNameOutput1(c.getString(7));
                device.setNameOutput1(c.getString(8));
                device.setNameOutput1(c.getString(9));
                device.setNameOutput1(c.getString(10));
                device.setNameOutput1(c.getString(11));
                device.setNameOutput1(c.getString(12));
                device.setNameOutput1(c.getString(13));
                device.setNameOutput1(c.getString(14));

                device.setStatusOutput1(Integer.parseInt(c.getString(15)));
                device.setStatusOutput2(Integer.parseInt(c.getString(16)));
                device.setStatusOutput3(Integer.parseInt(c.getString(17)));
                device.setStatusOutput4(Integer.parseInt(c.getString(18)));
                device.setStatusOutput5(Integer.parseInt(c.getString(19)));
                device.setStatusOutput6(Integer.parseInt(c.getString(20)));
                device.setStatusOutput7(Integer.parseInt(c.getString(21)));
                device.setStatusOutput8(Integer.parseInt(c.getString(22)));

                device.setIcon1(c.getString(23));
                device.setIcon2(c.getString(24));
                device.setIcon3(c.getString(25));
                device.setIcon4(c.getString(26));
                device.setIcon5(c.getString(27));
                device.setIcon6(c.getString(28));
                device.setIcon7(c.getString(29));
                device.setIcon8(c.getString(30));

                device.setType1(c.getString(31));
                device.setType2(c.getString(32));
                device.setType3(c.getString(33));
                device.setType4(c.getString(34));
                device.setType5(c.getString(35));
                device.setType6(c.getString(36));
                device.setType7(c.getString(37));
                device.setType8(c.getString(38));

                device.setTime1(Integer.parseInt(c.getString(39)));
                device.setTime2(Integer.parseInt(c.getString(40)));
                device.setTime3(Integer.parseInt(c.getString(41)));
                device.setTime4(Integer.parseInt(c.getString(42)));
                device.setTime5(Integer.parseInt(c.getString(43)));
                device.setTime6(Integer.parseInt(c.getString(44)));
                device.setTime7(Integer.parseInt(c.getString(45)));
                device.setTime8(Integer.parseInt(c.getString(46)));
                devices.add(device);

            } while (c.moveToNext());
            c.close();
            db.close();
        }

        return devices;

    }

    public void updateDevice(Device device){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME_COLUMN, device.getName());
        values.put(MODEL_COLUMN, device.getModel());
        values.put(IP_COLUMN, device.getIp());
        values.put(PORTCONTROLL_COLUMN, device.getPortcontroll());
        values.put(PORTCONFIG_COLUMN, device.getPortcontroll());
        values.put(QTY_COLUMN, device.getQty());

        values.put(NAME_OUTPUT1_COLUMN, device.getNameOutput1());
        values.put(NAME_OUTPUT2_COLUMN, device.getNameOutput2());
        values.put(NAME_OUTPUT3_COLUMN, device.getNameOutput3());
        values.put(NAME_OUTPUT4_COLUMN, device.getNameOutput4());
        values.put(NAME_OUTPUT5_COLUMN, device.getNameOutput5());
        values.put(NAME_OUTPUT6_COLUMN, device.getNameOutput6());
        values.put(NAME_OUTPUT7_COLUMN, device.getNameOutput7());
        values.put(NAME_OUTPUT8_COLUMN, device.getNameOutput8());

        values.put(STATUS_OUTPUT1_COLUMN, device.getStatusOutput1());
        values.put(STATUS_OUTPUT2_COLUMN, device.getStatusOutput2());
        values.put(STATUS_OUTPUT3_COLUMN, device.getStatusOutput3());
        values.put(STATUS_OUTPUT4_COLUMN, device.getStatusOutput4());
        values.put(STATUS_OUTPUT5_COLUMN, device.getStatusOutput5());
        values.put(STATUS_OUTPUT6_COLUMN, device.getStatusOutput6());
        values.put(STATUS_OUTPUT7_COLUMN, device.getStatusOutput7());
        values.put(STATUS_OUTPUT8_COLUMN, device.getStatusOutput8());

        values.put(ICON1_COLUMN, device.getIcon1());
        values.put(ICON2_COLUMN, device.getIcon2());
        values.put(ICON3_COLUMN, device.getIcon3());
        values.put(ICON4_COLUMN, device.getIcon4());
        values.put(ICON5_COLUMN, device.getIcon5());
        values.put(ICON6_COLUMN, device.getIcon6());
        values.put(ICON7_COLUMN, device.getIcon7());
        values.put(ICON8_COLUMN, device.getIcon8());

        values.put(TYPE1_COLUMN, device.getType1());
        values.put(TYPE2_COLUMN, device.getType2());
        values.put(TYPE3_COLUMN, device.getType3());
        values.put(TYPE4_COLUMN, device.getType4());
        values.put(TYPE5_COLUMN, device.getType5());
        values.put(TYPE6_COLUMN, device.getType6());
        values.put(TYPE7_COLUMN, device.getType7());
        values.put(TYPE8_COLUMN, device.getType8());

        values.put(TIME1_COLUMN, device.getTime1());
        values.put(TIME2_COLUMN, device.getTime2());
        values.put(TIME3_COLUMN, device.getTime3());
        values.put(TIME4_COLUMN, device.getTime4());
        values.put(TIME5_COLUMN, device.getTime5());
        values.put(TIME6_COLUMN, device.getTime6());
        values.put(TIME7_COLUMN, device.getTime7());
        values.put(TIME8_COLUMN, device.getTime8());

            db.update(DEVICE_TABLE,values,CODE_COLUMN + " = ?", new String[]{ String.valueOf(device.getCodigo())});
            db.close();
    }

    public void deleteDevice(int codigo){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DEVICE_TABLE,CODE_COLUMN + " = ?", new String[]{ String.valueOf(codigo)});
        db.close();
    }
}
