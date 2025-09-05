package com.example.validadorsenha.servico;

import org.springframework.stereotype.Service;

import com.example.validadorsenha.modelo.ResultadoValidacao;
import com.example.validadorsenha.validador.ValidadorSenha;

// Serviço que delega a validação ao validador.

@Service
public class ServicoValidacaoSenha {

    private final ValidadorSenha validador;

    public ServicoValidacaoSenha(ValidadorSenha validador) {
        this.validador = validador;
    }

    public ResultadoValidacao validar(String senha) {
        return validador.validar(senha);
    }
}
