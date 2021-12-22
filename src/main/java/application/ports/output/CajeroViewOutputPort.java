package application.ports.output;

import domain.Cajero;

import java.util.List;

public interface CajeroViewOutputPort {
    List<Cajero> fetchCajeros();
}
