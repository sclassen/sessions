package demo

import geb.Page
import org.openqa.selenium.Keys

class EquipmentDetailsEditPage extends Page {

    static at = {
        title == 'Equipment Management'
        equipmentHeading.displayed
    }

    static content = {
        equipmentHeading { $("div#equipmentNameHeading") }
        saveEquipmentButton { $('button#saveEquipmentButton') }

        inputPruefbankName { $("input#edit_Pruefbank_Name") }
        inputPruefbankExecutor { $("input#edit_Pruefbank_Executor") }
        inputPruefbankType { $("input#typeahead_Pruefbank_Type") }
    }

    void selectPruefbankType(value) {
        inputPruefbankType.value(value)
        inputPruefbankType << Keys.ARROW_DOWN
        inputPruefbankType << Keys.ENTER
    }


    PruefbankOverviewPage saveNewEquipment() {
        saveEquipmentButton.click()
        return browser.at(PruefbankOverviewPage)
    }

}
