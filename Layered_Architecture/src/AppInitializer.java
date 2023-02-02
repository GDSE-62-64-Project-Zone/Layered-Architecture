import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/pos/view/main-form.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Java FX POS");
        primaryStage.centerOnScreen();
        primaryStage.show();

        //https://drive.google.com/file/d/1cJJO9RkJTRq_bN2cnuPao7oBVUp_n3Jn/view?usp=sharing
        //https://forms.gle/YpsQy4txj67i3dXQ7
    }
}
