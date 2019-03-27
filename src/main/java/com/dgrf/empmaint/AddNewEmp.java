/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.dgrf.empdev.DTO.EmployeeDTO;
import org.dgrf.empdev.DTO.PostDTO;
import org.dgrf.empdev.DTO.ProductDTO;
import org.dgrf.empdev.DTO.ResponseCode;
import org.emp.bl.EmployeeDataService;
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

/**
 *
 * @author dgrfiv
 */
@Named(value = "addNewEmp")
@ViewScoped
public class AddNewEmp implements Serializable {

    /**
     * Creates a new instance of AddNewEmp
     */
    private int empId;
    private String empName;
    private int selectedEmpPostId;
    private Integer[] selectedProdList;

    private Map<String, Integer> postListMap;
    private List<SelectItem> productList;

    public void fillDropdownValues() {

        EmployeeDataService empData = new EmployeeDataService();
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
    }

    public String addNewEmployee() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(empId);
        employeeDTO.setPostId(selectedEmpPostId);
        employeeDTO.setName(empName);
        employeeDTO.setProductIdList(selectedProdList);

        EmployeeDataService empData = new EmployeeDataService();
        responseCode = empData.addEmployee(employeeDTO);

        if (responseCode == ResponseCode.SUCCESS) {
            fm = new FacesMessage("Employee creation alert:", "Employee added Successfully.");
            context.addMessage(null, fm);
            return "ViewAllEmp?faces-redirect=true";
        } else if (responseCode == ResponseCode.ALREADY_EXISISTS) {
            fm = new FacesMessage("Employee creation alert:", "Employee already exsists.");
            context.addMessage(null, fm);
            return "AddNewEmp?faces-redirect=true";
        } else {
            fm = new FacesMessage("Employee creation alert:", "duh! Something went wrong :(");
            context.addMessage(null, fm);
            return "AddNewEmp?faces-redirect=true";
        }
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getSelectedEmpPostId() {
        return selectedEmpPostId;
    }

    public void setSelectedEmpPostId(int selectedEmpPostId) {
        this.selectedEmpPostId = selectedEmpPostId;
    }

    public Map<String, Integer> getPostMap() {
        return postListMap;
    }

    public void setPostMap(Map<String, Integer> postMap) {
        this.postListMap = postMap;
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

    public Integer[] getSelectedProdList() {
        return selectedProdList;
    }

    public void setSelectedProdList(Integer[] selectedProdList) {
        this.selectedProdList = selectedProdList;
    }

}
