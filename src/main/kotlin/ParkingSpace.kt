import kotlin.math.roundToInt

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

    fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean?): Int {
        var totalFee = type.price.toDouble()
        var count = parkedTime - 120

        while (count > 0) {
            totalFee += 5
            count -= 15
        }

        if (hasDiscountCard != null) {
            totalFee -= (totalFee * 0.15)
        }

        return totalFee.roundToInt()


    }
}

/*

2) Após obter o total da tarifa, aplique o desconto se aplicável e retorne o
valor atualizado (os centavos não devem ser contados na cobrança da
tarifa).
 */