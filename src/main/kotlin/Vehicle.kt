import java.util.*

data class Vehicle(
    val plate: String,
    val type: VehicleType,
    val checkInTime: Calendar = Calendar.getInstance(),
    val discountCard: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }

        return super.equals(other)
    }

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / 60000

    //Function states that the hashCode (Used internally in search functions
    //in sets and arrays) is the hashcode of the plate
    override fun hashCode(): Int = this.plate.hashCode()
}


