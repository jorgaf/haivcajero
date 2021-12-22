package runners;

import framework.adapters.input.cli.CajeroViewCLIAdapter;

public class App {
    public static void main(String[] args) {
        var cli = new CajeroViewCLIAdapter();
        var type = "RETCO";
        System.out.println(cli.obtainRelatedCajeros(type));
    }
}
