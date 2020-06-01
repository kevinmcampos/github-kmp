package me.kevincampos.githubkmp.presentation

import kotlinx.coroutines.launch
import me.kevincampos.githubkmp.ApplicationDispatcher
import me.kevincampos.githubkmp.model.DataRepository

class MembersPresenter(
    private val view: MembersView,
    private val repository: DataRepository
) : CoroutinePresenter(ApplicationDispatcher, view) {

    override fun onCreate() {
        view.isUpdating = isFirstDataLoading()
        repository.onRefreshListeners += onRefreshListener
        showData()
        updateData()
    }

    override fun onDestroy() {
        super.onDestroy()
        repository.onRefreshListeners -= onRefreshListener
    }

    private val onRefreshListener: () -> Unit = this::showData

    private fun showData() {
        view.onUpdate(repository.members ?: "No members")
    }

    private fun updateData() {
        launch {
            repository.update()
            showData()
        }.invokeOnCompletion {
            view.isUpdating = false
        }
    }

    private fun isFirstDataLoading() = repository.members == null
}
