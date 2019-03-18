/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import com.dgrf.empdev.DAO.EmpDataDAO;
import com.dgrf.empdev.DAO.EmpPostsDAO;
import com.dgrf.empdev.DTO.EmployeeDTO;
import com.dgrf.empdev.entities.EmpDetails;
import com.dgrf.empdev.entities.EmpDetailsPK;
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
@Named(value = "viewAllEmp")
@ViewScoped
public class ViewAllEmp implements Serializable {

    /**
     * Creates a new instance of ViewAllEmp
     */
    private List<EmployeeDTO> empDTOList;
    //private EmployeeDTO selectedEmp;

    public void viewAllEmpData() {

        EmpDataDAO empDataDAO = new EmpDataDAO();
        EmpPostsDAO empPostsDAO = new EmpPostsDAO();
        empDTOList = new ArrayList<>();

        List<EmpDetails> emps = empDataDAO.findEmpDetailsEntities();

        for (int i = 0; i < emps.size(); i++) {
            EmpDetailsPK edPK = emps.get(i).getEmpDetailsPK();
            EmpPost ep = empPostsDAO.findEmpPost(edPK.getPostId());

            EmployeeDTO empDTO = new EmployeeDTO();

            empDTO.setId(edPK.getEmpId());
            empDTO.setName(emps.get(i).getEmpName());
            empDTO.setPostId(edPK.getPostId());
            empDTO.setJoined(emps.get(i).getEmpJoined());
            empDTO.setExp(emps.get(i).getEmpExp());
            empDTO.setSalary(emps.get(i).getEmpSalary());
            empDTO.setPostName(ep.getPostName());

            empDTOList.add(empDTO);
        }
        
    }

    public List<EmployeeDTO> getEmpDTOList() {
        return empDTOList;
    }

    public void setEmpDTOList(List<EmployeeDTO> empDTOList) {
        this.empDTOList = empDTOList;
    }
}
