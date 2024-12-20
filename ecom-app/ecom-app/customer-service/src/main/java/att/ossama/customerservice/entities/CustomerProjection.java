package att.ossama.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullCustomer",types = {Customer.class})
public interface CustomerProjection {
    public String getEmail();
    public String getName();
}
