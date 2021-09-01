/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp.views;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.esprit.myapp.MyApplication;
import com.esprit.myapp.entities.Candidat;
import com.esprit.myapp.services.ServiceUser;
import com.esprit.myapp.utils.StaticVars;
import static com.esprit.myapp.utils.StaticVars.currentCandidat;

public class Profil extends Form {

    public Profil(Form previous, Candidat candidat) {

        setTitle("Profile");
        setLayout(BoxLayout.y());
   Container  cnt = new Container();
        ImageViewer profilePic = new ImageViewer(MyApplication.theme.getImage("Profile.png"));
        Label lbLogin = new Label("Login: " + StaticVars.currentCandidat.getLogin());
        Label lbEmail = new Label("Email: " + StaticVars.currentCandidat.getEmail());
        Label lbPays = new Label("Pays: " + StaticVars.currentCandidat.getPays());
        Label lbVille = new Label("Ville:" + StaticVars.currentCandidat.getVille());
        Label lbTel = new Label("Tel: " + StaticVars.currentCandidat.getTel());
        Label lbDomaine = new Label("Domaine: " + StaticVars.currentCandidat.getDomaine());

        
        
        
        Button btnUpdate = new Button("update");
        Button btnDelete = new Button("Delete");

        getToolbar().addCommandToRightBar("Retour", null, (evt) -> {
            new FormHome(this, candidat).show();
        });
        getToolbar().addCommandToLeftBar("View cv", null, (evt) -> {
            new PDFloader(this).show();
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Dialog.show("Info:", "id=" + StaticVars.currentCandidat.getId(), "ok", null);
                ServiceUser su = new ServiceUser();
                if (su.deleteUser(currentCandidat) == 200) {
                    Dialog.show("success", "we wish see you again!", "ok", null);

                    new FormLogin().show();
                } else {
                    Dialog.show("Error", "we try to fix the error!", "ok", null);
                }

            }

        });
  
        
        
//        btnUpdate.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//      Dialog.show("Info:", "id=" + StaticVars.currentCandidat.getId(), "ok", null);
//                ServiceUser su = new ServiceUser();
//                if (su.updateUser(currentCandidat) == 200) {
//                    
//                    
//                    Dialog.show("success", "we wish see you again!", "ok", null);
//
//                    new FormLogin().show();
//                } else {
//                    Dialog.show("Error", "we try to fix the error!", "ok", null);
//                }
//            }
//
//        });

btnUpdate.addActionListener(evt->{ 
    new FormUpdate(this,candidat).show();
 
 
});

        addAll(profilePic, lbLogin, lbEmail, lbPays, lbVille, lbTel, lbDomaine, btnDelete, btnUpdate);
    }

}
