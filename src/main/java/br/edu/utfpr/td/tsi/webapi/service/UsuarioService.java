package br.edu.utfpr.td.tsi.webapi.service;

import java.util.List;
import br.edu.utfpr.td.tsi.webapi.model.Usuario;

public interface UsuarioService {

    void cadastrar(Usuario usuario);
    void atualizar(Usuario usuario);
    void remover(String idUsuario);
    Usuario localizar(String idUsuario);
    List<Usuario> listarTodos();
}
