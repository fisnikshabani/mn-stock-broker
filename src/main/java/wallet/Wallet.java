package wallet;

import broker.Symbol;
import broker.api.RestApiResponse;

import java.math.BigDecimal;
import java.util.UUID;

public record Wallet(

    UUID accountId,
    UUID walletId,
    Symbol symbol,
    BigDecimal available,
    BigDecimal locked
) implements RestApiResponse {

    public Wallet addAvailable(BigDecimal ammountToAdd){
        return new Wallet(
                this.accountId,
                this.walletId,
                this.symbol,
                this.available.add(ammountToAdd),
                this.locked
        );
    }
}

