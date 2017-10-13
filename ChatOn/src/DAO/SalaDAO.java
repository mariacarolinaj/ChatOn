/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Sala;
import java.util.List;

/**
 *
 * @author maria
 */
public interface SalaDAO {
    public boolean insert(Sala sala);
    public boolean update(Sala sala);
    public Sala delete(int id);
    public Sala getSalaById(int id);
    public List<Sala> listAll();
}