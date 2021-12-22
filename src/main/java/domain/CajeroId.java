package domain;

public class CajeroId {
    private String id;

    private CajeroId(String id) {
        this.id = id;
    }

    public static CajeroId of(String id) {
        return new CajeroId(id);
    }

    @Override
    public String toString() {
        return String.format("CajeroId{id='%s'}", id);
    }
}
