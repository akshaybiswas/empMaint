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
import org.dgrf.empdev.DTO.PostDTO;
import org.dgrf.empdev.DTO.ResponseCode;
import org.emp.bl.EmployeeDataService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "addNewPost")
@ViewScoped
public class AddNewPost implements Serializable {

    /**
     * Creates a new instance of AddNewPost
     */
    private int postId;
    private String postName;
    private int postGP;
    
    public String addNewPost() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        
        PostDTO postDTO = new PostDTO();
        
        postDTO.setId(postId);
        postDTO.setName(postName);
        postDTO.setGp(postGP);
        
        EmployeeDataService employeeDataService = new EmployeeDataService();
        responseCode = employeeDataService.addPost(postDTO);
        
        if (responseCode == ResponseCode.SUCCESS) {
            fm = new FacesMessage("Post creation alert:", "Post added Successfully.");
            context.addMessage(null, fm);
            return "ViewAllPosts?faces-redirect=true";
        } else if (responseCode == ResponseCode.ALREADY_EXISISTS) {
            fm = new FacesMessage("Post creation alert:", "Post already exsists.");
            context.addMessage(null, fm);
            return "AddNewPost?faces-redirect=true";
        } else {
            fm = new FacesMessage("Post creation alert:", "duh! Something went wrong :(");
            context.addMessage(null, fm);
            return "AddNewPost?faces-redirect=true";
        }
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

    public int getPostGP() {
        return postGP;
    }

    public void setPostGP(int postGP) {
        this.postGP = postGP;
    }
    
    
    
}
