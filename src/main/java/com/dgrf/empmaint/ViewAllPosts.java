/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import com.dgrf.empdev.DAO.EmpPostsDAO;
import com.dgrf.empdev.DTO.PostDTO;
import com.dgrf.empdev.entities.EmpPost;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

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

        EmpPostsDAO empPostsDAO = new EmpPostsDAO();
        postDTOList = new ArrayList<>();

        List<EmpPost> eps = empPostsDAO.findEmpPostEntities();

        for (int i = 0; i < eps.size(); i++) {

            PostDTO postDTO = new PostDTO();

            postDTO.setId(eps.get(i).getPostId());
            postDTO.setName(eps.get(i).getPostName());
            postDTO.setGp(eps.get(i).getPostGp());

            postDTOList.add(postDTO);
        }
        
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
