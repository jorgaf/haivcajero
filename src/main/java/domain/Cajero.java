package domain;

import java.util.List;
import java.util.function.Predicate;

public class Cajero {
    private final CajeroType cajeroType;
    private final CajeroId cajeroId;

    public Cajero(CajeroType cajeroType, CajeroId cajeroId) {
        this.cajeroType = cajeroType;
        this.cajeroId = cajeroId;
    }

    public static Predicate<Cajero> filterCajeroByType( CajeroType cajeroType) {
        return cajeroType.equals(CajeroType.MULTI) ? isMulti() : isRetCo();
    }

    private static Predicate<Cajero> isMulti() {
        return p -> p.cajeroType == CajeroType.MULTI;
    }

    private static Predicate<Cajero> isRetCo() {
        return p -> p.cajeroType == CajeroType.RETCO;
    }

    public static List<Cajero> retrieveRouter(List<Cajero> cajeros, Predicate<Cajero> predicate){
        return cajeros.stream()
                .filter(predicate)
                .toList();
    }

    public CajeroType getCajeroType() {
        return cajeroType;
    }

    @Override
    public String toString() {
        return String.format("Cajero{type= %s, id=%s}\n", cajeroType, cajeroId);
    }
}
