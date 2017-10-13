package Teste;

import Controller.ChatController;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

    private String host;
    private int porta;
    private ChatController chatControl;

    public Cliente(String host, int porta) {
        this.host = host;
        this.porta = porta;
    }

    public void startCliente() throws UnknownHostException, IOException {
        try (Socket cliente = new Socket(this.host, this.porta);
            PrintStream saida = new PrintStream(cliente.getOutputStream())) {
            System.out.println(">>> Novo cliente conectado ao servidor");
            Adapter adapter = new Adapter(cliente.getInputStream());
            new Thread(adapter).start();
            //saida.println(chatControl.getTextAreaMensagem()); AQUI OCORRE ALGUM ERRO!!! IMPOSSIBILITA ENTRAR NO CHAT COM AS INFORMAÇÕES CORRETAS.
        }
    }
    
    public void enviaMensagem(String mensagem){
                
    }
}
