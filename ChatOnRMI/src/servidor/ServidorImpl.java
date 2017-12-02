/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cliente.Cliente;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class ServidorImpl extends UnicastRemoteObject implements Servidor {

    private static final long serialVersionUID = 1L;
    private ArrayList<Cliente> usuarios;

    protected ServidorImpl() throws RemoteException {
        usuarios = new ArrayList<Cliente>();

    }

    @Override
    public synchronized void registraCliente(Cliente cliente) throws RemoteException {
        this.usuarios.add(cliente);
    }

    @Override
    public synchronized void enviaMensagem(String mensagem) throws RemoteException {
        int a = 0;
        while (a < usuarios.size()) {
            usuarios.get(a+1).recuperarMensagem(mensagem);
        }
    }

}
