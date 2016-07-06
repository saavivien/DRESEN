/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dresen.dresen.Test;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.dresen.dresen.DaoImplement.DepartementDaoImpl;
import com.dresen.dresen.DaoImplement.CategorieStructureDaoImpl;
import com.dresen.dresen.DaoImplement.PosteDaoImpl;
import com.dresen.dresen.DaoImplement.StructureDaoImpl;
import com.dresen.dresen.DaoInterface.IDepartementDao;
import com.dresen.dresen.entities.Departement;
import com.dresen.dresen.entities.CategorieStructure;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.dresen.dresen.DaoInterface.ICategorieStructureDao;
import com.dresen.dresen.DaoInterface.IPosteDao;
import com.dresen.dresen.DaoInterface.IStructureDao;
import com.dresen.dresen.entities.Poste;
import com.dresen.dresen.entities.StructureAttache;
import java.util.List;

/**
 *
 * @author Vivien Saa
 */
public class test {
//    public static void main(String[] args) throws DataAccessException {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dresenPU");
//        EntityManager em = emf.createEntityManager();
//        IDepartementDao iDepartementDao= new DepartementDaoImpl();
//        //ICompteCourantDao iCompteCourantDao= new CompteDaoImpl();
//        ((GenericDao) iDepartementDao).setManager(em);
//        System.out.println("hello");
//        
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//           Departement departement = new Departement();
//           departement.setIntituleDepartement("DIAMARE");
//           iDepartementDao.create(departement);
//        tx.commit();
//               
//    }
     public static void main(String[] args) throws DataAccessException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dresenPU");
        EntityManager em = emf.createEntityManager();
        IPosteDao iPosteDao= new PosteDaoImpl();
        //ICompteCourantDao iCompteCourantDao= new CompteDaoImpl();
        ((GenericDao) iPosteDao).setManager(em);
        System.out.println("hello");
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
           List<Poste> listPostes = iPosteDao.findPosteByCategorieStructure(2);
           for(Poste p:listPostes)
               System.out.println("intitulé de la structure:vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvssssssssssssssssssssssssssssssss"+p.getIntitulePoste());
           tx.commit();
    }
    
}
