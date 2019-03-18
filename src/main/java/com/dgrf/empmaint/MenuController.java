/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgrf.empmaint;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author dgrfiv
 */
@Named(value = "menuController")
@RequestScoped
public class MenuController {

    /**
     * Creates a new instance of MenuController
     */
    private MenuModel model;
    
    public MenuController() {
    }
    
    @PostConstruct
    void init() {
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu mainSubmenu = new DefaultSubMenu("Menu");
        DefaultMenuItem item;
        String menuUrl;
        
        item = new DefaultMenuItem("Dashboard");
        menuUrl = "/index?faces-redirect=true";
        item.setOutcome(menuUrl);
        mainSubmenu.addElement(item);
        
        item = new DefaultMenuItem("Employees");           
        menuUrl = "/ViewAllEmp?faces-redirect=true";
        item.setOutcome(menuUrl);
        mainSubmenu.addElement(item);
        
        item = new DefaultMenuItem("Designations");           
        menuUrl = "/ViewAllPosts?faces-redirect=true";
        item.setOutcome(menuUrl);
        mainSubmenu.addElement(item);
        
        item = new DefaultMenuItem("Products");           
        menuUrl = "/ViewAllProduct?faces-redirect=true";
        item.setOutcome(menuUrl);
        mainSubmenu.addElement(item);
        
        model.addElement(mainSubmenu);
    }

    public MenuModel getModel() {
        return model;
    }

    public void setModel(MenuModel model) {
        this.model = model;
    }
    
    
}
