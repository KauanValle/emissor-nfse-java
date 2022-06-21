package com.kauan;

import java.util.Scanner;

import com.kauan.nfs.NfsController;

public class main {
	
	public static void main(String[] args) throws Exception {
		NfsController nfs = new NfsController();
		int idNota = 0;
		
		System.out.println("Qual operação voce deseja realizar?");
		System.out.println("------------------------------------");
		System.out.println("-------- 1 - Cadastrar NFSe --------");
		System.out.println("-------- 2 - Consultar NFSe --------");
		System.out.println("-------- 3 - Atualizar NFSe --------");
		System.out.println("-------- 4 - Deletar NFSe ----------");
		System.out.println("-------- 5 - Listar Todas NFSe -----");
		System.out.println("------------------------------------");
		
		Scanner s = new Scanner(System.in);
		int op = s.nextInt();
		
		if(op == 2 || op == 3 || op == 4) {
			System.out.println("Show!! Agora digite o ID da nota: ");
			 idNota = s.nextInt();
		}
		
		switch(op) {
			case 1:
				nfs.incluir();
				break;
			case 2:
				nfs.listarPorId(idNota);
				break;
			case 3:
				nfs.atualizar(idNota);
				break;
			case 4:
				nfs.apagar(idNota);
				break;
			case 5:
				nfs.listar();
				break;
			default: 
				System.out.println("\n\n\n\nDigite uma opção válida! \n");
				main(args);
		}
	}

}
