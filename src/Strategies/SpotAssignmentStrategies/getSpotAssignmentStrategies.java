package Strategies.SpotAssignmentStrategies;

import Models.*;

import java.util.Optional;

public class getSpotAssignmentStrategies implements SpotAssignment{
    @Override
    public Optional<ParkingSpot> getSpotStrategis(Gate gate, VehicleType vehicleType, ParkingLot parkingLot) {

        for(ParkingFloor parkingFloor: parkingLot.getParkingFloor()){

            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpot()){

                if(parkingSpot.getSpotStatus().equals(SpotStatus.EMPTY) && parkingSpot.getVehicleType().contains(vehicleType)){

                    return Optional.of(parkingSpot);

                }
            }
        }
        return Optional.empty();
    }
}
