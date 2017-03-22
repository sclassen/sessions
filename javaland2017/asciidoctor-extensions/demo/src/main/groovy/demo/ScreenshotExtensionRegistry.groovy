package demo

import org.asciidoctor.Asciidoctor
import org.asciidoctor.extension.JavaExtensionRegistry
import org.asciidoctor.extension.spi.ExtensionRegistry

class ScreenshotExtensionRegistry implements ExtensionRegistry {

    @Override
    void register(Asciidoctor asciidoctor) {
        JavaExtensionRegistry registry = asciidoctor.javaExtensionRegistry()

        registry.blockMacro('screenshot', ScreenshotBlockMacroProcessor)
    }
}
