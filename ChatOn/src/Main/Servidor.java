/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author maria
 */
public class Servidor {

    public static void main(String[] args) {

        ServerSocket servidor = null;
        try {
            System.out.println(">>> Iniciando servidor");
            servidor = new ServerSocket(1111);
            System.out.println(">>> Servidor conectado na porta " + servidor.getLocalPort());

            while (true) {
                Socket cliente = servidor.accept();
                System.out.println(">>> Novo cliente conectado");
                new GerenciadorDeClientes(cliente);
            }

        } catch (IOException e) {

            try {
                if (servidor != null) {
                    servidor.close();
                }
            } catch (IOException e1) {
            }

            System.err.println(">>> Erro ao conectar. Verifique a disponibilidade da porta usada.");
            e.printStackTrace();
        }

    }
}
