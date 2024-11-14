package att.ossama.billingservice;

import att.ossama.billingservice.entities.Bill;
import att.ossama.billingservice.entities.ProductItem;
import att.ossama.billingservice.feign.CustomerRestClient;
import att.ossama.billingservice.feign.ProductRestClient;
import att.ossama.billingservice.model.Customer;
import att.ossama.billingservice.model.Product;
import att.ossama.billingservice.repository.BillRepository;
import att.ossama.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;
@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {
            // Fetch customers and products
            Collection<Customer> customers = customerRestClient.getAllCustomers() != null ? customerRestClient.getAllCustomers().getContent() : null;
            Collection<Product> products = productRestClient.getAllProducts() != null ? productRestClient.getAllProducts() : null;

            // Check if customers and products are available
            if (customers != null && products != null) {
                customers.forEach(customer -> {
                    // Create and save a new bill
                    Bill bill = Bill.builder()
                            .billingDate(new Date())
                            .customerId(customer.getId())
                            .build();
                    billRepository.save(bill);

                    // Add products to the bill
                    products.forEach(product -> {
                        ProductItem productItem = ProductItem.builder()
                                .bill(bill)
                                .productId(product.getId())
                                .quantity(1 + new Random().nextInt(10))  // Random quantity between 1 and 10
                                .unitPrice(product.getPrice())
                                .build();
                        productItemRepository.save(productItem);
                    });
                });
            } else {
                System.out.println("No customers or products found.");
            }
        };
    }


}