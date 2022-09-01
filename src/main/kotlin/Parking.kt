open class Parking(
    var vehicles: MutableSet<Vehicle>,
    val maxSlots: Int = 3,
) {
    var par: Pair<Int, Int> = Pair<Int, Int>(0,0)

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


    fun earningsParking() {
        println("${par.first} vehicles have checked out and have earnings of $${par.second}.")
    }

    fun listVehicles() {
        for (vehicle in vehicles) {
            println(vehicle.plate)
        }

    }

}
