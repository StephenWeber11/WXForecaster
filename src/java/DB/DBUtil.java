/*
 * From Chapter 13 in textbook
 */
package DB;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("WxForecasterPU");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}