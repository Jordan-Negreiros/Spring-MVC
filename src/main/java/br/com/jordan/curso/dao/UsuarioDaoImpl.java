package br.com.jordan.curso.dao;

import br.com.jordan.curso.domain.TipoSexo;
import br.com.jordan.curso.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UsuarioDaoImpl implements UsuarioDao{

    private static List<Usuario> user;

    public UsuarioDaoImpl() {
        createUserList();
    }

    private List<Usuario> createUserList() {
        if (user == null) {
            user = new LinkedList<>();
            user.add(new Usuario(System.currentTimeMillis() + 1L, "Ana", "da Silva", LocalDate.of(1992, 5, 10), TipoSexo.FEMININO));
            user.add(new Usuario(System.currentTimeMillis() + 2L, "Luiz", "dos Santos", LocalDate.of(1990, 8, 11), TipoSexo.MASCULINO));
            user.add(new Usuario(System.currentTimeMillis() + 3L, "Mariana", "Mello", LocalDate.of(1988, 9, 17), TipoSexo.FEMININO));
            user.add(new Usuario(System.currentTimeMillis() + 4L, "Caren", "Pereira"));
            user.add(new Usuario(System.currentTimeMillis() + 5L, "Sonia", "Fagundes"));
            user.add(new Usuario(System.currentTimeMillis() + 6L, "Norberto", "de Souza"));
        }
        return user;
    }

    @Override
    public void salvar(Usuario usuario) {
        usuario.setId(System.currentTimeMillis());
        user.add(usuario);
    }

    @Override
    public void editar(Usuario usuario) {
        user.stream()
                .filter((u) -> u.getId().equals(usuario.getId()))
                .forEach((u) -> {
                    u.setNome(usuario.getNome());
                    u.setSobrenome(usuario.getSobrenome());
                    u.setDtNascimento(usuario.getDtNascimento());
                    u.setSexo(usuario.getSexo());
                });
    }

    @Override
    public void excluir(Long id) {
        user.removeIf((u) -> u.getId().equals(id));
    }

    @Override
    public Usuario getId(Long id) {
        return user.stream()
                .filter((u) -> u.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public List<Usuario> getTodos() {
        return user;
    }
}
