package br.com.seguradora.model.seguros;

public enum CarroEnum {
    CARRO1(30000.0), // Exemplo de valores na tabela Fipe
    CARRO2(25000.0),
    CARRO3(45000.0),
    CARRO4(50000.0),
    CARRO5(20000.0);

    private final double valorTabelaFipe;

    CarroEnum(double valorTabelaFipe) {
        this.valorTabelaFipe = valorTabelaFipe;
    }

    public double getValorTabelaFipe() {
        return valorTabelaFipe;
    }
}