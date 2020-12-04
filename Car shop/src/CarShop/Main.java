package CarShop;

import CarShop.Exceptions.WorkOnFileException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("carshop.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Car online shop");

        Controller controller = loader.getController();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setOnHidden(e -> {
            try {
                controller.closeProgram();
            } catch (WorkOnFileException workOnFileException) {
                workOnFileException.printStackTrace();
            }
            primaryStage.close();
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
