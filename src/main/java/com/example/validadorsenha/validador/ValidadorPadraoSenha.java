package com.example.validadorsenha.validador;

import java.util.ArrayList;
import java.util.List;

import com.example.validadorsenha.modelo.ResultadoValidacao;
import com.example.validadorsenha.validador.regra.Regra;

//Implementação padrão que aplica uma lista de regras.

public class ValidadorPadraoSenha implements ValidadorSenha { //implementa a interface ValidadorSenha

    private final List<Regra> regras;//lista de regras a serem aplicadas.

    public ValidadorPadraoSenha(List<Regra> regras) {//construtor que recebe a lista de regras.
        this.regras = regras == null ? new ArrayList<>() : regras;//inicializa a lista de regras, garantindo que não seja nula.
    }

    @Override
    public ResultadoValidacao validar(String senha) {
        List<String> erros = new ArrayList<>();//lista para coletar mensagens de erro.
        for (Regra regra : regras) {
            regra.validar(senha).ifPresent(erros::add);//aplica cada regra e coleta mensagens de erro.
        }
        return new ResultadoValidacao(erros.isEmpty(), erros);//retorna o resultado da validação.
    }
}
