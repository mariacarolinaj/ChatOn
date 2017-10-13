package Teste;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Proxy implements Runnable {

    private final Socket cliente;
    private final Servidor servidor;

    public Proxy(Socket cliente, Servidor servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        try (Scanner s = new Scanner(this.cliente.getInputStream())) {
            while (s.hasNextLine()) {
                servidor.enviaMensagem(this.cliente, s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
