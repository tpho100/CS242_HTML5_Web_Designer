package master.controller;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import master.model.ApplicationManager;
import master.model.HTMLHeader;
import master.model.JavaToHTML;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Thanh-Phong on 12/2/2015.
 */
public class HeaderSelectorController {

    HTMLHeader header;

    @FXML
    private TextField picturePath;
    @FXML private TextField headerTextField;
    @FXML private ImageView picturePreview;
    @FXML private Button chooseButton;
    @FXML private Button okButton = new Button();
    @FXML private Button cancelButton = new Button();

    @FXML private void onChooseButtonClicked(){

        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        Image image;
        try{
            BufferedImage bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage,null);
            picturePreview.setImage(image);
            picturePath.setText(file.getAbsolutePath());
        }catch(Exception img){
            System.err.println("Problem reading image.");
        }

    }
    @FXML private void onOkButtonClicked(){

        if(!headerTextField.getText().isEmpty() && picturePreview.getImage() != null){
            HTMLHeader header = new HTMLHeader(headerTextField.getText(),picturePreview.getImage());
            ApplicationManager.getInstance().setWebPageHeader(header);
        }
        Stage stage = (Stage) okButton.getScene().getWindow();
        JavaToHTML HTML = new JavaToHTML();
        HTML.setHeaderFromGUI(headerTextField.getText(),picturePath.getText()); // controller tie in
        stage.close();
    }
    @FXML private void onCancelButtonClicked(){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    //If time allows. Implement drag and drop support for images.
    @FXML private void onImageDraggedDone(DragEvent event) {
        System.out.println("Dragged done: " + event.getEventType());
    }
    @FXML private void onImageDraggedDetected(Event event) {
        System.out.println("Dragged detected: " + event.getEventType());
    }
    @FXML private void onImageDraggedDropped(Event event) {
        System.out.println("Dragged dropped: " + event.getEventType());
    }

}