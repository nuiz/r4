package r4.ctl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import r4.entity.Category;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 * Created by NUIZ on 15/1/2558.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/category")
public class CategoryCTL {
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Category getClichedMessage() {
        return new Category();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Category add() throws Exception {
        Category item = new Category();
        try {
            SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

            Session session = sessionFactory.openSession();
            session.beginTransaction();

            item.setName("video");

            session.save(item);

            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            item.setName(e.getMessage());
        }

        return item;
    }
}
