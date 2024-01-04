package by.bsuir.zhenyabigel.pmislabs.sportify.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.bsuir.zhenyabigel.pmislabs.sportify.model.SportEvent
import by.bsuir.zhenyabigel.pmislabs.sportify.repository.EventsRepository
import by.bsuir.zhenyabigel.pmislabs.sportify.repository.EventsRepositoryImpl
import by.bsuir.zhenyabigel.pmislabs.sportify.ui.EventsListUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.UUID

class HomeViewModel:ViewModel() {
    private val eventsRepository: EventsRepository = EventsRepositoryImpl
    private val events = eventsRepository.getEvents()
    private val eventsLoadingItems = MutableStateFlow(0)
    private val favoriteEvents = eventsRepository.getFavoritesEvents()

    val uiState = combine(events,favoriteEvents, eventsLoadingItems) { events,favoriteEvents, loadingItems ->
        EventsListUiState(
            events = events.toList(),
            favoriteEvents=favoriteEvents.toList(),
            isLoading = loadingItems > 0,
            isError = false
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = EventsListUiState(isLoading = true)
    )

    private suspend fun withLoading(block: suspend () -> Unit) {
        try {
            addLoadingElement()
            block()
        }
        finally {
            removeLoadingElement()
        }
    }

    private fun addLoadingElement() = eventsLoadingItems.getAndUpdate { num -> num + 1 }
    private fun removeLoadingElement() = eventsLoadingItems.getAndUpdate { num -> num - 1 }
    fun deleteEvent(eventId: UUID){
        viewModelScope.launch {
            withLoading { eventsRepository.removeEvent(eventId) }
        }
    }
    fun deleteFavoriteEvent(sportEvent: SportEvent){
        viewModelScope.launch {
            withLoading { eventsRepository.removeFavoriteEvent(sportEvent) }
        }
    }
    fun addEventToFavorite(sportEvent: SportEvent){
        viewModelScope.launch {
            eventsRepository.addFavoriteEvent(sportEvent)
        }
    }
    fun findSportEventById(sportEvents: List<SportEvent>, uuid: UUID): SportEvent? {
        return sportEvents.find { it.id == uuid }
    }
}