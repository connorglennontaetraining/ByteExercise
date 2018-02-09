package undercover.android.avengers.byteexercise

/**
 * Created by Connor Glennon on 09/02/2018.
 * Code belongs to The App Experts.
 * Do not use/copy/redistribute unless you have been given permission to do so.
 */
data class ConnectionStatus(var isSlavePuckConnected: Boolean = false,
                            var isGpsConnected: Boolean = false,
                            var isHrmConnected: Boolean = false,
                            var sessionStatus: SessionStatus = SessionStatus.IDLE,
                            var runProfile: String = ""){

    fun printString(): String {
        return "Slave Puck Connected: " + isSlavePuckConnected +
                "\n GPS Connected: " + isGpsConnected +
                "\n HRM connected: " + isHrmConnected +
                "\n Session Status: " + sessionStatus.value +
                "\n Run Profile: " + runProfile
    }

}