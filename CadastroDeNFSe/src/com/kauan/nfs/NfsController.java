package com.kauan.nfs;

import java.sql.*;
import java.util.Scanner;

public class NfsController {
	
	public Nfs nfs = new Nfs();
	public NfsModel nfsModel = new NfsModel();
	
	public void apagar(int id) throws SQLException{
		try {
			nfs.deletarDados(id);
			System.out.println("Nota deletada com sucesso!");
		} catch (Exception e) {
			System.out.println("Algo deu errado! Mensagem: " + e);
		}
	} 
	
	public void atualizar(int id) throws SQLException{
		int op = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("\nO você que deseja renomear na NFS-e?");
		System.out.println("------------------------------------");
		System.out.println("------- 1 - Razão Social -----------");
		System.out.println("------- 2 - Cnpj da Empresa --------");
		System.out.println("------- 3 - Nome do Cliente --------");
		System.out.println("------- 4 - Valor da Nota ----------");
		System.out.println("------------------------------------\n");
		
		op = s.nextInt();
		
		try {
			nfs.atualizarDados(op, id, nfs.lerVariavel("\nDigite: "));
			listarPorId(id);
		} catch (Exception e) {
			System.out.println("Algo deu errado! Mensagem: " + e);
		}
	}

	public void incluir() throws Exception{
		try {
			String simularDados = nfs.lerVariavel("Deseja simular os valores da nota? (Sim ou nao)");
			simularDados.toLowerCase();
			
			if(simularDados.equals("sim")) {
				listarPorId(nfs.simularDados());
			} else if(simularDados.equals("nao") || simularDados.equals("não")) {
				nfsModel.getInstance().setRazao_social(nfs.lerVariavel("Digite a razão social da sua empresa"));
				nfsModel.getInstance().setCnpj(nfs.lerVariavel("Digite o CNPJ da sua empresa"));
				nfsModel.getInstance().setNome_cliente(nfs.lerVariavel("Digite o nome do seu cliente"));
				nfsModel.getInstance().setValor_nota(nfs.lerVariavel("Digite o valor total da nota"));
				nfsModel.getInstance().setStatus("1");
				nfsModel.getInstance().setSituacao("Emitido");
				
				listarPorId(nfs.salvarDados());
			} else {
				System.out.println("Digite uma opção válida!");
				incluir();
			}
			
		} catch(Exception e) {
			System.out.println("Algo deu errado! Mensagem: " + e);
		}
	}
			
	public void listar() throws SQLException{
		nfs.listarTodosOsDados();
	}
	
	public void listarPorId(int id) throws SQLException{

		nfs.listarDadosPorId(id);
		
		if(this.nfsModel.getInstance().getId() == 0) {
			System.out.println("NFS-e não existe!");
		}else {
			nfs.resultadoFinal();
		}
	}
	
}
