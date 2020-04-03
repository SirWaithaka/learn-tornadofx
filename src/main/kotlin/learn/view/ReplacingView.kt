package learn.view


import tornadofx.*

/**
 * This example shows who we can swap a view with another view using replaceWith method,
 * and optionally add a transition while at it. Also we can leverage 2 view methods that
 * are called as the events of a view is connected to a parent and when a view is
 * disconnected from a parent. `onDock()` when connected and `onUnDock()` when disconnected
 */

class ReplacingView : View ("Original View") {

    override val root = vbox {
        button("Go to next View") {
            action {
                replaceWith(NextView::class, ViewTransition.Fade(0.3.seconds))
            }
        }
    }

    override fun onDock() {
        super.onDock()

        println("Docking ReplacingView")
    }

    override fun onUndock() {
        super.onUndock()

        println("Undocking ReplacingView")
    }
}


class NextView : View("Next View") {

    override val root = vbox {
        button("Go back to original") {
            action {
                replaceWith(ReplacingView::class, ViewTransition.Slide(0.3.seconds, ViewTransition.Direction.LEFT))
            }
        }
    }

    override fun onDock() {
        super.onDock()

        println("Docking NextView")
    }

    override fun onUndock() {
        super.onUndock()

        println("Undocking NextView")
    }
}