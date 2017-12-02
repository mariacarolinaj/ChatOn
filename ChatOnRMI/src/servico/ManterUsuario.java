/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import Model.Usuario;
import java.util.List;

/**
 *
 * @author maria
 */
public interface ManterUsuario {

    public void cadastrarUsuario(Usuario usuario);

    public Usuario deletarUsuario(int codUsuario);

    public Usuario getUsuarioById(int codUsuario);

    public List<Usuario> ListAll();
}
