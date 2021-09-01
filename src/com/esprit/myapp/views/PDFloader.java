/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.myapp.views;

import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
//import static com.esprit.myapp.utils.Exemple.encode;


/**
 *
 * @author naderayadi
 */
public class PDFloader extends Form {

    public PDFloader(Form previous) {
      Form hi = new Form("PDF Viewer", BoxLayout.y());
Button devGuide = new Button("Show cv");

devGuide.addActionListener(e -> {
    FileSystemStorage fs = FileSystemStorage.getInstance();
        String fileName = fs.getAppHomePath() + "pdf-sample.pdf";
    if(!fs.exists(fileName)) {
        Util.downloadUrlToFile("http://www.polyu.edu.hk/iaee/files/pdf-sample.pdf", fileName, true);
//        Util.downloadUrlToFile("http:127.0.0.1/Cv.pdf", fileName, true);

    }
    Display.getInstance().execute(fileName);
});

getToolbar().addCommandToRightBar("retour", null, evt->{
   previous.showBack();
});

addAll(devGuide);


    }
    
}
