package com.charlesalmeida.teste;

import com.charlesalmeida.DAO.CadastroDao;

public class Teste {

	public static void main(String[] args) {
		CadastroDao conexao = new CadastroDao();
		
		conexao.getConnection();

	}

}
