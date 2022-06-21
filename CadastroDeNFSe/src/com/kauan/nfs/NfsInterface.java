package com.kauan.nfs;

import java.sql.*;

public interface NfsInterface {
	public void resultadoFinal();
	public String lerVariavel(String mensagem);
	public int simularDados() throws SQLException;
	public int salvarDados() throws SQLException;
	public void listarDadosPorId(int id) throws SQLException;
}
