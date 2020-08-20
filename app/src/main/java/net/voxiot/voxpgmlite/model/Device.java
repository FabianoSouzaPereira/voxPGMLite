package net.voxiot.voxpgmlite.model;

import android.widget.ImageView;
import 	android.text.TextUtils;

import java.util.Objects;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class Device {
    private int codigo;
    private String name = "Dispositivo";
    private String model = "Vox PGM 100";
    private String ip = "192.168.0.1";
    private int portcontroll = 65565;
    private int portconfig = 65565;
    private int qty = 0;
    private String nameOutput1 = "Comando 1";
    private String nameOutput2 = "Comando 2";
    private String nameOutput3 = "Comando 3";
    private String nameOutput4 = "Comando 4";
    private String nameOutput5 = "Comando 5";
    private String nameOutput6 = "Comando 6";
    private String nameOutput7 = "Comando 7";
    private String nameOutput8 = "Comando 8";
    private int statusOutput1 = 0;
    private int statusOutput2 = 0;
    private int statusOutput3 = 0;
    private int statusOutput4 = 0;
    private int statusOutput5 = 0;
    private int statusOutput6 = 0;
    private int statusOutput7 = 0;
    private int statusOutput8 = 0;
    private String icon1 = "Lâmpada";
    private String icon2 = "Lâmpada";
    private String icon3 = "Lâmpada";
    private String icon4 = "Lâmpada";
    private String icon5 = "Lâmpada";
    private String icon6 = "Lâmpada";
    private String icon7 = "Lâmpada";
    private String icon8 = "Lâmpada";
    private String type1 = "Retenção";
    private String type2 = "Retenção";
    private String type3 = "Retenção";
    private String type4 = "Retenção";
    private String type5 = "Retenção";
    private String type6 = "Retenção";
    private String type7 = "Retenção";
    private String type8 = "Retenção";
    private int time1 = 2;
    private int time2 = 2;
    private int time3 = 2;
    private int time4 = 2;
    private int time5 = 2;
    private int time6 = 2;
    private int time7 = 2;
    private int time8 = 2;

    public Device(int codigo, String name, String model, String ip, int portcontroll, int portconfig, int qty,
                  String nameOutput1,String nameOutput2, String nameOutput3, String nameOutput4, String nameOutput5, String nameOutput6,  String nameOutput7, String nameOutput8,
                  int statusOutput1, int statusOutput2, int statusOutput3,int statusOutput4, int statusOutput5, int statusOutput6, int statusOutput7, int statusOutput8,
                  String icon1, String icon2, String icon3, String icon4, String icon5, String icon6, String icon7,String icon8,
                  String type1, String type2, String type3, String type4, String type5, String type6, String type7, String type8,
                  int time1, int time2, int time3, int time4, int time5, int time6,int time7, int time8)
                {

                    this.codigo = codigo;
                    this.name = name;
                    this.model = model;
                    this.ip = ip;
                    this.portcontroll = portcontroll;
                    this.portconfig = portconfig;
                    this.qty = qty;
                    this.nameOutput1 = nameOutput1;
                    this.nameOutput2 = nameOutput2;
                    this.nameOutput3 = nameOutput3;
                    this.nameOutput4 = nameOutput4;
                    this.nameOutput5 = nameOutput5;
                    this.nameOutput6 = nameOutput6;
                    this.nameOutput7 = nameOutput7;
                    this.nameOutput8 = nameOutput8;
                    this.statusOutput1 = statusOutput1;
                    this.statusOutput2 = statusOutput2;
                    this.statusOutput3 = statusOutput3;
                    this.statusOutput4 = statusOutput4;
                    this.statusOutput5 = statusOutput5;
                    this.statusOutput6 = statusOutput6;
                    this.statusOutput7 = statusOutput7;
                    this.statusOutput8 = statusOutput8;
                    this.icon1 = icon1;
                    this.icon2 = icon2;
                    this.icon3 = icon3;
                    this.icon4 = icon4;
                    this.icon5 = icon5;
                    this.icon6 = icon6;
                    this.icon7 = icon7;
                    this.icon8 = icon8;
                    this.type1 = type1;
                    this.type2 = type2;
                    this.type3 = type3;
                    this.type4 = type4;
                    this.type5 = type5;
                    this.type6 = type6;
                    this.type7 = type7;
                    this.type8 = type8;
                    this.time1 = time1;
                    this.time2 = time2;
                    this.time3 = time3;
                    this.time4 = time4;
                    this.time5 = time5;
                    this.time6 = time6;
                    this.time7 = time7;
                    this.time8 = time8;
    }

    public Device(String name, String model, String ip, int portcontroll, int portconfig, int qty,
                  String nameOutput1, String nameOutput2,String nameOutput3, String nameOutput4, String nameOutput5, String nameOutput6, String nameOutput7,String nameOutput8,
                  int statusOutput1, int statusOutput2, int statusOutput3, int statusOutput4, int statusOutput5, int statusOutput6, int statusOutput7, int statusOutput8,
                  String icon1, String icon2,String icon3, String icon4, String icon5, String icon6, String icon7, String icon8,
                  String type1, String type2, String type3, String type4, String type5, String type6, String type7, String type8,
                  int time1, int time2, int time3, int time4, int time5, int time6, int time7, int time8)
                {

                    this.name = name;
                    this.model = model;
                    this.ip = ip;
                    this.portcontroll = portcontroll;
                    this.portconfig = portconfig;
                    this.qty = qty;
                    this.nameOutput1 = nameOutput1;
                    this.nameOutput2 = nameOutput2;
                    this.nameOutput3 = nameOutput3;
                    this.nameOutput4 = nameOutput4;
                    this.nameOutput5 = nameOutput5;
                    this.nameOutput6 = nameOutput6;
                    this.nameOutput7 = nameOutput7;
                    this.nameOutput8 = nameOutput8;
                    this.statusOutput1 = statusOutput1;
                    this.statusOutput2 = statusOutput2;
                    this.statusOutput3 = statusOutput3;
                    this.statusOutput4 = statusOutput4;
                    this.statusOutput5 = statusOutput5;
                    this.statusOutput6 = statusOutput6;
                    this.statusOutput7 = statusOutput7;
                    this.statusOutput8 = statusOutput8;
                    this.icon1 = icon1;
                    this.icon2 = icon2;
                    this.icon3 = icon3;
                    this.icon4 = icon4;
                    this.icon5 = icon5;
                    this.icon6 = icon6;
                    this.icon7 = icon7;
                    this.icon8 = icon8;
                    this.type1 = type1;
                    this.type2 = type2;
                    this.type3 = type3;
                    this.type4 = type4;
                    this.type5 = type5;
                    this.type6 = type6;
                    this.type7 = type7;
                    this.type8 = type8;
                    this.time1 = time1;
                    this.time2 = time2;
                    this.time3 = time3;
                    this.time4 = time4;
                    this.time5 = time5;
                    this.time6 = time6;
                    this.time7 = time7;
                    this.time8 = time8;
    }

    public Device() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPortcontroll() {
        return portcontroll;
    }

    public void setPortcontroll(int portcontroll) {
        this.portcontroll = portcontroll;
    }

    public int getPortconfig() {
        return portconfig;
    }

    public void setPortconfig(int portconfig) {
        this.portconfig = portconfig;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getNameOutput1() {
        return nameOutput1;
    }

    public void setNameOutput1(String nameOutput1) {
        this.nameOutput1 = nameOutput1;
    }

    public String getNameOutput2() {
        return nameOutput2;
    }

    public void setNameOutput2(String nameOutput2) {
        this.nameOutput2 = nameOutput2;
    }

    public String getNameOutput3() {
        return nameOutput3;
    }

    public void setNameOutput3(String nameOutput3) {
        this.nameOutput3 = nameOutput3;
    }

    public String getNameOutput4() {
        return nameOutput4;
    }

    public void setNameOutput4(String nameOutput4) {
        this.nameOutput4 = nameOutput4;
    }

    public String getNameOutput5() {
        return nameOutput5;
    }

    public void setNameOutput5(String nameOutput5) {
        this.nameOutput5 = nameOutput5;
    }

    public String getNameOutput6() {
        return nameOutput6;
    }

    public void setNameOutput6(String nameOutput6) {
        this.nameOutput6 = nameOutput6;
    }

    public String getNameOutput7() {
        return nameOutput7;
    }

    public void setNameOutput7(String nameOutput7) {
        this.nameOutput7 = nameOutput7;
    }

    public String getNameOutput8() {
        return nameOutput8;
    }

    public void setNameOutput8(String nameOutput8) {
        this.nameOutput8 = nameOutput8;
    }

    public int getStatusOutput1() {
        return statusOutput1;
    }

    public void setStatusOutput1(int statusOutput1) {
        this.statusOutput1 = statusOutput1;
    }

    public int getStatusOutput2() {
        return statusOutput2;
    }

    public void setStatusOutput2(int statusOutput2) {
        this.statusOutput2 = statusOutput2;
    }

    public int getStatusOutput3() {
        return statusOutput3;
    }

    public void setStatusOutput3(int statusOutput3) {
        this.statusOutput3 = statusOutput3;
    }

    public int getStatusOutput4() {
        return statusOutput4;
    }

    public void setStatusOutput4(int statusOutput4) {
        this.statusOutput4 = statusOutput4;
    }

    public int getStatusOutput5() {
        return statusOutput5;
    }

    public void setStatusOutput5(int statusOutput5) {
        this.statusOutput5 = statusOutput5;
    }

    public int getStatusOutput6() {
        return statusOutput6;
    }

    public void setStatusOutput6(int statusOutput6) {
        this.statusOutput6 = statusOutput6;
    }

    public int getStatusOutput7() {
        return statusOutput7;
    }

    public void setStatusOutput7(int statusOutput7) {
        this.statusOutput7 = statusOutput7;
    }

    public int getStatusOutput8() {
        return statusOutput8;
    }

    public void setStatusOutput8(int statusOutput8) {
        this.statusOutput8 = statusOutput8;
    }

    public String getIcon1() {
        return icon1;
    }

    public void setIcon1(String icon1) {
        this.icon1 = icon1;
    }

    public String getIcon2() {
        return icon2;
    }

    public void setIcon2(String icon2) {
        this.icon2 = icon2;
    }

    public String getIcon3() {
        return icon3;
    }

    public void setIcon3(String icon3) {
        this.icon3 = icon3;
    }

    public String getIcon4() {
        return icon4;
    }

    public void setIcon4(String icon4) {
        this.icon4 = icon4;
    }

    public String getIcon5() {
        return icon5;
    }

    public void setIcon5(String icon5) {
        this.icon5 = icon5;
    }

    public String getIcon6() {
        return icon6;
    }

    public void setIcon6(String icon6) {
        this.icon6 = icon6;
    }

    public String getIcon7() {
        return icon7;
    }

    public void setIcon7(String icon7) {
        this.icon7 = icon7;
    }

    public String getIcon8() {
        return icon8;
    }

    public void setIcon8(String icon8) {
        this.icon8 = icon8;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public String getType5() {
        return type5;
    }

    public void setType5(String type5) {
        this.type5 = type5;
    }

    public String getType6() {
        return type6;
    }

    public void setType6(String type6) {
        this.type6 = type6;
    }

    public String getType7() {
        return type7;
    }

    public void setType7(String type7) {
        this.type7 = type7;
    }

    public String getType8() {
        return type8;
    }

    public void setType8(String type8) {
        this.type8 = type8;
    }

    public int getTime1() {
        return time1;
    }

    public void setTime1(int time1) {
        this.time1 = time1;
    }

    public int getTime2() {
        return time2;
    }

    public void setTime2(int time2) {
        this.time2 = time2;
    }

    public int getTime3() {
        return time3;
    }

    public void setTime3(int time3) {
        this.time3 = time3;
    }

    public int getTime4() {
        return time4;
    }

    public void setTime4(int time4) {
        this.time4 = time4;
    }

    public int getTime5() {
        return time5;
    }

    public void setTime5(int time5) {
        this.time5 = time5;
    }

    public int getTime6() {
        return time6;
    }

    public void setTime6(int time6) {
        this.time6 = time6;
    }

    public int getTime7() {
        return time7;
    }

    public void setTime7(int time7) {
        this.time7 = time7;
    }

    public int getTime8() {
        return time8;
    }

    public void setTime8(int time8) {
        this.time8 = time8;
    }
}
