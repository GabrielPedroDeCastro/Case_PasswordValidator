package com.example.validadorsenha.validador.regra;

import java.util.Optional;

//Regra para caracteres especiais permitidos.
public class RegraCaracterEspecial implements Regra {

    private static final String CARACTERES_ESPECIAIS = "!@#$%^&*()-+";

    @Override
    public Optional<String> validar(String senha) {
        if (senha == null) return Optional.of("senha deve conter ao menos um caractere especial: " + CARACTERES_ESPECIAIS);//verifica se a senha é nula.
        for (char c : senha.toCharArray()) {//percorre cada caractere da senha.
            if (CARACTERES_ESPECIAIS.indexOf(c) >= 0) return Optional.empty();//se encontrar um caractere especial, retorna sucesso.
        }
        return Optional.of("senha deve conter ao menos um caractere especial: " + CARACTERES_ESPECIAIS);
    }
}
