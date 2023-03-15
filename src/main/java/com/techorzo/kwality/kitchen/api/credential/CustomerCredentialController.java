package com.techorzo.kwality.kitchen.api.credential;

import com.techorzo.kwality.kitchen.model.credential.CustomerCredential;
import com.techorzo.kwality.kitchen.service.credential.CustomerCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/cred")
@RestController
public class CustomerCredentialController {
    private final CustomerCredentialService credentialService;

    @Autowired
    public CustomerCredentialController(CustomerCredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @PostMapping(path = "/add")
    public int addCredential(@RequestBody CustomerCredential credential) {
        return credentialService.insertCredential(credential);
    }

    @GetMapping(path = "/get/id={id}")
    public CustomerCredential getCredentialById(@PathVariable("id") String id) {
        return credentialService.getCredentialById(id)
                .orElse(null);
    }

    @GetMapping(path = "/get/name={name}")
    public CustomerCredential getCredentialByName(@PathVariable("name") String name) {
        return credentialService.getCredentialByName(name)
                .orElse(null);
    }
}
