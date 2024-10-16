package br.com.seguradora;

import br.com.seguradora.model.cliente.Cliente;
import br.com.seguradora.model.seguros.*;
import br.com.seguradora.service.ISeguro;

public class Main {
    public static void main(String[] args) {

        SeguroFactory factory = new SeguroFactory();

        ISeguro seguroCarro = factory.getSeguro("SeguroCarro");
        if (seguroCarro instanceof SeguroCarro) {
            SeguroCarro seguroCarroCast = (SeguroCarro) seguroCarro;


            var preco = seguroCarroCast.getValor();
            System.out.println("Valor do seguro do carro: " + preco);
        }

        ISeguro seguroResidencia = factory.getSeguro("SeguroResidencia");
        if (seguroResidencia instanceof SeguroResidencia) {
            SeguroResidencia seguroResidenciaCast = (SeguroResidencia) seguroResidencia;

            var preco = seguroResidenciaCast.getValor();
            System.out.println("Valor do seguro de residência: " + preco);
        }

        ISeguro seguroVida = factory.getSeguro("SeguroVida");
        if (seguroVida instanceof SeguroVida) {
            SeguroVida seguroVidaCast = (SeguroVida) seguroVida;

            var preco = seguroVidaCast.getValor();
            System.out.println("Valor do seguro de vida: " + preco);
        }



    }
}