package com.example.validadorsenha.controlador;






//  DTO de requisição.

public class RequisicaoSenha {
    private String senha;

    public RequisicaoSenha() {}

    public RequisicaoSenha(String senha) { this.senha = senha; }//Construtor com parâmetro senha.

    public String getSenha() { return senha; }//Getter para senha.
    public void setSenha(String senha) { this.senha = senha; }//Setter para senha.
}






