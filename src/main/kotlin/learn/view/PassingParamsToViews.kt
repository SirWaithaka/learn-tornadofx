package learn.view

import tornadofx.*


/**
 * This example shows how we can pass parameters to views. The demonstration here is the use
 * of the find function to pass params to another view that might want to work on some data
 * from another view.
 *
 * Here we have the main view that a user interacts with and a button click opens a fragment
 * view that should display some information from the main view. Should allow the fragment view
 * to edit a customer.
 */

class PassingParamsToViews : View("Passing Parameters to Views") {

    override val root = vbox {

        val customer = Customer("Jane Doe")

        button("Edit") {
            action {
                editCustomer(customer)
            }
        }

    }

    private fun editCustomer(customer: Customer) {
        find<CustomerEditor>(mapOf(CustomerEditor::customer to customer)).openWindow()
    }
}


class CustomerEditor : Fragment() {
    // lazily loaded, so it could be null.
    val customer: Customer by param()

    override val root = label("Customer name ${customer.name}")
}

data class Customer(
    val name: String
)
