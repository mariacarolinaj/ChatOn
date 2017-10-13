package Teste;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private int porta;
    private List<Socket> clientes;

    public Servidor(int porta) {
        this.porta = porta;
        this.clientes = new ArrayList<>();
    }

    public boolean verificaDisponibilidade(int porta) throws IOException {
        boolean estado = false;
        ServerSocket socket = null;
        try {
            socket = new ServerSocket(porta);
        } catch (IOException e) {
            estado = true;
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        return estado;
    }

    public void startServidor() throws IOException {
        try (ServerSocket servidor = new ServerSocket(this.porta)) {
            System.out.println(">>> Servidor aberto na porta " + servidor.getLocalPort());

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println(">>> Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

                this.clientes.add(cliente);
                Proxy proxy = new Proxy(cliente, this);
                new Thread(proxy).start();
            }
        }
    }

    public void enviaMensagem(Socket remetente, String mensagem) {
        for (Socket cliente : this.clientes) {
            if (!cliente.equals(remetente)) {
                try {
                    PrintStream ps = new PrintStream(cliente.getOutputStream());                    
                    ps.println(mensagem);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
