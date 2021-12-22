package framework.adapters.input.cli;

import application.ports.input.CajeroViewInputPort;
import application.usecases.CajeroViewUseCase;
import domain.Cajero;
import domain.CajeroType;
import framework.adapters.output.file.CajeroViewFileAdapter;

import java.util.List;

public class CajeroViewCLIAdapter {
    CajeroViewUseCase cajeroViewUseCase;

    public CajeroViewCLIAdapter() {
        setAdapters();
    }

    public List<Cajero> obtainRelatedCajeros(String type) {
        return cajeroViewUseCase.getCajeros(Cajero.filterCajeroByType(CajeroType.valueOf(type)));
    }
    private void setAdapters() {
        this.cajeroViewUseCase = new CajeroViewInputPort(CajeroViewFileAdapter.getInstance());
    }
}
