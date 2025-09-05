package com.example.validadorsenha.validador.regra;

import java.util.Optional;

//Interface para regras de validação.
public interface Regra {
    //Valida a senha e retorna uma mensagem de erro se a regra falhar.
    Optional<String> validar(String senha);
}
