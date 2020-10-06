package camionero.model;

import java.util.HashMap;
import java.util.Map;

// todo completar datos correctos de distancias de la tablita
public enum Location {
    CABA(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    CORDOBA(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    CORRIENTES(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    FORMOSA(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    LAPLATA(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    LARIOJA(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    MENDOZA(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    ),
    NEUQUEN(
            new HashMap<Location, Integer>() {{
                put(CABA, 0);
                put(CORDOBA, 646);
                put(CORRIENTES, 792);
                put(FORMOSA, 933);
                put(LAPLATA, 53);
                put(LARIOJA, 986);
                put(MENDOZA, 985);
                put(NEUQUEN, 989);
            }}
    );


    private final Map<Location, Integer> distances;

    Location(Map<Location, Integer> distances) {
        this.distances = distances;
    }

    int getDistanceTo(Location to) {
        return distances.get(to);
    }
}
