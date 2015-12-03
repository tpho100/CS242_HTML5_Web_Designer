package master.view;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javafx.stage.Modality;
import javafx.stage.Stage;
import master.model.*;
import master.MainApp;

/**
 * Created by Thanh-Phong on 11/14/2015.
 */
public class MainViewController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Set default sample html file on start
        String htmlSample = "../path/template/index.html";
        WebEngine engine = webViewCanvas.getEngine();
        URL urlSample = getClass().getResource(htmlSample);
        engine.load(urlSample.toExternalForm());
    }

    /*
        MENUBAR ITEMS
     */
    @FXML private MenuItem newProject;
    @FXML private MenuItem openProject;
    @FXML private MenuItem saveProject;
    @FXML private MenuItem closeProject;
    @FXML private MenuItem quit;
    @FXML private MenuItem changeTemplateButton;
    @FXML private MenuItem explorerButton;
    @FXML private MenuItem aboutButton;

    @FXML private WebView webViewCanvas = new WebView();;
    @FXML private ListView webComponentList;

    @FXML private void onNewProjectClicked(ActionEvent actionEvent) {
    }
    @FXML private void onOpenProjectClicked(ActionEvent actionEvent) {
    }
    @FXML private void onSaveProjectClicked(ActionEvent actionEvent) {

    }
    @FXML private void onCloseProjectClicked(ActionEvent actionEvent) {

    }
    @FXML private void onQuitClicked(ActionEvent actionEvent) {
        Platform.exit();
    }
    @FXML private void onChangeTemplateButtonClicked(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/TemplateSelectorOverview.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //Locks mainstage until user quits the selector
            stage.setScene(scene);
            stage.showAndWait();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML private void onExplorerButtonClicked(ActionEvent actionEvent) {
    }
    @FXML private void onAboutButtonClicked(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("CS242 HTML5 Website Designer" + "\nBy: David Mosto, \nThanh-Phong Ho, \nOumar Ly, \n& James Dapp.");
        alert.setHeaderText("About");
        alert.setTitle("About");
        alert.showAndWait();
    }

    /*
        Prompt for getting text
        Accepts custom prompt messages
     */
    private Optional<String> getPromptInput(String title, String header, String prompt){
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(title);
        dialog.setHeaderText(header);
        dialog.setContentText(prompt);
        return dialog.showAndWait();
    }

    /*
        HTML5 Content Buttons
     */

    @FXML private Button headerButton;
    @FXML private Button footerButton;
    @FXML private Button navButton;
    @FXML private Button sectionButton;
    @FXML private Button listButton;

    @FXML private void onHeaderButtonClicked(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/HeaderEditor.fxml"));
            Pane headerSelector = loader.load();
            Scene scene = new Scene(headerSelector);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

            refreshComponentList();
        }catch(IOException e) {
            e.printStackTrace();
        }

    }
    @FXML private void onFooterButtonClicked(ActionEvent e){
        if(ApplicationManager.getInstance().getCurrentWebPage().getFooter() == null){
            Optional<String> result = getPromptInput("New Footer", "", "Enter new footer: ");
            if(result.isPresent()){
                ApplicationManager.getInstance().getCurrentWebPage().setFooter(result.get());
            }
        }
        else{
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("New Footer");
            dialog.setHeaderText("Old footer: " + ApplicationManager.getInstance().getCurrentWebPage().getFooter());
            dialog.setContentText("Change footer: ");

            Optional<String> result = dialog.showAndWait();
            if(result.isPresent()){
                ApplicationManager.getInstance().getCurrentWebPage().setFooter(result.get());
            }
        }

        refreshComponentList();
    }
    @FXML private void onSectionButtonClicked(ActionEvent e){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/SectionEditor.fxml"));
            Pane sectionSelector = loader.load();
            Scene scene = new Scene(sectionSelector);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

            refreshComponentList();
        }catch(IOException e_section) {
            e_section.printStackTrace();
        }
    }
    @FXML private void onNavButtonClicked(ActionEvent actionEvent) {
    }

    private void refreshComponentList(){
        int i = 0; //Object counter

        List<String> objectTypes = new ArrayList<>();

        if(ApplicationManager.getInstance().getCurrentWebPage().getHeader() != null){
            objectTypes.add(ApplicationManager.getInstance().getCurrentWebPage().getHeader().getObjectType() + " 0");
            i++;
        }

        List<HTMLSection> sections = ApplicationManager.getInstance().getCurrentWebPage().getSections();
        for(HTMLSection s : sections){
            String t = s.getObjectType();
            String f = t + " " + i;
            objectTypes.add( f );
            i++;
        }

        if(ApplicationManager.getInstance().getCurrentWebPage().getFooter() != null){
            objectTypes.add("FOOTER " + i);
            i++;
        }

        ObservableList<String> myObservableList = FXCollections.observableList(objectTypes);
        webComponentList.setItems(myObservableList);
    }

}
