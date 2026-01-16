package br.edu.utfpr.td.tsi.webapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;
import br.edu.utfpr.td.tsi.webapi.model.Usuario;

@Component
public class UsuarioServiceImpl implements UsuarioService {

    private static final ConcurrentMap<String, Usuario> usuarios = new ConcurrentHashMap<>();

    @Override
    public void cadastrar(Usuario usuario) {
        if (usuario.getIdade() < 18) {
            throw new RuntimeException("Usuário menor de idade");
        }

        for (Usuario u : usuarios.values()) {
            if (u.getEmail().equals(usuario.getEmail())) {
                throw new RuntimeException("E-mail já cadastrado");
            }
        }

        usuario.setId(UUID.randomUUID().toString());
        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public Usuario localizar(String idUsuario) {
        return usuarios.get(idUsuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public void atualizar(Usuario usuario) {
        if (!usuarios.containsKey(usuario.getId())) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarios.put(usuario.getId(), usuario);
    }

    @Override
    public void remover(String idUsuario) {
        usuarios.remove(idUsuario);
    }
}
