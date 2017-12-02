/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoImpl;

import Model.Sala;
import dao.SalaDAO;
import java.util.List;
import servico.ManterSala;

/**
 *
 * @author maria
 */
public class ManterSalaImpl implements ManterSala {

    private final SalaDAO salaDao;

    public ManterSalaImpl(SalaDAO salaDao) {
        this.salaDao = salaDao;
    }

    @Override
    public void criarSala(Sala sala) {
        salaDao.insert(sala);
    }

    @Override
    public Sala deletarSala(int codSala) {
        return salaDao.delete(codSala);
    }

    @Override
    public Sala getSalaById(int codSala) {
        return salaDao.getSalaById(codSala);
    }

    @Override
    public List<Sala> ListAll() {
        return salaDao.listAll();
    }

}
