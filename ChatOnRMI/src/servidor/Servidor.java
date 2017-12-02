/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import cliente.Cliente;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author maria
 */
public interface Servidor extends Remote{
    void registraCliente(Cliente cliente) throws RemoteException;
    void enviaMensagem(String mensagem) throws RemoteException;
}
