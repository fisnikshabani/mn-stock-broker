package data;

import jakarta.inject.Singleton;
import wallet.Wallet;
import watchlist.WatchList;

import java.util.*;

@Singleton
public class InMemoryAccountStore {

    public static final UUID ACCOUNT_ID = UUID.fromString("f4245629-83df-4ed8-90d9-7401045b5921");

    private final Map<UUID, WatchList> watchListPerAccount = new HashMap<>();
    private final Map<UUID, Map<UUID, Wallet>> walletsPerAccount = new HashMap<>();

    public WatchList getWatchList(final UUID accountId) {
        return watchListPerAccount.getOrDefault(accountId, new WatchList());
    }

    public WatchList updateWatchList(final UUID accountId, final WatchList watchList) {
        watchListPerAccount.put(accountId, watchList);
        return getWatchList(accountId);
    }
    public void deleteWatchList(final UUID accountId) {
        watchListPerAccount.remove(accountId);
    }

    public Collection<Wallet> getWallets(final UUID accountId) {
        return Optional.ofNullable(walletsPerAccount.get(accountId))
                .orElse(new HashMap<>())
                .values();
    }
}
