/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import org.dgrf.empdev.DAO.EmpPostsDAO;
import org.dgrf.empdev.DTO.PostDTO;
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
@Named(value = "viewAllPosts")
@ViewScoped
public class ViewAllPosts implements Serializable{

    /**
     * Creates a new instance of ViewAllEmp
     */
    private List<PostDTO> postDTOList;
    private PostDTO selectedPost;

    public void viewAllPostsData() {
        EmployeeDataService eds = new EmployeeDataService();
        postDTOList = eds.getAllPostDTO();
    }
    
    public String sortByPost() {
        System.out.println(selectedPost.getId());
        return "/EmpByPost?faces-redirect=true&postId=" + selectedPost.getId();
    }

    public List<PostDTO> getPostDTOList() {
        return postDTOList;
    }

    public void setPostDTOList(List<PostDTO> postDTOList) {
        this.postDTOList = postDTOList;
    }

    public PostDTO getSelectedPost() {
        return selectedPost;
    }

    public void setSelectedPost(PostDTO selectedPost) {
        this.selectedPost = selectedPost;
    }
    
}
