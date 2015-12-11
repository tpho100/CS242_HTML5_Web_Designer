package master.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import master.model.ApplicationManager;
import master.model.JavaToHTML;
import master.model.HTMLStringDefinitions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class TemplateSelectorController implements Initializable{

    /**
     * Controller class for the TemplateSelector UI
     * Tells the ApplicationManager what template to use.
     */

    private String templateSelected;

    /*
       TEMPLATE SELECTOR ITEMS
    */
    //TODO update template photos
    private Image template1Image = new Image("master/images/template1_preview.png");
    private Image template2Image = new Image("master/images/template2_preview.png");
    private Image[] templateImage = {template1Image, template2Image};

    @FXML
    private ImageView templatePreview;

    @FXML
    private Button nextViewButton;
    @FXML private Button cancelButton;

    @FXML
    private void onTemplate1ButtonClicked(ActionEvent e){
        templatePreview.setImage(templateImage[0]);
        templateSelected = "template1";
    }

    @FXML
    private void onTemplate2ButtonClicked(ActionEvent e) {
        templatePreview.setImage(templateImage[1]);
        templateSelected = "template2";
    }

    @FXML
    private void onNextViewButtonClicked(ActionEvent e) {

        //Get template number
        if(templateSelected != null) {
            ApplicationManager.getInstance().changeTemplate(templateSelected);

            //--------------Added by James---------------------------------------------------------------
            //source file is found, but is never loaded into copy statement
            File projectDir = new File(ApplicationManager.getInstance().getProjectDirectory()+"\\styles.css");
            //ApplicationManager.getInstance().setProjectFolder(projectDir);
            File source = new File("./path/" + templateSelected + "/styles.css");
            try {                                                       //controller tie in
                FileUtils.copyFile(source, projectDir); //load styles.css into project directory
            } catch (IOException err) {
                System.out.println("Css error");
                //e.printStackTrace();
            }
            //ApplicationManager.getInstance().getHtmlGenerator().readFromFile(/*HTMLStringDefinitions.path + */"index"); //This is weird, may need to be reworked
            //MainViewController.writeAndRefresh(ApplicationManager.getInstance().getProjectDirectory());
            //---------------end added by James---------------------------------------------------------
        }
        Stage stage = (Stage) nextViewButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void onCancelButtonClicked(ActionEvent e) {
        Stage stage = (Stage) nextViewButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
