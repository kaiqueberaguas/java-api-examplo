package com.spring.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.example.controllers.parameters.CategoryParameter;
import com.spring.example.presenters.CategoryPresenter;
import com.spring.example.services.CategoryService;

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
@Api(tags="Categorias")
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "Consulta de categorias")
    public ResponseEntity<List<CategoryPresenter>> findAll(
    @RequestParam(value = "page",required = false,defaultValue = "0") int page,
    @RequestParam(value = "size",required = false,defaultValue = "15") int size){
        var response = this.categoryService.findAll(page, size);
        if(response == null || response.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(response.stream().map(s -> new CategoryPresenter(s))
            .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping(value = "{/code}")
    @ApiOperation(value = "Consulta de categoria pelo codigo")
    public ResponseEntity<CategoryPresenter> findByCode(
        @PathVariable(value = "code") String categoryCode ){
            var response = this.categoryService.find(categoryCode);
            if(response == null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new CategoryPresenter(response), HttpStatus.OK);
        }

    @PostMapping()
    @ApiOperation(value = "Cria uma categoria")
    public ResponseEntity<CategoryPresenter> create(
    @RequestBody() CategoryParameter categoryParameter){
        var response = this.categoryService.create(categoryParameter.toModel());
        return new ResponseEntity<>(new CategoryPresenter(response), HttpStatus.CREATED);
    }
    
    @PutMapping()
    @ApiOperation(value = "Atualiza uma categoria")
    public ResponseEntity<CategoryPresenter> update(
        @RequestBody() CategoryParameter categoryParameter){
            var response = this.categoryService.update(categoryParameter.toModel());
            if(response == null){
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(new CategoryPresenter(response), HttpStatus.OK);
 
    }
 
    @DeleteMapping("/{code}")
    @ApiOperation(value = "Deleta uma categoria")
    public ResponseEntity<CategoryPresenter> delete(
        @PathVariable(value="code") String categoryCode){
            var response = this.categoryService.delete(categoryCode);
            if(response == null){
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(new CategoryPresenter(response), HttpStatus.OK);
    }
}