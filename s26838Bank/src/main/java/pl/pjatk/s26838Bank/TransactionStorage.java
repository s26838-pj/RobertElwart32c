package pl.pjatk.s26838Bank;
import org.springframework.stereotype.Service;

@Service
public class TransactionStorage {


    public TransactionResult transfer(BankClient sender, BankClient receiver, double amount) {
        if (sender == null || receiver == null || amount <= 0) {
            return new TransactionResult(TransactionStatus.DECLINED, 0);
        }


        double senderBalance = sender.getBalance();
        double receiverBalance = receiver.getBalance();

        if (senderBalance < amount) {
            return new TransactionResult(TransactionStatus.DECLINED, senderBalance);
        }



        sender.setBalance(senderBalance - amount);
        receiver.setBalance(receiverBalance + amount);

        return new TransactionResult(TransactionStatus.ACCEPTED, sender.getBalance());
    }
}
