/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Main.DadosGerais;
import cliente.ClienteDriver;
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
public class CreateRoomController implements Initializable, InterfaceController {
    @FXML
    private TextField username;
    @FXML
    private TextField roomid;
    @FXML
    private Button entrar;
    
    private ClienteDriver run;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println(">>> CreateRoomController");
    }    

    public String getUsername() {
        return username.getText();
    }

    public void setUsername(String username) {
        this.username.setText(username); 
    }

    public String getRoomid() {
        return roomid.getText();
    }

    public void setRoomid(String roomid) {
        this.roomid.setText(roomid);
    }

    @FXML
    public void criarSala(MouseEvent event) {
        DadosGerais.setIdSala(getRoomid());
        DadosGerais.setNomeUsuario(getUsername());
        run.exibePagina("Chat");
    }
    
    @Override
    public void setRun(ClienteDriver run) {
        this.run = run;
    }
    
}
