package pl.pjatk.s26838Bank;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionStorageTest {

    @Test
    void AcceptsTransaction() {
        // GIVEN
        BankClient sender = new BankClient("senderId", 1000.0);
        BankClient receiver = new BankClient("receiverId", 500.0);
        double amount = 200.0;
        TransactionStorage transactionStorage = new TransactionStorage();

        // WHEN
        TransactionResult result = transactionStorage.transfer(sender, receiver, amount);

        // THEN
        assertThat(result.getStatus()).isEqualTo(TransactionStatus.ACCEPTED);
        assertThat(sender.getBalance()).isEqualTo(1800.0);
        assertThat(receiver.getBalance()).isEqualTo(1700.0);
    }

    @Test
    void DeclinesTransaction() {
        // GIVEN
        BankClient sender = new BankClient("senderId", 100.0);
        BankClient receiver = new BankClient("receiverId", 500.0);
        double amount = 200.0;
        TransactionStorage transactionStorage = new TransactionStorage();

        // WHEN
        TransactionResult result = transactionStorage.transfer(sender, receiver, amount);

        // THEN
        assertThat(result.getStatus()).isEqualTo(TransactionStatus.DECLINED);
        assertThat(sender.getBalance()).isEqualTo(100.0);
        assertThat(receiver.getBalance()).isEqualTo(500.0);
    }


}
