package com.mayab.desarrollo.persistence;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mayab.desarrollo.entities.Usuario;
import com.mayab.desarrollo.main.HibernateUtil;

public class UserDAO implements IUserDAO{

    @Override
    public List<Usuario> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Usuario");
        List<Usuario> list = query.getResultList();
        session.close();
        return list;
    }

    @Override
    public int createUser(Usuario usuario) {
        int id;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            id = (int) session.save(usuario);
            session.getTransaction().commit();
        }
        return id;
    }

    @Override
    public boolean deleteUser(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();        
        Usuario usuario = session.find(Usuario.class, id);
        if (usuario != null) {
            session.delete(usuario);
        }
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Usuario findById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario usuario = session.get(Usuario.class, id);
        session.close();
        return usuario;
    }

    @Override
    public Usuario updatePass(Usuario usuario, String Ncontra) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        //Usuario updateUsuario = session.get(Usuario.class, usuario.getId());
        //updateUsuario.setPassword(Ncontra);
        usuario.setPassword(Ncontra);
        session.update(usuario);
        session.getTransaction().commit();
        session.close();
        return usuario;
    }

    @Override
    public Usuario findByName(String nombre) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Usuario WHERE nombre = :nombre");
        query.setParameter("nombre", nombre);
        Usuario usuario = (Usuario) query.uniqueResult();
        session.close();
        return usuario;
    }

    @Override
    public Usuario findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("FROM Usuario WHERE email = :email");
        query.setParameter("email", email);
        Usuario usuario = (Usuario) query.uniqueResult();
        session.close();
        return usuario;
    }

}
