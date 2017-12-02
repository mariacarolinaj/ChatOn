/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Model.Sala;
import java.util.List;

/**
 *
 * @author maria
 */
public interface ManterSala {

    public void criarSala(Sala sala);

    public Sala deletarSala(int codSala);

    public Sala getSalaById(int codSala);

    public List<Sala> ListAll();
}
