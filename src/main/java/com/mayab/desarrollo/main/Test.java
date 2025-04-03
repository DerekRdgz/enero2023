package com.mayab.desarrollo.main;

import java.util.List;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistence.UserDAO;
import com.mayab.desarrollo.servicios.LoginServicio;

public class Test {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		LoginServicio servicio = new LoginServicio(dao);
		
		// Crear un usuario
		System.out.println("--------Creando usuarios...--------");
		Usuario usuario1 = servicio.createUser("Pipo", "124", "pipo@gmail.com");
		Usuario usuario2 = servicio.createUser("Ponce", "123", "ponce@gmail.com");
		Usuario usuario3 = servicio.createUser("Derek", "1235325", "derek@gmail.com");
		Usuario usuario4 = servicio.createUser("Patylu", "542234", "patylu@gmail.com");
		Usuario usuario5 = servicio.createUser("Ocariz", "3456", "ocariz@gmail.com");
		// FindAll
		System.out.println("--------Lista de usuarios:--------");
		List <Usuario> listaUsuarios = servicio.findAll();
		for (Usuario usuario : listaUsuarios) {
			System.out.println(usuario.getId() + " " + usuario.getNombre() + " " + usuario.getEmail());
		}

		// Borrar un usuario
		servicio.deleteUser(usuario5.getId());
		System.out.println("--------Usuario borrado: --------" + usuario5.getId());
		List <Usuario> listaUsuariosActualizada = servicio.findAll();
		System.out.println("Lista de usuarios actualizada:");
		for (Usuario usuario : listaUsuariosActualizada) {
			System.out.println(usuario.getId() + " " + usuario.getNombre() + " " + usuario.getEmail());
		}

		// FindById
		Usuario usuarioEncontrado = servicio.findUsuarioById(usuario2.getId());
		System.out.println("--------Usuario encontrado por ID: " + usuarioEncontrado.getId() + " " + usuarioEncontrado.getNombre() + " " + usuarioEncontrado.getEmail());

		// UpdatePass
		servicio.updatePass(usuario2, "nuevaContraseña");
		System.out.println("--------Usuario actualizado: " + usuario3.getId() + " " + usuario2.getNombre() + " " + usuario2.getEmail());

		// FindByName
		Usuario usuarioPorNombre = servicio.findUsuarioByName(usuario1.getNombre());
		System.out.println("--------Usuario encontrado por nombre: " + usuarioPorNombre.getId() + " " + usuarioPorNombre.getNombre() + " " + usuarioPorNombre.getEmail());

		// FindByEmail
		Usuario usuarioPorEmail = servicio.findUsuarioByEmail(usuario4.getEmail());
		System.out.println("--------Usuario encontrado por email: " + usuarioPorEmail.getId() + " " + usuarioPorEmail.getNombre() + " " + usuarioPorEmail.getEmail());
		
	}
}