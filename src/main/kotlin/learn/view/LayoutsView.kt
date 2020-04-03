package learn.view

import javafx.scene.control.TabPane
import javafx.scene.layout.Priority
import tornadofx.*

class LayoutsView : View("Layouts and Menus") {

    override val root = vbox {
        button("Button 1") {
            vboxConstraints {
                marginBottom = 20.0
                vGrow = Priority.ALWAYS
            }
        }
        button("Button 2")

        tabpane {
            tabClosingPolicy = TabPane.TabClosingPolicy.UNAVAILABLE

            tab("Screen 1") {
                vbox {
                    button("Button 1")
                    button("Button 2")
                }
            }
            tab("Screen 2") {
                hbox {
                    button("Button 3")
                    button("Button 4")
                }
            }
        }
    }
}
