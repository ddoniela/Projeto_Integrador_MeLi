data class Parking(
    var vehicles: MutableSet<Vehicle>,
    val maxSlots: Int = 3
) {
    fun addVehicle(vehicle: Vehicle): Boolean {
        if (vehicles.size < maxSlots) {
            vehicles.add(vehicle)
            println("Welcome to AlkeParking!")
            return true
        } else {
            println("Sorry, the check-in failed.")
            return false
        }

    }
}