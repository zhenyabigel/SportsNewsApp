package by.bsuir.zhenyabigel.pmislabs.sportify.ui

import by.bsuir.zhenyabigel.pmislabs.sportify.model.SportEvent

data class EventsListUiState(
    val events: List<SportEvent> = emptyList(),
    val favoriteEvents: List<SportEvent> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false
)