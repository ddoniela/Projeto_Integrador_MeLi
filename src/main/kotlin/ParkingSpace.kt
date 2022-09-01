class ParkingSpace(
    val vehicle: Vehicle,
    val parking: Parking
) {
    fun checkOutVehicle(
        plate: String,
        onSuccess: (totalValue: Int) -> Unit,
        onError: () -> Unit
    ) {
        val car = parking.vehicles.find { it.plate == plate }
        if (car != null) {
            parking.vehicles.remove(vehicle)

            val totalValue = calculateFee(car.type, car.parkedTime)

            onSuccess(totalValue)
        } else {
            onError()
        }
    }

    fun calculateFee(type: VehicleType, parkedTime: Long): Int {
        var totalFee = type.price
        var count = parkedTime - 120

        while (count > 0) {
            totalFee += 5
            count -= 15
        }
        return totalFee
    }
}
