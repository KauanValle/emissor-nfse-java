package com.kauan.nfs;

public class NfsModel {
	public int id;
	public String razao_social;
	public String cnpj;
	public String nome_cliente;
	public String valor_nota;
	public String status;
	public String situacao;
    public boolean simular_dados;
    
    private static NfsModel instancia;
    
    public synchronized NfsModel getInstance() {
    	if(instancia == null) {
    		instancia = new NfsModel();
    	}
    	return instancia;
    }
	
    public int getId() {
        return id;
    }

    public void setId(int i) {
        this.id = i;
    }
    
    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getValor_nota() {
        return valor_nota;
    }

    public void setValor_nota(String valor_nota) {
        this.valor_nota = valor_nota;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public boolean getSimular_dados() {
        return simular_dados;
    }

    public void setSimular_dados(boolean b) {
        this.simular_dados = b;
    }

    
}


