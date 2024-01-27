package pl.pjatk.s26838Bank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankService {

    private final List<BankClient> clients;

    public BankService() {
        this.clients = new ArrayList<>();
    }

    public TransactionResult registerClient(String clientId, double initialBalance) {

        for (BankClient client : clients) {
            if (client.getClientId().equals(clientId)) {
                return new TransactionResult(TransactionStatus.DECLINED, 0);
            }
        }


        BankClient newClient = new BankClient(clientId, initialBalance);
        clients.add(newClient);

        return new TransactionResult(TransactionStatus.ACCEPTED, initialBalance);
    }

    public BankClient getClient(String clientId) {
        for (BankClient client : clients) {
            if (client.getClientId().equals(clientId)) {
                return client;
            }
        }
        return null;
    }
}
