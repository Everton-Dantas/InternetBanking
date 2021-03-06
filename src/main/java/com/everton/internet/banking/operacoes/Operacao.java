package com.everton.internet.banking.operacoes;

import com.everton.internet.banking.services.TransacaoService;
import com.everton.internet.banking.entities.Conta;
import com.everton.internet.banking.entities.enuns.TipoOperacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class Operacao {

    @Autowired
    private TransacaoService service;

    public BigDecimal sacar(Conta conta, BigDecimal valor){

        BigDecimal taxa;

        if(!conta.getExclusive() && valor.compareTo(new BigDecimal("100")) > 0 && valor.compareTo(new BigDecimal("300")) <= 0){
            taxa = valor.multiply( new BigDecimal("0.004"));
            valor = valor.add(taxa);
        }else if(!conta.getExclusive() && valor.compareTo(new BigDecimal("300")) > 0 ){
            taxa = valor.multiply( new BigDecimal("0.01"));
            valor = valor.add(taxa);
        }
        service.insert(TipoOperacao.SAQUE,valor, conta);
        return conta.getSaldo().subtract(valor).setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal depositar(Conta conta, BigDecimal valor){
        service.insert(TipoOperacao.DEPOSITO,valor, conta);
        return conta.getSaldo().add(valor).setScale(2, RoundingMode.HALF_EVEN);
    }
}
