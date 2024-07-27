package Repository;

import Models.Vehicle;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeMap;

public  class VehicleRepository {


    private HashMap<String, Vehicle> vehicles= new HashMap<>();

    public Optional<Vehicle> findVehicleByVehicalNumber(String vehicalNumber) {

        for(Vehicle v : vehicles.values()) {

            if(v.getVehicleName().equals(vehicalNumber)) {
                return Optional.of(v);

            }
        }
        return Optional.empty();
    }

    public  Vehicle save(Vehicle vehicle){

      return vehicles.put(vehicle.getVehicleName(),vehicle);
    }


}
