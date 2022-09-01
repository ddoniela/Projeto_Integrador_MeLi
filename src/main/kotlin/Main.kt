import java.util.*

fun onSuccess(totalValue: Int) {
    println("Your fee is $$totalValue. Come back soon.")
}

fun onError() {
    println("Sorry, the check-out failed")
}

fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_01")
    val moto = Vehicle("B222BB", VehicleType.MOTORCYCLE, Calendar.getInstance(), "DISCOUNT_CARD_02")
    val minibus = Vehicle("CC333C", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle("DD44DDD", VehicleType.BUS, Calendar.getInstance())

    val parking = Parking(mutableSetOf())

    val vehicles = mutableListOf<Vehicle>(moto, car, minibus, bus)

    for (vehicle in vehicles) {
        parking.addVehicle(vehicle)
    }

    val parkingSpace = ParkingSpace(parking)
    parkingSpace.checkOutVehicle("AA111AA", ::onSuccess, ::onError)
    parking.addVehicle(bus)
    parkingSpace.checkOutVehicle("DD44DDD", ::onSuccess, ::onError)

    parking.earningsParking()

    parking.listVehicles()
}