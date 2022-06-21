package com.kauan.DB;

public class DbQuery {
	public final String listar = "select * from nfs";
	public final String listarPorId = "select * from nfs where id like ?";
	public final String incluir = "INSERT INTO nfs (razao_social, cnpj, nome_cliente, valor_nota, status, situacao, simular_dados) VALUES (?, ?, ?, ?, ?, ?, ?)";
	public final String deletar = "DELETE FROM nfs WHERE id like ?";

	// Query's atualizar
	
	public final String atualizarRazao = "UPDATE nfs SET razao_social = ? WHERE id like ?";
	public final String atualizarCnpj = "UPDATE nfs SET cnpj = ? WHERE id like ?";
	public final String atualizarNomeCliente = "UPDATE nfs SET nome_cliente = ? WHERE id like ?";
	public final String atualizarValorNota = "UPDATE nfs SET valor_nota = ? WHERE id like ?";
}
