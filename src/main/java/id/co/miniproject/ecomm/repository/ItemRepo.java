package id.co.miniproject.ecomm.repository;

import id.co.miniproject.ecomm.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

}
