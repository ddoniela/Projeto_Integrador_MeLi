data class Parking(
    var vehicles: MutableSet<Vehicle>,
    val maxSlots: Int = 20
) {
    fun addVehicle(vehicle: Vehicle): Boolean {
        if (vehicles.size < maxSlots) {
            vehicles.add(vehicle)
            return true
        } else {
            return false
        }

    }
}