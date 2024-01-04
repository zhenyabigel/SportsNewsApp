package by.bsuir.zhenyabigel.pmislabs.sportify.model

import androidx.annotation.DrawableRes
import java.time.LocalDate
import java.util.Date
import java.util.UUID

data class SportEvent (
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val date: LocalDate,
    val firstTeam: String,
    val secondTeam: String,
    val winningTeam: String,
    val score: String,
    var isFavorite: Boolean,
    @DrawableRes val imageFirst: Int,
    @DrawableRes val imageSecond: Int
)

//У матча есть название, дата, команды которые играли, результат матча, кто победил.
