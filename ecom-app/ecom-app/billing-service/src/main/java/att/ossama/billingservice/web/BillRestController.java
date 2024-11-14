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
import feign.FeignException;

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
    public Bill getBill(@PathVariable Long id) {
        Bill bill = billRepository.findById(id).orElse(null);
        if (bill == null) {
            throw new RuntimeException("Bill with ID " + id + " not found.");
        }

        try {
            bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomerId()));
        } catch (FeignException.NotFound e) {
            // Handle customer not found case
            System.err.println("Customer with ID " + bill.getCustomerId() + " not found.");
            bill.setCustomer(null); // or set a default customer
        }

        bill.getProductItems().forEach(productItem -> {
            try {
                productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
            } catch (FeignException.NotFound e) {
                // Handle product not found case
                System.err.println("Product with ID " + productItem.getProductId() + " not found.");
                productItem.setProduct(null); // or set a default product
            }
        });
        return bill;
    }

}