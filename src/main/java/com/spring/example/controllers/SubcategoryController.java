package com.spring.example.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.spring.example.controllers.parameters.SubcategoryParameter;
import com.spring.example.models.Subcategory;
import com.spring.example.presenters.SubcategoryPresenter;
import com.spring.example.services.SubcategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
@Api(tags="Subcategorias")
@RequestMapping("/api/v1/subcategories")
public class SubcategoryController {

    @Autowired
    private SubcategoryService subcategoryService;

    @GetMapping
    @ApiOperation(value = "Consulta de Subcategorias")
    public ResponseEntity<List<SubcategoryPresenter>> findAll(
        @RequestParam(value = "page",required = false,defaultValue = "1") int page,
        @RequestParam(value = "size",required = false,defaultValue = "15") int size){
            
        var response = this.subcategoryService.findAll(page, size);
        if(response == null || response.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(response.stream().map(s -> new SubcategoryPresenter(s))
        .collect(Collectors.toList()), HttpStatus.OK);
    }
//continuar a partir do POST
    @GetMapping(value = "{/code}")
    @ApiOperation(value = "Consulta de Subcategoria pelo codigo")
    public ResponseEntity<SubcategoryPresenter> findByCode(
        @PathVariable(value = "code") String subcategoryCode ){
        
        var response = this.subcategoryService.findById(subcategoryCode);
        if(response == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new SubcategoryPresenter(response), HttpStatus.OK);
    }

    @PostMapping()
    @ApiOperation(value = "Cria uma Subcategoria")
    public ResponseEntity<SubcategoryPresenter> create(
        @RequestBody() SubcategoryParameter subcategoryParameter){
        return null;
    }
    @PutMapping()
    @ApiOperation(value = "Atualiza uma Subcategoria")
    public ResponseEntity<SubcategoryPresenter> update(
        @RequestBody() SubcategoryParameter subcategoryParameter){
        return null;
    }
    @PatchMapping("/{code}")
    @ApiOperation(value = "Atualiza parcialmente uma Subcategoria")
    public ResponseEntity<SubcategoryPresenter> partialUpdate(
        @PathVariable(value="code") String subcategoryCode,
        @RequestBody() SubcategoryParameter subcategoryParameter){
        return null;
    }
    @DeleteMapping()
    @ApiOperation(value = "Deleta uma Subcategoria")
    public ResponseEntity<SubcategoryPresenter> delete(
        @PathVariable(value="code") String subcategoryCode){
        return null;
    }
}