package com.tft.apibatch.repository;

import com.tft.apibatch.entry.ItemSet
import org.springframework.data.mongodb.repository.MongoRepository

interface ItemSetRepository : MongoRepository<ItemSet, String>