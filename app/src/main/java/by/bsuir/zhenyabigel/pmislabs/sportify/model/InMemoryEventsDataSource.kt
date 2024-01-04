package by.bsuir.zhenyabigel.pmislabs.sportify.model

import by.bsuir.zhenyabigel.pmislabs.sport.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.Month
import java.util.UUID

object InMemorySportEventsDataSource:EventsDataSource {
    private val events = DefaultEventsList.associateBy { it.id }.toMutableMap() // (1)

    private val _eventsFlow = MutableSharedFlow<Map<UUID, SportEvent>>(1) // (2)

    override fun getEvent(id: UUID?): Flow<SportEvent?> {

        GlobalScope.launch(Dispatchers.Default) {
            while (true) {
                _eventsFlow.emit(events)
                delay(5000L)
            }
        }

        return _eventsFlow.asSharedFlow().map { it[id] }
    }
    override fun getEvents(): Flow<List<SportEvent>> {
        GlobalScope.launch(Dispatchers.Default) {
            while (true) {
                _eventsFlow.emit(events)
                delay(800L)
            }
        }
        return _eventsFlow.asSharedFlow().map { it.values.toList() }
    }

    override suspend fun upsert(event: SportEvent) {
        events[event.id] = event // Вставляем или обновляем событие в коллекции
    }

    override suspend fun delete(id: UUID) {
        events.remove(id)// Удалить значение из sportEventsMap
    }
}



val DefaultEventsList = listOf(
    SportEvent(
        name = "Spain - La Liga",
        date = LocalDate.of(2023, Month.SEPTEMBER, 15),
        firstTeam = "Granada",
        secondTeam = "Villarreal",
        winningTeam = "Villarreal",
        isFavorite = false,
        score = "3:4",
        imageFirst = R.drawable.logo_teambravo,
        imageSecond = R.drawable.logo_mascots
    ),
    SportEvent(
        name = "Italy - Serie A",
        date = LocalDate.of(2023, Month.NOVEMBER, 23),
        firstTeam = "Empoli",
        secondTeam = "Atalanta",
        winningTeam = "Atalanta",
        isFavorite = false,
        score = "1:0",
        imageFirst = R.drawable.logo_mascots,
        imageSecond = R.drawable.logo_teambravo
    ),
    SportEvent(
        name = "England - Championship",
        date = LocalDate.of(2016, Month.OCTOBER, 11),
        firstTeam = "Coventry",
        secondTeam = "West Bromwich",
        winningTeam = "Coventry",
        score = "3:1",
        isFavorite = true,
        imageFirst = R.drawable.logo_mascots,
        imageSecond = R.drawable.logo_teambravo
    )
)