package pl.pjatk.s26838Bank;
public class TransactionResult {

    private TransactionStatus status;
    private double newBalance;

    public TransactionResult(TransactionStatus status, double newBalance) {
        this.status = status;
        this.newBalance = newBalance;
    }



    public TransactionStatus getStatus() {
        return status;
    }

    public double getNewBalance() {
        return newBalance;
    }
}
