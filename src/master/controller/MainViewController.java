package master.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javafx.stage.Modality;
import javafx.stage.Stage;
import master.model.*;
import org.apache.commons.io.FileUtils;

/**
 * Created by Thanh-Phong on 11/14/2015.
 *
 *
 */
public class MainViewController implements Initializable{

    ObservableList<String> myObservableList;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Set default sample html file on start

        Optional<String> result = getPromptInput("NEW PROJECT", "This project name will be the folder location.", "Enter Project Folder Location: ");
        if(result.isPresent()){
            File dir = new File(result.get());
            dir.mkdir();
            File imgDir = new File(dir.getAbsolutePath()+"\\images");
            imgDir.mkdir();
            System.out.println(dir.getAbsolutePath());
            ApplicationManager.getInstance().setProjectDirectory(dir.getAbsolutePath()+"\\");
            ApplicationManager.getInstance().setProjectFolder(dir);
            System.out.println(ApplicationManager.getInstance().getProjectDirectory());
            File projectDir = new File(ApplicationManager.getInstance().getProjectDirectory());

            ApplicationManager.getInstance().getHtmlGenerator().readFromFile("./path/blankindex.html");
            onChangeTemplateButtonClicked(null);


            //Function to Copy appropriate files to project directory
        }

//        String htmlSample = "../path/template/index.html";
//        WebEngine engine = webViewCanvas.getEngine();
//        URL urlSample = getClass().getResource(htmlSample);
//        engine.load(urlSample.toExternalForm());

        webComponentList.setCellFactory(TextFieldListCell.forListView());
        webComponentList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    /*
        MENUBAR ITEMS
     */
    @FXML private MenuItem saveProject;
    @FXML private MenuItem quit;
    @FXML private MenuItem changeTemplateButton;
    @FXML private MenuItem explorerButton;
    @FXML private MenuItem aboutButton;

    @FXML private WebView webViewCanvas = new WebView();
    @FXML private ListView webComponentList;


    @FXML private void onSaveProjectClicked(ActionEvent actionEvent) {
        //Write HTML code to template

    }
    @FXML private void onQuitClicked(ActionEvent actionEvent) {
        Platform.exit();
    }
    @FXML private void onChangeTemplateButtonClicked(ActionEvent actionEvent) {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/TemplateSelectorOverview.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //Locks mainstage until user quits the selector
            stage.setScene(scene);
            stage.showAndWait();

            writeAndRefresh(new File(ApplicationManager.getInstance().getProjectDirectory()));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML private void onExplorerButtonClicked(ActionEvent actionEvent) {

        //Open the project directory
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
            loader.setLocation(MainApp.class.getResource("../view/HeaderEditor.fxml"));
            Pane headerSelector = loader.load();
            Scene scene = new Scene(headerSelector);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

            writeAndRefresh(new File(ApplicationManager.getInstance().getProjectDirectory()));
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
                JavaToHTML.setFooterFromGUI(result.get()); //controller tie in
                ApplicationManager.getInstance().getCurrentWebPage().setFooter(result.get());
            }
        }

