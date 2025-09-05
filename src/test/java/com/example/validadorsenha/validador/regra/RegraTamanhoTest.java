package com.example.validadorsenha.validador.regra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class RegraTamanhoTest {

    @Test
    void falhaQuandoMenorQueMinimo() {
        RegraTamanho regra = new RegraTamanho(9);
        Optional<String> res = regra.validar("curta");
        assertTrue(res.isPresent());
    }

    @Test
    void passaQuandoIgualOuMaior() {
        RegraTamanho regra = new RegraTamanho(9);
        Optional<String> res = regra.validar("123456789");
        assertFalse(res.isPresent());
    }
}
