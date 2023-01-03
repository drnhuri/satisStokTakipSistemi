/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bilgi.VeriTabani;
import com.toedter.calendar.JDateChooser;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author sevinc
 */
public class RaporGoruntuleModel {

    private DateFormat df;

    public boolean rprGoruntule(JDateChooser baslangicDate, JDateChooser bitisDate) {
        boolean kontrol = false;

        df = new SimpleDateFormat("yyyy/M/dd");
        Date baslangic = baslangicDate.getDate();
        Date bitis = bitisDate.getDate();

        if (baslangic == null || bitis == null) {

        } else {
            kontrol = true;

        }
        return kontrol;
    }

    public DateFormat getDf() {
        return df;
    }
    public final ArrayList<ArrayList<String>> getDefaultTable(String baslangicTarih, String bitisTarih) {
        VeriTabani vti = new VeriTabani();
        String sql = "SELECT * FROM stok WHERE Tarih BETWEEN '" + baslangicTarih + "' AND '" + bitisTarih + "';";
        String message = "Sorgu yapılmadı";
        ArrayList<ArrayList<String>> queryList = vti.executeQuerySQL(sql, message, null);
        return queryList;
    }

}
