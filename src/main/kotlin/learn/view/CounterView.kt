package learn.view

import javafx.scene.layout.BorderPane
import tornadofx.*

class CounterView : View("Counter View") {

    override val root: BorderPane by fxml(hasControllerAttribute = true)
}
