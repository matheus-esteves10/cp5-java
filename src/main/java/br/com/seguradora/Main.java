package br.com.seguradora;

import br.com.seguradora.model.cliente.Cliente;
import br.com.seguradora.model.seguros.SeguroFactory;
import br.com.seguradora.service.ISeguro;

public class Main {
    public static void main(String[] args) {

        ISeguro seguroCarro = SeguroFactory.getSeguro("SeguroCarro");
    }
}