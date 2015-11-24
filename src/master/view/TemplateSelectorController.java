package master.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import master.MainApp;

import java.io.IOException;


/**
 * Created by Thanh-Phong on 11/14/2015.
 */
public class TemplateSelectorController
{
    public MenuItem newFromTemplate;
    @FXML
    private MenuItem newButton;
    @FXML
    private MenuItem openButton;
    @FXML
    private MenuItem closeButton;
    @FXML
    private TextField statusField;

    @FXML
    public void onNewButtonClicked(ActionEvent e){

    }

    @FXML
    public void onNewFromTemplateButtonClicked(ActionEvent e)
    {
        showTemplateSelectorOverview();
    }

    @FXML
    public void onOpenButtonClicked(ActionEvent e){

    }

    @FXML
    public void onCloseButtonClicked(ActionEvent e){

    }

    public void showTemplateSelectorOverview()
    {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TemplateSelectorOverview.fxml"));
            AnchorPane templateOverview = (AnchorPane) loader.load();
            Scene scene = new Scene(templateOverview);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

        }catch(IOException e){
            e.printStackTrace();
        }
    }


    private Image template1Image = new Image("master/images/template1_preview.PNG");
    private Image template2Image = new Image("master/images/template2_preview.png");
    private Image template3Image = new Image("master/images/template3_preview.png");
    private Image template4Image = new Image("master/images/template4_preview.png");
    private Image[] templateImage = {template1Image, template2Image, template3Image, template4Image};

    @FXML
    private ImageView templatePreview;
    @FXML
    private Button nextViewButton;
    @FXML
    private Button template1Button;
    @FXML
    private Button template2Button;
    @FXML
    private Button template3Button;
    @FXML
    private Button template4Button;

    public void onTemplate1ButtonClicked(ActionEvent e){

        templatePreview.setImage(templateImage[0]);
    }

    public void onTemplate2ButtonClicked(ActionEvent e) {
        templatePreview.setImage(templateImage[1]);
    }

    public void onTemplate3ButtonClicked(ActionEvent e) {
        templatePreview.setImage(templateImage[2]);
    }

    public void onTemplate4ButtonClicked(ActionEvent e) {
        templatePreview.setImage(templateImage[3]);
    }


    public void onNextViewButtonClicked(ActionEvent e){
        System.out.println("Setting template.");
        Stage stage = (Stage) nextViewButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void initialize(){

    }


}
