package com.dkb.urlshortner.util

import java.time.Instant

class TimeManagerUtil : TimeManager {
    override fun now(): Long {
        return Instant.now().toEpochMilli()
    }
}