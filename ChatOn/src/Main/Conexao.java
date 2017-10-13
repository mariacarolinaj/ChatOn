package Main;

import Controller.ChatController;
import Controller.JoinRoomController;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class Conexao {

    private JList liUsarios = new JList();
    private ObjectOutputStream escritor;
    private ObjectInputStream leitor;

    private ChatController chatControl;
    private JoinRoomController joinControl;

    /**
     * Preenche a lista de usuarios
     *
     * @param usuarios
     */
    private void preencherListaUsuarios(String[] usuarios) {
        DefaultListModel modelo = new DefaultListModel();
        liUsarios.setModel(modelo);
        for (String usuario : usuarios) {
            modelo.addElement(usuario);
        }
//		liUsarios.getModel().

    }

    public void iniciarEscritor() {
        System.out.println(">>> Escritor iniciado");
        // escrevendo para o servidor
        if (chatControl.getTextAreaMensagem() == "") {
            return;
        } else {
            //Object usuario = liUsarios.getSelectedValue();
            //if (usuario != null) {
            // jogando no visor
            chatControl.setRoomMessages("Eu: ");
            chatControl.setRoomMessages(chatControl.getTextAreaMensagem());
            chatControl.setRoomMessages("\n");
            try {
                escritor.writeObject("mensagem" + DadosGerais.getNomeUsuario());
                escritor.writeObject(chatControl.getTextAreaMensagem());
            } catch (IOException ex) {
                System.out.println(">>> Erro no escritor.");
            }
            chatControl.setTextAreaMensagem("");

        }
    }

    public void iniciarChat() {
        try {
            final Socket cliente = new Socket("localhost", 1111);
            escritor = new ObjectOutputStream(cliente.getOutputStream());
            System.out.println("OL");
            leitor = new ObjectInputStream(cliente.getInputStream());
        } catch (UnknownHostException e) {
            System.out.println("o endereço passado é inválido");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("o servidor pode estar fora ar");
            e.printStackTrace();
        }
    }

    public void inicarLeitor() throws ClassNotFoundException {
        System.out.println(">>> Iniciando leitor");
        try {
            while (true) {
                String mensagem = (String) leitor.readObject();
                if (mensagem == null || mensagem.isEmpty()) {
                    continue;
                }
                // recebe o texto
                if (mensagem.equals("lista_usuarios")) {
                    String[] usuarios = leitor.readObject().toString().split(",");
                    preencherListaUsuarios(usuarios);
                } else if (mensagem.equals("login")) {
                    String login = DadosGerais.getNomeUsuario();
                    escritor.writeObject(login);
                    escritor.flush();
                } else if (mensagem.equals("erro de login")) {
                    JOptionPane.showMessageDialog(null, "o login é inválido");
                } else if (mensagem.equals("login aceito")) {
                } else {
                    System.out.println(">>> Leitor apto a receber mensagens");
                    chatControl.setRoomMessages(mensagem);
                    chatControl.setRoomMessages("\n");
                    System.out.println(">>> Mensagem enviada: " + mensagem);
                }
            }
        } catch (IOException e) {
            System.out.println(">>> Não foi possível receber a mensagem do servidor.");
            e.printStackTrace();
        }
    }

    private DefaultListModel getListaUsuarios() {
        return (DefaultListModel) liUsarios.getModel();
    }
}
