package by.bsuir.zhenyabigel.pmislabs.sportify.repository

import by.bsuir.zhenyabigel.pmislabs.sportify.model.EventsDataSource
import by.bsuir.zhenyabigel.pmislabs.sportify.model.InMemorySportEventsDataSource
import by.bsuir.zhenyabigel.pmislabs.sportify.model.SportEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.UUID

object EventsRepositoryImpl:EventsRepository {
    private val dataSource: EventsDataSource = InMemorySportEventsDataSource
    override fun getEvents(): Flow<List<SportEvent>> {
        return dataSource.getEvents()
    }

    override fun getFavoritesEvents(): Flow<List<SportEvent>> {
        return dataSource.getEvents().map { sportEventsList ->
            val filteredList = sportEventsList.filter { it.isFavorite }
            filteredList
        }
    }

    override fun getEvent(id: UUID?): Flow<SportEvent?> {
        return dataSource.getEvent(id)
    }

    override suspend fun removeEvent(id: UUID) {
         dataSource.delete(id)
    }

    override suspend fun removeFavoriteEvent(event: SportEvent) {
        event.isFavorite = false
        dataSource.upsert(event)
    }

    override suspend fun addFavoriteEvent(event: SportEvent) {
        event.isFavorite = true
        dataSource.upsert(event)
    }
}