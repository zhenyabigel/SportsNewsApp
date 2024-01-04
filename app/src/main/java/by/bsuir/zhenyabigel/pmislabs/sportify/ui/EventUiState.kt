package by.bsuir.zhenyabigel.pmislabs.sportify.ui

import androidx.annotation.DrawableRes
import by.bsuir.zhenyabigel.pmislabs.sport.R
import java.time.LocalDate
import java.util.Date
import java.util.UUID

data class EventUiState(
    val id: UUID = UUID.randomUUID(),
    val name: String ="",
    val date: LocalDate = LocalDate.MIN,
    val firstTeam: String ="",
    val secondTeam: String="",
    val winningTeam: String= "",
    val score: String ="",
    var isFavorite: Boolean = false,
    @DrawableRes
    val imageFirst: Int = R.drawable.logo_mascots,
    @DrawableRes
    val imageSecond: Int =R.drawable.logo_mascots,

    val isDraft: Boolean = false,
    val isLoading: Boolean = false,
    val isEventSaved: Boolean = false,
    val isEventSaving: Boolean = false,
    val eventSavingError: String? = null
) {
    val articlesDate = Date()
}
