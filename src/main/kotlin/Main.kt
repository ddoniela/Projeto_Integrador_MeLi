import java.util.*

fun main() {
    val car = Vehicle("AA111AA", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_01")
    val moto = Vehicle("B222BB", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle( "CC333C", VehicleType.MINIBUS, Calendar.getInstance())
    val bus = Vehicle("DD44DDD", VehicleType.BUS, Calendar.getInstance())

    val parking = Parking(mutableSetOf())

    val vehicles = mutableListOf<Vehicle>(moto, car, minibus, bus)

    for (vehicle in vehicles) {
        parking.addVehicle(vehicle)
    }
}