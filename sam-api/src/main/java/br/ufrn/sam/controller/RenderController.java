package br.ufrn.sam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.ufrn.sam.model.AlunoModel;
import br.ufrn.sam.model.PessoaModel;
import jakarta.servlet.http.HttpSession;

@Controller
public class RenderController {
    @GetMapping("/dashboardAluno")
    public String dashboardAluno(Model model) {
        return "pages/dashboardAluno";
    }
    @GetMapping("/turmas")
    public String turmas(Model model) {
        return "pages/turmas";
    }
    @GetMapping("/ranking")
    public String ranking(Model model) {
        return "pages/ranking";
    }
    @GetMapping("/configuracoes")
    public String configuracoes(HttpSession session, Model model) {
        PessoaModel usuarioLogado = (PessoaModel) session.getAttribute("usuarioLogado");

        // Se ninguém estiver logado, manda de volta para a página inicial
        if (usuarioLogado == null) {
            return "redirect:/";
        }

        if (usuarioLogado.getIsAluno()) {
            AlunoModel aluno = (AlunoModel) usuarioLogado;
            model.addAttribute("aluno", aluno);
        }   
        return "pages/configuracoes";
    }
    @GetMapping("/logout")
    public String fazerLogout(HttpSession session) {
        session.invalidate();
        
        return "redirect:/sam"; 
    }
}
