package com.zm.comcurrent.deadlock;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2017/3/12.
 */
public class DynamicSequenceDeadLock {

    public static void main(String[] args){
        DynamicSequenceDeadLock _this = new DynamicSequenceDeadLock();
        Account account1 = _this.new Account();
        Account account2 = _this.new Account();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                _this.transferMoney(account1,account2,BigDecimal.ZERO);

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                _this.transferMoney(account2,account1,BigDecimal.ZERO);

            }
        });

        t1.start();
        t2.start();
    }

    public void transferMoney(Account fromoAccount, Account toAccount, BigDecimal amount){
        synchronized (fromoAccount){
            System.out.println(Thread.currentThread().getName());
            if (fromoAccount.getAmount().compareTo(amount) < 0){
                throw new IllegalStateException("fromAccount balance is not enough.");
            }
            synchronized (toAccount){
                fromoAccount.debit(amount);
                toAccount.credit(amount);
            }
        }
    }

    class Account{
        private BigDecimal amount = BigDecimal.ONE;

        public BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(BigDecimal amount) {
            this.amount = amount;
        }

        public void debit(BigDecimal amount){
            amount.add(amount);
        }

        public void credit(BigDecimal amount){
            amount.subtract(amount);
        }
    }
}
