package pl.pjatk.s26838Bank;

public class BankClient {
    private String clientId;
    private double balance;

    public BankClient(String clientId, double balance) {
        this.clientId = clientId;
        this.balance = balance;
    }

    public String getClientId() {
        return clientId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
