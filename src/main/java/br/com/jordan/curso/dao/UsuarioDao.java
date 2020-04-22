package br.com.jordan.curso.dao;

import br.com.jordan.curso.domain.TipoSexo;
import br.com.jordan.curso.domain.Usuario;

import java.util.List;

public interface UsuarioDao {

    void salvar(Usuario usuario);

    void editar(Usuario usuario);

    void excluir(Long id);

    Usuario getId(Long id);

    List<Usuario> getTodos();

    List<Usuario> getBySexo(TipoSexo sexo);

    List<Usuario> getByNome(String nome);
}
