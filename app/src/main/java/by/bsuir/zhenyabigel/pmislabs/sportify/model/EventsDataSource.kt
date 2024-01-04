package by.bsuir.zhenyabigel.pmislabs.sportify.model

import kotlinx.coroutines.flow.Flow
import java.util.UUID

interface EventsDataSource {
    fun getEvents(): Flow<List<SportEvent>>
    fun getEvent(id: UUID?): Flow<SportEvent?>

    suspend fun upsert(event: SportEvent)
    suspend fun delete(id: UUID)

}