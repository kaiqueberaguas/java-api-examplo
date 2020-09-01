package com.spring.example.controllers;

import java.util.List;

import com.spring.example.controllers.parameters.ProductParameter;
import com.spring.example.presenters.ProductPresenter;
import com.spring.example.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(tags="Produtos")
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation(value = "Consulta de produtos")
    public ResponseEntity<List<ProductPresenter>> findAll(
        @RequestParam(value = "page",required = false,defaultValue = "1") int page,
        @RequestParam(value = "size",required = false,defaultValue = "15") int size){
        return null;
    }
    @GetMapping(value = "{/code}")
    @ApiOperation(value = "Consulta de produto pelo codigo")
    public ResponseEntity<ProductPresenter> findByCode(
        @PathVariable(value = "code") String productCode ){
        return null;
    }

    @PostMapping()
    @ApiOperation(value = "Cria um produto")
    public ResponseEntity<ProductPresenter> create(
        @RequestBody() ProductParameter product){
        return null;
    }
    @PutMapping()
    @ApiOperation(value = "Atualiza um produto")
    public ResponseEntity<ProductPresenter> update(
        @RequestBody() ProductParameter product){
        return null;
    }
    @PatchMapping("/{code}")
    @ApiOperation(value = "Atualiza parcialmente um produto")
    public ResponseEntity<ProductPresenter> partialUpdate(
        @PathVariable(value="code") String productCode,
        @RequestBody() ProductParameter product){
        return null;
    }
    @DeleteMapping()
    @ApiOperation(value = "Deleta um produto")
    public ResponseEntity<ProductPresenter> deleteProduct(
        @PathVariable(value="code") String productCode){
        return null;
    }
}