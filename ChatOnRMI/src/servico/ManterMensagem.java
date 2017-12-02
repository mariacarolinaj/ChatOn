/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Model.Mensagem;
import java.util.List;

/**
 *
 * @author maria
 */
public interface ManterMensagem {

    public void gravarMensagem(Mensagem mensagem);

    public Mensagem deletarMensagem(int codMensagem);

    public Mensagem getMensagemById(int codMensagem);

    public List<Mensagem> ListAllBySala(int codSala);
}
