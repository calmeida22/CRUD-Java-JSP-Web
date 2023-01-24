package com.charlesalmeida.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.charlesalmeida.bean.Cadastro;
import com.mysql.jdbc.PreparedStatement;

public class CadastroDao {

public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudcharlesalmeida","root","");
			System.out.println("Conexão estabelecida com sucesso!");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return con;
		
	}

//READ
	public static List<Cadastro> getAllCadastros(){
		List<Cadastro> list = new ArrayList<Cadastro>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cadastro");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Cadastro cadastro = new Cadastro();
				
				cadastro.setId(rs.getInt("id"));
				cadastro.setNome(rs.getString("nome"));
				cadastro.setCpf(rs.getString("cpf"));
				cadastro.setCidade(rs.getString("cidade"));
				cadastro.setEstado(rs.getString("estado"));
				
				list.add(cadastro);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return list;
	}

//UPDATE
		//Editar usuário (pegar do banco e editar no formulário)
			public static Cadastro getRegistroById(int id) {
				Cadastro cadastro = null;
				
				try {
					Connection con = getConnection();
					PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cadastro WHERE id=?");
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					
					while(rs.next()){
						cadastro = new Cadastro();				
						cadastro.setId(rs.getInt("id"));
						cadastro.setNome(rs.getString("nome"));
						cadastro.setCpf(rs.getString("cpf"));
						cadastro.setCidade(rs.getString("cidade"));
						cadastro.setEstado(rs.getString("estado"));
						
					}
				}catch(Exception ex) {
					System.out.println(ex);
				}
				return cadastro;
			}

		//Método para atualizar o banco de dados
			public static int updateCadastro(Cadastro u){
					int status = 0;
		
					try {
						Connection con = getConnection();
						PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE cadastro SET nome=?,"
								  + "cpf=?, cidade=?, estado=? WHERE id=?");
						ps.setString(1, u.getNome());
						ps.setString(2, u.getCpf());
						ps.setString(3, u.getCidade());
						ps.setString(4, u.getEstado());
						ps.setInt(5, u.getId());
						status = ps.executeUpdate();			
					}catch (Exception ex) {
						System.out.println(ex);
					}
					return status;
		
				}

//DELETE-Excluir	
	public static int deletarCadastro(Cadastro u) {
		int status = 0;
			
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM cadastro WHERE id=?");
			ps.setInt(1, u.getId());
			status=ps.executeUpdate();
		}catch (Exception ex) {
			System.out.println(ex);
			}
			return status;
		}

//CREATE
	public static int salvarCadastro(Cadastro u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT into cadastro (nome, cpf, cidade, estado) VALUES(?,?,?,?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getCpf());
			ps.setString(3, u.getCidade());
			ps.setString(4, u.getEstado());
			status = ps.executeUpdate();
		}catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
		}	
}
