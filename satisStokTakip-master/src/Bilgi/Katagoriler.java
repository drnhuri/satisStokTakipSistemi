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
public class Katagoriler {
    private String katagoriAdi;
    
    public String getKatagoriAdi() {
        return katagoriAdi;
    }

    public void setKatagoriAdi(String katagoriAdi) {
        this.katagoriAdi = katagoriAdi;
    }

    public Katagoriler(String katagoriAdi) {
        
        this.katagoriAdi = katagoriAdi;
    }

    public Katagoriler() {
    }
     public final ArrayList<String> katagoriler(){
         VeriTabaniIslemler vti = new VeriTabaniIslemler() {};
          ArrayList<String> katagori = vti.katagoriler();
          return katagori;
     }
    }
    

