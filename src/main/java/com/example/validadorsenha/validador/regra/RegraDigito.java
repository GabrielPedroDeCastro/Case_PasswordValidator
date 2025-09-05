package com.example.validadorsenha.validador.regra;

import java.util.Optional;

//Regra que exige ao menos um dígito.
public class RegraDigito implements Regra {

    @Override
    public Optional<String> validar(String senha) {
        if (senha == null) return Optional.of("senha deve conter ao menos um dígito");
        for (char c : senha.toCharArray()) {
            if (Character.isDigit(c)) return Optional.empty();
        }
        return Optional.of("senha deve conter ao menos um dígito");
    }
}
