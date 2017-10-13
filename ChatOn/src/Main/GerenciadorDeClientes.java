package Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeClientes extends Thread {

    private Socket cliente;
    private String username;
    private ObjectInputStream recebeDados;
    private ObjectOutputStream enviaDados;
    private static final Map<String, GerenciadorDeClientes> listaDeClientes = new HashMap<String, GerenciadorDeClientes>();

    public GerenciadorDeClientes(Socket cliente) {
        this.cliente = cliente;
        start();
    }

    @Override
    public void run() {
        try {
            recebeDados = new ObjectInputStream(cliente.getInputStream());
            enviaDados = new ObjectOutputStream(cliente.getOutputStream());

            efetuarLogin();

            String comando;
            while (true) {
                comando = recebeDados.readObject().toString();
                if (comando == null) {
                    continue;
                }
                if (comando == "sair") {
                    this.cliente.close();
                } else if (comando == "mensagem") {
                    String nomeDestinario = comando.substring(comando.length(), comando.length());
                    GerenciadorDeClientes destinario = listaDeClientes.get(nomeDestinario);
                    if (destinario == null) {
                        enviaDados.writeObject(">>> Não foi indicado nenhum destinatário.");
                    } else {
                        destinario.getEscritor().writeObject(this.username + " says:\t " + recebeDados.readObject().toString());
                    }

                    // lista o nome de todos os clientes logados
                } else if (comando == "lista_usuarios") {
                    atualizarListaUsuarios(this);
                } else {
                    enviaDados.writeObject(this.username + ", você disse: " + comando);
                }
            }

        } catch (IOException e) {
            System.err.println(">>> Conexão encerrada pelo cliente.");
            listaDeClientes.remove(this.username);
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println(">>> ERRO: " + ex.getMessage());
        }
    }

    private synchronized void efetuarLogin() throws IOException {

        while (true) {
            try {
                System.out.println(">>> Fazendo login");
                enviaDados.writeObject("login");
                this.username = recebeDados.readObject().toString();
                if (this.username.equalsIgnoreCase("null") || this.username.isEmpty()) {
                    enviaDados.writeObject("erro de login");
                } else if (listaDeClientes.containsKey(this.username)) {
                    enviaDados.writeObject("erro de login");
                } else {
                enviaDados.writeObject("login aceito" );
                    enviaDados.writeObject(">>> Conectado como " + this.username);
                    listaDeClientes.put(this.username, this);
                    for (String cliente : listaDeClientes.keySet()) {
                        atualizarListaUsuarios(listaDeClientes.get(cliente));
                    }
                    break;
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(">>> ERRO: " + ex.getMessage());
            }
        }
    }

    private void atualizarListaUsuarios(GerenciadorDeClientes cliente) throws IOException {
        StringBuffer str = new StringBuffer();
        for (String c : listaDeClientes.keySet()) {
            if (cliente.getNomeCliente().equals(c)) {
                continue;
            }
            str.append(c);
            str.append(",");
        }
        if (str.length() > 0) {
            str.delete(str.length() - 1, str.length());
        }
        cliente.getEscritor().writeObject("lista_usuarios");
        cliente.getEscritor().writeObject(str.toString());
    }

    public ObjectOutputStream getEscritor() {
        return enviaDados;
    }

    public String getNomeCliente() {
        return username;
    }
}
