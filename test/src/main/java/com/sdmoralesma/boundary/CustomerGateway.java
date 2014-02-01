package com.sdmoralesma.boundary;

import com.sdmoralesma.domain.Customer;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import static javax.ejb.TransactionAttributeType.NOT_SUPPORTED;
import static javax.ejb.TransactionAttributeType.REQUIRES_NEW;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

@Stateful
@TransactionAttribute(NOT_SUPPORTED)
public class CustomerGateway {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void create(Customer customer) {
        em.persist(customer);
        this.customer = customer;
    }

    public Customer find(Integer id) {
        this.customer = em.find(Customer.class, id);
        System.out.println("customer managed ? " + em.contains(this.customer));
        // Workaround :
//    this.customer = em.merge(customer);
        return customer;
    }

    public void remove(Long id) {
        Customer cust = em.getReference(Customer.class, id);
        em.remove(cust);
    }

    @TransactionAttribute(REQUIRES_NEW)
    public void save() {
    }

    public List<Customer> findAllCustomers() {
        Query query = em.createNamedQuery("Customer.all");
        return query.getResultList();
    }

    @Remove
    public void close() {
    }

}
