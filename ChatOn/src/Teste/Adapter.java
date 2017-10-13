package Teste;

import Controller.ChatController;
import java.io.InputStream;
import java.util.Scanner;

class Adapter implements Runnable {

    private final InputStream servidor;
    private ChatController chatControl;

    public Adapter(InputStream servidor) {
        this.servidor = servidor;
    }

    @Override
    public void run() {
        try (Scanner s = new Scanner(this.servidor)) {
            while (s.hasNextLine()) {
                String str = s.nextLine();
                System.out.println(">>> Veio do servidor: " + str);
                chatControl.setRoomMessages(str);
            }
        }
    }
}
