package com.tft.apibatch.repository;

import com.tft.apibatch.entry.SynergySet
import org.springframework.data.mongodb.repository.MongoRepository

interface SynergySetRepository : MongoRepository<SynergySet, String>