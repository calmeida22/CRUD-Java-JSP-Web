package com.crudjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crudjsp.bean.Usuario;
import com.mysql.jdbc.PreparedStatement;

public class UsuarioDao {
	
	public static Connection getConnection() {
		
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/crudjsptarde","root","");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return con;
	}

	//UPDATE
		//Editar usuário (pegar do banco e editar no formulário)
		public static Usuario getRegistroById(int id) {
			Usuario usuario = null;
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					usuario = new Usuario();				
					usuario.setId(rs.getInt("id"));
					usuario.setNome(rs.getString("nome"));
					usuario.setPassword(rs.getString("password"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSexo(rs.getString("sexo"));
					usuario.setPais(rs.getString("pais"));
				}
			}catch(Exception ex) {
				System.out.println(ex);
			}
			return usuario;
		}
	
		//Método para atualizar o banco de dados
		public static int updateUsuario(Usuario u){
				int status = 0;
	
				try {
					Connection con = getConnection();
					PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE usuario SET nome=?,"
							  + "password=?, email=?, sexo=?, pais=? WHERE id=?");
					ps.setString(1, u.getNome());
					ps.setString(2, u.getPassword());
					ps.setString(3, u.getEmail());
					ps.setString(4, u.getSexo());
					ps.setString(5, u.getPais());
					ps.setInt(6, u.getId());
					status = ps.executeUpdate();			
				}catch (Exception ex) {
					System.out.println(ex);
				}
				return status;
	
			}
	
	//READ
	public static List<Usuario> getAllUsuarios(){
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSexo(rs.getString("sexo"));
				usuario.setPais(rs.getString("pais"));
				
				list.add(usuario);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		return list;
	}


	//CREATE
	public static int salvarUsuario(Usuario u) {
		int status = 0;

		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("INSERT into usuario (nome, password, email, sexo, pais) VALUES(?,?,?,?,?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSexo());
			ps.setString(5, u.getPais());
			status = ps.executeUpdate();
		}catch (Exception ex) {
			System.out.println(ex);
		}
		return status;
	}

	//DELETE-Excluir	
		public static int deletarUsuario(Usuario u) {
			int status = 0;
			
			try {
				Connection con = getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM usuario WHERE id=?");
				ps.setInt(1, u.getId());
				status=ps.executeUpdate();
			}catch (Exception ex) {
				System.out.println(ex);
			}
			return status;
		}
}
