/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import com.dgrf.empdev.DTO.ProductDTO;
import com.org.empdev.EmpData;
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
    private ProductDTO selectedPost;
    
    public void viewAllProduct() {
        EmpData empData = new EmpData();
        productDTOList = empData.getAllProducts(); 
    
    }
    
    public String sortByProduct() {
        System.out.println(selectedPost.getId());
        return "/EmpByProduct?faces-redirect=true&prodId=" + selectedPost.getId();
    }
    

    public List<ProductDTO> getProductDTOList() {
        return productDTOList;
    }

    public void setProductDTOList(List<ProductDTO> productDTOList) {
        this.productDTOList = productDTOList;
    }

    public ProductDTO getSelectedPost() {
        return selectedPost;
    }

    public void setSelectedPost(ProductDTO selectedPost) {
        this.selectedPost = selectedPost;
    }
    
    
}