        writeAndRefresh(new File(ApplicationManager.getInstance().getProjectDirectory()));
        refreshComponentList();
    }
    @FXML private void onSectionButtonClicked(ActionEvent e){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../view/SectionEditor.fxml"));
            Pane sectionSelector = loader.load();
            Scene scene = new Scene(sectionSelector);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.showAndWait();

            writeAndRefresh(new File(ApplicationManager.getInstance().getProjectDirectory()));
            refreshComponentList();
        }catch(IOException e_section) {
            e_section.printStackTrace();
        }
    }
    @FXML private void onNavButtonClicked(ActionEvent actionEvent) {
        writeAndRefresh(new File(ApplicationManager.getInstance().getProjectDirectory()));
    }

    private void refreshComponentList(){
        int i = 0; //Object counter

        List<String> objectTypes = new ArrayList<>();

        if(ApplicationManager.getInstance().getCurrentWebPage().getHeader() != null){
            objectTypes.add(ApplicationManager.getInstance().getCurrentWebPage().getHeader().getObjectType() + " 0" );
            i++;
        }

        List<HTMLSection> sections = ApplicationManager.getInstance().getCurrentWebPage().getSections();
        for(HTMLSection s : sections){
            String t = s.getObjectType();
            String h = "No Heading";
            if(s.getSectionHeading() != null)
            {
                h = s.getSectionHeading();
            }
            String f = t + " " + i + " : " +h;
            objectTypes.add( f );
            i++;
        }

        if(ApplicationManager.getInstance().getCurrentWebPage().getFooter() != null){
            objectTypes.add("FOOTER " + i + " : " + ApplicationManager.getInstance().getCurrentWebPage().getFooter());
            i++;
        }

        myObservableList = FXCollections.observableList(objectTypes);
        webComponentList.setItems(myObservableList);
    }

    public void onDeleteKeyPressed(KeyEvent event) {
        event.consume();
        if( event.getCode().toString().equals("DELETE") ){
            try{

                int index = webComponentList.getSelectionModel().getSelectedIndex();
                int totalSize = myObservableList.size();
                System.out.println("total size: " + totalSize);
                System.out.println("selected index: " + index);
                System.out.println(ApplicationManager.getInstance().getCurrentWebPage().getFooter());

                if(index == 0 && (ApplicationManager.getInstance().getCurrentWebPage().getHeader() != null)){
                    myObservableList.remove(index);
                    ApplicationManager.getInstance().getCurrentWebPage().clearHeader();
                    System.out.println("removed header");

                }else if( (index == (totalSize-1)) && (ApplicationManager.getInstance().getCurrentWebPage().getFooter() != null) ){
                    myObservableList.remove(webComponentList.getSelectionModel().getSelectedIndex());
                    ApplicationManager.getInstance().getCurrentWebPage().clearFooter();
                    System.out.println("removed footer");

                }
                else if(ApplicationManager.getInstance().getSectionsFromWebPage().size() > 0){
                    System.out.println("deleting " + index);
                    myObservableList.remove(index);
                    ApplicationManager.getInstance().getCurrentWebPage().removeSection(index);
                }
                else{
                    //?
                }
                //System.out.println("Section size: " + ApplicationManager.getInstance().getSectionsFromWebPage().size());
                //System.out.println("Footer " + ApplicationManager.getInstance().getCurrentWebPage().getFooter());
                //System.out.println("Header " + ApplicationManager.getInstance().getCurrentWebPage().getHeader().getHeaderText());


            }catch(Exception ex){
                System.out.println("Nothing left to delete.");
                System.err.println(ex.getStackTrace());
                System.err.println(ex.getCause());
               System.err.println(ex.getMessage());
           }

        }
        writeAndRefresh(new File(ApplicationManager.getInstance().getProjectDirectory()));

    }
    //---------------------------Added By James--------------------------------
    public boolean writeAndRefresh(File savePath)
    {
        //get content from objects
        HTMLObjectWriter writer = new HTMLObjectWriter();
        writer.getHTMLWebsiteToText(ApplicationManager.getInstance().getCurrentWebPage());
        //Re-write the index.html to refresh HTML file
        ApplicationManager.getInstance().getHtmlGenerator().writeToFile("index", savePath.getPath());//write


        //Reload webview so the user can see the website
        //String projectIndex = savePath + "index.html";
        File f = new File( savePath, "index.html" );
        WebEngine engine = webViewCanvas.getEngine();
        //System.out.println(projectIndex);

        try{
            System.out.println("Attempting to refresh webview at: " +f.toURI().toURL().toString() );
            webViewCanvas.getEngine().load(f.toURI().toURL().toString());
        }catch(Exception e){
            System.err.println("Could not reload proper webview");

        }

        //URL urlSample = getClass().getResource(projectIndex);
        //System.out.println(urlSample);
        //engine.load(urlSample.toExternalForm());
        return true;
    }
    //---------------------------End added by James---------------------------

}
