package uk.org.nbn.specieslist

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(SpeciesListItemController)
class SpeciesListItemControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "downloadListFix calls downloadList"() {
        expect:
            controller.downloadList()
    }
}
