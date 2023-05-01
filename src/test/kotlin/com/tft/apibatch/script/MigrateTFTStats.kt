//package com.tft.apibatch.script
//
//import com.tft.apibatch.entry.TftStats
//import com.tft.apibatch.repository.TFTStatsRepository
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//
//@SpringBootTest
//@ActiveProfiles("aws")
//class MigrateTFTStats {
//    @Autowired
//    private lateinit var tftStatsRepository: TFTStatsRepository
//
//    @Test
//    fun migrate() {
//        tftStatsRepository.findAll()
//            .let {
//                for (tftStats in it) {
//                    tftStats.items.clear()
//
//                    for ((championName, championStats) in tftStats.champions) {
//                        for ((itemName, championItemStats) in championStats.items) {
//                            val itemStats = tftStats.items.getOrPut(itemName) { TftStats.ItemStats() }
//                            itemStats.totalCount += championItemStats.totalCount
//                            itemStats.totalPlacement += championItemStats.totalPlacement
//
//                            val itemChampionStats = itemStats.champions.getOrPut(championName) { TftStats.Stats() }
//                            itemChampionStats.totalCount += championItemStats.totalCount
//                            itemChampionStats.totalPlacement += championItemStats.totalPlacement
//                        }
//                    }
//                }
//
//                it
//            }
//            .let { tftStatsRepository.saveAll(it) }
//    }
//}