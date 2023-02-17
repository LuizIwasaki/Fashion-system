/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eduardo Faustino
 */
public class FabricaEntidades {

    private static EntityManagerFactory emf;

    public static EntityManagerFactory getFabricaEntidade() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("FSYPU");
        }
        return emf;
    }

    public static EntityManager getGerenteEntidade() {
        if (emf == null) {
            emf = getFabricaEntidade();
        }
        return emf.createEntityManager();
    }
    
}
