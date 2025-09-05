package com.example.validadorsenha.validador.regra;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class RegraDigitoTest {

    @Test
    void falhaQuandoSemDigito() {
        RegraDigito regra = new RegraDigito();
        Optional<String> res = regra.validar("abcdefgH!");
        assertTrue(res.isPresent());
    }

    @Test
    void passaQuandoTemDigito() {
        RegraDigito regra = new RegraDigito();
        Optional<String> res = regra.validar("abc1defGH");
        assertFalse(res.isPresent());
    }
}
