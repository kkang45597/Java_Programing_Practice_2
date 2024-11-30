package com.mingi.beandefinitions;

public interface AccountRepository {
    void transfer(double amount, String fromAccountId, String toAccountId);
}
