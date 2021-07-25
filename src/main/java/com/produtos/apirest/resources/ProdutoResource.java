package com.produtos.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping(value = "/api")
@Api(value ="API REST Produtos")
@CrossOrigin(origins="*")
public class ProdutoResource {

  @Autowired
  ProdutoRepository produtoRepository;

  //lista produtos
  @GetMapping("/produtos")
  @ApiOperation(value = "Retorna uma lista de produtos")
  public List<Produto> listProdutos() {
    return produtoRepository.findAll();
  }

  //lista por (ID)
  @GetMapping("/produtos/{id}")
  @ApiOperation(value = "Retorna um produtos unico")
  public Produto listaProdutoUnico(@PathVariable(value="id") long id){
    return produtoRepository.findById(id);
  }

  //create produts
  @PostMapping(value="/produto")
  @ApiOperation(value = "Salva um produto")
  public Produto salvaProduto(@RequestBody  Produto produto) {
      return produtoRepository.save(produto);
  
  }

  //delete produto(ID)
  @DeleteMapping(value="/produtos/{id}")
  @ApiOperation(value = "Deleta um produto")
  public void deletaProduto(@PathVariable(value = "id") long id){
    produtoRepository.deleteById(id);
  }

  //ataulizar produto
  @PutMapping(value="/produto")
  @ApiOperation(value = "Atualiza um produto")
  public Produto AtualizaProduto(@RequestBody  Produto produto) {
      return produtoRepository.save(produto);
  
  }


  


}
