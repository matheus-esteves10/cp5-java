package br.com.seguradora.model.cliente;

import br.com.seguradora.model.seguros.Seguro;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Cliente {
    Seguro seguro = new Seguro();

    private Long id;
    private String nome;
    private String cpf;
    private boolean isAtivo;
    private List<Seguro> listaSeguro;;
    private LocalDate dataNasc;
    private int idade;


    public Cliente(Long id, String nome, String cpf, boolean isAtivo, List<Seguro> listaSeguro, LocalDate dataNasc, int idade) {
        this.id = id;
        this.nome = nome;
        isCpfValid(cpf);
        this.isAtivo = isAtivo;
        setListaSeguro(listaSeguro);
        setDataNasc(dataNasc);
        this.idade = (int) ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    //RN: CASO O USUÁRIO SEJA MENOR DE IDADE NÃO PODE TER CADASTRO PARA ADQUIRIR UM SEGURO
    public void setDataNasc(LocalDate dataNasc) {
        long idade = ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
        if (idade >= 18) {
            this.dataNasc = dataNasc;
        } else {
            throw new RuntimeException("usuario deve ser maior de idade");
        }
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() {
        return isAtivo;
    }

    public void setAtivo(boolean ativo) {
        isAtivo = ativo;
    }

    public List<Seguro> getListaSeguro() {
        return listaSeguro;
    }

    public void setListaSeguro(List<Seguro> listaSeguro) {
        listaSeguro.add((Seguro) seguro.getInfos());
        this.listaSeguro = listaSeguro;
    }

    //verifica se é maior de idade
    private boolean verificaIdade() {
        if (dataNasc == null) {
            return false;
        }
        long idade = ChronoUnit.YEARS.between(dataNasc, LocalDate.now());
        return idade >= 18;
    }

    //verifica se o cpf é valido
    public boolean isCpfValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", ""); // Remover caracteres não numéricos

        if (cpf.length() != 11)
            return false;

        if (cpf.matches("(\\d)\\1*")) // Verificar se todos os dígitos são iguais (caso contrário, não é um CPF válido)
            return false;

        // Calcular o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (10 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        int resto = soma % 11;
        int digitoVerificador1 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o primeiro dígito verificador
        if (Character.getNumericValue(cpf.charAt(9)) != digitoVerificador1)
            return false;

        // Calculando o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (11 - i) * Character.getNumericValue(cpf.charAt(i));
        }
        resto = soma % 11;
        int digitoVerificador2 = (resto < 2) ? 0 : (11 - resto);

        // Verificando o segundo dígito verificador
        if (Character.getNumericValue(cpf.charAt(10)) != digitoVerificador2)
            return false;

        // CPF válido
        return true;
    }

}

