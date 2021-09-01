/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp.services;

import com.codename1.db.Cursor;
import com.codename1.db.Row;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.myapp.entities.Candidat;
import com.esprit.myapp.utils.StaticVars;
import static com.esprit.myapp.utils.StaticVars.currentCandidat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceUser {

    int result = 0;
    ArrayList<Candidat> candidat;

    public int addPerson(Candidat c) {
        String url = StaticVars.baseURL + "/adduser";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("login", c.getLogin());
        req.addArgument("password", c.getPassword());
        req.addArgument("password2", c.getPassword2());
        req.addArgument("email", c.getEmail());
        req.addArgument("pays", c.getVille());
        req.addArgument("ville", c.getVille());
        req.addArgument("codep", Integer.toString(c.getCodePostal()));
        req.addArgument("adresse", c.getAdresse());
        req.addArgument("tel", Integer.toString(c.getTel()));
        req.addArgument("domaine", c.getDomaine());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    public int SignIn(Candidat c) {
        Candidat candidat = null;
        String url = StaticVars.baseURL + "/login";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(true);
        req.addArgument("id", Integer.toString(c.getId()));
        req.addArgument("login", c.getLogin());
        req.addArgument("password", c.getPassword());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                try {
                    result = req.getResponseCode();
                    System.out.println(req.getResponseData());
                    Map<String, Object> results;
                    results = new JSONParser().parseJSON(new InputStreamReader(new ByteArrayInputStream(req.getResponseData()), "UTF-8"));
                    List<Object> response = (List<Object>) results.get("root");
                    System.out.println(results);
                    System.out.println(response);

                    Map<String, Object> current = (Map<String, Object>) response.get(0);

                    float id = Float.parseFloat(current.get("id").toString());
                    currentCandidat.setId((int) id);
                    System.out.println("cuurent" + current);
                    currentCandidat.setLogin(current.get("login").toString());
                    currentCandidat.setEmail(current.get("email").toString());
                    currentCandidat.setPays(current.get("pays").toString());
                    currentCandidat.setVille(current.get("ville").toString());
                    float tel = Float.parseFloat(current.get("tel").toString());
                    currentCandidat.setTel((int) tel);
                    currentCandidat.setDomaine(current.get("domaine").toString());

//System.out.println(response);
                } catch (UnsupportedEncodingException ex) {
                    System.out.println(ex.getMessage());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;

    }


    public ArrayList<Candidat> parsePersons(String jsonText) {
        try {
            candidat = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> personsListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) personsListJson.get("root");
            for (Map<String, Object> objet : list) {
                Candidat c = new Candidat();
                c.setLogin(objet.get("login").toString());
                c.setEmail(objet.get("email").toString());
                c.setPays(objet.get("pays").toString());
                float id = Float.parseFloat(objet.get("id").toString());
                c.setId((int) id);

                candidat.add(c);

            }

        } catch (IOException ex) {
        }
        return (candidat);
    }

    public int deleteUser(Candidat c) {

        String url = StaticVars.baseURL + "/deleteuser";
        ConnectionRequest req = new ConnectionRequest();
            req.setUrl(url);
        req.setPost(true);

        String can = String.valueOf(currentCandidat.getId());
        req.addArgument("id", can);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return result;
    }

    public int updateUser(Candidat c) {
        
//        String url = StaticVars.baseURL + "/updateuser";
         String url = StaticVars.baseURL + "/updateuser";
            System.out.println(url);
        ConnectionRequest req = new ConnectionRequest();

        req.setUrl(url);
        req.setPost(true);

req.setHttpMethod("PUT");               


      String can = String.valueOf(currentCandidat.getId());
       req.addArgument("id", can);
        String login =String .valueOf(currentCandidat.getLogin());
        req.addArgument("login",login);
        req.addArgument("email", String .valueOf(currentCandidat.getEmail()));
        req.addArgument("pays", String .valueOf(currentCandidat.getPays()));
        req.addArgument("ville", String .valueOf(currentCandidat.getVille()));
         req.addArgument("tel", Integer.toString(currentCandidat.getTel()));
        req.addArgument("domaine", String .valueOf(currentCandidat.getDomaine()));

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
       
                System.out.println(result);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return result;
    }

    public Candidat getUserByid(int id) {
//        Candidat candidat = new Candidat();
      Candidat candidat = StaticVars.currentCandidat;
        String url = StaticVars.baseURL + "/userbyid";
        ConnectionRequest req = new ConnectionRequest();
        req.setUrl(url);
        req.setPost(false);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                result = req.getResponseCode();
            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        return candidat;

    }

}
