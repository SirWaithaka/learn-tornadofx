package learn.view

import tornadofx.*

import learn.app.Styles


class HelloWorldView : View(title = "Example App") {

    override val root = hbox {

        label("Hello world") {
            addClass(Styles.heading)
        }

    }
}
