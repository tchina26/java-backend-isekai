package basics.exception;

public class CurrenciesNotEqualException extends Exception{
    public static final String MESSAGGIO_DEFAULT = "Le currencies non coincidono.";
    public CurrenciesNotEqualException() {
        super(MESSAGGIO_DEFAULT);
    }

}
