package id.co.miniproject.ecomm.repository;

import id.co.miniproject.ecomm.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Query(value = "SELECT * FROM customer WHERE username = :username", nativeQuery = true)
    Customer getCustomerInfo(@Param("username") String username);
}
