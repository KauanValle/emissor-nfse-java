package com.kauan.nfs;

import java.sql.*;
import java.util.*;

abstract class NfsAbstract implements NfsInterface {
	
	public NfsService service = new NfsService();
	public NfsModel model = new NfsModel();
	
	public void resultadoFinal() {
		System.out.println("\n--------------------------------");
		System.out.println("Codigo: " + this.model.getInstance().getId());
		System.out.println("Razão Social: "  + this.model.getInstance().getRazao_social());
		System.out.println("CNPJ da Empresa: "  + this.model.getInstance().getCnpj());
		System.out.println("Nome do Cliente: "  + this.model.getInstance().getNome_cliente());
		System.out.println("Valor total da nota: "  + this.model.getInstance().getValor_nota());
		System.out.println("Status da nota: "  + this.model.getInstance().getStatus());
		System.out.println("Situação da nota: "  + this.model.getInstance().getSituacao());
		System.out.println("--------------------------------\n");
	}
	
	public String lerVariavel(String mensagem) {
		Scanner s = new Scanner(System.in);
		System.out.println(mensagem);
		return s.next();
	}
	
	public void atualizarDados(int op, int id, String dado) throws SQLException {
		service.atualizarDados(op, id, dado);
	}
	
	public int simularDados() throws SQLException {
		String cnpj = "";
		String valor_nota = "";
		Random gen = new Random();
		int aleatorio = gen.nextInt(5);
		
		if(aleatorio == 0) {
			aleatorio++;
		}
		
		for(int i = 0; i < aleatorio; i++) {
			valor_nota += gen.nextInt(9);
		}
		
		for(int i = 0; i < 14; i++) {
			cnpj += gen.nextInt(9);
		}
		
		String[] razaoSocial = {
				"Milena e Alexandre Lavanderia Ltda",
				"Daniel e Cecília Transportes Ltda",
				"Mecânica Teixeira Ltda",
				"Cláudio e Bianca Informática Ltda",
				"Nicolas e Rosa Limpeza ME",
				"Joaquim e Sebastiana Locações de Automóveis Ltda",
				"Heloise e Luana Comercio de Bebidas ME",
				"Jorge e Ruan Consultoria Financeira Ltda",
				"Carolina e Rebeca Padaria Ltda",
				"Cecília e Lucas Buffet Ltda"
		};
		
		String[] nomeCliente = {
				"Henrique Pereira",
				"Helena Cardoso",
				"Breno da Rosa",
				"Dra. Yasmin Pinto",
				"Emanuella Martins",
				"Sofia Duarte",
				"Sr. Lucas Gabriel Freitas",
				"Benício Monteiro",
				"Sr. Nathan da Luz",
				"Srta. Ana Lívia Pinto"
		};
		
		this.model.getInstance().setCnpj(cnpj);
		this.model.getInstance().setRazao_social(razaoSocial[gen.nextInt(razaoSocial.length)]);
		this.model.getInstance().setNome_cliente(nomeCliente[gen.nextInt(nomeCliente.length)]);
		this.model.getInstance().setValor_nota(valor_nota);
		this.model.getInstance().setSituacao("Emitida");
		this.model.getInstance().setStatus("1");
		this.model.getInstance().setSimular_dados(true);
		
		return this.salvarDados();
	}
	
	public int salvarDados() throws SQLException {
		return service.salvarNfs(model.getInstance().getRazao_social(), model.getInstance().getCnpj(), model.getInstance().getNome_cliente(), model.getInstance().getValor_nota(), model.getInstance().getSimular_dados());		
	}
	
	public void deletarDados(int id) throws SQLException {
		service.deletarNfs(id);
	}
	
	public void listarDadosPorId(int id) throws SQLException {
		ResultSet resultado = service.listarPorId(id);
		
		while (resultado.next()) {
			this.model.getInstance().setId(resultado.getInt(1));
			this.model.getInstance().setRazao_social(resultado.getString(2));
			this.model.getInstance().setCnpj(resultado.getString(3));
			this.model.getInstance().setNome_cliente(resultado.getString(4));
			this.model.getInstance().setValor_nota(resultado.getString(5));
		}
	}
	
	public void listarTodosOsDados() throws SQLException {
		ResultSet resultado = service.listarTodos();
		
		while (resultado.next()) {
			System.out.println("\n--------------------------------");
			System.out.println("Codigo: " + resultado.getInt(1));
			System.out.println("Razão Social: "  + resultado.getString(2));
			System.out.println("CNPJ da Empresa: "  + resultado.getString(3));
			System.out.println("Nome do Cliente: "  + resultado.getString(4));
			System.out.println("Valor total da nota: "  + resultado.getString(5));
			System.out.println("Status da nota: "  + resultado.getString(6));
			System.out.println("Situação da nota: "  + resultado.getString(7));
			System.out.println("--------------------------------\n");
		}
		
	}

}
