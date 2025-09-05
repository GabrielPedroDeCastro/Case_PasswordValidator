package com.example.validadorsenha.validador.regra;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


//Regra que evita caracteres repetidos (case-sensitive).
//
public class RegraSemRepeticao implements Regra {

    @Override
    public Optional<String> validar(String senha) {
        if (senha == null) return Optional.of("senha nula");//verifica se a senha é nula.
        Set<Character> vistos = new HashSet<>();//conjunto para rastrear caracteres vistos.
        for (char c : senha.toCharArray()) {//percorre cada caractere da senha.
            if (vistos.contains(c)) {
                return Optional.of(String.format("caractere repetido: '%s'", c));//se o caractere já foi visto, retorna erro.
            }
            vistos.add(c);//adiciona o caractere ao conjunto de vistos.
        }
        return Optional.empty();
    }
}
