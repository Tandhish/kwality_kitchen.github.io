package com.techorzo.kwality.kitchen.api;


import com.techorzo.kwality.kitchen.misc.Authorize;
import com.techorzo.kwality.kitchen.model.credential.CustomerCredential;
import com.techorzo.kwality.kitchen.service.credential.CustomerCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/login")
@RestController
public class Login {
     private final CustomerCredentialService service;
     private final Authorize authorize = Authorize.getInstance();

     @Autowired
     public Login(CustomerCredentialService service) {
         this.service = service;
     }

     @PostMapping(path = "/authenticate/user/token={token}")
     public String authenticateCustomer(@RequestBody CustomerCredential credential,@PathVariable("token") String token) {
          if(service.getCredentialById(credential.getCustomerID()).isEmpty()) {
               return "N/A";
          }

          return authorize.newAuthorize(credential.getCustomerID() + token);
     }

     @PostMapping(path = "/new/user/token={token}")
     public String newAuthenticate(@RequestBody CustomerCredential credential, @PathVariable("token") String token) {
          if(service.getCredentialById(credential.getCustomerUserName()).isPresent()) {
               return "User Exists";
          }
          service.insertCredential(credential);
          return authorize.newAuthorize(credential.getCustomerID() + token);
     }
}
