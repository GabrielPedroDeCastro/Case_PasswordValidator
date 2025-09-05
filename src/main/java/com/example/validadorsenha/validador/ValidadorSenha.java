package com.example.validadorsenha.validador;

import com.example.validadorsenha.modelo.ResultadoValidacao;

//  Interface do validador de senha.
 
public interface ValidadorSenha {
    ResultadoValidacao validar(String senha);
}
