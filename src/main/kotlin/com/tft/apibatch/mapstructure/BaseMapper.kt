package com.tft.apibatch.mapstructure


import org.mapstruct.Mapper



interface BaseMapper<T,E> {
    fun dtoToEntry(dto: T): E // 3
    fun entryToDTO(entity: E): T // 3
}