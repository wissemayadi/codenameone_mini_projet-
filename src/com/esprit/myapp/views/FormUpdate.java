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
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.esprit.myapp.entities.Candidat;
import com.esprit.myapp.services.ServiceUser;
import com.esprit.myapp.utils.StaticVars;
import static com.esprit.myapp.utils.StaticVars.currentCandidat;

/**
 *
 * @author naderayadi
 */
public class FormUpdate extends Form {

    public FormUpdate(Form previous,Candidat candidat) {
        setTitle("update user");
          setLayout(new FlowLayout(CENTER,CENTER));
          setLayout( BoxLayout.x());
             setLayout( BoxLayout.y());

      TextField lbLogin = new TextField();
      
       TextField lbEmail = new TextField();
        TextField lbPays = new TextField();
       TextField lbVille = new TextField();
       TextField lbTel = new TextField();
        TextField lbDomaine = new TextField();
        
        Label bLogin = new Label ("Login"); 
        Label bEmail = new Label ("Email");
          Label bPays = new Label ("Pays");
            Label bville = new Label ("Ville");
              Label bTel = new Label ("Tel");
          Label bDomaine = new Label ("Domaine");
          
          lbLogin.setText(StaticVars.currentCandidat.getLogin());
        lbEmail.setText(StaticVars.currentCandidat.getEmail());
      lbPays.setText(StaticVars.currentCandidat.getPays());
      lbVille.setText(StaticVars.currentCandidat.getVille());
      lbTel.setText(Integer.toString(StaticVars.currentCandidat.getTel()));
      lbDomaine.setText(StaticVars.currentCandidat.getDomaine());
        
        
        
        
       Button btnValid=new Button("valider");
       
       
       
        btnValid.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceUser su = new ServiceUser();

         Candidat candidatupdate = new ServiceUser().getUserByid(1);
            candidatupdate.setId(StaticVars.currentCandidat.getId());
          candidatupdate.setLogin(lbLogin.getText());
          candidatupdate.setEmail(lbEmail.getText());
          candidatupdate.setPays(lbPays.getText());
          candidatupdate.setVille(lbVille.getText());
          candidatupdate.setTel(Integer.parseInt(lbTel.getText()));
          candidatupdate.setDomaine(lbDomaine.getText());
          

  if(su.updateUser(candidatupdate)==200){
                 Dialog.show("success", "contact updated!", "ok", null);

               previous.showBack();
           }else{
                 Dialog.show("error", "try to fix your data!!!", "ok", null);
           }

            }
            
        });
        getToolbar().addCommandToRightBar("Retour", null, (evt) -> {
           previous.showBack();
          
        });
        
//        ServiceUser su = new ServiceUser();
          addAll( bLogin,lbLogin,bEmail,lbEmail,bPays, lbPays,bville, lbVille,bTel, lbTel,bDomaine, lbDomaine,btnValid);
        
    }
          

}
