package com.kaspperAcad.empresa.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaspperAcad.empresa.model.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{
	List<Fornecedor> findByRazaoSocialContainingIgnoreCase(String razaoSocial);
    List<Fornecedor> findByNomeFantasiaContainingIgnoreCase(String nomeFantasia);
}
