/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.emp.bl.OverallCount;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dgrfiv
 */
@Named(value = "dashBoard")
@ViewScoped
public class DashBoard implements Serializable{

    /**
     * Creates a new instance of DashBoard
     */
    private int empCount;
    private int prodCount;
    
    public DashBoard() {
        
        OverallCount overallCount = new OverallCount();
        empCount = overallCount.numberOfEmp();
        prodCount = overallCount.numberOfProd();
        
    }

    public int getEmpCount() {
        return empCount;
    }

    public void setEmpCount(int empCount) {
        this.empCount = empCount;
    }

    public int getProdCount() {
        return prodCount;
    }

    public void setProdCount(int prodCount) {
        this.prodCount = prodCount;
    }
    
    
    
}
