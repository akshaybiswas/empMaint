/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.dgrf.empdev.DAO.EmpDataDAO;
import org.dgrf.empdev.DAO.EmpPostsDAO;
import org.dgrf.empdev.DTO.EmployeeDTO;
import org.dgrf.empdev.entities.EmpDetails;
import org.dgrf.empdev.entities.EmpDetailsPK;
import org.dgrf.empdev.entities.EmpPost;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.emp.bl.EmployeeDataService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "viewAllEmp")
@ViewScoped
public class ViewAllEmp implements Serializable {

    /**
     * Creates a new instance of ViewAllEmp
     */
    private List<EmployeeDTO> empDTOList;
    private EmployeeDTO selectedEmp;

    public void viewAllEmpData() { 
        EmployeeDataService empData = new EmployeeDataService();
        empDTOList = empData.getAllEmployeeDTO();   
        
    }
    
    public String sortByEmployee() {
        System.out.println(selectedEmp.getId());
        return "/ProdByEmployee?faces-redirect=true&empId=" + selectedEmp.getId();
    }
    
    public String editEmp() {
        System.out.println(selectedEmp.getId());
        return "UpdateEmp?faces-redirect=true&empId=" + selectedEmp.getId() +"&empPid=" + selectedEmp.getPostId();
    }

    public List<EmployeeDTO> getEmpDTOList() {
        return empDTOList;
    }

    public void setEmpDTOList(List<EmployeeDTO> empDTOList) {
        this.empDTOList = empDTOList;
    }

    public EmployeeDTO getSelectedEmp() {
        return selectedEmp;
    }

    public void setSelectedEmp(EmployeeDTO selectedEmp) {
        this.selectedEmp = selectedEmp;
    }
    
    
}
