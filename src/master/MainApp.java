package master;

/**
 * Created by Thanh-Phong on 11/14/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApp extends Application {


    String windowTitle = "HTML5 Website Designer";

    private Stage primaryStage; //Primary window
    private BorderPane editorLayout; //Main scene component that user will see and interact with
    private Scene scene; //Global variable so that the program can keep track of multiple scenes

    public Scene getScene(){
        return scene;
    }

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
        /*
            Not needed for this application.
         */
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(windowTitle);
        initLayout();
    }

    public void initLayout(){
        try{
            FXMLLoader editorLoader = new FXMLLoader();
            editorLoader.setLocation(MainApp.class.getResource("view/EditorView.fxml"));
            editorLayout = editorLoader.load();

            scene = new Scene(editorLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
