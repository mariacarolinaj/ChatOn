/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoImpl;

import Model.Mensagem;
import dao.MensagemDAO;
import java.util.List;
import servico.ManterMensagem;

/**
 *
 * @author maria
 */
public class ManterMensagemImpl implements ManterMensagem {

    private final MensagemDAO mensagemDao;

    public ManterMensagemImpl(MensagemDAO mensagemDao) {
        this.mensagemDao = mensagemDao;
    }

    @Override
    public void gravarMensagem(Mensagem mensagem) {
        mensagemDao.insert(mensagem);
    }

    @Override
    public Mensagem deletarMensagem(int codMensagem) {
        return mensagemDao.delete(codMensagem);
    }

    @Override
    public Mensagem getMensagemById(int codMensagem) {
        return mensagemDao.getMensagemById(codMensagem);
    }

    @Override
    public List<Mensagem> ListAllBySala(int codSala) {
        return mensagemDao.listAllBySala(codSala);
    }

}
