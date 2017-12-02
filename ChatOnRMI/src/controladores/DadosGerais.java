/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

/**
 *
 * @author maria
 */
public class DadosGerais {
    private static String nomeUsuario;
    private static String idSala;
    private static String usersList;
    private static String[] roomList;
    private static String mensagem;

    public static String getNomeUsuario() {
        return nomeUsuario;
    }

    public static void setNomeUsuario(String nomeUsuario) {
        DadosGerais.nomeUsuario = nomeUsuario;
    }

    public static String getIdSala() {
        return idSala;
    }

    public static void setIdSala(String idSala) {
        DadosGerais.idSala = idSala;
    }

    public static String getUsersList() {
        return usersList;
    }

    public static void setUsersList(String usersList) {
        DadosGerais.usersList = usersList;
    }

    public static String[] getRoomList() {
        return roomList;
    }

    public static void setRoomList(String[] roomList) {
        DadosGerais.roomList = roomList;
    }

    public static String getMensagem() {
        return mensagem;
    }

    public static void setMensagem(String mensagem) {
        DadosGerais.mensagem = mensagem;
    }
    
}
