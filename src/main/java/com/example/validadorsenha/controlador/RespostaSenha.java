package com.example.validadorsenha.controlador;

import java.util.List;


// DTO de resposta.

public class RespostaSenha {
    private boolean valido;
    private List<String> erros;

    public RespostaSenha() {}

    public RespostaSenha(boolean valido, List<String> erros) {
        this.valido = valido;
        this.erros = erros;
    }

    public boolean isValido() { return valido; }
    public void setValido(boolean valido) { this.valido = valido; }
    public List<String> getErros() { return erros; }
    public void setErros(List<String> erros) { this.erros = erros; }
}











