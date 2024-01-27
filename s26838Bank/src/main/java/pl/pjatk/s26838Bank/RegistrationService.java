package pl.pjatk.s26838Bank;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final BankService bankService;

    public RegistrationService(BankService bankService) {
        this.bankService = bankService;
    }

    public TransactionResult registerClient(String clientId, double initialBalance) {

        if (clientId == null || clientId.isEmpty() || initialBalance < 0) {
            return new TransactionResult(TransactionStatus.DECLINED, 0);
        }

        TransactionResult result = bankService.registerClient(clientId, initialBalance);

        return result;
    }
}
