package learn.view

import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*


class SimpleMVCView : View("Simple MVC") {

    private val controller: SimpleController by inject()
    private val input = SimpleStringProperty()

    override val root = form {

        vbox {
            label("my items")

            listview(controller.values)
        }

        fieldset {
            field("Input") {
                textfield(input)
            }

            button("Commit") {
                action {
                    controller.writeToDb(input.value)
                    input.value = ""
                }
            }
        }

    }
}


class SimpleController: Controller() {

    val values = FXCollections.observableArrayList("Alpha", "Beta", "Gamma", "Delta")

    fun writeToDb(value: String) {
        println("Writing $value to database.")
    }
}