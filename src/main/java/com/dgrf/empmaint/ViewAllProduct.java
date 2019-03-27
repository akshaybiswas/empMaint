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
        System.out.println(selectedProd.getId());
        return "/EmpByProduct?faces-redirect=true&prodId=" + selectedProd.getId();
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
