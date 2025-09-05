package com.example.validadorsenha.validador.regra;

import java.util.Optional;

//Regra que proíbe espaços em branco.
public class RegraSemEspaco implements Regra {

    @Override
    public Optional<String> validar(String senha) {
        if (senha == null) return Optional.of("senha nula");
        for (char c : senha.toCharArray()) {//percorre cada caractere da senha.
            if (Character.isWhitespace(c)) return Optional.of("senha contém espaço em branco");//se encontrar espaço em branco, retorna erro.
        }
        return Optional.empty();
    }
}
