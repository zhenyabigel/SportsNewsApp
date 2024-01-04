//package by.bsuir.zhenyabigel.pmislabs.sport.viewmodel
//
//import androidx.lifecycle.SavedStateHandle
//import androidx.lifecycle.ViewModel
//import by.bsuir.zhenyabigel.pmislabs.sport.repisitory.EventsRepository
//import by.bsuir.zhenyabigel.pmislabs.sport.repisitory.EventsRepositoryImpl
//import by.bsuir.zhenyabigel.pmislabs.sport.ui.theme.EventUiState
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.asStateFlow
//import kotlinx.coroutines.flow.update
//import java.time.LocalDate
//
//class EditViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
//
//    private val repository: EventsRepository = EventsRepositoryImpl
//
//    private var articleId: String? = savedStateHandle["id"]
//
//    private val _uiState = MutableStateFlow(EventUiState())
//    val uiState: StateFlow<EventUiState> = _uiState.asStateFlow()
//
//    init {
//        if (articleId != null) {
//            loadEvent(UUID.fromString(articleId))
//        }
//    }
//
//    private fun loadEvent(eventId: UUID?) {
//
//        _uiState.update { it.copy(isLoading = true) }
//        viewModelScope.launch {
//            val result = repository.getEvent(eventId).first()
//            if (result == null) {
//                _uiState.update { it.copy(isLoading = false) }
//            } else {
//
////                _uiState.update {
////                    it.copy(
////                        isLoading = false,
////                        title = result.title,
////                        author = result.author,
////                        isDraft = result.isDraft
////                    )
////                }
//            }
//        }
//
//
//    }

//
//    fun saveEvent() {
//        viewModelScope.launch {
//            try {
//                _uiState.update { it.copy(isEventSaved = true) }
//                System.out.println(_uiState.value.name)
//                if (articleId != null) {
//                    repository.upsert(
//                        NewsArticle(
//                            id = UUID.fromString(articleId),
//                            title = _uiState.value.title,
//                            author = _uiState.value.author,
//                            isDraft = _uiState.value.isDraft,
//                        )
//                    )
//                } else {
//                    repository.upsert(
//                        NewsArticle(
//                            title = _uiState.value.title,
//                            author = _uiState.value.author,
//                            isDraft = _uiState.value.isDraft,
//                        )
//                    )
//                }
//                _uiState.update{it.copy(isArticleSaved = true)}
//
//            } catch (e: Exception){
//                _uiState.update { it.copy(articleSavingError = "unable to save or edit article") }
//            } finally {
//                _uiState.update { it.copy(isArticleSaving = false) }
//            }
//
//        }
//
//
//    }
//
//    fun deleteArticle() {
//        viewModelScope.launch {
//            try {
//                _uiState.update { it.copy(isArticleSaving = true) }
//
//                if(articleId!=null) {
//                    repository.delete(UUID.fromString(articleId))
//                }
//                _uiState.update { it.copy(isArticleSaved = true) }
//            }
//            catch (e: Exception) {
//                System.out.println(e)
//                _uiState.update { it.copy(articleSavingError = "erorrrr") }
//            }
//            finally {
//                _uiState.update { it.copy(isArticleSaving  = false) }
//            }
//
//        }
//    }
//
//
//    val id: UUID = UUID.randomUUID(),
//    val name: String ="",
//    val date: LocalDate = LocalDate.MIN,
//    val firstTeam: String ="",
//    val secondTeam: String="",
//    val winningTeam: String= "",
//    val score: String ="",
//    var isFavorite: Boolean = false,
//    @DrawableRes
//    val imageFirst: Int = R.drawable.logo_mascots,
//    @DrawableRes
//    val imageSecond: Int =R.drawable.logo_mascots,
//    fun setEventName(name: String) {
//
//        _uiState.update { it.copy(name = name) }
//    }
//    fun setEventNameFirstTeam(name: String) {
//
//        _uiState.update { it.copy(name = name) }
//    }
//    fun setEventWinningTeam(name: String) {
//
//        _uiState.update { it.copy(name = name) }
//    }
//    fun setEventScore(date: LocalDate) {
//        _uiState.update { it.copy(date = date) }
//    }
//}