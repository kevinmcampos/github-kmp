package me.kevincampos.githubkmp

import kotlin.coroutines.CoroutineContext

expect fun platformName(): String

class Greeting {
    fun greeting(): String = "Hi, ${platformName()}"
}

internal expect val ApplicationDispatcher: CoroutineContext
