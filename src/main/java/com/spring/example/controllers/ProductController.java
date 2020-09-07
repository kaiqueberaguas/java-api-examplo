package com.spring.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.example.controllers.parameters.ProductParameter;
import com.spring.example.presenters.ProductPresenter;
import com.spring.example.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
        @RequestParam(value = "page",required = false,defaultValue = "0") int page,
        @RequestParam(value = "size",required = false,defaultValue = "15") int size){
            var response = this.productService.findAll(page, size);
            if(response == null || response.isEmpty()){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(response.stream().map(s -> new ProductPresenter(s))
                .collect(Collectors.toList()), HttpStatus.OK);
       }
    @GetMapping(value = "{/code}")
    @ApiOperation(value = "Consulta de produto pelo codigo")
    public ResponseEntity<ProductPresenter> findByCode(
        @PathVariable(value = "code") String productCode ){
            var response = this.productService.find(productCode);
            if(response == null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new ProductPresenter(response), HttpStatus.OK);
      }

    @PostMapping()
    @ApiOperation(value = "Cria um produto")
    public ResponseEntity<ProductPresenter> create(
        @RequestBody() ProductParameter product){
            var response = this.productService.create(product.toModel());
            return new ResponseEntity<>(new ProductPresenter(response), HttpStatus.CREATED);
        }
    @PutMapping()
    @ApiOperation(value = "Atualiza um produto")
    public ResponseEntity<ProductPresenter> update(
        @RequestBody() ProductParameter product){
            var response = this.productService.update(product.toModel());
            if(response == null){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new ProductPresenter(response), HttpStatus.OK);
    }
 
    @DeleteMapping("/{code}")
    @ApiOperation(value = "Deleta um produto")
    public ResponseEntity<ProductPresenter> deleteProduct(
        @PathVariable(value="code") String productCode){

            var response = this.productService.delete(productCode);
            if(response == null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new ProductPresenter(response), HttpStatus.OK);
    }
}