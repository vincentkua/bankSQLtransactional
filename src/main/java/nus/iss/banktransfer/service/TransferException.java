package nus.iss.banktransfer.service;

import nus.iss.banktransfer.model.TransferRequest;

public class TransferException extends Exception {

    private TransferRequest transferInfo;

    public TransferException() {
        super();
    }

    public TransferException(String msg) {
        super(msg);
    }

    public TransferRequest getTransferInfo() {
        return transferInfo;
    }

    public void setTransferInfo(TransferRequest transferInfo) {
        this.transferInfo = transferInfo;
    }

}
