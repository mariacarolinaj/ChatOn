package dao;

import Model.Mensagem;
import java.util.List;

/**
 *
 * @author maria
 */
public interface MensagemDAO {
    public boolean insert(Mensagem mensagem);
    public Mensagem delete(int id);
    public Mensagem getMensagemById(int id);
    public List<Mensagem> listAllBySala(int codSala);
}