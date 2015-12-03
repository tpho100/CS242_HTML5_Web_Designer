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


    private String templateSelected;

    /*
       TEMPLATE SELECTOR ITEMS
    */

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
