package com.kaspperAcad.empresa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

import com.kaspperAcad.empresa.model.DadosCadastroFornecedor;
import com.kaspperAcad.empresa.model.Fornecedor;
import com.kaspperAcad.empresa.repository.FornecedorRepository;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository repository;

    // Método para abrir o formulário de cadastro
    @GetMapping
    public String abreFormFornecedor(Model model) {
        model.addAttribute("fornecedor", new Fornecedor()); // Para novo fornecedor
        return "fornecedor/cadFornecedor"; // A página do formulário
    }

    // Método para listar os fornecedor
    @GetMapping("/listForn")
    public String carregaPaginaListagem(@RequestParam(required = false) String razaoSocial,
            							@RequestParam(required = false) String nomeFantasia,
            							Model model) {
    	List<Fornecedor> lista;
        
        if (razaoSocial != null && !razaoSocial.isEmpty()) {
            lista = repository.findByRazaoSocialContainingIgnoreCase(razaoSocial);
        } else if (nomeFantasia != null && !nomeFantasia.isEmpty()) {
            lista = repository.findByNomeFantasiaContainingIgnoreCase(nomeFantasia);
        } else {
            lista = repository.findAll(); // Retorna todos se não houver filtros
        }
        
        model.addAttribute("lista", lista); // Passa a lista para view
        model.addAttribute("razaoSocial", razaoSocial); // Para manter o valor no campo de busca
        model.addAttribute("nomeFantasia", nomeFantasia); // Para manter o valor no campo de busca
        return "fornecedor/listForn"; // Retorna a view de listagem
    }

    // Método para carregar o formulário de edição
    @GetMapping("/cadFornecedor")
    public String carregaFormularioEdicao(@RequestParam Long id, Model model) {
        Fornecedor fornecedor = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Fornecedor inválido: " + id));
        model.addAttribute("fornecedor", fornecedor); // Passa o fornecedor para a view
        return "fornecedor/cadFornecedor"; // Retorna a view do formulário
    }

    // Método para cadastrar ou atualizar o funcionário
    @PostMapping
    @Transactional
    public String cadastraFornecedor(DadosCadastroFornecedor dados) {
        Fornecedor fornecedor;

        if (dados.id() != null) { // Verifica se é uma atualização
        	fornecedor = repository.findById(dados.id())
                    .orElseThrow(() -> new IllegalArgumentException("Fornecedor inválido: " + dados.id()));
        	fornecedor.atualizaDados(dados); // Atualiza os dados do fornecedor existente
        } else { // Se não houver ID, é uma nova inserção
        	fornecedor = new Fornecedor(dados);
        }

        repository.save(fornecedor); // Salva o fornecedor (criação ou atualização)
        return "redirect:/fornecedor/listForn"; // Redireciona para a listagem
    }

    // Método para remover o fornecedor
    @DeleteMapping
    @Transactional
    public String removeFornecedor(@RequestParam Long id) {
        repository.deleteById(id);
        System.out.println("Fornecedor EXCLUÍDO!");
        return "redirect:/fornecedor/listForn"; // Redireciona para a listagem
    }
    
  
}

