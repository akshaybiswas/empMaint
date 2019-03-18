/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import com.dgrf.empdev.DTO.EmployeeDTO;
import com.org.empdev.EmpData;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dgrfiv
 */
@Named(value = "empByProduct")
@ViewScoped
public class EmpByProduct implements Serializable {

    /**
     * Creates a new instance of EmpByProduct
     */
    private List<EmployeeDTO> empDTOList;
    //private EmployeeDTO selectedEmp;
    private int prodId;
    
    public void viewEmpByProduct() {
        EmpData empData = new EmpData();
        empDTOList  = empData.getEmpByProd(prodId);
    }

    public List<EmployeeDTO> getEmpDTOList() {
        return empDTOList;
    }

    public void setEmpDTOList(List<EmployeeDTO> empDTOList) {
        this.empDTOList = empDTOList;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }
    
    
}
