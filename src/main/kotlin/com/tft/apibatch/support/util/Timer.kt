package com.tft.apibatch.support.util

class Timer {
    companion object{
        fun sleep( millis:Long ){
            try {
                Thread.sleep(millis)
            }catch (e : InterruptedException){

            }
        }
    }
}