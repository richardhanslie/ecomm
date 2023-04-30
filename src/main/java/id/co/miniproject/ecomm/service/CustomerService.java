package id.co.miniproject.ecomm.service;

import id.co.miniproject.ecomm.entity.Customer;
import id.co.miniproject.ecomm.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo repo;

    public List<Customer> getAllCustomer(){
        try{
            List<Customer> resp = repo.findAll();
            return resp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Customer getCustomer(int id){
        try{
            Customer newCust = repo.findById(id).get();
            return newCust;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Customer addNewCust(Customer customer){
        try {
            return repo.save(customer);
        }catch (Exception e){
            throw new RuntimeException("Add New Customer Failed, Try Again");
        }
    }

    public Customer updateCustData(Customer customer){
        try {
            return repo.save(customer);
        }catch (Exception e){
            throw new RuntimeException("Update Customer Data Failed, Try Again");
        }
    }
}
