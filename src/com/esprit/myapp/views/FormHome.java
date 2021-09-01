/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp.views;

import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.esprit.myapp.entities.Candidat;

/**
 *
 * @author naderayadi
 */
public class FormHome extends Form {

    public FormHome(Form previous,Candidat candidat) {
           getToolbar().addCommandToRightBar("Go to profile", null, (evt) -> {
            previous.showBack();
            
           
        });
        
           getToolbar().addCommandToLeftSideMenu("home",null,(evt)->{
                           Dialog.show("Information", "Vous etes dans la form home !", "OK", null);

           });
              getToolbar().addCommandToLeftSideMenu("profil",null,(evt)->{
               new Profil(this,candidat).show();
           });
              
                 getToolbar().addCommandToLeftSideMenu("logout",null,(evt)->{
               new FormLogin().show();
           });
    }
    
}
