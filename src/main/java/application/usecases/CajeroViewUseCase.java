package application.usecases;

import domain.Cajero;

import java.util.List;
import java.util.function.Predicate;

public interface CajeroViewUseCase {
    List<Cajero> getCajeros(Predicate<Cajero> filter);
}
