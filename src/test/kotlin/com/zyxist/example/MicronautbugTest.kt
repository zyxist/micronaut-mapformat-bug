package com.zyxist.example
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.maps.shouldContainKey

@MicronautTest
class MicronautbugTest(private val application: EmbeddedApplication<*>, private val settings: DemoSettings): StringSpec({
    "test the server is running" {
        assert(application.isRunning)
    }

    "should read unaltered map keys at the top level" {
        settings.categories shouldContainKey "category-1"
        settings.categories shouldContainKey "category-2"
    }

    "should read unaltered map keys at the second level" {
        settings.nested.categories shouldContainKey "category-1"
        settings.nested.categories shouldContainKey "category-2"
    }
})
