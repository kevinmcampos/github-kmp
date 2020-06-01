package me.kevincampos.githubkmp

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

internal actual val ApplicationDispatcher: CoroutineContext = Dispatchers.IO
// Dispatchers.IO offloads blocking I/O to a pool of thread
