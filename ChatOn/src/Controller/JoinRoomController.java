/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Main.Cliente;
import Main.DadosGerais;
import Main.InterfaceController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author maria
 */
public class JoinRoomController implements Initializable, InterfaceController {

    @FXML
    private TextField username;
    @FXML
    private TextField roomid;
    @FXML
    private Button entrar;

    private Cliente run;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(">>> JoinRoomControler");
    }

    @FXML
    private void entrarSala(MouseEvent event) {
        DadosGerais.setNomeUsuario(this.getUsername());
        DadosGerais.setIdSala(this.getRoomid());
        /*try {
            run.iniciaServicos();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JoinRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        run.exibePagina("Chat");
    }

    @Override
    public void setRun(Cliente run) {
        this.run = run;
    }

    public String getUsername() {
        return username.getText();
    }

    public String getRoomid() {
        return roomid.getText();
    }
}
