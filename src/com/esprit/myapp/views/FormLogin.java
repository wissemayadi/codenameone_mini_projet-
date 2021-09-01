/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp.views;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.esprit.myapp.entities.Candidat;
import com.esprit.myapp.services.ServiceUser;

/**
 *
 * @author naderayadi
 */
public class FormLogin extends Form{

    public FormLogin() {
            

    
//    private ServiceUtilisateur sv ;

         ServiceUser su = new ServiceUser();
        
//        sv = new ServiceUtilisateur();
        
        setTitle("Sign In");
        setLayout(new FlowLayout(CENTER,CENTER));
        
        TextField tfLogin = new TextField("","Login");
        TextField tfPwd = new TextField("","Password");
        tfPwd.setConstraint(TextField.PASSWORD);
        
        Container cnt = new Container(BoxLayout.y());

        Button btnSignIn = new Button("Sign In");
        Button btnSignUp = new Button("Create Account");
        
        cnt.addAll(tfLogin, tfPwd, btnSignIn, btnSignUp);
        
        btnSignIn.addActionListener( ev -> {
            if(tfLogin.getText().equals("")|| tfPwd.getText().equals("")){
                Dialog.show("ERROR", "champs vide!!", "OK", null);

            }else{
//                ServiceUser su = new ServiceUser();
                Candidat c = new Candidat(tfLogin.getText(),tfPwd.getText());
                 if(su.SignIn(c) == 200){
                   Dialog.show("success", "welcome", "OK", null);
                 new Profil(this,c).show();

            }else{
                     Dialog.show("ERROR", "champs vide!!", "OK", null);
                 }
            }
           
            
          
        });
        
        btnSignUp.addActionListener( ev -> {
            new FormSignUp(this).show();
        });
        
        addAll(cnt);
    }
}
    


