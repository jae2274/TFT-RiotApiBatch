package com.tft.apibatch.api

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.tft.apibatch.api.dto.MatchDTO

class MatchFixture {
    companion object {
        val matchDTOs: List<MatchDTO>
            get() = matchJsons.map { objectMapper.readValue(it, MatchDTO::class.java) }


        private val objectMapper: ObjectMapper = jacksonObjectMapper().registerKotlinModule().configure(
            DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false
        )

        fun readValue(matchJson: String): MatchDTO {
            return objectMapper.readValue(matchJson, MatchDTO::class.java)
        }

        val matchJsons = listOf(
            """
{
    "metadata": {
        "data_version": "5",
        "match_id": "KR_6373779782",
        "participants": [
            "pMz_M78zHtrwtIBv2az1Z4YiLi33KrI3jHm5ukjIgFDFydP9-AUBTlvA9odIr5cTo-F4uDuz63nhdg",
            "NFNQSmMGBoJlCKOXvB4xpNyzPyXzlnTtosPitgqkj5B6MDtRoMrg9kvPZCHjWkPheY4MSFOZXzJ3iQ",
            "5ZlpNk5XzPoG3xwf8tNkOyZimhA11feXQRurqoEVm1mx6fpcnuJ0qLpt7LDSOrKVhwS0yEThOXxEqA",
            "KIPYIId3PvysT3ALnJjwGahSt4lTFZ_46s6uXFVm6Exr7SXnRNz_YUM7qbIOu6y_qwEhA5QNOJOoAw",
            "1vvXToltO3hDpTMEa_mNx4I1gezognsz86XeWMeJo9QWjLXh7K-4QFvBIKRqt4CHBekMkLiFX10aKQ",
            "pPI7r0nhMEroSo9MjiXQYe1_vFVVrBmXa4-jghCDiIej3oA9Qdvvqg2TP1PVHJl5m4gz85EKk_j0sQ",
            "P2sdZ61Im6eQ3jBDPTuw3edI6vymVhSzA30K746zFT3Pj0gzgd1ipepAD0FuzoZ1Lz0qfTSBkEIGJw",
            "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA"
        ]
    },
    "info": {
        "game_datetime": 1676973050336,
        "game_length": 1335.34814453125,
        "game_version": "Version 13.3.491.6222 (Feb 09 2023/14:51:50) [PUBLIC] <Releases/13.3>",
        "participants": [
            {
                "augments": [
                    "TFT8_Augment_LuxSupport",
                    "TFT6_Augment_ComponentGrabBag",
                    "TFT6_Augment_SalvageBin"
                ],
                "companion": {
                    "content_ID": "ead6ac92-a15e-44c0-9826-eb83eb2dbe57",
                    "item_ID": 44002,
                    "skin_ID": 2,
                    "species": "PetChibiLeeSin"
                },
                "gold_left": 3,
                "last_round": 21,
                "level": 9,
                "placement": 3,
                "players_eliminated": 2,
                "puuid": "pMz_M78zHtrwtIBv2az1Z4YiLi33KrI3jHm5ukjIgFDFydP9-AUBTlvA9odIr5cTo-F4uDuz63nhdg",
                "time_eliminated": 1227.95947265625,
                "total_damage_to_players": 22,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Recon",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 7,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Lux",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Yuumi",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Nilah",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_SeraphsEmbrace",
                            "TFT_Item_ArchangelsStaff"
                        ],
                        "items": [
                            99,
                            44,
                            34
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Kaisa",
                        "itemNames": [
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_StatikkShiv",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "items": [
                            23,
                            24,
                            12
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_BrambleVest"
                        ],
                        "items": [
                            57,
                            55
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Taliyah",
                        "itemNames": [
                            "TFT_Item_SeraphsEmbrace",
                            "TFT_Item_RabadonsDeathcap",
                            "TFT_Item_JeweledGauntlet"
                        ],
                        "items": [
                            44,
                            33,
                            39
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Urgot",
                        "itemNames": [
                            "TFT4_Item_OrnnMuramana",
                            "TFT_Item_RabadonsDeathcap"
                        ],
                        "items": [
                            9005,
                            33
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Syndra",
                        "itemNames": [
                            "TFT_Item_SpearOfShojin"
                        ],
                        "items": [
                            14
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_IonicSpark",
                            "TFT_Item_NegatronCloak"
                        ],
                        "items": [
                            36,
                            6
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_WukongSupport",
                    "TFT6_Augment_CelestialBlessing2",
                    "TFT6_Augment_JeweledLotus"
                ],
                "companion": {
                    "content_ID": "370f2b5c-2913-494e-8bd0-95ead07e2974",
                    "item_ID": 54002,
                    "skin_ID": 2,
                    "species": "PetChibiAnnie"
                },
                "gold_left": 2,
                "last_round": 14,
                "level": 7,
                "placement": 8,
                "players_eliminated": 0,
                "puuid": "NFNQSmMGBoJlCKOXvB4xpNyzPyXzlnTtosPitgqkj5B6MDtRoMrg9kvPZCHjWkPheY4MSFOZXzJ3iQ",
                "time_eliminated": 801.3533935546875,
                "total_damage_to_players": 2,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Gangplank",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_WuKong",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Draven",
                        "itemNames": [
                            "TFT_Item_Bloodthirster",
                            "TFT_Item_LastWhisper",
                            "TFT_Item_TitansResolve"
                        ],
                        "items": [
                            16,
                            29,
                            25
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [
                            "TFT_Item_BrambleVest",
                            "TFT_Item_GargoyleStoneplate"
                        ],
                        "items": [
                            55,
                            56
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Malphite",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Jax",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_PoppyCarry",
                    "TFT6_Augment_JeweledLotus",
                    "TFT6_Augment_TargetDummies"
                ],
                "companion": {
                    "content_ID": "87293a40-6439-4dad-af44-bf937973757d",
                    "item_ID": 26017,
                    "skin_ID": 17,
                    "species": "PetUmbra"
                },
                "gold_left": 5,
                "last_round": 23,
                "level": 9,
                "placement": 1,
                "players_eliminated": 1,
                "puuid": "5ZlpNk5XzPoG3xwf8tNkOyZimhA11feXQRurqoEVm1mx6fpcnuJ0qLpt7LDSOrKVhwS0yEThOXxEqA",
                "time_eliminated": 1327.2021484375,
                "total_damage_to_players": 42,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Arsenal",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_WuKong",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vi",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT_Item_WarmogsArmor"
                        ],
                        "items": [
                            77
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Samira",
                        "itemNames": [
                            "TFT_Item_LastWhisper",
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_UnstableConcoction"
                        ],
                        "items": [
                            29,
                            23,
                            49
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sett",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sejuani",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_RunaansHurricane",
                            "TFT_Item_Quicksilver"
                        ],
                        "items": [
                            99,
                            26,
                            69
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Aphelios",
                        "itemNames": [
                            "TFT4_Item_OrnnObsidianCleaver",
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_Deathblade"
                        ],
                        "items": [
                            9006,
                            13,
                            11
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_DragonsClaw"
                        ],
                        "items": [
                            77,
                            13,
                            66
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_BlitzcrankCarry",
                    "TFT6_Augment_SalvageBin",
                    "TFT7_Augment_BigFriend2"
                ],
                "companion": {
                    "content_ID": "370f2b5c-2913-494e-8bd0-95ead07e2974",
                    "item_ID": 54002,
                    "skin_ID": 2,
                    "species": "PetChibiAnnie"
                },
                "gold_left": 5,
                "last_round": 20,
                "level": 9,
                "placement": 5,
                "players_eliminated": 0,
                "puuid": "KIPYIId3PvysT3ALnJjwGahSt4lTFZ_46s6uXFVm6Exr7SXnRNz_YUM7qbIOu6y_qwEhA5QNOJOoAw",
                "time_eliminated": 1175.472412109375,
                "total_damage_to_players": 22,
                "traits": [
                    {
                        "name": "Set8_Admin",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 3,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Blitzcrank",
                        "itemNames": [
                            "TFT_Item_GargoyleStoneplate",
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_Redemption"
                        ],
                        "items": [
                            56,
                            77,
                            47
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Camille",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jax",
                        "itemNames": [
                            "TFT_Item_RapidFireCannon",
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_Bloodthirster"
                        ],
                        "items": [
                            22,
                            23,
                            16
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leblanc",
                        "itemNames": [
                            "TFT_Item_ZekesHerald"
                        ],
                        "items": [
                            17
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT4_Item_OrnnAnimaVisage",
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_TearOfTheGoddess"
                        ],
                        "items": [
                            9001,
                            77,
                            4
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Soraka",
                        "itemNames": [
                            "TFT_Item_MadredsBloodrazor",
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_SeraphsEmbrace"
                        ],
                        "items": [
                            12,
                            39,
                            44
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_KayleCarry",
                    "TFT6_Augment_ComponentGrabBag",
                    "TFT6_Augment_TargetDummies"
                ],
                "companion": {
                    "content_ID": "bdb8527c-baa5-4378-90a6-9a54f2c86ba8",
                    "item_ID": 10006,
                    "skin_ID": 6,
                    "species": "PetSGCat"
                },
                "gold_left": 2,
                "last_round": 17,
                "level": 8,
                "placement": 6,
                "players_eliminated": 0,
                "puuid": "1vvXToltO3hDpTMEa_mNx4I1gezognsz86XeWMeJo9QWjLXh7K-4QFvBIKRqt4CHBekMkLiFX10aKQ",
                "time_eliminated": 980.2733764648438,
                "total_damage_to_players": 10,
                "traits": [
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 6,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Recon",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Kayle",
                        "itemNames": [
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_GuinsoosRageblade"
                        ],
                        "items": [
                            23,
                            23,
                            23
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Gangplank",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Malphite",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_DragonsClaw",
                            "TFT_Item_FrozenHeart"
                        ],
                        "items": [
                            57,
                            66,
                            45
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Yasuo",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vayne",
                        "itemNames": [
                            "TFT_Item_StatikkShiv",
                            "TFT_Item_InfinityEdge"
                        ],
                        "items": [
                            24,
                            19
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Nilah",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Zed",
                        "itemNames": [
                            "TFT4_Item_OrnnDeathsDefiance"
                        ],
                        "items": [
                            9002
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_SylasSupport",
                    "TFT6_Augment_PortableForge",
                    "TFT6_Augment_MakeshiftArmor2"
                ],
                "companion": {
                    "content_ID": "c69f78f0-282a-4a13-bc90-59a7908e625f",
                    "item_ID": 31016,
                    "skin_ID": 16,
                    "species": "PetNimblefoot"
                },
                "gold_left": 3,
                "last_round": 21,
                "level": 9,
                "placement": 4,
                "players_eliminated": 2,
                "puuid": "pPI7r0nhMEroSo9MjiXQYe1_vFVVrBmXa4-jghCDiIej3oA9Qdvvqg2TP1PVHJl5m4gz85EKk_j0sQ",
                "time_eliminated": 1231.146728515625,
                "total_damage_to_players": 20,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 5,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Sylas",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Sylas",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sylas",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Nasus",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jinx",
                        "itemNames": [
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_InfinityEdge"
                        ],
                        "items": [
                            39,
                            19
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Riven",
                        "itemNames": [
                            "TFT4_Item_OrnnAnimaVisage"
                        ],
                        "items": [
                            9001
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Riven",
                        "itemNames": [
                            "TFT_Item_Redemption",
                            "TFT_Item_BrambleVest",
                            "TFT_Item_DragonsClaw"
                        ],
                        "items": [
                            47,
                            55,
                            66
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_MissFortune",
                        "itemNames": [
                            "TFT4_Item_OrnnMuramana",
                            "TFT_Item_MadredsBloodrazor",
                            "TFT_Item_JeweledGauntlet"
                        ],
                        "items": [
                            9005,
                            12,
                            39
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_GuardianAngel"
                        ],
                        "items": [
                            13,
                            94
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_BlitzcrankSupport",
                    "TFT6_Augment_Featherweights2",
                    "TFT8_Augment_RenegadeEmblem"
                ],
                "companion": {
                    "content_ID": "b4d0fd5a-82aa-46ed-a052-b41debc6deef",
                    "item_ID": 7004,
                    "skin_ID": 4,
                    "species": "PetGemTiger"
                },
                "gold_left": 7,
                "last_round": 15,
                "level": 7,
                "placement": 7,
                "players_eliminated": 0,
                "puuid": "P2sdZ61Im6eQ3jBDPTuw3edI6vymVhSzA30K746zFT3Pj0gzgd1ipepAD0FuzoZ1Lz0qfTSBkEIGJw",
                "time_eliminated": 857.0258178710938,
                "total_damage_to_players": 4,
                "traits": [
                    {
                        "name": "Set8_Admin",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 2
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Sylas",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Talon",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Blitzcrank",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Camille",
                        "itemNames": [
                            "TFT_Item_TitansResolve",
                            "TFT_Item_InfinityEdge"
                        ],
                        "items": [
                            25,
                            19
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Zoe",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leblanc",
                        "itemNames": [
                            "TFT_Item_ArchangelsStaff",
                            "TFT_Item_JeweledGauntlet",
                            "TFT8_Item_RenegadeEmblemItem"
                        ],
                        "items": [
                            34,
                            39,
                            8012
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Soraka",
                        "itemNames": [
                            "TFT_Item_StatikkShiv"
                        ],
                        "items": [
                            24
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_LuxCarry",
                    "TFT6_Augment_ComponentGrabBag",
                    "TFT6_Augment_PortableForge"
                ],
                "companion": {
                    "content_ID": "ee8d561e-d1d8-49db-ad24-0d9c9235daa7",
                    "item_ID": 30002,
                    "skin_ID": 2,
                    "species": "PetFenroar"
                },
                "gold_left": 0,
                "last_round": 23,
                "level": 9,
                "placement": 2,
                "players_eliminated": 1,
                "puuid": "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
                "time_eliminated": 1327.2021484375,
                "total_damage_to_players": 38,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 5,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Poppy",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_SeraphsEmbrace",
                            "TFT_Item_HextechGunblade"
                        ],
                        "items": [
                            99,
                            44,
                            13
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Lux",
                        "itemNames": [
                            "TFT_Item_SeraphsEmbrace",
                            "TFT4_Item_OrnnMuramana",
                            "TFT_Item_JeweledGauntlet"
                        ],
                        "items": [
                            44,
                            9005,
                            39
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Annie",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_DragonsClaw",
                            "TFT_Item_TitansResolve"
                        ],
                        "items": [
                            57,
                            66,
                            25
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Rell",
                        "itemNames": [
                            "TFT_Item_Redemption",
                            "TFT_Item_IonicSpark",
                            "TFT4_Item_OrnnEternalWinter"
                        ],
                        "items": [
                            47,
                            36,
                            9003
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Yuumi",
                        "itemNames": [
                            "TFT_Item_Chalice",
                            "TFT_Item_ZekesHerald"
                        ],
                        "items": [
                            46,
                            17
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Zoe",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT8_Item_Sunfire_GenAE"
                        ],
                        "items": [
                            9016
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Syndra",
                        "itemNames": [
                            "TFT_Item_SpearOfShojin"
                        ],
                        "items": [
                            14
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            }
        ],
        "queue_id": 1130,
        "tft_game_type": "turbo",
        "tft_set_core_name": "TFTSet8",
        "tft_set_number": 8
    }
}                
            """.trimIndent(),
            """
{
    "metadata": {
        "data_version": "5",
        "match_id": "KR_6358269110",
        "participants": [
            "RFCXKi2-M-QbWN0zR3klaWr3eF4zzmJobEp7qtMUZstltgAtxDwca9f8zC1j-RiYO5W5VCP5NAwAvQ",
            "9lV7NoD1Fu9mDLjPqLYsspe_Kv4xg-8zIZvvbWu-3YmNB1X3BQxn7hq445aUQs3a0qeDq2fdVoaIWQ",
            "qYzVH0z1SUkGEsO-1QHlZuI8BRVkV1oBa7w9IKgSYymZkvKpdAPmvtOej8R_x3synMJu1rdiAQfdEQ",
            "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
            "LBAa2gx6bP9gPV4Jkr4ijd1I9mvTfwtN25_YRiE5LifGiqBC-WQMCRqrlUuKUF9zTNBZlVvD8IESgQ",
            "uDhnmqF7S4iBb6f-hI_KVeqcQmcaCgJHebUwZeLpGCHi3g6yWRnSGyHrI05umrpoo1FWpUcSsf2rkg",
            "iBLyaCg6CMvMgW5SK_kKZvxKzgdL-35tMgX74I9sSQlxN2QNwE8FBzSEDG6TQ6SiwzzrfAPzhZDo7g",
            "ZsJ0jlX7-YbscE_JP9nTZkMW7blD3LJsjSRsw_73r7aMgk5VnHg2KqxY72aHQx99FTtfq8o7lx9jXA"
        ]
    },
    "info": {
        "game_datetime": 1676172787077,
        "game_length": 2167.666748046875,
        "game_version": "Version 13.3.491.6222 (Feb 09 2023/14:51:50) [PUBLIC] <Releases/13.3>",
        "participants": [
            {
                "augments": [
                    "TFT8_Augment_ViSupport",
                    "TFT6_Augment_Featherweights1",
                    "TFT6_Augment_SecondWind2"
                ],
                "companion": {
                    "content_ID": "0085ae00-24f6-47e4-bce3-f6f1a00fed5f",
                    "item_ID": 6003,
                    "skin_ID": 3,
                    "species": "PetPenguKnight"
                },
                "gold_left": 0,
                "last_round": 33,
                "level": 8,
                "placement": 4,
                "players_eliminated": 1,
                "puuid": "RFCXKi2-M-QbWN0zR3klaWr3eF4zzmJobEp7qtMUZstltgAtxDwca9f8zC1j-RiYO5W5VCP5NAwAvQ",
                "time_eliminated": 2012.4478759765625,
                "total_damage_to_players": 100,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Arsenal",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Recon",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Vi",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Samira",
                        "itemNames": [
                            "TFT_Item_RunaansHurricane",
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_LastWhisper"
                        ],
                        "items": [
                            26,
                            13,
                            29
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Urgot",
                        "itemNames": [
                            "TFT8_Item_ReconEmblemItem",
                            "TFT8_Item_DeadeyeEmblemItem"
                        ],
                        "items": [
                            8010,
                            8018
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Aphelios",
                        "itemNames": [
                            "TFT_Item_UnstableConcoction",
                            "TFT_Item_Bloodthirster",
                            "TFT_Item_TitansResolve"
                        ],
                        "items": [
                            49,
                            16,
                            25
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [
                            "TFT_Item_GargoyleStoneplate",
                            "TFT_Item_Redemption",
                            "TFT_Item_LocketOfTheIronSolari"
                        ],
                        "items": [
                            56,
                            47,
                            35
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_TitansResolve",
                            "TFT_Item_ChainVest"
                        ],
                        "items": [
                            25,
                            5
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_ViSupport",
                    "TFT6_Augment_SecondWind1",
                    "TFT6_Augment_TomeOfTraits1"
                ],
                "companion": {
                    "content_ID": "ad7cd3c3-3493-4c4a-8c41-4956b6cdae39",
                    "item_ID": 22010,
                    "skin_ID": 10,
                    "species": "PetPegasus"
                },
                "gold_left": 5,
                "last_round": 26,
                "level": 8,
                "placement": 7,
                "players_eliminated": 1,
                "puuid": "9lV7NoD1Fu9mDLjPqLYsspe_Kv4xg-8zIZvvbWu-3YmNB1X3BQxn7hq445aUQs3a0qeDq2fdVoaIWQ",
                "time_eliminated": 1556.8187255859375,
                "total_damage_to_players": 46,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 3,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Arsenal",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 3,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Vi",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [
                            "TFT_Item_TitansResolve",
                            "TFT_Item_FrozenHeart",
                            "TFT_Item_DragonsClaw"
                        ],
                        "items": [
                            25,
                            45,
                            66
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_AurelionSol",
                        "itemNames": [
                            "TFT_Item_HextechGunblade"
                        ],
                        "items": [
                            13
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Zac",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Aphelios",
                        "itemNames": [
                            "TFT_Item_LastWhisper",
                            "TFT_Item_RunaansHurricane",
                            "TFT_Item_Deathblade"
                        ],
                        "items": [
                            29,
                            26,
                            11
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Mordekaiser",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_Morellonomicon"
                        ],
                        "items": [
                            37
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_DravenSupport",
                    "TFT7_Augment_Preparation",
                    "TFT7_Augment_ScopedWeapons1"
                ],
                "companion": {
                    "content_ID": "23b0724b-9763-4806-bd7d-937f3bcde097",
                    "item_ID": 40006,
                    "skin_ID": 6,
                    "species": "PetPiximander"
                },
                "gold_left": 7,
                "last_round": 34,
                "level": 7,
                "placement": 3,
                "players_eliminated": 0,
                "puuid": "qYzVH0z1SUkGEsO-1QHlZuI8BRVkV1oBa7w9IKgSYymZkvKpdAPmvtOej8R_x3synMJu1rdiAQfdEQ",
                "time_eliminated": 2087.27490234375,
                "total_damage_to_players": 82,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Civilian",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Forecaster",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Gangplank",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_WuKong",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Draven",
                        "itemNames": [
                            "TFT_Item_UnstableConcoction",
                            "TFT_Item_InfinityEdge",
                            "TFT_Item_LastWhisper"
                        ],
                        "items": [
                            49,
                            19,
                            29
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [
                            "TFT_Item_TitansResolve",
                            "TFT_Item_FrozenHeart",
                            "TFT_Item_LocketOfTheIronSolari"
                        ],
                        "items": [
                            25,
                            45,
                            35
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Malphite",
                        "itemNames": [
                            "TFT_Item_RedBuff"
                        ],
                        "items": [
                            57
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jax",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Janna",
                        "itemNames": [
                            "TFT_Item_NeedlesslyLargeRod"
                        ],
                        "items": [
                            3
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_YasuoSupport",
                    "TFT6_Augment_CelestialBlessing1",
                    "TFT6_Augment_SecondWind2"
                ],
                "companion": {
                    "content_ID": "ee8d561e-d1d8-49db-ad24-0d9c9235daa7",
                    "item_ID": 30002,
                    "skin_ID": 2,
                    "species": "PetFenroar"
                },
                "gold_left": 1,
                "last_round": 35,
                "level": 8,
                "placement": 1,
                "players_eliminated": 3,
                "puuid": "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
                "time_eliminated": 2157.43310546875,
                "total_damage_to_players": 216,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 7,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Renekton",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Yasuo",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Zoe",
                        "itemNames": [
                            "TFT8_Item_InterPolarisEmblemItem"
                        ],
                        "items": [
                            8003
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Senna",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Zed",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_TitansResolve",
                            "TFT_Item_IonicSpark"
                        ],
                        "items": [
                            57,
                            25,
                            36
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sejuani",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Mordekaiser",
                        "itemNames": [
                            "TFT_Item_FrozenHeart",
                            "TFT_Item_ArchangelsStaff"
                        ],
                        "items": [
                            45,
                            34
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_ArchangelsStaff",
                            "TFT_Item_Morellonomicon",
                            "TFT_Item_HextechGunblade"
                        ],
                        "items": [
                            34,
                            37,
                            13
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_AnnieSupport",
                    "TFT6_Augment_ItemGrabBag1",
                    "TFT7_Augment_FirstAidKit2"
                ],
                "companion": {
                    "content_ID": "232ee062-ba5d-49bf-9899-745e1a413631",
                    "item_ID": 24018,
                    "skin_ID": 18,
                    "species": "PetBellswayer"
                },
                "gold_left": 0,
                "last_round": 33,
                "level": 7,
                "placement": 5,
                "players_eliminated": 0,
                "puuid": "LBAa2gx6bP9gPV4Jkr4ijd1I9mvTfwtN25_YRiE5LifGiqBC-WQMCRqrlUuKUF9zTNBZlVvD8IESgQ",
                "time_eliminated": 2009.01220703125,
                "total_damage_to_players": 128,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Poppy",
                        "itemNames": [
                            "TFT_Item_Spatula",
                            "TFT_Item_RedBuff",
                            "TFT_Item_Redemption"
                        ],
                        "items": [
                            8,
                            57,
                            47
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Lulu",
                        "itemNames": [
                            "TFT_Item_Zephyr"
                        ],
                        "items": [
                            67
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Annie",
                        "itemNames": [
                            "TFT_Item_DragonsClaw",
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_TitansResolve"
                        ],
                        "items": [
                            66,
                            77,
                            25
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sona",
                        "itemNames": [
                            "TFT_Item_SpearOfShojin",
                            "TFT_Item_SeraphsEmbrace",
                            "TFT_Item_JeweledGauntlet"
                        ],
                        "items": [
                            14,
                            44,
                            39
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Syndra",
                        "itemNames": [
                            "TFT8_Item_Shojin_GenAE"
                        ],
                        "items": [
                            9014
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_RenektonSupport",
                    "TFT6_Augment_Battlemage1",
                    "TFT6_Augment_CelestialBlessing2"
                ],
                "companion": {
                    "content_ID": "9f756223-fe56-4ea1-9221-f5011bad94fe",
                    "item_ID": 2022,
                    "skin_ID": 22,
                    "species": "PetGriffin"
                },
                "gold_left": 137,
                "last_round": 21,
                "level": 5,
                "placement": 8,
                "players_eliminated": 0,
                "puuid": "uDhnmqF7S4iBb6f-hI_KVeqcQmcaCgJHebUwZeLpGCHi3g6yWRnSGyHrI05umrpoo1FWpUcSsf2rkg",
                "time_eliminated": 1246.3822021484375,
                "total_damage_to_players": 12,
                "traits": [
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Recon",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Ashe",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Renekton",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Ezreal",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Yasuo",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Nilah",
                        "itemNames": [
                            "TFT_Item_GiantsBelt"
                        ],
                        "items": [
                            7
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_DravenSupport",
                    "TFT7_Augment_BandOfThieves1",
                    "TFT6_Augment_PortableForge"
                ],
                "companion": {
                    "content_ID": "d6593334-1e30-4eb1-907c-f6427139be4d",
                    "item_ID": 18,
                    "skin_ID": 18,
                    "species": "PetTFTAvatar"
                },
                "gold_left": 5,
                "last_round": 31,
                "level": 8,
                "placement": 6,
                "players_eliminated": 0,
                "puuid": "iBLyaCg6CMvMgW5SK_kKZvxKzgdL-35tMgX74I9sSQlxN2QNwE8FBzSEDG6TQ6SiwzzrfAPzhZDo7g",
                "time_eliminated": 1879.575439453125,
                "total_damage_to_players": 78,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Recon",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Ashe",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_TitanicHydra"
                        ],
                        "items": [
                            99,
                            77,
                            27
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_WuKong",
                        "itemNames": [
                            "TFT_Item_GargoyleStoneplate",
                            "TFT_Item_Bloodthirster",
                            "TFT_Item_Redemption"
                        ],
                        "items": [
                            56,
                            16,
                            47
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Draven",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ezreal",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vayne",
                        "itemNames": [
                            "TFT_Item_GuardianAngel",
                            "TFT_Item_LastWhisper"
                        ],
                        "items": [
                            94,
                            29
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jax",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Kaisa",
                        "itemNames": [
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_StatikkShiv",
                            "TFT4_Item_OrnnAnimaVisage"
                        ],
                        "items": [
                            39,
                            24,
                            9001
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sejuani",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_GangplankCarry",
                    "TFT6_Augment_CelestialBlessing1",
                    "TFT6_Augment_JeweledLotus"
                ],
                "companion": {
                    "content_ID": "2b9cba4e-100c-41e8-8349-7896e61010a4",
                    "item_ID": 8016,
                    "skin_ID": 16,
                    "species": "PetTurtle"
                },
                "gold_left": 1,
                "last_round": 35,
                "level": 8,
                "placement": 2,
                "players_eliminated": 1,
                "puuid": "ZsJ0jlX7-YbscE_JP9nTZkMW7blD3LJsjSRsw_73r7aMgk5VnHg2KqxY72aHQx99FTtfq8o7lx9jXA",
                "time_eliminated": 2157.43310546875,
                "total_damage_to_players": 92,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Civilian",
                        "num_units": 2,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Forecaster",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Galio",
                        "itemNames": [
                            "TFT_Item_BrambleVest",
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_DragonsClaw"
                        ],
                        "items": [
                            55,
                            77,
                            66
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Gangplank",
                        "itemNames": [
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_SeraphsEmbrace",
                            "TFT_Item_GuardianAngel"
                        ],
                        "items": [
                            39,
                            44,
                            94
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Malphite",
                        "itemNames": [
                            "TFT_Item_NegatronCloak"
                        ],
                        "items": [
                            6
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Yuumi",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "items": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Zed",
                        "itemNames": [
                            "TFT_Item_GuardianAngel"
                        ],
                        "items": [
                            94
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Janna",
                        "itemNames": [
                            "TFT_Item_ZekesHerald"
                        ],
                        "items": [
                            17
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            }
        ],
        "queue_id": 1090,
        "tft_game_type": "standard",
        "tft_set_core_name": "TFTSet8",
        "tft_set_number": 8
    }
}
            """.trimIndent(),
            """
{
    "metadata": {
        "data_version": "5",
        "match_id": "KR_6487126949",
        "participants": [
            "LYwRjh-MW3-zgC6IWw-uGdEKSgltf-SwbcI0oPyhiBHott_CGOLCxMyMZCR0jJS2xQ3RM6GiwEfnUw",
            "4Gw8PG3D4mw8Xju5wc68XpniL-PJuvJWtKCFyJ2DUkeI2zlN-jZJSJ4_UboXoj_AKHmosLUZfrppcA",
            "rLpDzY7VW1gwQruqYgwxx0lzy2q1o4irERdfABh94nuUcCrbTYGt2zMsTaO3CCigrOi4zayCsCH18A",
            "qfEUndQ2p9_aiermwex_nEAuSCwq1kG-chXJiaJiU4W1bT-nU62ZsBhkt749OdXBjOdb05Qo0Fv_Lg",
            "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
            "JVxdppCNbyeTLJkhh-GOpomQzVlDyyluVX3mENkZDIBEKYESg-wI-55t65LPddxbVTm2aNvMChAH8Q",
            "Iqcuu16_nXZ_KaD-WqYxGDOFa0r9ZQWmGFcs0NmWVVGiCHuptwzXtzUEEbqrDsAMggDREJAxXCEYgg",
            "7hBjswoPhMiEu0uRm5a1YwJp5RBTKIaT5qjWsIGdsquW40lponXtgu-zQ4Jm42ibOV6KgEttsQjsfA"
        ]
    },
    "info": {
        "game_datetime": 1683555794003,
        "game_length": 2044.77392578125,
        "game_version": "Version 13.9.506.4846 (Apr 28 2023/10:09:23) [PUBLIC] <Releases/13.9>",
        "participants": [
            {
                "augments": [
                    "TFT8_Augment_BlitzcrankCarry",
                    "TFT6_Augment_SecondWind1",
                    "TFT6_Augment_TomeOfTraits1"
                ],
                "companion": {
                    "content_ID": "9bed4a77-2a3a-41ae-93d8-45dd597d173e",
                    "item_ID": 29007,
                    "skin_ID": 7,
                    "species": "PetDowsie"
                },
                "gold_left": 0,
                "last_round": 30,
                "level": 8,
                "placement": 6,
                "players_eliminated": 1,
                "puuid": "LYwRjh-MW3-zgC6IWw-uGdEKSgltf-SwbcI0oPyhiBHott_CGOLCxMyMZCR0jJS2xQ3RM6GiwEfnUw",
                "time_eliminated": 1756.83740234375,
                "total_damage_to_players": 91,
                "traits": [
                    {
                        "name": "Set8_Admin",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_SpaceCorps",
                        "num_units": 5,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Blitzcrank",
                        "itemNames": [
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_GargoyleStoneplate",
                            "TFT_Item_DragonsClaw"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ashe",
                        "itemNames": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Renekton",
                        "itemNames": [
                            "TFT4_Item_OrnnRocketPropelledFist"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Yasuo",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_Morellonomicon",
                            "TFT_Item_GuardianAngel"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Riven",
                        "itemNames": [
                            "TFT8_Item_InterPolarisEmblemItem"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Warwick",
                        "itemNames": [
                            "TFT_Item_TitansResolve",
                            "TFT_Item_UnstableConcoction",
                            "TFT_Item_Bloodthirster"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_TwistedFate",
                        "itemNames": [
                            "TFT_Item_StatikkShiv",
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_RabadonsDeathcap"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Aatrox",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_BlitzcrankCarry",
                    "TFT6_Augment_TinyTitans",
                    "TFT6_Augment_ComponentGrabBag"
                ],
                "companion": {
                    "content_ID": "5897ad9f-4665-4372-8f3e-6c878adb8918",
                    "item_ID": 1,
                    "skin_ID": 1,
                    "species": "PetTFTAvatar"
                },
                "gold_left": 10,
                "last_round": 33,
                "level": 8,
                "placement": 3,
                "players_eliminated": 2,
                "puuid": "4Gw8PG3D4mw8Xju5wc68XpniL-PJuvJWtKCFyJ2DUkeI2zlN-jZJSJ4_UboXoj_AKHmosLUZfrppcA",
                "time_eliminated": 1933.0496826171875,
                "total_damage_to_players": 71,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Parallel",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 3,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_WuKong",
                        "itemNames": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Rammus",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_RapidFireCannon",
                            "TFT_Item_ArchangelsStaff"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Garen",
                        "itemNames": [
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_GargoyleStoneplate",
                            "TFT_Item_DragonsClaw"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Samira",
                        "itemNames": [
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_LastWhisper",
                            "TFT_Item_InfinityEdge"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_EzrealFuture",
                        "itemNames": [
                            "TFT_Item_LocketOfTheIronSolari",
                            "TFT4_Item_OrnnRocketPropelledFist"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Urgot",
                        "itemNames": [
                            "TFT_Item_GuardianAngel"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_MadredsBloodrazor",
                            "TFT_Item_InfinityEdge"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_5_Augment_PantheonCarry",
                    "TFT7_Augment_PandorasBench",
                    "TFT8_Augment_HeartEmblem"
                ],
                "companion": {
                    "content_ID": "5089d996-487a-40a7-aed2-0984dd9a0e0d",
                    "item_ID": 19033,
                    "skin_ID": 33,
                    "species": "PetDSSquid"
                },
                "gold_left": 21,
                "last_round": 24,
                "level": 7,
                "placement": 8,
                "players_eliminated": 0,
                "puuid": "rLpDzY7VW1gwQruqYgwxx0lzy2q1o4irERdfABh94nuUcCrbTYGt2zMsTaO3CCigrOi4zayCsCH18A",
                "time_eliminated": 1397.246337890625,
                "total_damage_to_players": 38,
                "traits": [
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 6,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Lulu",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_UnstableConcoction",
                            "TFT_Item_SpearOfShojin"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Pantheon",
                        "itemNames": [
                            "TFT_Item_DragonsClaw",
                            "TFT_Item_TitansResolve"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sona",
                        "itemNames": [
                            "TFT_Item_SeraphsEmbrace"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [
                            "TFT_Item_Zephyr"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_AurelionSol",
                        "itemNames": [
                            "TFT8_Item_HeartEmblemItem",
                            "TFT_Item_JeweledGauntlet"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Aatrox",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_FioraCarry",
                    "TFT8_Augment_DuelistTrait",
                    "TFT6_Augment_SecondWind2"
                ],
                "companion": {
                    "content_ID": "12065c27-2725-4c60-bd80-8ab98809f045",
                    "item_ID": 56002,
                    "skin_ID": 2,
                    "species": "PetChibiZed"
                },
                "gold_left": 1,
                "last_round": 28,
                "level": 8,
                "placement": 7,
                "players_eliminated": 0,
                "puuid": "qfEUndQ2p9_aiermwex_nEAuSCwq1kG-chXJiaJiU4W1bT-nU62ZsBhkt749OdXBjOdb05Qo0Fv_Lg",
                "time_eliminated": 1658.0958251953125,
                "total_damage_to_players": 75,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Fiora",
                        "itemNames": [
                            "TFT_Item_Bloodthirster",
                            "TFT_Item_RedBuff",
                            "TFT_Item_BrambleVest"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Fiora",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_MadredsBloodrazor",
                            "TFT_Item_RapidFireCannon"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Annie",
                        "itemNames": [
                            "TFT8_Item_DuelistEmblemItem"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sona",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_TwistedFate",
                        "itemNames": [
                            "TFT_Item_StatikkShiv",
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Neeko",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_5_Augment_PykeSupport",
                    "TFT6_Augment_CelestialBlessing1",
                    "TFT8_Augment_RenegadeEmblem"
                ],
                "companion": {
                    "content_ID": "17a6b1da-073f-4081-86fc-0828c14b0b1d",
                    "item_ID": 6001,
                    "skin_ID": 1,
                    "species": "PetPenguKnight"
                },
                "gold_left": 0,
                "last_round": 35,
                "level": 8,
                "placement": 2,
                "players_eliminated": 2,
                "puuid": "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
                "time_eliminated": 2036.436767578125,
                "total_damage_to_players": 131,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 3,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 4,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Riftwalker",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Pyke",
                        "itemNames": [
                            "TFT_Item_SpearOfShojin"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vex",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_TitanicHydra"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [
                            "TFT4_Item_OrnnZhonyasParadox",
                            "TFT_Item_Bloodthirster"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jhin",
                        "itemNames": [
                            "TFT_Item_LastWhisper",
                            "TFT_Item_Deathblade",
                            "TFT_Item_RunaansHurricane"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_RunaansHurricane",
                            "TFT_Item_UnstableConcoction"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_IonicSpark",
                            "TFT_Item_Bloodthirster",
                            "TFT8_Item_RenegadeEmblemItem"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Zac",
                        "itemNames": [],
                        "name": "",
                        "rarity": 9,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_NasusSupport",
                    "TFT6_Augment_ThrillOfTheHunt1",
                    "TFT6_Augment_Diversify2"
                ],
                "companion": {
                    "content_ID": "67cba3eb-f530-4940-a6c3-535e8ac9da80",
                    "item_ID": 42022,
                    "skin_ID": 22,
                    "species": "PetDuckbill"
                },
                "gold_left": 62,
                "last_round": 35,
                "level": 8,
                "placement": 1,
                "players_eliminated": 2,
                "puuid": "JVxdppCNbyeTLJkhh-GOpomQzVlDyyluVX3mENkZDIBEKYESg-wI-55t65LPddxbVTm2aNvMChAH8Q",
                "time_eliminated": 2036.436767578125,
                "total_damage_to_players": 190,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 5,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_GunMage",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Nasus",
                        "itemNames": [
                            "TFT4_Item_OrnnRocketPropelledFist"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jinx",
                        "itemNames": [
                            "TFT8_Item_DuelistEmblemItem"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vayne",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_SeraphsEmbrace"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Riven",
                        "itemNames": [
                            "TFT_Item_GargoyleStoneplate",
                            "TFT_Item_RedBuff",
                            "TFT_Item_IonicSpark"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Kaisa",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Garen",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_RapidFireCannon",
                            "TFT_Item_ArchangelsStaff"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_MissFortune",
                        "itemNames": [
                            "TFT_Item_SpearOfShojin",
                            "TFT_Item_ArchangelsStaff",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_5_Augment_PantheonSupport",
                    "TFT6_Augment_ThrillOfTheHunt1",
                    "TFT6_Augment_Distancing2"
                ],
                "companion": {
                    "content_ID": "ead6ac92-a15e-44c0-9826-eb83eb2dbe57",
                    "item_ID": 44002,
                    "skin_ID": 2,
                    "species": "PetChibiLeeSin"
                },
                "gold_left": 2,
                "last_round": 31,
                "level": 8,
                "placement": 4,
                "players_eliminated": 0,
                "puuid": "Iqcuu16_nXZ_KaD-WqYxGDOFa0r9ZQWmGFcs0NmWVVGiCHuptwzXtzUEEbqrDsAMggDREJAxXCEYgg",
                "time_eliminated": 1833.6015625,
                "total_damage_to_players": 112,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Pantheon",
                        "itemNames": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sona",
                        "itemNames": [
                            "TFT_Item_SeraphsEmbrace"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT8_Item_MascotEmblemItem",
                            "TFT4_Item_OrnnRocketPropelledFist"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_Chalice",
                            "TFT_Item_PowerGauntlet"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_AurelionSol",
                        "itemNames": [
                            "TFT_Item_SpearOfShojin",
                            "TFT_Item_JeweledGauntlet",
                            "TFT_Item_HextechGunblade"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Aatrox",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_GiantsBelt"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Syndra",
                        "itemNames": [
                            "TFT_Item_StatikkShiv"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_ViCarry",
                    "TFT6_Augment_SecondWind1",
                    "TFT6_Augment_MakeshiftArmor2"
                ],
                "companion": {
                    "content_ID": "a4a35782-fbae-45ee-bc0d-90c26269d1a9",
                    "item_ID": 27018,
                    "skin_ID": 18,
                    "species": "PetChoncc"
                },
                "gold_left": 4,
                "last_round": 31,
                "level": 8,
                "placement": 5,
                "players_eliminated": 0,
                "puuid": "7hBjswoPhMiEu0uRm5a1YwJp5RBTKIaT5qjWsIGdsquW40lponXtgu-zQ4Jm42ibOV6KgEttsQjsfA",
                "time_eliminated": 1827.1478271484375,
                "total_damage_to_players": 93,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 4,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Fiora",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Annie",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vi",
                        "itemNames": [
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_GargoyleStoneplate"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sona",
                        "itemNames": [
                            "TFT_Item_ArchangelsStaff",
                            "TFT4_Item_OrnnMuramana",
                            "TFT_Item_PowerGauntlet"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [
                            "TFT_Item_ThiefsGloves",
                            "TFT_Item_RunaansHurricane",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_TwistedFate",
                        "itemNames": [
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_StatikkShiv",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Neeko",
                        "itemNames": [
                            "TFT_Item_MadredsBloodrazor",
                            "TFT4_Item_OrnnMuramana"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    }
                ]
            }
        ],
        "queue_id": 1100,
        "tft_game_type": "standard",
        "tft_set_core_name": "TFTSet8_2",
        "tft_set_number": 8
    }
}
            """.trimIndent(),
            """
{
    "metadata": {
        "data_version": "5",
        "match_id": "KR_6487074402",
        "participants": [
            "9YDTcQoywwrb9Gh0Q4iXtyz4wK7_u1rckJkhITycuWM9GV32AA-jbYk0bsTouhXI_EQMXbTZ7vifQA",
            "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
            "MkGGYGkHe0-QJHqjrH4zKqu-DZ_D83HB28l-YhlV0eJ3BWPMOVCQ7fJKOwuZsRUMSedy0kaOVLETYw",
            "xrUKapJD9w0rv7hCiy50UfMwtxtRyyJZNA1eKEawW2eBEoMHm7XRxhmodG4EPo-5rhMN84BRc3vzvA",
            "t3Zr5k97NVedgezat2NQdjl2vFUP01H78cH5ehvbhzOvfDPaP-jErQLnvpZ_LHM0yVCU4syo5PoAUg",
            "CMYdLmbupfuHWahEatc4Tk56zeosCbu1-ZWAT8b-XH4rGIxX-8pGine0puirSfW3vJfoGrztDP3REQ",
            "6P5JDkWV_Lr4nJw0z4PCd-NO-daAlqCPESVxHFEc9zg-GSX-0Wnd6mj9Aud6u5rFyZ9DIUtVY38Tlg",
            "IZnFsRVW2gosF_ZkLVa6g20UzocRo8gU0KDCzWKARSsrxPfIdx8Sat382lR6B-pkCRAPAcTCJaOoRw"
        ]
    },
    "info": {
        "game_datetime": 1683554048763,
        "game_length": 2128.241943359375,
        "game_version": "Version 13.9.506.4846 (Apr 28 2023/10:09:23) [PUBLIC] <Releases/13.9>",
        "participants": [
            {
                "augments": [
                    "TFT8_Augment_AnimaSquadTrait",
                    "TFT8_Augment_MissFortuneCarry",
                    "TFT6_Augment_ComponentGrabBag"
                ],
                "companion": {
                    "content_ID": "7bf593ed-62d3-4f7f-abd8-e558c646af68",
                    "item_ID": 14026,
                    "skin_ID": 26,
                    "species": "PetQiyanaDog"
                },
                "gold_left": 13,
                "last_round": 35,
                "level": 8,
                "placement": 3,
                "players_eliminated": 1,
                "puuid": "9YDTcQoywwrb9Gh0Q4iXtyz4wK7_u1rckJkhITycuWM9GV32AA-jbYk0bsTouhXI_EQMXbTZ7vifQA",
                "time_eliminated": 2036.0823974609375,
                "total_damage_to_players": 85,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 5,
                        "style": 3,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_GunMage",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Nasus",
                        "itemNames": [
                            "TFT_Item_Zephyr",
                            "TFT_Item_Chalice"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jinx",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Riven",
                        "itemNames": [
                            "TFT_Item_RedBuff",
                            "TFT_Item_WarmogsArmor",
                            "TFT_Item_Redemption"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Kaisa",
                        "itemNames": [
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_StatikkShiv"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Garen",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_MissFortune",
                        "itemNames": [
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_SpearOfShojin",
                            "TFT_Item_JeweledGauntlet"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT6_Augment_MakeshiftArmor1",
                    "TFT8_Augment_ViegoCarry",
                    "TFT6_Augment_ComponentGrabBag"
                ],
                "companion": {
                    "content_ID": "17a6b1da-073f-4081-86fc-0828c14b0b1d",
                    "item_ID": 6001,
                    "skin_ID": 1,
                    "species": "PetPenguKnight"
                },
                "gold_left": 1,
                "last_round": 30,
                "level": 9,
                "placement": 6,
                "players_eliminated": 0,
                "puuid": "TGJLQTG6deBrcGxOqP277e1260z0ZYE2JH5Eli6dPQYgiE9UqWToNftjuYQD8D9f9X4E7uD-rar2jA",
                "time_eliminated": 1733.998779296875,
                "total_damage_to_players": 79,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Riftwalker",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Pyke",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vex",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_TitansResolve",
                            "TFT_Item_IonicSpark"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Jhin",
                        "itemNames": [
                            "TFT_Item_InfinityEdge",
                            "TFT_Item_Deathblade"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Urgot",
                        "itemNames": [
                            "TFT_Item_FrozenHeart"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [
                            "TFT_Item_Bloodthirster",
                            "TFT_Item_FrozenHeart",
                            "TFT_Item_UnstableConcoction"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Zac",
                        "itemNames": [],
                        "name": "",
                        "rarity": 9,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT6_Augment_FirstAidKit",
                    "TFT8_5_Augment_TwistedFateCarry",
                    "TFT8_Augment_OxForceEmblem"
                ],
                "companion": {
                    "content_ID": "5897ad9f-4665-4372-8f3e-6c878adb8918",
                    "item_ID": 1,
                    "skin_ID": 1,
                    "species": "PetTFTAvatar"
                },
                "gold_left": 5,
                "last_round": 37,
                "level": 9,
                "placement": 2,
                "players_eliminated": 3,
                "puuid": "MkGGYGkHe0-QJHqjrH4zKqu-DZ_D83HB28l-YhlV0eJ3BWPMOVCQ7fJKOwuZsRUMSedy0kaOVLETYw",
                "time_eliminated": 2120.094970703125,
                "total_damage_to_players": 168,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Forecaster",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 6,
                        "style": 4,
                        "tier_current": 3,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Fiora",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Annie",
                        "itemNames": [
                            "TFT_Item_DragonsClaw"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Sona",
                        "itemNames": [
                            "TFT_Item_Shroud"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ekko",
                        "itemNames": [
                            "TFT_Item_DragonsClaw",
                            "TFT8_Item_OxForceEmblemItem"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_TwistedFate",
                        "itemNames": [
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_StatikkShiv",
                            "TFT_Item_GuinsoosRageblade"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Janna",
                        "itemNames": [
                            "TFT_Item_ZekesHerald",
                            "TFT_Item_Chalice",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Syndra",
                        "itemNames": [
                            "TFT8_Item_OxForceEmblemItem"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT6_Augment_CyberneticShell1",
                    "TFT8_Augment_MissFortuneCarry",
                    "TFT8_Augment_StarGuardianEmblem"
                ],
                "companion": {
                    "content_ID": "a4a35782-fbae-45ee-bc0d-90c26269d1a9",
                    "item_ID": 27018,
                    "skin_ID": 18,
                    "species": "PetChoncc"
                },
                "gold_left": 0,
                "last_round": 24,
                "level": 8,
                "placement": 8,
                "players_eliminated": 0,
                "puuid": "xrUKapJD9w0rv7hCiy50UfMwtxtRyyJZNA1eKEawW2eBEoMHm7XRxhmodG4EPo-5rhMN84BRc3vzvA",
                "time_eliminated": 1372.3807373046875,
                "total_damage_to_players": 33,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Channeler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_GunMage",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_StarGuardian",
                        "num_units": 6,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Rell",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Nilah",
                        "itemNames": [
                            "TFT_Item_GargoyleStoneplate"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Kaisa",
                        "itemNames": [
                            "TFT_Item_StatikkShiv"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Garen",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_MissFortune",
                        "itemNames": [
                            "TFT_Item_RabadonsDeathcap",
                            "TFT8_Item_StarGuardianEmblemItem"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Neeko",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Syndra",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT_Item_Morellonomicon"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT7_Augment_Consistency",
                    "TFT8_Augment_RenegadePartners",
                    "TFT6_Augment_Battlemage2"
                ],
                "companion": {
                    "content_ID": "5897ad9f-4665-4372-8f3e-6c878adb8918",
                    "item_ID": 1,
                    "skin_ID": 1,
                    "species": "PetTFTAvatar"
                },
                "gold_left": 9,
                "last_round": 28,
                "level": 6,
                "placement": 7,
                "players_eliminated": 0,
                "puuid": "t3Zr5k97NVedgezat2NQdjl2vFUP01H78cH5ehvbhzOvfDPaP-jErQLnvpZ_LHM0yVCU4syo5PoAUg",
                "time_eliminated": 1629.9373779296875,
                "total_damage_to_players": 54,
                "traits": [
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Heart",
                        "num_units": 4,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 3,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Lulu",
                        "itemNames": [
                            "TFT_Item_SeraphsEmbrace",
                            "TFT_Item_HextechGunblade",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Gangplank",
                        "itemNames": [
                            "TFT_Item_UnstableConcoction",
                            "TFT_Item_RunaansHurricane"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Pantheon",
                        "itemNames": [
                            "TFT_Item_IonicSpark",
                            "TFT_Item_WarmogsArmor"
                        ],
                        "name": "",
                        "rarity": 0,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_LeeSin",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Malphite",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Viego",
                        "itemNames": [],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    }
                ]
            },
            {
                "augments": [
                    "TFT8_Augment_AnimaSquadTrait",
                    "TFT8_Augment_VayneCarry",
                    "TFT6_Augment_ThrillOfTheHunt2"
                ],
                "companion": {
                    "content_ID": "489abd90-0929-447d-ba51-0326e0aa5469",
                    "item_ID": 42024,
                    "skin_ID": 24,
                    "species": "PetDuckbill"
                },
                "gold_left": 3,
                "last_round": 35,
                "level": 9,
                "placement": 4,
                "players_eliminated": 1,
                "puuid": "CMYdLmbupfuHWahEatc4Tk56zeosCbu1-ZWAT8b-XH4rGIxX-8pGine0puirSfW3vJfoGrztDP3REQ",
                "time_eliminated": 2045.5384521484375,
                "total_damage_to_players": 124,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 7,
                        "style": 4,
                        "tier_current": 3,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Corrupted",
                        "num_units": 1,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Duelist",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_GunMage",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Prankster",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Nasus",
                        "itemNames": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jinx",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vayne",
                        "itemNames": [
                            "TFT_Item_InfinityEdge",
                            "TFT_Item_RunaansHurricane",
                            "TFT_Item_PowerGauntlet"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_Riven",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_MissFortune",
                        "itemNames": [
                            "TFT_Item_FrozenHeart",
                            "TFT_Item_ArchangelsStaff"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Nunu",
                        "itemNames": [
                            "TFT_Item_Redemption"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Urgot",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Fiddlesticks",
                        "itemNames": [
                            "TFT8_Item_AnimaSquadEmblemItem",
                            "TFT_Item_GargoyleStoneplate"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT7_Augment_AFK",
                    "TFT8_Augment_BelVethCarry",
                    "TFT7_Augment_FirstAidKit2"
                ],
                "companion": {
                    "content_ID": "d4650578-8b9d-4af2-842f-04c7801d6f17",
                    "item_ID": 29034,
                    "skin_ID": 34,
                    "species": "PetDowsie"
                },
                "gold_left": 1,
                "last_round": 33,
                "level": 9,
                "placement": 5,
                "players_eliminated": 0,
                "puuid": "6P5JDkWV_Lr4nJw0z4PCd-NO-daAlqCPESVxHFEc9zg-GSX-0Wnd6mj9Aud6u5rFyZ9DIUtVY38Tlg",
                "time_eliminated": 1913.8504638671875,
                "total_damage_to_players": 101,
                "traits": [
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_AnimaSquad",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_GenAE",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Mascot",
                        "num_units": 6,
                        "style": 3,
                        "tier_current": 3,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_OxForce",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Riftwalker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Supers",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Threat",
                        "num_units": 4,
                        "style": 0,
                        "tier_current": 1,
                        "tier_total": 1
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8_Nasus",
                        "itemNames": [],
                        "name": "",
                        "rarity": 0,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Malphite",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Vex",
                        "itemNames": [
                            "TFT_Item_Zephyr"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Alistar",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Morgana",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_BelVeth",
                        "itemNames": [
                            "TFT_Item_TitansResolve",
                            "TFT_Item_Deathblade",
                            "TFT_Item_Quicksilver"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_AurelionSol",
                        "itemNames": [
                            "TFT_Item_Zephyr"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Aatrox",
                        "itemNames": [
                            "TFT8_Item_MascotEmblemItem",
                            "TFT_Item_FrozenHeart"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 1
                    },
                    {
                        "character_id": "TFT8_Nunu",
                        "itemNames": [
                            "TFT_Item_GuardianAngel"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            },
            {
                "augments": [
                    "TFT7_Augment_Consistency",
                    "TFT8_Augment_SamiraCarry",
                    "TFT6_Augment_TargetDummies"
                ],
                "companion": {
                    "content_ID": "4e0a1f65-efb0-47c3-83d9-a8b294885f90",
                    "item_ID": 15021,
                    "skin_ID": 21,
                    "species": "PetSennaBunny"
                },
                "gold_left": 17,
                "last_round": 37,
                "level": 8,
                "placement": 1,
                "players_eliminated": 2,
                "puuid": "IZnFsRVW2gosF_ZkLVa6g20UzocRo8gU0KDCzWKARSsrxPfIdx8Sat382lR6B-pkCRAPAcTCJaOoRw",
                "time_eliminated": 2120.094970703125,
                "total_damage_to_players": 179,
                "traits": [
                    {
                        "name": "Set8_Ace",
                        "num_units": 1,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_Aegis",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Brawler",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Deadeye",
                        "num_units": 3,
                        "style": 2,
                        "tier_current": 2,
                        "tier_total": 4
                    },
                    {
                        "name": "Set8_Defender",
                        "num_units": 2,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_ExoPrime",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 2
                    },
                    {
                        "name": "Set8_GunMage",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Hacker",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Parallel",
                        "num_units": 2,
                        "style": 3,
                        "tier_current": 1,
                        "tier_total": 1
                    },
                    {
                        "name": "Set8_Pulsefire",
                        "num_units": 3,
                        "style": 1,
                        "tier_current": 1,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_Renegade",
                        "num_units": 1,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 3
                    },
                    {
                        "name": "Set8_UndergroundThe",
                        "num_units": 2,
                        "style": 0,
                        "tier_current": 0,
                        "tier_total": 4
                    }
                ],
                "units": [
                    {
                        "character_id": "TFT8b_Sivir",
                        "itemNames": [
                            "TFT_Item_ZekesHerald"
                        ],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Ezreal",
                        "itemNames": [],
                        "name": "",
                        "rarity": 1,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Jax",
                        "itemNames": [],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Shen",
                        "itemNames": [
                            "TFT_Item_RedBuff"
                        ],
                        "name": "",
                        "rarity": 2,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Garen",
                        "itemNames": [
                            "TFT_Item_DragonsClaw",
                            "TFT_Item_Bloodthirster",
                            "TFT_Item_Redemption"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Samira",
                        "itemNames": [
                            "TFT_Item_LastWhisper",
                            "TFT_Item_GuardianAngel",
                            "TFT_Item_MadredsBloodrazor"
                        ],
                        "name": "",
                        "rarity": 4,
                        "tier": 3
                    },
                    {
                        "character_id": "TFT8_EzrealFuture",
                        "itemNames": [
                            "TFT4_Item_OrnnInfinityForce",
                            "TFT_Item_GuinsoosRageblade",
                            "TFT_Item_InfinityEdge"
                        ],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    },
                    {
                        "character_id": "TFT8_Leona",
                        "itemNames": [],
                        "name": "",
                        "rarity": 6,
                        "tier": 2
                    }
                ]
            }
        ],
        "queue_id": 1100,
        "tft_game_type": "standard",
        "tft_set_core_name": "TFTSet8_2",
        "tft_set_number": 8
    }
}
            """.trimIndent()
        )
    }
}