package es.davidrico.jakarta.jpahibernate.fetch;

import jakarta.persistence.EntityManager;
import es.davidrico.jakarta.jpahibernate.fetch.entity.Cliente;
import es.davidrico.jakarta.jpahibernate.fetch.util.JpaUtil;

import java.util.List;

public class HibernateFetchResultList {
    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();
        List<Cliente> clientes = em.createQuery("select distinct c from Cliente c left outer join fetch c.direcciones left outer join fetch c.detalle", Cliente.class).getResultList();

        clientes.forEach(c -> System.out.println(c.getNombre() + ", direcciones: " + c.getDirecciones()));
        em.close();
    }
}
