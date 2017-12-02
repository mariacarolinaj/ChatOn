/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import cliente.ClienteDriver;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author maria
 */
public class PaginaInicialController implements Initializable, InterfaceController {
    @FXML
    private ImageView joinroom;
    @FXML
    private ImageView createroom;
    
    private ClienteDriver run;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(">>> PaginaInicialController");
    }

    @FXML
    public void entrarSala() throws Exception {
        run.exibePagina("JoinRoom");
    }

    @FXML
    public void criarSala() throws Exception {
        run.exibePagina("CreateRoom");
    }    
    
    @Override
    public void setRun(ClienteDriver run) {
        this.run = run;
    }
    
}
