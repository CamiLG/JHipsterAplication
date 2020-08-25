package merliontechs.service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merliontechs.domain.Sales;
import merliontechs.domain.enumeration.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Transactional
public class FilterService {

    private final Logger log = LoggerFactory.getLogger(FilterService.class);

    @Autowired
    private EntityManager em;

    public FilterService(){

    }

    public List<Sales> salesDelivered(){
        log.debug("Return all sales delivered");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sales> criteria = cb.createQuery(Sales.class);
        Root<Sales> s = criteria.from(Sales.class);
        ParameterExpression<State> p = cb.parameter(State.class);
        criteria.select(s).where(cb.equal(s.get("state"), p));
        TypedQuery<Sales> query = em.createQuery(criteria);
        query.setParameter(p, State.DELIVERED);
        List<Sales> results = query.getResultList();
        return results;
    }

    public List<Sales> salesInCharge(){
        log.debug("Return all sales In Charge");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sales> criteria = cb.createQuery(Sales.class);
        Root<Sales> s = criteria.from(Sales.class);
        ParameterExpression<State> p = cb.parameter(State.class);
        criteria.select(s).where(cb.equal(s.get("state"), p));
        TypedQuery<Sales> query = em.createQuery(criteria);
        query.setParameter(p, State.IN_CHARGE);
        List<Sales> results = query.getResultList();
        return results;
    }

    public List<Sales> salesShipped(){
        log.debug("Return all sales Shipped");
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sales> criteria = cb.createQuery(Sales.class);
        Root<Sales> s = criteria.from(Sales.class);
        ParameterExpression<State> p = cb.parameter(State.class);
        criteria.select(s).where(cb.equal(s.get("state"), p));
        TypedQuery<Sales> query = em.createQuery(criteria);
        query.setParameter(p, State.SHIPPED);
        List<Sales> results = query.getResultList();
        return results;
    }
    
    
}