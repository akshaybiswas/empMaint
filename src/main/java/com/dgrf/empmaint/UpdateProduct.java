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
import org.emp.bl.EmployeeDataService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "updateProduct")
@ViewScoped
public class UpdateProduct implements Serializable {

    /**
     * Creates a new instance of UpdateProduct
     */
    private ProductDTO productDTO;
    private int prodId;
    private String prodName;
    private int prodPrice;
    
    public void fillValues() {
        EmployeeDataService employeeDataService = new EmployeeDataService();
        productDTO = employeeDataService.getProductDTO(prodId);
        
        prodId = productDTO.getId();
        prodName = productDTO.getName();
        prodPrice = productDTO.getPrice();
    }
    
    public String updateSelectedProduct() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        EmployeeDataService employeeDataService = new EmployeeDataService();
        productDTO = new ProductDTO();
        productDTO.setId(prodId);
        productDTO.setName(prodName);
        productDTO.setPrice(prodPrice);
        
        responseCode = employeeDataService.updateProduct(productDTO);
        
        if (responseCode == 0) {
            fm = new FacesMessage("Product changes alert:", "Product data changed Successfully.");
            context.addMessage(null, fm);
            return "ViewAllProduct?faces-redirect=true";
        } else {
            fm = new FacesMessage("Product changes alert:", "Either Product not found or something went wrong.");
            context.addMessage(null, fm);
            return "UpdateProduct?faces-redirect=true&prodId=" + prodId;
        }
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
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
