package nus.iss.banktransfer.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nus.iss.banktransfer.model.AccountDetails;
import nus.iss.banktransfer.model.TransferRequest;

@Repository
public class BankRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String FINDACOUNT = """
            select * from account where account_name = ?
            """;

    private static final String UPDATEBALANCE = """
            update account
            set balance = balance + ?
            where account_name = ?;
            """;

    public Boolean findAccount(String accountname) {
        try {
            AccountDetails accountfound = jdbcTemplate.queryForObject(FINDACOUNT,
                    BeanPropertyRowMapper.newInstance(AccountDetails.class), accountname);
            System.out.println(accountfound);
            return true;
        } catch (Exception e) {
            System.out.println("Account Not Found !!!");
            return false;
        }
    }

    public Boolean checkBalanceOk(TransferRequest transreq) {

        AccountDetails accountfound = jdbcTemplate.queryForObject(FINDACOUNT,
                BeanPropertyRowMapper.newInstance(AccountDetails.class), transreq.getAccountFrom());
        if (accountfound.getBalance() > transreq.getAmount()) {
            System.out.println("Balance Sufficient ... Continue");
            return true;
        } else {
            System.out.println("Balance Not Sufficient...");
            return false;
        }

    }

    public Boolean performTransfer(TransferRequest transreq) {

        try {
            jdbcTemplate.update(UPDATEBALANCE, -transreq.getAmount(), transreq.getAccountFrom());
            jdbcTemplate.update(UPDATEBALANCE, +transreq.getAmount(), transreq.getAccountTo());
            System.out.println("Transfer Completed...");
            return true;
        } catch (Exception e) {
            System.out.println("Transfer Failed...");
            return false;
        }

    }

}
