/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicoImpl;

import Model.Usuario;
import dao.UsuarioDAO;
import java.util.List;
import servico.ManterUsuario;

/**
 *
 * @author maria
 */
public class ManterUsuarioImpl implements ManterUsuario {

    private final UsuarioDAO usuarioDao;

    public ManterUsuarioImpl(UsuarioDAO usuarioDao) {
        this.usuarioDao = usuarioDao;
    }

    @Override
    public void cadastrarUsuario(Usuario usuario) {
        usuarioDao.insert(usuario);
    }

    @Override
    public Usuario deletarUsuario(int codUsuario) {
        return usuarioDao.delete(codUsuario);
    }

    @Override
    public Usuario getUsuarioById(int codUsuario) {
        return usuarioDao.getUsuarioById(codUsuario);
    }

    @Override
    public List<Usuario> ListAll() {
        return usuarioDao.listAll();
    }

}
