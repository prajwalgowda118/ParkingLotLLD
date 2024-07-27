package Strategies.SpotAssignmentStrategies;

import Models.Gate;
import Models.ParkingLot;
import Models.ParkingSpot;
import Models.VehicleType;

import java.util.Optional;

public interface SpotAssignment {

    Optional<ParkingSpot> getSpotStrategis(Gate gate, VehicleType vehicleType, ParkingLot parkingLot);
}
