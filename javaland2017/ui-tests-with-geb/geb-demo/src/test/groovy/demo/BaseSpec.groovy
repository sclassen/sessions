package demo

import geb.Page
import geb.spock.GebReportingSpec
import spock.lang.Shared

import java.text.SimpleDateFormat

/**
 * Base class for GEB tests.
 */
abstract class BaseSpec extends GebReportingSpec {

    @Shared
    Page p

    String unique(String s) {
        return s + new SimpleDateFormat("_dd-MMM-yyyy'T'HH:mm:ss_", Locale.ENGLISH).format(new Date())
    }

    protected <T extends Page> T login(Class<T> page) {
        // do login omitted
        return browser.to(page)
    }

    protected executeQuery(String q) {
        // omitted
    }
}
