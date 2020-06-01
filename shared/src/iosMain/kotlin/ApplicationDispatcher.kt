package me.kevincampos.githubkmp

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import platform.darwin.dispatch_async
import platform.darwin.dispatch_get_main_queue
import platform.darwin.dispatch_queue_t
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineContext =
    NsQueueDispatcher(
        dispatch_get_main_queue()
    )

// In the future, Dispatchers.IO might be available for iOS
// Create a CoroutineDispatcher with iOS specific mean of providing the Application dispatcher
internal class NsQueueDispatcher(
    private val dispatchQueue: dispatch_queue_t
) : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        dispatch_async(dispatchQueue) {
            block.run()
        }
    }
}
