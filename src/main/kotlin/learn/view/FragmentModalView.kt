package learn.view

import javafx.stage.Modality
import javafx.stage.StageStyle
import tornadofx.*



class FragmentModalView : View ("Simple Fragment") {
    override val root = vbox {
        button("Press Me") {
            action {
                find<SimpleFragment>().openModal(stageStyle = StageStyle.UTILITY, modality = Modality.WINDOW_MODAL)
            }
        }
    }
}


class SimpleFragment : Fragment() {
    override val root = label("This is a popup")
}