package merliontechs.web.rest;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import merliontechs.domain.Sales;
import merliontechs.service.FilterService;

import java.util.List;


@RestController
@RequestMapping("/api")
@Transactional
public class FilterResource {
    private final Logger log = LoggerFactory.getLogger(SalesResource.class);
    
    private final FilterService filter;

    public FilterResource(FilterService filterService){
        this.filter = filterService;
    }
    @GetMapping("/sales/delivered")
    public List<Sales> getAllSalesDelivered(){
        log.debug("REST request to get all Sales delivered");
        return filter.salesDelivered();
    }
    @GetMapping("/sales/incharge")
    public List<Sales> getAllSalesInCharge(){
        log.debug("REST request to get all Sales in charge");
        return filter.salesInCharge();
    }

    @GetMapping("/sales/shipped")
    public List<Sales> getAllSalesShipped(){
        log.debug("REST request to get all Sales shipped");
        return filter.salesShipped();
    }
    
}