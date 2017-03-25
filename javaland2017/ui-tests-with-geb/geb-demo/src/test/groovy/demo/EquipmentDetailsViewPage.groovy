package demo

import geb.Page

class EquipmentDetailsViewPage extends Page {

    static at = {
        title == 'Equipment Management'
        equipmentHeading.displayed
    }

    static content = {
        equipmentHeading { $("div#equipmentNameHeading") }

        pruefbankName { $("div#view_Pruefbank_Name").text() }
        pruefbankExecutor{ $("div#view_Pruefbank_Executor").text() }
        pruefbankType{ $("div#view_Pruefbank_Type").text() }
    }

}
