package learn.view

import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

class BuilderExampleView : View("How builder functions are made") {

    override val root = VBox()


    init {
        with(root) {

            this += Button("Builder Button").apply {
                textFill = Color.RED
                action { println("Button pressed!") }
            }

        }
    }

}