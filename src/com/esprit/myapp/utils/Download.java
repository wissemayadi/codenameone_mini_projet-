/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.esprit.myapp.utils;
//
//import com.codename1.capture.Capture;
//import java.io.BufferedInputStream;
//import com.codename1.io.ConnectionRequest;
//import com.codename1.io.File;
//import com.codename1.io.JSONParser;
//import com.codename1.io.MultipartRequest;
//import com.codename1.io.NetworkManager;
//import com.codename1.io.URL;
//import com.codename1.io.URL.HttpURLConnection;
//import com.codename1.ui.BrowserComponent;
//import com.codename1.util.Callback;
//import java.io.ByteArrayInputStream;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.URISyntaxException;
//import java.util.Hashtable;
//import java.util.Map;

/**
 *
 * @author naderayadi
 */
//public class Download implements Runnable {

//    private static void Download(String urlStr,String fileStr ) throws Exception{
//        URL url =new URL(urlStr);
//        BufferedInputStream bis = new BufferedInputStream(url.openStream());
//        FileOutputStream fis = new FileOutputStream(fileStr);
//        byte[] buffer = new byte [1024];
//        int count =0;
//        while((count =bis.read(buffer,0,1024))!=-1){
//            fis.write(buffer,0,count);
//        }
//        fis.close();
//        bis.close();
//    }

 

//    String link ;
//    File out ;
//     public Download( String link , File out){
//         this.link=link;
//         this.out=out;
//     }
//
//
//
//    @Override
//    public void run() {
//        try {
//            URL url =new URL(link);
//            HttpURLConnection http = (HttpURLConnection) url.openConnection();
//            double fileSize= (double)http.getContentLength();
//            BufferedInputStream in = new BufferedInputStream(http.getInputStream());
//           FileOutputStream fos = new FileOutputStream(this.out) ;
//           BufferedInputStream bout = new BufferedInputStream(fos,1024);
//        } catch (Exception e) {
//        }
//        
//    }
//
//}




    

