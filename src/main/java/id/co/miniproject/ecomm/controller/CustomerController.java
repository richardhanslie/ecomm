package id.co.miniproject.ecomm.controller;

import id.co.miniproject.ecomm.entity.Customer;
import id.co.miniproject.ecomm.model.CustomerInfo;
import id.co.miniproject.ecomm.service.CustomerService;
import id.co.miniproject.ecomm.util.ErrorCode;
import id.co.miniproject.ecomm.util.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cust")
public class CustomerController {

    private final CustomerService customerService;
    private final ResponseUtils responseUtils;

    @GetMapping()
    private ResponseEntity<Object> getAllCustomer(){
        List<Customer> response = customerService.getAllCustomer();
        if(ObjectUtils.isEmpty(response)){
            return responseUtils.generate(ErrorCode.Not_Found, HttpStatus.NOT_FOUND, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.OK, response);
    }

    @PostMapping()
    private ResponseEntity<Object> addNewCust(@Validated @RequestBody Customer customer){
        Customer newCust = customerService.addNewCust(customer);
        if(StringUtils.isEmpty(newCust)){
            return responseUtils.generate(ErrorCode.General_Error, HttpStatus.BAD_REQUEST, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.ACCEPTED, newCust);
    }

    @GetMapping("/id")
    private ResponseEntity<Object> getCustById(@RequestParam("id") int id){
        Customer cust = customerService.getCustomer(id);
        if(ObjectUtils.isEmpty(cust)){
            return responseUtils.generate(ErrorCode.Not_Found, HttpStatus.NOT_FOUND, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.OK, cust);
    }

    @PutMapping()
    private ResponseEntity<Object> updateCust(@Validated @RequestBody Customer customer){
        Customer newCust = customerService.addNewCust(customer);
        if(StringUtils.isEmpty(newCust)){
            return responseUtils.generate(ErrorCode.General_Error, HttpStatus.BAD_REQUEST, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.ACCEPTED, newCust);
    }

    @GetMapping("/info/{username}")
    private ResponseEntity<Object> getCustInfo(@PathVariable("username")String username){
        CustomerInfo cust = customerService.getCustInfo(username);
        if(StringUtils.isEmpty(cust.getId())){
            return responseUtils.generate(ErrorCode.Not_Found, HttpStatus.NOT_FOUND, null);
        }
        return responseUtils.generate(ErrorCode.Success, HttpStatus.OK, cust);
    }
}
