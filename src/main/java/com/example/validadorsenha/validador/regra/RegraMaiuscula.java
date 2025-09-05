package com.example.validadorsenha.validador.regra;

import java.util.Optional;

//Regra que exige ao menos uma letra maiúscula.
public class RegraMaiuscula implements Regra {

    @Override
    public Optional<String> validar(String senha) {
        if (senha == null) return Optional.of("senha deve conter ao menos uma letra maiúscula");
        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) return Optional.empty();
        }
        return Optional.of("senha deve conter ao menos uma letra maiúscula");
    }
}
