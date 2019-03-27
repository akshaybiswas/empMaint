/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.dgrf.empdev.DTO.EmployeeDTO;
import org.emp.bl.EmployeeDataService;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dgrfiv
 */
@Named(value = "empByPost")
@ViewScoped
public class EmpByPost implements Serializable {

    /**
     * Creates a new instance of EmpByPost
     */
    private List<EmployeeDTO> empDTOList;
    //private EmployeeDTO selectedEmp;
    private int postId;
    private String postName;

    public void viewEmpByPost() {
        
        EmployeeDataService empData = new EmployeeDataService();
        empDTOList  = empData.getEmpByPost(postId);
        
    }

    public List<EmployeeDTO> getEmpDTOList() {
        return empDTOList;
    }

    public void setEmpDTOList(List<EmployeeDTO> empDTOList) {
        this.empDTOList = empDTOList;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }      
    
}
