package id.co.miniproject.ecomm.service;

import id.co.miniproject.ecomm.entity.Item;
import id.co.miniproject.ecomm.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepo repo;

    public List<Item> getAllItem() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Item getItem(int id) {
        try {
            return repo.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Item not found with ID: " + id);
        }
    }

    public Item addNewItem(Item Item) {
        try {
            return repo.save(Item);
        } catch (Exception e) {
            throw new RuntimeException("Add New Item Failed, Try Again");
        }
    }

    public Item updateItemData(Item Item) {
        try {
            return repo.save(Item);
        } catch (Exception e) {
            throw new RuntimeException("Update Item Data Failed, Try Again");
        }
    }
}
