/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.dgrf.empdev.DTO.ProductDTO;
import org.emp.bl.EmployeeDataService;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author dgrfiv
 */
@Named(value = "viewAllProduct")
@ViewScoped
public class ViewAllProduct implements Serializable {

    /**
     * Creates a new instance of ViewAllProduct
     */
    private List<ProductDTO> productDTOList;
    private ProductDTO selectedProd;
    
    public void viewAllProduct() {
        EmployeeDataService empData = new EmployeeDataService();
        productDTOList = empData.getAllProductDTO(); 
    
    }
    
    public String sortByProduct() {
        //System.out.println(selectedProd.getId());
        return "/EmpByProduct?faces-redirect=true&prodId=" + selectedProd.getId();
    }
    
    public String editProduct() {
        return "UpdateProduct?faces-redirect=true&prodId=" + selectedProd.getId();
    }
    
    public String deleteProduct() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        int prodId = selectedProd.getId();
        
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(prodId);
        
        EmployeeDataService employeeDataService = new EmployeeDataService();
        responseCode = employeeDataService.deleteProduct(productDTO);
        
        if (responseCode == 0) {
            fm = new FacesMessage("Product delete alert:", "Product data deleted Successfully.");
            context.addMessage(null, fm);
            return "ViewAllProduct?faces-redirect=true";
        } else if (responseCode == 1) {
            fm = new FacesMessage("Product delete alert:", "Either Product not found.");
            context.addMessage(null, fm);
            return "ViewAllProduct?faces-redirect=true";
        } else {
            fm = new FacesMessage("Product delete alert:", "Something went wrong, please contact admin.");
            context.addMessage(null, fm);
            return "ViewAllProduct?faces-redirect=true";
        }
    }

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    public ProductDTO getSelectedProd() {
        return selectedProd;
    }

    public void setSelectedProd(ProductDTO selectedProd) {
        this.selectedProd = selectedProd;
    }
    
    
}
