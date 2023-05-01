package id.co.miniproject.ecomm.service;

import id.co.miniproject.ecomm.entity.Customer;
import id.co.miniproject.ecomm.model.MyCustomerDetail;
import id.co.miniproject.ecomm.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyCustomerDetailService implements UserDetailsService {
    @Autowired
    private CustomerRepo customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer cust = customerRepository.findByUsername(username);
        if (cust == null) {
            throw new UsernameNotFoundException("No user found!");
        }
        return new MyCustomerDetail(cust);
    }
}
