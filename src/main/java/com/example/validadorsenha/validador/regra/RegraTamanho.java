package com.example.validadorsenha.validador.regra;

import java.util.Optional;


//Regra que exige tamanho mínimo.

public class RegraTamanho implements Regra {

    private final int minimo;

    public RegraTamanho(int minimo) {
        this.minimo = minimo;
    }

    @Override
    public Optional<String> validar(String senha) {
        if (senha == null || senha.length() < minimo) {
            return Optional.of(String.format("senha deve ter ao menos %d caracteres", minimo));
        }
        return Optional.empty();
    }
}
