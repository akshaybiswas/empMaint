/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.dgrf.empdev.DTO.ProductDTO;
import org.dgrf.empdev.DTO.ResponseCode;
import org.emp.bl.EmployeeDataService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "addNewProduct")
@ViewScoped
public class AddNewProduct implements Serializable {

    /**
     * Creates a new instance of AddNewProduct
     */
    private int prodId;
    private String prodName;
    private int prodPrice;
    
    
    public String addNewProduct() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        
        ProductDTO productDTO = new ProductDTO();
        
        productDTO.setId(prodId);
        productDTO.setName(prodName);
        productDTO.setPrice(prodPrice);
        
        EmployeeDataService employeeDataService = new EmployeeDataService();
        responseCode = employeeDataService.addProduct(productDTO);
        
        if (responseCode == ResponseCode.SUCCESS) {
            fm = new FacesMessage("Product creation alert:", "Product added Successfully.");
            context.addMessage(null, fm);
            return "ViewAllProduct?faces-redirect=true";
        } else if (responseCode == ResponseCode.ALREADY_EXISISTS) {
            fm = new FacesMessage("Product creation alert:", "Product already exsists.");
            context.addMessage(null, fm);
            return "AddNewProduct?faces-redirect=true";
        } else {
            fm = new FacesMessage("Product creation alert:", "duh! Something went wrong :(");
            context.addMessage(null, fm);
            return "AddNewProduct?faces-redirect=true";
        }
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }
    
    
    
}
