package learn.app

import learn.view.*
import tornadofx.*


//class HelloApp: App(HelloWorldView::class, Styles::class)
//class MainApp: App(SimpleMVCView::class, Styles::class)
//class MainApp: App(FragmentModalView::class, Styles::class)
//class MainApp: App(ReplacingView::class, Styles::class)
//class MainApp: App(PassingParamsToViews::class, Styles::class)
//class MainApp: App(BuilderExampleView::class, Styles::class)
//class MainApp: App(SingleAssignView::class, Styles::class)
//class MainApp: App(BasicControlsView::class, Styles::class)
//class MainApp: App(DataControlsView::class, Styles::class)
//class MainApp: App(LayoutsView::class, Styles::class)
class MainApp: App(CounterView::class, Styles::class)

