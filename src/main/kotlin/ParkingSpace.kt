import kotlin.math.roundToInt

class ParkingSpace(
    val parking: Parking
) {
    fun checkOutVehicle(
        plate: String,
        onSuccess: (totalValue: Int) -> Unit,
        onError: () -> Unit
    ) {
        val car = parking.vehicles.find { it.plate == plate }
        if (car != null) {
            parking.vehicles.remove(car)

            val hasDiscountCard = car.discountCard != null;

            val totalValue = calculateFee(car.type, car.parkedTime, hasDiscountCard)

            onSuccess(totalValue)
        } else {
            onError()
        }
    }

    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {
        var totalFee = type.price.toDouble()
        var count = parkedTime - 120

        while (count > 0) {
            totalFee += 5
            count -= 15
        }

        if (hasDiscountCard) {
            totalFee = (totalFee * 0.85)
        }

        return totalFee.roundToInt()
    }
}
