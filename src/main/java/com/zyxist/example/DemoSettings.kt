package com.zyxist.example

import io.micronaut.context.annotation.ConfigurationProperties
import io.micronaut.core.convert.format.MapFormat
import io.micronaut.core.naming.conventions.StringConvention

@ConfigurationProperties("demo")
class DemoSettings {
    @MapFormat(keyFormat = StringConvention.RAW)
    var categories: Map<String, List<String>> = emptyMap()
    var nested: Nested = Nested()

    class Nested {
        @MapFormat(keyFormat = StringConvention.RAW)
        var categories: Map<String, List<String>> = emptyMap()
    }
}
