package com.mayab.desarrollo.servicios;

import java.util.List;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.persistence.UserDAO;

public class LoginServicio {
    private final UserDAO dao;
    public LoginServicio(UserDAO d){
        this.dao = d;
    }
    public Usuario createUser(String username, String pass, String email){
        Usuario usuario = new Usuario();
        usuario.setPassword(pass);
        usuario.setEmail(email);
        usuario.setNombre(username);
        int ID = dao.createUser(usuario);
        usuario.setId(ID);
        System.out.println("ID: " + ID);
        return usuario;
    }

    public void deleteUser(int id){
        dao.deleteUser(id);
    }

    public void updatePass(Usuario usuario, String Ncontra){
        dao.updatePass(usuario, Ncontra);
    }

    public List<Usuario> findAll(){
        return dao.findAll();
    }

    public Usuario findUsuarioById(int id){
        return dao.findById(id);
    }

    public Usuario findUsuarioByName(String username){
        return dao.findByName(username);
    }

    public Usuario findUsuarioByEmail(String email){
        return dao.findByEmail(email);
    }
    
}
