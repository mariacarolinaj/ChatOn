package Controller;

import Main.Cliente;
import Main.Conexao;
import Main.DadosGerais;
import Main.InterfaceController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * FXML Controller class
 *
 * @author maria
 */
public class ChatController implements Initializable, InterfaceController {

    @FXML
    private Label nomeUsuario;
    @FXML
    private TextArea textAreaMensagem;
    @FXML
    private TextFlow userslist;
    @FXML
    private TextFlow roomMessages;
    @FXML
    private ImageView joinRoom;
    @FXML
    private ImageView createRoom;
    @FXML
    private Button enviar;
    @FXML
    private ChoiceBox roomList;

    private Conexao con;
    private Cliente run;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.setNomeUsuario("Conectado como " + DadosGerais.getNomeUsuario());
        System.out.println(">>> ChatController");
        /*try {
            run.iniciaServicos();
        } catch (ClassNotFoundException ex) {
            System.out.println("Erro: " + ex.getMessage());
        }*/
    }

    public void setTextAreaMensagem(String texto) {
        textAreaMensagem.setText(texto);
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario.setText(nomeUsuario);
    }

    public void setTextAreaMensagem(TextArea textAreaMensagem) {
        this.textAreaMensagem = textAreaMensagem;
    }

    public void setUserslist(TextFlow userslist) {
        this.userslist = userslist;
    }

    public void setRoomMessages(TextFlow roomMessages) {
        this.roomMessages = roomMessages;
    }

    public void setRoomList(ChoiceBox roomList) {
        this.roomList = roomList;
    }

    public String getTextAreaMensagem() {
        return textAreaMensagem.getText();
    }

    public TextFlow getRoomMessages() {
        return roomMessages;
    }

    public void setRoomMessages(String mensagem) {
        Text text = new Text(mensagem);
        roomMessages.getChildren().add(text);
    }

    @FXML
    public void entrarSala(MouseEvent e) throws Exception {
        run.exibePagina("JoinRoom");
    }

    @FXML
    public void criarSala(MouseEvent e) throws Exception {
        run.exibePagina("CreateRoom");
    }

    @FXML
    public void enviarMensagem(MouseEvent e) {
        
    }

    @Override
    public void setRun(Cliente run) {
        this.run = run;
    }

    public TextArea getTextArea() {
        return textAreaMensagem;
    }

}
