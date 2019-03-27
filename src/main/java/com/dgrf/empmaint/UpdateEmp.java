/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dgrfiv
 */
@Named(value = "updateEmp")
@ViewScoped
public class UpdateEmp implements Serializable {

    /**
     * Creates a new instance of UpdateEmp
     */
    private int empId;
    private int empPostId;
    private String empName;
    private String empPostName;
    
    public UpdateEmp() {
    }
    
}
