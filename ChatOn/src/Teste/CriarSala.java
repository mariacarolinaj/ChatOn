package Teste;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author maria
 */
public class CriarSala extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Runnable run;

    /**
     *
     * @param args
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public BorderPane getRootLayout() {
        return rootLayout;
    }

    public void setRootLayout(BorderPane rootLayout) {
        this.rootLayout = rootLayout;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ChatOn!");
        initRootLayout();
        exibePagina("CreateRoom");
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Servidor.class.getResource("../View/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exibePagina(String nomePagina) {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(Cliente.class.getResource("../View/" + nomePagina + ".fxml"));
            AnchorPane pagina = (AnchorPane) loader.load();

            rootLayout.setCenter(pagina);

            InterfaceController controller = loader.getController();
            controller.setRun(this);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void escondeTela(){
        //rootLayout.setVisible(false);
        primaryStage.hide();
        //rootLayout.setVisible(false);
    }
    
    public static void main(String[] args) throws UnknownHostException, IOException {
        launch(args);
    }

}
