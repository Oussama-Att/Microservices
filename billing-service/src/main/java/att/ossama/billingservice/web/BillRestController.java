package att.ossama.billingservice.web;

import att.ossama.billingservice.entities.Bill;
import att.ossama.billingservice.feign.CustomerRestClient;
import att.ossama.billingservice.feign.ProductRestClient;
import att.ossama.billingservice.repository.BillRepository;
import att.ossama.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping(path = "/api/bills")
    public List<Bill> getBills() {
        return billRepository.findAll();
    }
    @GetMapping(path = "/api/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }
}