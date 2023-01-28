package com.techorzo.kwality.kitchen.api;


import com.techorzo.kwality.kitchen.misc.Authorize;
import com.techorzo.kwality.kitchen.model.credential.CustomerCredential;
import com.techorzo.kwality.kitchen.model.credential.EmployeeCredential;
import com.techorzo.kwality.kitchen.model.main.Customer;
import com.techorzo.kwality.kitchen.service.credential.CustomerCredentialService;
import com.techorzo.kwality.kitchen.service.main.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RequestMapping("/api/v1/login")
@RestController
public class Login {
     private CustomerCredentialService service;
     private Authorize authorize = Authorize.getInstance();

     @Autowired
     public Login(CustomerCredentialService service) {
         this.service = service;
     }

     @PostMapping(path = "/authenticate/user/token={token}")
     public String authenticateCustomer(@RequestBody CustomerCredential credential,@PathVariable("token") String token) {
          if(service.getCredentialById(credential.getCustomerUserName()).isEmpty()) {
               return "N/A";
          }

          return authorize.newAuthorize(credential.getCustomerUserName() + token);
     }
}
