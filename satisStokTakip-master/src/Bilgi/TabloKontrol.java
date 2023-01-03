/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;


import java.util.ArrayList;

/**
 *
 * @author sevinc
 */
public class TabloKontrol {
    private String sortToggle = "desc";
    VeriTabaniIslemler vti;
   
    
       public  ArrayList<ArrayList<String>> getDefaultTable(String tabloAdi) {
        vti = new VeriTabaniIslemler() {};
        String sql = "Select * FROM "+tabloAdi+"  ;";
        String message = "Sorgu yapılmadı";
        ArrayList<ArrayList<String>> queryList = vti.executeQuerySQL(sql, message, null);
        return queryList;
    }

    public  ArrayList<ArrayList<String>> getSortedTable(String tabloAdi, String kolonAdi) {
        vti = new VeriTabaniIslemler() {};

        sortToggle = sortToggle.equals("asc") ? "desc" : "asc";
        String sql = "Select * FROM " + tabloAdi + "  order by " + kolonAdi + " " + sortToggle + " ;";
        String message = "Sorgu yapılmadı";
        ArrayList<ArrayList<String>> queryList = vti.executeQuerySQL(sql, message, null);
        return queryList;
    }
    

    

   
}
