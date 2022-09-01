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

            onSuccess(0)
        } else {
            onError()
        }
    }
}