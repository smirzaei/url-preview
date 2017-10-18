package com.github.smirzaei.urlpreview.extractors

import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

object TwitterCardsExtractorSpec : Spek({
    describe("twitter cards extractor") {
        on("extract") {
            it("should fail for now") {
                true shouldEqualTo false
            }
        }
    }
})