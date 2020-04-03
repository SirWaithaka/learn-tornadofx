package learn.view

import javafx.scene.control.TextField
import tornadofx.*

class SingleAssignView : View("Make sure only assign once") {

    private var firstNameField: TextField by singleAssign()
    private var lastNameField: TextField by singleAssign()


    override val root = vbox {
        hbox {
            label("First Name")
            firstNameField = textfield()
        }

        hbox {
            label("Last Name")
            lastNameField = textfield("input something") {
                textProperty().addListener{obs, old, new ->
                    println("old $old")
                    println("you typed: $new")
                }
            }
        }

        button("LOGIN") {
            useMaxWidth = true
            action {
                println("Logging in as ${firstNameField.text} ${lastNameField.text}")
            }
        }
    }
}