/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp.views;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.esprit.myapp.entities.Candidat;
import com.esprit.myapp.services.ServiceUser;

/**
 *
 * @author naderayadi
 */
public class FormSignUp extends Form{

//  private ServiceUtilisateur sv ;

    public FormSignUp(Form previous) {
        
//        sv = new ServiceUtilisateur();
       ServiceUser su = new ServiceUser();

        setTitle("Sign Up");
        setLayout(BoxLayout.y());
        

        TextField tfLogin = new TextField("","Login");
        TextField tfPassword = new TextField("","Password");
        tfPassword.setConstraint(TextField.PASSWORD);
      TextField tfPassword2 = new TextField("","Password2");
        tfPassword2.setConstraint(TextField.PASSWORD);
           TextField tfEmail = new TextField("","Email");
        TextField tfPays = new TextField("","Pays");
       TextField tfVille = new TextField("","Ville");
          TextField tfCodepostale = new TextField("","code postale");
               TextField tfAdresse = new TextField("","Adresse");
               TextField tfTel = new TextField("","Tel");
                      TextField tfDomaine = new TextField("","Domaine");
               
        Button btnSignIn = new Button("Go To Sign In");
        Button btnSignUp = new Button("Register !");
        
        btnSignIn.addActionListener( ev -> {
            previous.showBack();            
        });
        
        btnSignUp.addActionListener( new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                if (tfLogin.getText().equals("")|| tfLogin.getText().equals("") || tfPassword.getText().equals("")|| tfPassword2.getText().equals("")|| tfEmail.getText().equals("")||tfPays .getText().equals("")||tfVille.getText().equals("")|| tfCodepostale.getText().equals("")|| tfAdresse.getText().equals("")||tfTel.getText().equals("")||tfDomaine.getText().equals("")) {
                    Dialog.show("ERROR", "champs vide!!", "OK", null);
                } else if (! tfPassword.getText().equals(tfPassword2.getText())|| !tfPassword2.getText().equals(tfPassword.getText())) {
                    Dialog.show("ERROR", "password non authentique", "OK", null);
                }else if(tfLogin.getText().length() < 5){
                    
                 Dialog.show("ERROR", "Login DOIT AVOIR AU MOINS 5 CARACTÈRES", "OK", null);
                } else {
                    Candidat c = new Candidat(tfLogin.getText(),tfPassword.getText(),tfPassword2.getText(),tfEmail.getText(),tfPays.getText(),tfVille.getText(),Integer.parseInt(tfCodepostale.getText()),tfAdresse.getText(),Integer.parseInt(tfTel.getText()),tfDomaine.getText());
//                    ServiceUser su = new ServiceUser();
                    if (su.addPerson(c) == 200) {
                        Dialog.show("SUCCESS", "Personne ajoutée avec succès", "OK", null);
                      previous.showBack();
                    } else {
                     Dialog.show("ERROR", "ERREUR SERVEUR", "OK", null);   
                    }
                }
            }                           
         
        });
        
        addAll( tfLogin, tfPassword,tfPassword2,tfEmail,tfPays,tfVille,tfCodepostale,tfAdresse,tfTel,tfDomaine, btnSignUp, btnSignIn);
    }
    

    
    
   
}


    
    

