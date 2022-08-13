package wallet.error;

public record CustomError(
        int status,
        String error,
        String message
)
{
}
