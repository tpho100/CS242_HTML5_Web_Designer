package master.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import master.model.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class SectionSelectorController {

    List<TextArea> paragraphs = new ArrayList<>();
    List< ListView > lists = new ArrayList<>();
    List<ImageView> images = new ArrayList<>();
    HTMLSection section = new HTMLSection();

    @FXML private Button minusListButton;
    @FXML private Button minusImageButton;
    @FXML private Button minusParagraphButton;
    @FXML private Button addImageButton;
    @FXML private Button addListButton;
    @FXML private Button cancelButton;
    @FXML private TextField headingTextField;
    @FXML private Button addParagraphButton;
    @FXML private Button okButton;
    @FXML private Button incrListButton;
    @FXML private VBox sectionObjects;
    @FXML private TextField listCounter;
    @FXML private Button decrListButton;

    @FXML void incrementListButtonClicked(ActionEvent event) {
        int count = 0;
        try{
            if( listCounter.getText().isEmpty() ){
                count = 1;
            }else{
                count = Integer.valueOf(listCounter.getText()) + 1;
            }
        }catch(NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NOT A NUMBER!");
            alert.setContentText("YOU DID NOT ENTER A VALID NUMBER");
        }
        listCounter.setText(String.valueOf(count));
    }
    @FXML void decrementListButtonClicked(ActionEvent event) {
        int count = 0;
        try{
            if( listCounter.getText().isEmpty() || Integer.valueOf(listCounter.getText()) == 0 ){
                count = 0;
            }else{
                count = Integer.valueOf(listCounter.getText()) - 1;
            }
        }catch(NumberFormatException nfe){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("NOT A NUMBER!");
            alert.setContentText("YOU DID NOT ENTER A VALID NUMBER");
        }
        listCounter.setText(String.valueOf(count));
    }

    @FXML void appendListButtonClicked(ActionEvent event) {
        HTMLList htmlList = new HTMLList();
        ListView<String> list = new ListView<>();

        ObservableList<String> items = FXCollections.observableArrayList();
        int counter = Integer.valueOf(listCounter.getText());
        for( int i = 0; i < counter; i ++){
            items.add( "item " + i );
        }
        list.setMinHeight(20*counter);
        list.setEditable(true);
        list.setItems(items);
        list.setPrefHeight(50*counter);
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lists.add(list);
        sectionObjects.getChildren().add(list);
        //sectionObjects.getScene().getWindow().sizeToScene();

        htmlList.setListElements(list.getItems());
        htmlList.setIndex(section.getSectionComponents().size());
        section.addHTMLObject(htmlList);
    }
    @FXML void appendParagraphButtonClicked(ActionEvent event) {
        HTMLParagraph htmlParagraph = new HTMLParagraph();
        TextArea newArea = new TextArea();
        newArea.setMinHeight(150);
        newArea.setPrefRowCount(4);
        newArea.setWrapText(true);
        paragraphs.add(newArea);
        sectionObjects.getChildren().add(newArea);
        //sectionObjects.getScene().getWindow().sizeToScene();
        htmlParagraph.setIndex(section.getSectionComponents().size() );
        section.addHTMLObject(htmlParagraph);
    }
    @FXML void appendImageButtonClicked(ActionEvent event) {
        HTMLImage htmlImage = new HTMLImage();
        ImageView picturePreview = new ImageView();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        Image image;
        try{
            BufferedImage bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage,null);
            picturePreview.setImage(image);
        }catch(Exception img){
            System.err.println("Problem reading image.");
        }

        picturePreview.setFitHeight( 300 );
        picturePreview.setFitWidth(sectionObjects.getMaxWidth() - 50);
        picturePreview.setPreserveRatio(true);
        images.add(picturePreview);
        sectionObjects.getChildren().add(picturePreview);
        htmlImage.setIndex(section.getSectionComponents().size());
        section.addHTMLObject(htmlImage);
        //sectionObjects.getScene().getWindow().sizeToScene();
    }

    @FXML private void minusListButtonOnClicked(ActionEvent actionEvent) {
        if (lists.size() > 0) {

            int index = lists.size() - 1;
            //System.out.println("minusing" + index);
            sectionObjects.getChildren().remove( lists.get(index) );
            //sectionObjects.getScene().getWindow().sizeToScene();
            lists.remove( index );
            section.removeHTMLObject( section.getListLocations().get( section.getListLocations().size()-1 ) );
        }
        else{
            //System.out.println("Nothing to delete.");
        }
    }
    @FXML private void minusParagraphButtonClicked(ActionEvent actionEvent) {
        if (paragraphs.size() > 0) {
            int index = paragraphs.size() -1;
            sectionObjects.getChildren().remove( paragraphs.get(index) );
            //sectionObjects.getScene().getWindow().sizeToScene();
            paragraphs.remove( index );
            section.removeHTMLObject( section.getListLocations().get( section.getParagraphLocations().size()-1 ) );
        }
        else{
            //System.out.println("Nothing to delete.");
        }

    }
    @FXML private void minusImageButtonOnClicked(ActionEvent actionEvent) {
        if (images.size() > 0) {

            int index = images.size() - 1;
            //System.out.println("minusing" + index);
            sectionObjects.getChildren().remove( images.get(index) );
            //sectionObjects.getScene().getWindow().sizeToScene();
            images.remove( index );
            section.removeHTMLObject( section.getListLocations().get( section.getImageLocations().size()-1 ) );
        }
        else{
            //System.out.println("Nothing to delete.");
        }
    }

    @FXML void onOkButtonClicked(ActionEvent event) {

        int count = sectionObjects.getChildren().size();
        if(!headingTextField.getText().isEmpty()){
            //System.out.println("There is a heading...");
            count++;
        }
        else{
           // System.out.println("No heading...");
        }
        //System.out.println("There are: " + count + " elements in this section.");
        //System.out.println("There are: " + section.getSectionComponents().size() + " elements in this section html object");

        int paragraphCount = section.getParagraphLocations().size();
        List<Integer> paragraphLocations = section.getParagraphLocations();
        //System.out.println("There are " + paragraphCount + "paragraphs in section");
        //System.out.println("at " + section.getParagraphLocations().toString());

        int imageCount = section.getImageLocations().size();
        List<Integer> imageLocations = section.getImageLocations();
        //System.out.println("There are " + imageCount + "images in section");
        //System.out.println("at " + section.getImageLocations().toString());

        int listCount = section.getListLocations().size();
        List<Integer> listLocations = section.getListLocations();
        //System.out.println("There are " + listCount + "lists in section");
        //System.out.println("at " + section.getListLocations().toString());



    }
    @FXML void onCancelButtonClicked(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

}

