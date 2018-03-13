/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builder;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author KnaldeKalle
 */
public class Schema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jetbrainsDatabase");
        EntityManager em = emf.createEntityManager();
        
        Persistence.generateSchema("jetbrainsDatabase", null);
    }
    
}
