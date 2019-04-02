/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import java.util.List;
import java.util.Map;
import org.dgrf.empdev.DTO.EmployeeDTO;
import org.emp.bl.EmployeeDataService;
import org.emp.bl.OverallCount;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author dgrfiv
 */
public class EmployeeLazyDataModel extends LazyDataModel<EmployeeDTO>{
    public EmployeeLazyDataModel(){
      System.out.println("--------- "+this+" -----------------");
      OverallCount oc = new OverallCount();
      this.setRowCount(oc.numberOfEmp());
  }
  @Override
  public List<EmployeeDTO> load(int first, int pageSize, String sortField,
                             SortOrder sortOrder, Map<String, Object> filters) {
      EmployeeDataService employeeDataService = new EmployeeDataService();
      List<EmployeeDTO> list = employeeDataService.getAllEmployeeDTO(first, pageSize);
      return list;
  }
    
}
