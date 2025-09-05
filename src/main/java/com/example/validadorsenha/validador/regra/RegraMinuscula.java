package com.example.validadorsenha.validador.regra;

import java.util.Optional;

//Regra que exige ao menos uma letra minúscula.
public class RegraMinuscula implements Regra {

    @Override
    public Optional<String> validar(String senha) {//verifica se a senha é nula.
        if (senha == null) return Optional.of("senha deve conter ao menos uma letra minúscula");
        for (char c : senha.toCharArray()) {//percorre cada caractere da senha.
            if (Character.isLowerCase(c)) return Optional.empty();//se encontrar uma letra minúscula
        }
        return Optional.of("senha deve conter ao menos uma letra minúscula");
    }
}
