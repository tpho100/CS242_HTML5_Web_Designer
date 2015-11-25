package master.view;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javafx.stage.Modality;
import javafx.stage.Stage;

import master.MainApp;
import master.model.WebPage;


/**
 * Created by Thanh-Phong on 11/14/2015.
 */
public class MainViewController
{
    public Label prompt;
    private WebPage currentWebPage = new WebPage();

    @FXML
    private WebView webViewCanvas = new WebView();

    @FXML
    public void initialize() throws Exception{
        currentWebPage = new WebPage();
        String htmlSample = "default_sample.html";
        WebEngine engine = webViewCanvas.getEngine();
        URL urlSample = getClass().getResource(htmlSample);
        engine.load(urlSample.toExternalForm());
    }

    /*
        TEMPLATE SELECTOR ITEMS
     */

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
        Stage stage = (Stage) nextViewButton.getScene().getWindow();
        stage.close();
    }

    /*
        MENUBAR ITEMS
     */
    @FXML
    private MenuItem newProject;
    @FXML
    private MenuItem openProject;
    @FXML
    private MenuItem saveProject;
    @FXML
    private MenuItem closeProject;
    @FXML
    private MenuItem quit;

    @FXML
    private void onNewProjectClicked(ActionEvent actionEvent) {
        showTemplateSelectorOverview();
    }

    @FXML
    private void onOpenProjectClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onSaveProjectClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onCloseProjectClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onQuitClicked(ActionEvent actionEvent) {
    }

    /*
        Prompt components
     */


    private Optional<String> getPromptInput(String title, String header, String prompt){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(prompt);

        Optional<String> result = dialog.showAndWait();
        return result;
    }

    /*
        HTML5 Content Buttons
     */

    @FXML
    private Button mediaButton;
    @FXML
    private Button headingButton;
    @FXML
    private Button footerButton;
    @FXML
    private Button sectionButton;
    @FXML
    private Button paragraphButton;
    @FXML
    private Button headerButton;
    @FXML
    private Button listButton;
    @FXML
    private Button otherButton;


    @FXML
    private void onHeaderButtonClicked(ActionEvent actionEvent) {
        headerButton = new Button();
        Optional<String> result = getPromptInput("New Header", "", "Please enter header: ");

        if(result.isPresent()){
            currentWebPage.setHeader(result.get());
        }
    }

    @FXML
    private void onListButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onOtherButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void onMediaButtonClicked(ActionEvent e){
        mediaButton = new Button();

    }


    @FXML
    private void onHeadingButtonClicked(ActionEvent e){
        headingButton = new Button();
        Optional<String> result = getPromptInput("New Heading", "", "Please enter heading: ");

        if(result.isPresent()){
            currentWebPage.getHeadings().add(result.get());
        }
    }

    @FXML
    private void onFooterButtonClicked(ActionEvent e){
        footerButton = new Button();
        Optional<String> result = getPromptInput("New Footer", "", "Please enter footer: ");

        if(result.isPresent()){
            currentWebPage.setFooter(result.get());
        }
    }

    @FXML
    private void onSectionButtonClicked(ActionEvent e){
        sectionButton = new Button();
    }

    @FXML
    private void onParagraphButtonClicked(ActionEvent e){

    }

    public void showTemplateSelectorOverview()
    {
        try{
            FXMLLoader loader = loadFXMLSafely("view/TemplateSelectorOverview.fxml");
            BorderPane templateOverview = loader.load();
            Scene scene = new Scene(templateOverview);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.showAndWait();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private FXMLLoader loadFXMLSafely(String fxmlName){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MainApp.class.getResource(fxmlName));

        return loader;
    }


}
