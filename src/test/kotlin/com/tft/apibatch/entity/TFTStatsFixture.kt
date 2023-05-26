package com.tft.apibatch.entity

class TFTStatsFixture {
    val standard = Fixture(
        championsStats = mutableMapOf(
            "TFT8_Camille" to TftStats.ChampionStats(
                totalCount = 3,
                totalPlacement = 14,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 3),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 7),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                    "TFT_Item_LastWhisper" to TftStats.Stats(totalCount = 2, totalPlacement = 8),
                    "TFT_Item_IonicSpark" to TftStats.Stats(totalCount = 5, totalPlacement = 23)
                )
            ),
            "TFT8_Pyke" to TftStats.ChampionStats(
                totalCount = 5,
                totalPlacement = 17,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 3, totalPlacement = 12),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 3),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 2),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                    "TFT_Item_HextechGunblade" to TftStats.Stats(totalCount = 2, totalPlacement = 7),
                )
            ),

            ),
        itemStats = mutableMapOf(
            "TFT8_Item_RenegadeEmblemItem" to TftStats.ItemStats(
                totalCount = 3,
                totalPlacement = 16,
                champions = mutableMapOf(
                    "TFT8_Camille" to TftStats.Stats(totalCount = 2, totalPlacement = 10),
                    "TFT8_Urgot" to TftStats.Stats(totalCount = 1, totalPlacement = 6),
                )
            ),
            "TFT_Item_HextechGunblade" to TftStats.ItemStats(
                totalCount = 4,
                totalPlacement = 15,
                champions = mutableMapOf(
                    "TFT8_Viego" to TftStats.Stats(totalCount = 2, totalPlacement = 6),
                    "TFT8_Mordekaiser" to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                    "TFT8_Nilah" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                )
            )
        ),
        synergyStats = mutableMapOf(
            "Set8_Admin" to TftStats.SynergyStats(
                totalCount = 5, totalPlacement = 22,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 3, totalPlacement = 15),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 3)
                )
            ),
            "Set8_Aegis" to TftStats.SynergyStats(
                totalCount = 4, totalPlacement = 20,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 2, totalPlacement = 15),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 3),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 2)
                )
            ),
        ),
        augmentStats = mutableMapOf(
            "TFT6_Augment_Windfall" to TftStats.Stats(
                totalCount = 2,
                totalPlacement = 7,
            ),
            "TFT7_Augment_UrfsGrabBag2" to TftStats.Stats(
                totalCount = 3,
                totalPlacement = 19,
            ),
            "TFT6_Augment_ForceOfNature" to TftStats.Stats(
                totalCount = 5,
                totalPlacement = 20,
            )
        )
    )

    val another = Fixture(
        championsStats = mutableMapOf(
            "TFT8_Camille" to TftStats.ChampionStats(
                totalCount = 2,
                totalPlacement = 5,
                tiers = mutableMapOf(
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 1),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 1, totalPlacement = 3),
                    "TFT_Item_LastWhisper" to TftStats.Stats(totalCount = 2, totalPlacement = 8),
                    "TFT_Item_HextechGunblade" to TftStats.Stats(totalCount = 2, totalPlacement = 7)
                )
            ),
            "TFT8_Samira" to TftStats.ChampionStats(
                totalCount = 6,
                totalPlacement = 21,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 1, totalPlacement = 8),
                    2 to TftStats.Stats(totalCount = 3, totalPlacement = 10),
                    3 to TftStats.Stats(totalCount = 2, totalPlacement = 3),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                    "TFT_Item_HextechGunblade" to TftStats.Stats(totalCount = 2, totalPlacement = 7)
                )
            ),
        ),
        itemStats = mutableMapOf(
            "TFT8_Item_RenegadeEmblemItem" to TftStats.ItemStats(
                totalCount = 3,
                totalPlacement = 14,
                champions = mutableMapOf(
                    "TFT8_Camille" to TftStats.Stats(totalCount = 2, totalPlacement = 10),
                    "TFT8_Vex" to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                )
            ),
            "TFT_Item_MadredsBloodrazor" to TftStats.ItemStats(
                totalCount = 8,
                totalPlacement = 36,
                champions = mutableMapOf(
                    "TFT8_Jhin" to TftStats.Stats(totalCount = 5, totalPlacement = 20),
                    "TFT8_Samira" to TftStats.Stats(totalCount = 2, totalPlacement = 10),
                    "TFT8_Morgana" to TftStats.Stats(totalCount = 1, totalPlacement = 6),
                )
            )
        ),
        synergyStats = mutableMapOf(
            "Set8_Admin" to TftStats.SynergyStats(
                totalCount = 3, totalPlacement = 17,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 2, totalPlacement = 12),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                )
            ),
            "Set8_Hacker" to TftStats.SynergyStats(
                totalCount = 9, totalPlacement = 36,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 5, totalPlacement = 25),
                    2 to TftStats.Stats(totalCount = 3, totalPlacement = 8),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 3)
                )
            )
        ),
        augmentStats = mutableMapOf(
            "TFT6_Augment_Windfall" to TftStats.Stats(
                totalCount = 3,
                totalPlacement = 11,
            ),
            "TFT7_Augment_UrfsGrabBag2" to TftStats.Stats(
                totalCount = 2,
                totalPlacement = 15,
            ),
            "TFT8_Augment_InterPolarisTrait2" to TftStats.Stats(
                totalCount = 1,
                totalPlacement = 2,
            )
        )
    )

    val expected = Fixture(
        championsStats = mutableMapOf(
            "TFT8_Camille" to TftStats.ChampionStats(
                totalCount = 5,
                totalPlacement = 19,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                    2 to TftStats.Stats(totalCount = 2, totalPlacement = 7),
                    3 to TftStats.Stats(totalCount = 2, totalPlacement = 8),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 2, totalPlacement = 8),
                    "TFT_Item_LastWhisper" to TftStats.Stats(totalCount = 4, totalPlacement = 16),
                    "TFT_Item_HextechGunblade" to TftStats.Stats(totalCount = 2, totalPlacement = 7),
                    "TFT_Item_IonicSpark" to TftStats.Stats(totalCount = 5, totalPlacement = 23),
                )
            ),
            "TFT8_Samira" to TftStats.ChampionStats(
                totalCount = 6,
                totalPlacement = 21,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 1, totalPlacement = 8),
                    2 to TftStats.Stats(totalCount = 3, totalPlacement = 10),
                    3 to TftStats.Stats(totalCount = 2, totalPlacement = 3),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                    "TFT_Item_HextechGunblade" to TftStats.Stats(totalCount = 2, totalPlacement = 7)
                )
            ),
            "TFT8_Pyke" to TftStats.ChampionStats(
                totalCount = 5,
                totalPlacement = 17,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 3, totalPlacement = 12),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 3),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 2),
                ),
                items = mutableMapOf(
                    "TFT_Item_TitansResolve" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                    "TFT_Item_HextechGunblade" to TftStats.Stats(totalCount = 2, totalPlacement = 7)
                )
            ),
        ),
        itemStats = mutableMapOf(
            "TFT8_Item_RenegadeEmblemItem" to TftStats.ItemStats(
                totalCount = 6,
                totalPlacement = 30,
                champions = mutableMapOf(
                    "TFT8_Camille" to TftStats.Stats(totalCount = 4, totalPlacement = 20),
                    "TFT8_Urgot" to TftStats.Stats(totalCount = 1, totalPlacement = 6),
                    "TFT8_Vex" to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                )
            ),
            "TFT_Item_HextechGunblade" to TftStats.ItemStats(
                totalCount = 4,
                totalPlacement = 15,
                champions = mutableMapOf(
                    "TFT8_Viego" to TftStats.Stats(totalCount = 2, totalPlacement = 6),
                    "TFT8_Mordekaiser" to TftStats.Stats(totalCount = 1, totalPlacement = 4),
                    "TFT8_Nilah" to TftStats.Stats(totalCount = 1, totalPlacement = 5),
                )
            ),
            "TFT_Item_MadredsBloodrazor" to TftStats.ItemStats(
                totalCount = 8,
                totalPlacement = 36,
                champions = mutableMapOf(
                    "TFT8_Jhin" to TftStats.Stats(totalCount = 5, totalPlacement = 20),
                    "TFT8_Samira" to TftStats.Stats(totalCount = 2, totalPlacement = 10),
                    "TFT8_Morgana" to TftStats.Stats(totalCount = 1, totalPlacement = 6),
                )
            )
        ),
        synergyStats = mutableMapOf(
            "Set8_Admin" to TftStats.SynergyStats(
                totalCount = 8, totalPlacement = 39,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 5, totalPlacement = 27),
                    2 to TftStats.Stats(totalCount = 2, totalPlacement = 9),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 3)
                )
            ),
            "Set8_Hacker" to TftStats.SynergyStats(
                totalCount = 9, totalPlacement = 36,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 5, totalPlacement = 25),
                    2 to TftStats.Stats(totalCount = 3, totalPlacement = 8),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 3)
                )
            ),
            "Set8_Aegis" to TftStats.SynergyStats(
                totalCount = 4, totalPlacement = 20,
                tiers = mutableMapOf(
                    1 to TftStats.Stats(totalCount = 2, totalPlacement = 15),
                    2 to TftStats.Stats(totalCount = 1, totalPlacement = 3),
                    3 to TftStats.Stats(totalCount = 1, totalPlacement = 2)
                )
            )
        ),
        augmentStats = mutableMapOf(
            "TFT6_Augment_Windfall" to TftStats.Stats(
                totalCount = 5,
                totalPlacement = 18,
            ),
            "TFT7_Augment_UrfsGrabBag2" to TftStats.Stats(
                totalCount = 5,
                totalPlacement = 34,
            ),
            "TFT8_Augment_InterPolarisTrait2" to TftStats.Stats(
                totalCount = 1,
                totalPlacement = 2,
            ),
            "TFT6_Augment_ForceOfNature" to TftStats.Stats(
                totalCount = 5,
                totalPlacement = 20,
            )
        )
    )

    class Fixture(
        private val championsStats: MutableMap<String, TftStats.ChampionStats>,
        private val itemStats: MutableMap<String, TftStats.ItemStats>,
        private val synergyStats: MutableMap<String, TftStats.SynergyStats>,
        private val augmentStats: MutableMap<String, TftStats.Stats>
    ) {
        fun championsStats(): MutableMap<String, TftStats.ChampionStats> {
            return championsStats.entries
                .associate { it.key to it.value.copy() }
                .toMutableMap()
        }

        fun itemStats(): MutableMap<String, TftStats.ItemStats> {
            return itemStats.entries
                .associate { it.key to it.value.copy() }
                .toMutableMap()
        }

        fun synergyStats(): MutableMap<String, TftStats.SynergyStats> {
            return synergyStats.entries
                .associate { it.key to it.value.copy() }
                .toMutableMap()
        }

        fun augmentStats(): MutableMap<String, TftStats.Stats> {
            return augmentStats.entries
                .associate { it.key to it.value.copy() }
                .toMutableMap()
        }

        fun tftStats(season: String, seasonNumber: Int, gameVersion: String): TftStats {
            return TftStats(
                season = season,
                seasonNumber = seasonNumber,
                gameVersion = gameVersion,
                champions = championsStats(),
                items = itemStats(),
                synergies = synergyStats(),
                augments = augmentStats()
            )
        }
    }
}