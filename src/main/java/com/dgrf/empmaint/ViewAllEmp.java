/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.dgrf.empdev.DTO.EmployeeDTO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.emp.bl.EmployeeDataService;
import org.primefaces.model.LazyDataModel;

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
    //private List<EmployeeDTO> empDTOList;
    private LazyDataModel<EmployeeDTO> empDTOList;
    private EmployeeDTO selectedEmp;

    public void viewAllEmpData() { 
        empDTOList = new EmployeeLazyDataModel();
        //EmployeeDataService empData = new EmployeeDataService();
        //empDTOList = empData.getAllEmployeeDTO();   
        
    }
    
    public String sortByEmployee() {
        System.out.println(selectedEmp.getId());
        return "/ProdByEmployee?faces-redirect=true&empId=" + selectedEmp.getId();
    }
    
    public String editEmp() {
        return "UpdateEmp?faces-redirect=true&empId=" + selectedEmp.getId() +"&empPid=" + selectedEmp.getPostId();
    }
    
    public String deleteEmp() {
        //return "DeleteEmp?faces-redirect=true&empId=" + selectedEmp.getId() +"&empPid=" + selectedEmp.getPostId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        int empId = selectedEmp.getId();
        int empPid = selectedEmp.getPostId();
        
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(empId);
        employeeDTO.setPostId(empPid);
        
        EmployeeDataService employeeDataService = new EmployeeDataService();
        responseCode = employeeDataService.deleteEmployee(employeeDTO);
        
        if (responseCode == 0) {
            fm = new FacesMessage("Employee delete alert:", "Employee data deleted Successfully.");
            context.addMessage(null, fm);
            return "ViewAllEmp?faces-redirect=true";
        } else if (responseCode == 1) {
            fm = new FacesMessage("Employee delete alert:", "Either Employee not found.");
            context.addMessage(null, fm);
            return "ViewAllEmp?faces-redirect=true";
        } else {
            fm = new FacesMessage("Employee delete alert:", "Something went wrong, please contact admin.");
            context.addMessage(null, fm);
            return "ViewAllEmp?faces-redirect=true";
        }
    }

    public LazyDataModel<EmployeeDTO> getEmpDTOList() {
        return empDTOList;
    }

    public void setEmpDTOList(LazyDataModel<EmployeeDTO> empDTOList) {
        this.empDTOList = empDTOList;
    }


    public EmployeeDTO getSelectedEmp() {
        return selectedEmp;
    }

    public void setSelectedEmp(EmployeeDTO selectedEmp) {
        this.selectedEmp = selectedEmp;
    }
    
    
}
