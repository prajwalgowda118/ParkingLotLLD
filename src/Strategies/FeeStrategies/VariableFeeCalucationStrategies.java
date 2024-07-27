package Strategies.FeeStrategies;

import Models.VehicleType;

public class VariableFeeCalucationStrategies implements FeeCalculationStrategies{

    private final double car=100;
    private final double bike=50;


    @Override
    public long CalculateFee(long durationtime, VehicleType vehicleType) {

        switch (vehicleType)
        {
                case CAR:
                return
                        durationtime *= car;
                case BIKE:
                return
                        durationtime *= bike;
                default:
                return
                        100*2;
        }
    }
}
