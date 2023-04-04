package nus.iss.banktransfer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nus.iss.banktransfer.model.TransferRequest;
import nus.iss.banktransfer.repository.BankRepository;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    @Transactional(rollbackFor = TransferException.class)
    public Boolean checkAndTransfer(TransferRequest newtransreq) throws TransferException {
        Boolean bProceed = true;

        System.out.println(newtransreq);

        bProceed = bankRepository.findAccount(newtransreq.getAccountFrom());

        if (!bProceed) {
            throw new TransferException("Sender Account Not Found...");
        } else {
            bProceed = bankRepository.findAccount(newtransreq.getAccountTo());
        }

        if (!bProceed) {
            throw new TransferException("Receiver Account Not Found...");
        } else {
            bProceed = bankRepository.checkBalanceOk(newtransreq);
        }

        if (!bProceed) {
            throw new TransferException("Balance Not Sufficient...");
        } else {
            bProceed = bankRepository.performTransfer(newtransreq);
        }

        if (!bProceed) {
            throw new TransferException("Balance Transfer Operation Failed...");
        }

        return bProceed;

    }

}
