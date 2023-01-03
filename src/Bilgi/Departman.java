/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

/**
 *
 * @author hurud
 */
public class Departman {

    private int id;
    private String departmanAd;

    public Departman() {

    }

    public Departman(int id, String departmanAd) {
        this.id = id;
        this.departmanAd = departmanAd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmanAd() {
        return departmanAd;
    }

    public void setDepartmanAd(String departmanAd) {
        this.departmanAd = departmanAd;
    }

}
