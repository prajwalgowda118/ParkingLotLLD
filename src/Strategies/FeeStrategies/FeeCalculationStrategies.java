package Strategies.FeeStrategies;

import Models.VehicleType;

public interface FeeCalculationStrategies {

    long CalculateFee(long durationtime, VehicleType vehicleType);
}
