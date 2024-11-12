package att.ossama.inventoryservice;

import att.ossama.inventoryservice.entities.Product;
import att.ossama.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            //restConfiguration.exposeIdsFor(Product.class);
            productRepository.save(Product.builder()
                    .name("Computer")
                    .price(3000)
                    .quantity(100)
                    .build());
            productRepository.save(Product.builder()
                    .name("Phone")
                    .price(5000)
                    .quantity(10)
                    .build());
            productRepository.save(Product.builder()
                    .name("Xbox")
                    .price(4000)
                    .quantity(50)
                    .build());

            productRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
        };

    }

}