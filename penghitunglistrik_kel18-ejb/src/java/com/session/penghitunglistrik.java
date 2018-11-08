/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.session;

import java.text.DecimalFormat;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author bleezy
 */
@Stateless
@LocalBean
public class penghitunglistrik {
    
    DecimalFormat a = new DecimalFormat("0.0");
    String hasil;

    public String perhitunganlistrik(double daya, double waktu) {
        return hasil  = a.format((daya * waktu)/1000 *(1200 * 30));
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
