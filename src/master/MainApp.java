package master;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("HTML5 Website Designer");
        initLayout();
    }

    public void initLayout(){

        try{
            FXMLLoader rootLoader = new FXMLLoader();
            rootLoader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
            BorderPane rootLayout = (BorderPane) rootLoader.load();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/EditorView.fxml"));
            AnchorPane editorView = (AnchorPane) loader.load();

            rootLayout.setCenter(editorView);

            scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();

        }catch(IOException e)
        {
            e.printStackTrace();
        }

    }

}
