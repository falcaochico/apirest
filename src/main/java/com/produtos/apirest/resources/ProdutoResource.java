package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return this.produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto listaProdutos(@PathVariable(value = "id") Long id){
		return this.produtoRepository.findById(id).get();
	}
	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto")
	public void deletaProduto(@RequestBody Produto produto) {
		this.produtoRepository.delete(produto);
	}
	
	@PutMapping("/produto")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return this.produtoRepository.save(produto);
	}
	
}
