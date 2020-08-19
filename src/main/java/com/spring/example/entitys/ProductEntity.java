// package com.spring.example.entitys;

// import com.spring.example.entitys.ProductEntity;
// import java.io.Serializable;
// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
// public class ProductEntity implements Serializable{
// 	private static final long serialVersionUID = 1L;
    
//     @Id
// 	@GeneratedValue(strategy=GenerationType.AUTO)
// 	private Long id;
// 	private String nome;
//     private double preco;
//     private String descricao;
    
//     public ProductEntity() {
    	
//     }

//     public ProductEntity(long id, String nome, double preco, String descricao) {
//         this.id = id;
//         this.nome = nome;
//         this.preco = preco;
//         this.descricao = descricao;
//     }
    
//     public Product toModel(){
//         return new Product(this.id,this.nome,this.preco,this.descricao);
//     }

//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getNome() {
//         return nome;
//     }

//     public void setNome(String nome) {
//         this.nome = nome;
//     }

//     public double getPreco() {
//         return preco;
//     }

//     public void setPreco(double preco) {
//         this.preco = preco;
//     }

//     public String getDescricao() {
//         return descricao;
//     }

//     public void setDescricao(String descricao) {
//         this.descricao = descricao;
//     }

// }
