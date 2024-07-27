package Repository;

import Models.Gate;
import Models.ParkingLot;
import Models.Ticket;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap = new TreeMap<>();

    public Optional<ParkingLot> getParkingLotofGate(Gate gate){

        for(ParkingLot parkingLot : parkingLotMap.values()){

            if(parkingLot.getGate().equals(gate)){
                return Optional.of(parkingLot);

            }
        }
        return Optional.empty();


    };
}
