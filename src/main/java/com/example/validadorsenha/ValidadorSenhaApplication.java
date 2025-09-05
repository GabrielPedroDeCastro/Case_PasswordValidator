package com.example.validadorsenha;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.validadorsenha.servico.ServicoValidacaoSenha;

// Ponto de entrada da aplicação.

@SpringBootApplication
public class ValidadorSenhaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidadorSenhaApplication.class, args);
        
    }
    @Bean
    CommandLineRunner runner(ServicoValidacaoSenha servico) {//Bean para executar código na inicialização.
        return args -> {
            System.out.println(servico.validar("AbTp9!fok"));   // deve ser válido
            System.out.println(servico.validar("AbTp9!foo"));   // inválido
        };
    }
}
