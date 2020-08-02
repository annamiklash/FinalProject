package ania.miklash.pjatk.FinalProject.controller

import spock.lang.Specification
import spock.lang.Unroll

class TestControllerTest extends Specification {

    @Unroll
    def "test #target is true"() {
        when:
        def result = 5

        then:
        result == target

        where:
        target | _
        5      | _
        5      | _
        5      | _
    }

}
