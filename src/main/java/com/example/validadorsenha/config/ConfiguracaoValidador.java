package com.example.validadorsenha.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.validadorsenha.validador.ValidadorPadraoSenha;
import com.example.validadorsenha.validador.ValidadorSenha;
import com.example.validadorsenha.validador.regra.RegraCaracterEspecial;
import com.example.validadorsenha.validador.regra.RegraDigito;
import com.example.validadorsenha.validador.regra.RegraMaiuscula;
import com.example.validadorsenha.validador.regra.RegraMinuscula;
import com.example.validadorsenha.validador.regra.RegraSemEspaco;
import com.example.validadorsenha.validador.regra.RegraSemRepeticao;
import com.example.validadorsenha.validador.regra.RegraTamanho;

@Configuration
public class ConfiguracaoValidador {
//Configuração do validador de senha com regras específicas.
    @Bean
    public ValidadorSenha validadorSenha() {//Bean que cria uma instância do validador de senha com regras definidas.
        return new ValidadorPadraoSenha(List.of(
            new RegraTamanho(9),
            new RegraDigito(),
            new RegraMinuscula(),
            new RegraMaiuscula(),
            new RegraCaracterEspecial(),
            new RegraSemEspaco(),
            new RegraSemRepeticao()
        ));
    }
}
