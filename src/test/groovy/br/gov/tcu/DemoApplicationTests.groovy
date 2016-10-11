package br.gov.tcu;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.See
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll
import br.gov.tcu.domain.Customer

/* http://techbus.safaribooksonline.com/book/software-engineering-and-development/9781617290084
 * http://spockframework.org/spock/docs/1.1-rc-2/index.html
 *  http://spockframework.org/spock/docs/1.1-rc-2/spock_primer.html
 * http://groovy-lang.org/documentation.html
 * http://groovy-coder.com/?p=111
 * https://github.com/spockframework/spock-example
 * http://meetspock.appspot.com/edit/9001 - Web Console
 * http://docs.spring.io/spring-boot/docs/1.4.1.RELEASE/reference/htmlsingle/#boot-features-testing-spring-boot-applications
 */

@Narrative("""Como fulano
Gostaria de fazer uma operação
""")
@Title("Especificação qualquer")
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DemoApplicationTests extends Specification {

    @Autowired
    private TestRestTemplate restTemplate;

    def setup() {
        println "setup"
    } // run before every feature method

    def cleanup() {
        println "cleanup"
    } // run after every feature method

    def setupSpec() {
        println "setupSpec"
    } // run before the first feature method

    def cleanupSpec() {
        println "cleanupSpec"
    } // run after the last feature method

    def "pushing an element on the stack"() {
        given: "Condição inicial"
        println "given"
        when: "Ação realizada"
        println "when"
        throw new IllegalArgumentException("Exceção qualquer")
        then: "Então, o resultado: "
        println "then"
        thrown(IllegalArgumentException)
        Math.max(1, 2) == 2

        // blocks go here
    }

    @Unroll
    @Issue("225")
    @See("http://spockframework.org/spock/docs/1.1-rc-2/index.html")
    def "maximum between #a and #b is #c"() {
        expect:
        Math.max(a, b) == c

        where:
        a | b | c
        1 | 3 | 3
        7 | 4 | 7
        0 | 0 | 0
    }

    def "contract test"() {
        expect:
        restTemplate.getForObject('/something', Customer.class)?.name == 'Somebody'
    }

}
