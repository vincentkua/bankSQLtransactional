package nus.iss.banktransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import nus.iss.banktransfer.model.TransferRequest;
import nus.iss.banktransfer.service.BankService;
import nus.iss.banktransfer.service.TransferException;

@RestController
public class BankController {

    @Autowired
    BankService bankService;

    @PostMapping(value = "/transfer")
    public ResponseEntity<String> transferMoney(@ModelAttribute TransferRequest newtransreq) {

        Boolean transfercomplete = false;
        String payload;

        try {
            transfercomplete = bankService.checkAndTransfer(newtransreq);
            payload = "Transfer Completed";
        } catch (TransferException ex) {
            payload = ex.getMessage();
        }

        if (transfercomplete) {
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(payload);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(payload);
        }
    }
}
