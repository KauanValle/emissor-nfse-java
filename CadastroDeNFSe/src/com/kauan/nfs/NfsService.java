package com.kauan.nfs;

import java.sql.*;
import com.kauan.DB.DbQuery;

public class NfsService {
	public DbQuery querys = new DbQuery();
	
	public Connection getConnection() throws SQLException {
		String url = "jdbc:sqlite:K:\\EclipseProject\\CadastroDeNFSe\\DB\\banco.db";
		Connection conexao = DriverManager.getConnection(url);
		return conexao;
	}
	
	public PreparedStatement statement (String query) throws SQLException {
		return getConnection().prepareStatement(query);
	}
	
	public int salvarNfs(String razao_social, String cnpj, String nome_cliente, String valor_nota, boolean simular_dados) throws SQLException {
		final PreparedStatement ps = getConnection().prepareStatement(querys.incluir, Statement.RETURN_GENERATED_KEYS);
		
		ps.setString(1, razao_social);
		ps.setString(2, cnpj);
		ps.setString(3, nome_cliente);
		ps.setString(4, valor_nota);
		ps.setString(5, "1");
		ps.setString(6, "Emitida");
		ps.setBoolean(7, simular_dados);
		ps.executeUpdate();
		
		final ResultSet rs = ps.getGeneratedKeys();
		
		if (rs.next()) {
		    final int lastId = rs.getInt(1);
		    return lastId;
		}
		
		return 0;
	}
	
	public ResultSet listarPorId(int id) throws SQLException {
		PreparedStatement prepare = statement(querys.listarPorId);
		prepare.setInt(1, id);
		return prepare.executeQuery();
	}
	
	public ResultSet listarTodos() throws SQLException {
		PreparedStatement prepare = statement(querys.listar);
		return prepare.executeQuery();
	}
	
	public void deletarNfs(int id) throws SQLException {
		PreparedStatement prepare = statement(querys.deletar);
		prepare.setInt(1, id);
		prepare.executeUpdate();
	}
	
	public void atualizarDados(int op, int id, String dado) throws SQLException {
		/*
		 * 1 - Atualizar Razao
		 * 2 - Atualizar Cnpj
		 * 3 - Atualizar Cliente
		 * 4 - Atualizar Valor Nota
		 */
		String queryPrincipal = "";
		
		switch (op) {
			case 1:
				queryPrincipal = querys.atualizarRazao;
				break;
			case 2:
				queryPrincipal = querys.atualizarCnpj;
				break;
			case 3:
				queryPrincipal = querys.atualizarNomeCliente;
				break;
			case 4:
				queryPrincipal = querys.atualizarValorNota;
				break;
		}
		
		PreparedStatement prepare = getConnection().prepareStatement(queryPrincipal, Statement.RETURN_GENERATED_KEYS);
		
		prepare.setString(1, dado);
		prepare.setInt(2, id);
		prepare.executeUpdate();
	}
}
