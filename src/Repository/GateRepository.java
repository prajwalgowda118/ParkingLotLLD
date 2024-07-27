package Repository;

import Models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    private Map<Long, Gate> gates = new TreeMap<>();

    public Optional<Gate> FindGateByID(long gateID){

       if(gates.containsKey(gateID)){
           return Optional.of(gates.get(gateID));
       }
       return Optional.empty();
    }

    public Gate save(Gate gate){

        gates.put(gate.getId(), gate);
        return gate;

    }
}
