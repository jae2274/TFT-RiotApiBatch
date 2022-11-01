package com.tft.apibatch.entry

//import com.querydsl.core.annotations.QueryEntity
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime



//@QueryEntity
@Document(collection = "user")
data class User
    (
    @Id
    val summonerId: String,
    var puuid: String? = null,
    var isProcessed: Boolean = false
)
{


}
