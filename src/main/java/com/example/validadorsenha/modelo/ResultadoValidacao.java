package com.example.validadorsenha.modelo;

import java.util.Collections;
import java.util.List;

//Resultado da validação de senha.





public class ResultadoValidacao {
    private final boolean valido;
    private final List<String> erros;

    public ResultadoValidacao(boolean valido, List<String> erros) {
        this.valido = valido;
        this.erros = erros == null ? Collections.emptyList() : erros;
    }

    public boolean isValido() {
        return valido;
    }

    public List<String> getErros() {
        return erros;
    }
}
