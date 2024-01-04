package by.bsuir.zhenyabigel.pmislabs.sportify.repository

import by.bsuir.zhenyabigel.pmislabs.sportify.model.SportEvent
import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface EventsRepository {
    fun getEvents(): Flow<List<SportEvent>>
    fun getFavoritesEvents(): Flow<List<SportEvent>>
    fun getEvent(id: UUID?): Flow<SportEvent?>
    suspend fun removeEvent(id: UUID)
    suspend fun removeFavoriteEvent(event: SportEvent)
    suspend fun addFavoriteEvent(event: SportEvent)
}