package com.example.validadorsenha.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validadorsenha.modelo.ResultadoValidacao;
import com.example.validadorsenha.servico.ServicoValidacaoSenha;




// Controller REST para validação de senhas.

@RestController
@RequestMapping("/api/v1/senha")//Rota base para o controlador.
public class ControladorSenha {

    private final ServicoValidacaoSenha servico;//Serviço de validação de senha.

    public ControladorSenha(ServicoValidacaoSenha servico) {
        this.servico = servico;
    }

    @PostMapping("/validar")
    public ResponseEntity<RespostaSenha> validar(@RequestBody RequisicaoSenha requisicao){///Endpoint para validar a senha.{
        ResultadoValidacao resultado = servico.validar(requisicao.getSenha()); //valida a senha recebida na requisição.
        RespostaSenha resposta = new RespostaSenha(resultado.isValido(), resultado.getErros()); //cria a resposta com o resultado da validação.
        return ResponseEntity.ok(resposta); //retorna a resposta com status 200 OK.
    }
}
