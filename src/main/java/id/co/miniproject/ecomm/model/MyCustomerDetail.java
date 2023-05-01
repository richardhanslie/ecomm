package id.co.miniproject.ecomm.model;

import id.co.miniproject.ecomm.entity.Customer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MyCustomerDetail implements UserDetails {

    private final Customer mCustomer;

    public MyCustomerDetail(Customer mCustomer) {
        this.mCustomer = mCustomer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(mCustomer.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return mCustomer.getPassword();
    }

    @Override
    public String getUsername() {
        return mCustomer.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
