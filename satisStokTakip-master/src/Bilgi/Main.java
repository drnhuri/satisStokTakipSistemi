/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bilgi;

import Controller.GirisController;
import Model.GirisModel;
import View.GirisView;

/**
 *
 * @author sevinc
 */
public class Main {

    public static void main(String[] args) {
        VeriTabani veriTabani = new VeriTabani();
        GirisModel girisModel = new GirisModel();
        GirisView girisView = new GirisView();
        GirisController controller = new GirisController(girisModel, girisView);

    }

}
