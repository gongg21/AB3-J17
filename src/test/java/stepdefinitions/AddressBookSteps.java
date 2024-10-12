package stepdefinitions;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddCommand;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains the necessary step execution code for AddingContact.feature feature file.
 */
public class AddressBookSteps {

    private Model model;
    private Model expectedModel;
    @Given("a typical address book")
    public void get_typical_addressBook() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    /**
     * Add new contact with given name and address.
     *
     * @param name
     * @param address
     */
    @When("I add a new contact with the name {string} and address {string}")
    public void add_new_contact(String name, String address) {
        Person newContact = new PersonBuilder().withName(name).withAddress(address).build();
        expectedModel.addPerson(newContact);
    }

    /**
     * Verify new contact with given name and address is added.
     *
     * @param name
     * @param address
     */
    @Then("the address book should contain the added contact {string} with the address {string}")
    public void check_newContact_added(String name, String address) {
        Person newContact = new PersonBuilder().withName(name).withAddress(address).build();
        assertCommandSuccess(new AddCommand(newContact), model,
                String.format(AddCommand.MESSAGE_SUCCESS, Messages.format(newContact)),
                expectedModel);
    }
}
