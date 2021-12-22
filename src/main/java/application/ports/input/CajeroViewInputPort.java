package application.ports.input;

import application.ports.output.CajeroViewOutputPort;
import application.usecases.CajeroViewUseCase;
import domain.Cajero;

import java.util.List;
import java.util.function.Predicate;

public class CajeroViewInputPort implements CajeroViewUseCase {
    private CajeroViewOutputPort cajeroViewOutputPort;

    public CajeroViewInputPort(CajeroViewOutputPort cajeroViewOutputPort) {
        this.cajeroViewOutputPort = cajeroViewOutputPort;
    }

    @Override
    public List<Cajero> getCajeros(Predicate<Cajero> filter) {
        var cajeros = cajeroViewOutputPort.fetchCajeros();
        return Cajero.retrieveRouter(cajeros, filter);
    }
}
