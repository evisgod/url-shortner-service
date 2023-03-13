package com.dkb.urlshortner.util

class UniqueIdGenerator constructor(
    private val timeManager: TimeManager
) {

    private var lastTimestamp: Long = -1
    private var sequence: Long = 0

    fun nextId(): Long {
        var timestamp = timeManager.now()

        if (timestamp == lastTimestamp) {
            sequence = (sequence + 1) and MAX_SEQUENCE
            if (sequence == 0L) {
                // Sequence overflow, wait until next millisecond.
                timestamp = tilNextMillis(lastTimestamp)
            }
        } else {
            sequence = 0
        }

        lastTimestamp = timestamp
        return (timestamp shl TIMESTAMP_LEFT_SHIFT) or (sequence shl SEQUENCE_LEFT_SHIFT)
    }

    private fun tilNextMillis(lastTimestamp: Long): Long {
        var timestamp = timeManager.now()
        while (timestamp <= lastTimestamp) {
            timestamp = timeManager.now()
        }
        return timestamp
    }

    companion object {
        private const val MAX_SEQUENCE = 4095L // 12 bits
        private const val SEQUENCE_LEFT_SHIFT = 0
        private const val TIMESTAMP_LEFT_SHIFT = 12

        @Volatile
        private var INSTANCE: UniqueIdGenerator? = null

        fun getInstance(timeManager: TimeManager): UniqueIdGenerator =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: UniqueIdGenerator(timeManager).also { INSTANCE = it }
            }
    }
}

