package me.kevincampos.githubkmp.presentation

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class CoroutinePresenter(
    private val presenterContext: CoroutineContext,
    private val baseView: BaseView
): CoroutineScope {

    // Job to hold the execution
    private val job = Job()

    // Call the presenter to handle error
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        baseView.showError(throwable)
    }

    // Create a CoroutineContext using plus overload
    override val coroutineContext: CoroutineContext
        get() = presenterContext + job + exceptionHandler

    abstract fun onCreate()

    // Default job cancellation
    open fun onDestroy() {
        job.cancel()
    }

}
