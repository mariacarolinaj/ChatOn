package Main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author maria
 */
public class Cliente extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private Socket socket;
    private OutputStream ou;
    private Writer ouw;
    private BufferedWriter bfw;
    private Conexao con;

    public Cliente() {
        con = new Conexao();
    }

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
        try {
            con.iniciarChat();
        } catch (Exception ex) {
            System.out.println(">>> Erro ao conectar no servidor: " + ex.toString());
        }
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("ChatOn!");
        initRootLayout();
        exibePagina("PaginaInicial");
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Cliente.class.getResource("../View/RootLayout.fxml"));
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

    public Conexao getConexao() {
        return con;
    }

    public void iniciaServicos() throws ClassNotFoundException {
        con.inicarLeitor();
        con.iniciarEscritor();
    }

    public static void main(String args[]) {
        launch(args);
    }

}
