package demo

import org.asciidoctor.Asciidoctor
import spock.lang.Specification

class SimpleCaptureSpec extends Specification {

    def url = SimpleCaptureSpec.classLoader.getResource("sample.html").toString()

    def aDoc = """== Capture Test

[geb]
....
go "${url}"
\$("input").value("JavaLand 2017")
....

screenshot::${url}[]

"""

    def "ensure extensions are working"() {
        given:
          Asciidoctor asciidoctor = Asciidoctor.Factory.create()

        when:
          String html = asciidoctor.convert(aDoc, [:])

          new File('/tmp/aDoc.html').write(html)
          println html
          html = html.replaceAll('\n', ' ')

        then:
          html.contains('Capture Test XXX')
    }
}
