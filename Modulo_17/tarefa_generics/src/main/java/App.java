import Carros.Carro;
import Carros.Onix;
import Carros.Civic;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Carro> carros = new ArrayList<>();
        carros.add(new Civic(2012,"branco",300));
        carros.add(new Onix(2012,"branco",300));
    }
}
