package es.davidrico.jakarta.jpahibernate.fetch;

import jakarta.persistence.EntityManager;
import es.davidrico.jakarta.jpahibernate.fetch.entity.Cliente;
import es.davidrico.jakarta.jpahibernate.fetch.entity.Factura;
import es.davidrico.jakarta.jpahibernate.fetch.util.JpaUtil;

public class HibernateAsociacionesManyToOne {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("credito");
            em.persist(cliente);

            Factura factura = new Factura("compras de oficina", 1000L);
            factura.setCliente(cliente);
            em.persist(factura);

            System.out.println(factura.getCliente());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
