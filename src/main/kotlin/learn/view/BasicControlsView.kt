package learn.view

import javafx.application.Platform
import javafx.beans.property.SimpleBooleanProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import javafx.scene.control.ToggleGroup
import tornadofx.*
import java.time.LocalDate
import kotlin.concurrent.thread

class BasicControlsView : View("Basic Controls") {

    private val selectedCity = SimpleStringProperty()
    private val booleanProperty = SimpleBooleanProperty()
    private val dateProperty = SimpleObjectProperty<LocalDate>()

    private val btnToggleGroup = ToggleGroup()
    private val radioToggleGroup = ToggleGroup()

    private val cities = FXCollections.observableArrayList("Nairobi", "Eldoret",
        "Nakuru", "Mombasa", "Ruiru"
        )

    override val root = vbox {
        hbox {
            combobox(selectedCity, cities)
        }

        hbox {
            checkbox("Admin Mode", booleanProperty) {
                action {
                    println(isSelected)
                }
            }
        }

        hbox {
            togglebutton("OFF") {
                action {
                    text = if (isSelected) "ON" else "OFF"
                }
            }

            togglebutton {
                val stateText = selectedProperty().stringBinding {
                    if (it == true) "YES" else "NO"
                }
                textProperty().bind(stateText)
            }
        }

        hbox {
            togglebutton("MALE", btnToggleGroup)
            togglebutton("FEMALE", btnToggleGroup)
            togglebutton("RATHER NOT SAY", btnToggleGroup)
        }

        hbox {
            radiobutton("Power User Mode") {
                action {
                    println("Power User Mode: $isSelected")
                }
            }
        }

        hbox {
            label("Radio button Toggle Group")
            radiobutton("Employee", radioToggleGroup)
            radiobutton("Contractor", radioToggleGroup)
            radiobutton("Intern", radioToggleGroup)
        }

        hbox {
            datepicker(dateProperty) {
                value = LocalDate.now()
            }
        }

        hbox {
            progressbar {
                thread {
                    for (i in 1..100) {
                        Platform.runLater { progress = i.toDouble() / 100.0 }
                        Thread.sleep(100)
                    }
                }
            }

            // progress indicator uses a filling circle
            progressindicator {
                thread {
                    for (i in 1..100) {
                        Platform.runLater { progress = i.toDouble() / 100.0 }
                        Thread.sleep(100)
                    }
                }
            }
        }

        hbox {
            imageview("")
        }
    }
}