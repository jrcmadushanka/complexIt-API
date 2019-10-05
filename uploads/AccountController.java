package com.example.travella.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.travella.exception.ResourceNotFoundException;
import com.example.travella.model.Account;
import com.example.travella.repository.AccountRepository;

@RestController
@RequestMapping("api")
public class AccountController {

	@Autowired
	AccountRepository accountRepository;
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
	    return accountRepository.findAll();
	}
	
	@GetMapping("/accounts/test")
	public String test() {
	    return "Test pass" ;
	}
	
	// Create a new Account
	@PostMapping("/accounts")
	public Account createAccount(@Valid @RequestBody Account account) {
	    return accountRepository.save(account);
	}
	
	// Get a Single Account
	@GetMapping("/accounts/{id}")
	public Account getAccountById(@PathVariable(value = "id") Long accountId) {
	    return accountRepository.findById(accountId).orElseThrow(() ->
	    new ResourceNotFoundException("Account", "Id", accountId));
	}
	
	// Update a Account
	@PutMapping("/accounts/{id}")
	public Account updateAccount(@PathVariable(value = "id") Long accountId,
	                                        @Valid @RequestBody Account accountDetails) {

	    Account account = accountRepository.findById(accountId)
	            .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

	    account.setFirstName(accountDetails.getFirstName());
	    account.setLastName(accountDetails.getLastName());
	    account.setRole(accountDetails.getRole());
	    account.setStatus(accountDetails.getRole());
	    account.setEmail(accountDetails.getEmail());
	    account.setPassword(generateMD5(accountDetails.getPassword()));
	    
	    Account updatedAccount = accountRepository.save(account);
	    return updatedAccount;
	}
	
	// Delete a Account
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable(value = "id") Long accountId) {
	    Account account = accountRepository.findById(accountId)
	            .orElseThrow(() -> new ResourceNotFoundException("Account", "id", accountId));

	    accountRepository.delete(account);

	    return ResponseEntity.ok().build();
	}
	
	public String generateMD5( String string) {
		
		String hashedOutput = "";
	    MessageDigest messageDigest;
		
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		    messageDigest.update(string.getBytes());
		    byte[] digiest = messageDigest.digest();
		    hashedOutput = DatatypeConverter.printHexBinary(digiest);
		    
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return hashedOutput;
	}
}
