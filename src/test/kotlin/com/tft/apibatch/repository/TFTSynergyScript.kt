//package com.tft.apibatch.repository
//
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//
//@SpringBootTest
//@ActiveProfiles("aws")
//class TFTSynergyScript {
//    @Autowired
//
//    lateinit var tftStatsRepository: TFTStatsRepository
//
//    @Test
//    fun script() {
//        val tftStatsList = tftStatsRepository.findAll()
//
//        for (tftStats in tftStatsList) {
//            for (synergyDataId in tftStats.synergies.keys) {
//                val synergyStats = tftStats.synergies[synergyDataId]
//
//                checkNotNull(synergyStats)
//
//                var totalCount = 0L
//                var totalPlacement = 0L
//                for (tier in synergyStats.tiers.entries.filter { it.key != 0 }.map { it.value }) {
//                    totalCount += tier.totalCount
//                    totalPlacement += tier.totalPlacement
//                }
//
//                synergyStats.totalCount = totalCount
//                synergyStats.totalPlacement = totalPlacement
//            }
//        }
//
//        tftStatsRepository.saveAll(tftStatsList)
//    }
//}