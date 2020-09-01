package com.spring.example.controllers;

import java.util.List;

import com.spring.example.controllers.parameters.CategoryParameter;
import com.spring.example.presenters.CategoryPresenter;
import com.spring.example.services.CategoryService;

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
@Api(tags="Categorias")
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    @ApiOperation(value = "Consulta de categorias")
    public ResponseEntity<List<CategoryPresenter>> findAll(
        @RequestParam(value = "page",required = false,defaultValue = "1") int page,
        @RequestParam(value = "size",required = false,defaultValue = "15") int size){
        return null;
    }
    @GetMapping(value = "{/code}")
    @ApiOperation(value = "Consulta de categoria pelo codigo")
    public ResponseEntity<CategoryPresenter> findByCode(
        @PathVariable(value = "code") String categoryCode ){
        return null;
    }

    @PostMapping()
    @ApiOperation(value = "Cria uma categoria")
    public ResponseEntity<CategoryPresenter> create(
        @RequestBody() CategoryParameter category){
        return null;
    }
    @PutMapping()
    @ApiOperation(value = "Atualiza uma categoria")
    public ResponseEntity<CategoryPresenter> update(
        @RequestBody() CategoryParameter category){
        return null;
    }
    @PatchMapping("/{code}")
    @ApiOperation(value = "Atualiza parcialmente uma categoria")
    public ResponseEntity<CategoryPresenter> partialUpdate(
        @PathVariable(value="code") String categoryCode,
        @RequestBody() CategoryParameter category){
        return null;
    }
    @DeleteMapping()
    @ApiOperation(value = "Deleta uma categoria")
    public ResponseEntity<CategoryPresenter> delete(
        @PathVariable(value="code") String categoryCode){
        return null;
    }
}