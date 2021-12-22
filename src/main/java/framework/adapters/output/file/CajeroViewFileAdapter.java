package framework.adapters.output.file;

import application.ports.output.CajeroViewOutputPort;
import domain.Cajero;
import domain.CajeroId;
import domain.CajeroType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CajeroViewFileAdapter implements CajeroViewOutputPort {
    private static CajeroViewFileAdapter instance;

    @Override
    public List<Cajero> fetchCajeros() {
        return readFileAsString();
    }

    private static List<Cajero> readFileAsString() {
        List<Cajero> cajeros = new ArrayList<>();
        try(Stream<String> stream = new BufferedReader(new InputStreamReader(CajeroViewFileAdapter.class.getClassLoader().getResourceAsStream("cajeros.txt"))).lines()) {
            stream.forEach(line -> {
                String[] cajeroEntry = line.split(";");
                var id = cajeroEntry[0];
                var type = cajeroEntry[1];
                Cajero cajero = new Cajero(CajeroType.valueOf(type), CajeroId.of(id));
                cajeros.add(cajero);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cajeros;
    }

    private CajeroViewFileAdapter() {
    }

    public static CajeroViewFileAdapter getInstance() {
        if(instance == null) {
            instance = new CajeroViewFileAdapter();
        }
        return instance;
    }
}
