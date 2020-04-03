package learn.view

import javafx.scene.control.SelectionMode
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class DataControlsView : View("") {

    private val counties = observableListOf("Kiambu", "Narok", "Kajiado", "Uasin Gishu")
    private val persons = observableListOf(
        Person(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
        Person(2, "Tom Marks", LocalDate.of(2001, 1, 23)),
        Person(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
        Person(3, "Nicole Williams", LocalDate.of(1998, 8, 11))
    )

    override val root = vbox {

//        hbox {
//            listview<String> {
//                items.add("Alpha")
//                items.add("Beta")
//                items.add("Gamma")
//                items.add("Epsilon")
//                items.add("Delta")
//                selectionModel.selectionMode = SelectionMode.MULTIPLE
//            }
//        }

        hbox {
            listview(counties) {
                selectionModel.selectionMode = SelectionMode.MULTIPLE
            }
        }

        hbox {
            tableview(persons) {
                readonlyColumn("ID", Person::id)
                readonlyColumn("Name", Person::name)
                readonlyColumn("Birthday", Person::birthday)
                readonlyColumn("Age", Person::age)
            }
        }

    }
}


class Person(val id: Int, val name: String, val birthday: LocalDate) {
    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}