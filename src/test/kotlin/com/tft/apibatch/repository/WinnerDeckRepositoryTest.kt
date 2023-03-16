//package com.tft.apibatch.repository
//
//import com.tft.apibatch.service.DataService
//import org.junit.jupiter.api.Test
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.context.SpringBootTest
//import org.springframework.test.context.ActiveProfiles
//
//@SpringBootTest
//@ActiveProfiles("aws")
//class WinnerDeckRepositoryTest(
//
//) {
//    @Autowired
//    private lateinit var dataService: DataService
//
//    @Autowired
//    private lateinit var winnerDeckRepository: WinnerDeckRepository
//
//    @Test
//    fun test() {
//
//        winnerDeckRepository.findAllByMatchId(
//                listOf(
//                        "KR_6404753039"
//
//                )
//        ).forEach { println(it) }
//
//        dataService.filterIfExisted(
//                listOf(
//                        "KR_6404753039"
//
//                )
//        ).forEach { println(it) }
//    }
//}