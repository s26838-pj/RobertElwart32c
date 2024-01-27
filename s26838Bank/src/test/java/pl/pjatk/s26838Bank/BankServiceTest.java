package pl.pjatk.s26838Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BankServiceTest {

    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = new BankService();
    }

    @Test
    void getClient() {
        // GIVEN
        BankClient client1 = new BankClient("12345", 1259.30);
        bankService.registerClient(client1.getClientId(), client1.getBalance());
        // WHEN
        BankClient client = bankService.getClient(client1.getClientId());
        // THEN
        assertThat(client).isNotNull();
        assertThat(client.getClientId()).isEqualTo(client1.getClientId());
        assertThat(client.getBalance()).isEqualTo(client1.getBalance());
    }

    @Test
    void EmptyClient() {
        // GIVEN
        BankClient client = new BankClient(" ", 1259.30);
        bankService.registerClient(client.getClientId(), client.getBalance());

        // WHEN
        TransactionResult result = bankService.registerClient(client.getClientId(), client.getBalance());

        // THEN
        assertThat(result.getStatus()).isEqualTo(TransactionStatus.DECLINED);
        assertThat(result.getNewBalance()).isEqualTo(0);
    }
}
