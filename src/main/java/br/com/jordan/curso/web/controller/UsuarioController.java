package br.com.jordan.curso.web.controller;

import br.com.jordan.curso.dao.UsuarioDao;
import br.com.jordan.curso.domain.TipoSexo;
import br.com.jordan.curso.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDao dao;

    @ModelAttribute("sexos")
    public TipoSexo[] tipoSexo() {
        return TipoSexo.values();
    }

    @GetMapping(value = "/nome")
    public ModelAndView listarPorNome(@RequestParam(value = "nome") String nome) {

        if (nome == null) {
            return new ModelAndView("redirect:/usuario/todos");
        }
        return new ModelAndView("list", "usuarios", dao.getByNome(nome));
    }

    @GetMapping(value = "/sexo")
    public ModelAndView listarPorSexo(@RequestParam(value = "tipoSexo") TipoSexo sexo) {

        if (sexo == null) {
            return new ModelAndView("redirect:/usuario/todos");
        }
        return new ModelAndView("list", "usuarios", dao.getBySexo(sexo));
    }

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ModelAndView listaTodos(ModelMap model) {
        model.addAttribute("usuarios", dao.getTodos());
        return new ModelAndView("list", model);
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastro(@ModelAttribute("usuario")Usuario usuario, ModelMap model) {
        return new ModelAndView("add");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("add");
        }
        dao.salvar(usuario);
        attr.addFlashAttribute("message", "Usúario salvo com sucesso");
        return  new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("usuario", dao.getId(id));
        return new ModelAndView("add", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("usuario") Usuario usuario,BindingResult result, RedirectAttributes attr) {

        if (result.hasErrors()) {
            new ModelAndView("add");
        }

        dao.editar(usuario);
        attr.addFlashAttribute("message", "Usuário alterado com sucesso");
        return new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
        dao.excluir(id);
        attr.addFlashAttribute("message", "Usuário excluído com sucesso");
        return "redirect:/usuario/todos";
    }
}
