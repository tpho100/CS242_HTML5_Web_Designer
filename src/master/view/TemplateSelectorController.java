package master.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class TemplateSelectorController implements Initializable{

    /*private MainViewController main;

    public void init(MainViewController mainC){
        main = mainC;
    }*/

    private String templateSelected;
    public String getTemplateSelected(){
        return templateSelected;
    }

    /*
       TEMPLATE SELECTOR ITEMS
    */

    private Image template1Image = new Image("master/images/template1_preview.png");
    private Image template2Image = new Image("master/images/template2_preview.png");
    private Image template3Image = new Image("master/images/template3_preview.png");
    private Image template4Image = new Image("master/images/template4_preview.png");
    private Image[] templateImage = {template1Image, template2Image, template3Image, template4Image};

    @FXML
    private ImageView templatePreview;

    @FXML
    private Button nextViewButton;

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
    private void onTemplate3ButtonClicked(ActionEvent e) {
        templatePreview.setImage(templateImage[2]);
        templateSelected = "template3";
    }

    @FXML
    private void onTemplate4ButtonClicked(ActionEvent e) {
        templatePreview.setImage(templateImage[3]);
        templateSelected = "template4";
    }

    @FXML
    private void onNextViewButtonClicked(ActionEvent e) {
        Stage stage = (Stage) nextViewButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
