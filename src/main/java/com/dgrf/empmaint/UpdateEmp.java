/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dgrf.empdev.DTO.EmployeeDTO;
import org.dgrf.empdev.DTO.PostDTO;
import org.dgrf.empdev.DTO.ProductDTO;
import org.emp.bl.EmployeeDataService;

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
    private EmployeeDTO employeeDTO;
    private int empId;
    private int empPid;
    private String empName;
    private Integer[] selectedProdList;
    private int selectedEmpPostId;

    private Map<String, Integer> postListMap;
    private List<SelectItem> productList;
    
    public UpdateEmp() {
    }
    
    public void fillDropdownValues() {

        EmployeeDataService empData = new EmployeeDataService();
        employeeDTO = new EmployeeDTO();
        
        employeeDTO.setId(empId);
        employeeDTO.setPostId(empPid);
        
        employeeDTO = empData.getEmployeeDTO(employeeDTO);
        
        
        List<PostDTO> postDTOList = empData.getAllPostDTO();
        postListMap = new HashMap<>();

        for (int i = 0; i < postDTOList.size(); i++) {
            postListMap.put(postDTOList.get(i).getName(), postDTOList.get(i).getId());
        }

        productList = new ArrayList<>();
        List<ProductDTO> productDTOList = empData.getAllProductDTO();

        for (int j = 0; j < productDTOList.size(); j++) {
            productList.add(new SelectItem(productDTOList.get(j).getId(), productDTOList.get(j).getName()));

        }
        
        empId = employeeDTO.getId();
        empName = employeeDTO.getName();
        selectedEmpPostId = employeeDTO.getPostId();
        selectedProdList = employeeDTO.getProductIdList();

    }
    
    public String updateSelectedEmp() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        EmployeeDataService employeeDataService = new EmployeeDataService();
        employeeDTO = new EmployeeDTO();
        employeeDTO.setId(empId);
        employeeDTO.setName(empName);
        employeeDTO.setPostId(selectedEmpPostId);
        employeeDTO.setProductIdList(selectedProdList);
        responseCode = employeeDataService.updateEmployee(employeeDTO);

        if (responseCode == 0) {
            fm = new FacesMessage("User changes alert:", "User data changed Successfully.");
            context.addMessage(null, fm);
            return "ViewAllEmp?faces-redirect=true";
        } else {
            fm = new FacesMessage("User changes alert:", "Either user not found or something went wrong.");
            context.addMessage(null, fm);
            return "UpdateEmp?faces-redirect=true&empId=" + empId +"&empPid=" + empPid;
        }

    }

    public EmployeeDTO getEmployeeDTO() {
        return employeeDTO;
    }

    public void setEmployeeDTO(EmployeeDTO employeeDTO) {
        this.employeeDTO = employeeDTO;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public int getEmpPid() {
        return empPid;
    }

    public void setEmpPid(int empPid) {
        this.empPid = empPid;
    }

    public Integer[] getSelectedProdList() {
        return selectedProdList;
    }

    public void setSelectedProdList(Integer[] selectedProdList) {
        this.selectedProdList = selectedProdList;
    }

    public int getSelectedEmpPostId() {
        return selectedEmpPostId;
    }

    public void setSelectedEmpPostId(int selectedEmpPostId) {
        this.selectedEmpPostId = selectedEmpPostId;
    }

    public Map<String, Integer> getPostListMap() {
        return postListMap;
    }

    public void setPostListMap(Map<String, Integer> postListMap) {
        this.postListMap = postListMap;
    }

    public List<SelectItem> getProductList() {
        return productList;
    }

    public void setProductList(List<SelectItem> productList) {
        this.productList = productList;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    
}
