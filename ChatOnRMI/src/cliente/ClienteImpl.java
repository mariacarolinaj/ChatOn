/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import DAOImpl.MensagemDAOImpl;
import DAOImpl.SalaDAOImpl;
import DAOImpl.UsuarioDAOImpl;
import Model.Mensagem;
import Model.Sala;
import Model.Usuario;
import servidor.Servidor;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import servico.ManterMensagem;
import servico.ManterSala;
import servico.ManterUsuario;
import servicoImpl.ManterMensagemImpl;
import servicoImpl.ManterSalaImpl;
import servicoImpl.ManterUsuarioImpl;

/**
 *
 * @author maria
 */
public class ClienteImpl extends UnicastRemoteObject implements Cliente, Runnable {

    private Servidor servidor;
    private Usuario usuario;
    private Mensagem mensagem;
    private Sala sala;
    private ManterUsuario manterUsuario;
    private ManterMensagem manterMensagem;
    private ManterSala manterSala;

    protected ClienteImpl(String nomeUsuario, Servidor servidor) throws RemoteException {
        this.servidor = servidor;
        this.manterUsuario = new ManterUsuarioImpl(UsuarioDAOImpl.getInstance());
        this.manterMensagem = new ManterMensagemImpl(MensagemDAOImpl.getInstance());
        this.manterSala = new ManterSalaImpl(SalaDAOImpl.getInstance());

        Random random = new Random(1000);
        
        usuario.setUserName(nomeUsuario);
        manterUsuario.cadastrarUsuario(usuario);
        sala.setIdSala(random.nextInt());
        manterSala.criarSala(sala);
        servidor.registraCliente(this);
    }

    @Override
    public void recuperarMensagem(String txtMensagem) throws RemoteException {
        mensagem.setData((java.sql.Date) new Date());
        mensagem.setSala(sala);
        mensagem.setUsuario(usuario);
        mensagem.setTxtMsg(txtMensagem);

        manterMensagem.gravarMensagem(mensagem);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        String mensagem;
        while (true) {
            mensagem = scanner.nextLine();
            try {
                servidor.enviaMensagem(usuario.getUserName() + ": " + mensagem);
            } catch (RemoteException ex) {
                System.out.println("ERRO: " + ex.getMessage());
            }
        }
    }

}
