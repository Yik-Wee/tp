package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ITEM_INDEX;
import static seedu.address.logic.parser.CliSyntax.PREFIX_QUANTITY;

import java.util.Objects;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Deadline;
import seedu.address.model.order.Quantity;

/**
 * Represents a parsed request to add a bakery order to a client.
 * Model, storage, and UI integration are deferred; execution reports that limitation without changing data.
 */
public class AddClientOrderCommand extends Command {
    public static final String COMMAND_WORD = "add-order";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an order to a client. "
            + "Parameters: CONTACT_INDEX (positive integer) "
            + PREFIX_ITEM_INDEX + "ITEM_INDEX (positive integer) "
            + PREFIX_QUANTITY + "QUANTITY (1 to 9,999) "
            + PREFIX_DEADLINE + "DEADLINE (YYYY-MM-DD)\n"
            + "Example: " + COMMAND_WORD + " 1 i/2 q/5 d/2026-10-15";
    public static final String MESSAGE_NOT_IMPLEMENTED =
            "Adding client orders is not available yet. No order has been saved.";

    private final Index clientIndex;
    private final Index itemIndex;
    private final Quantity quantity;
    private final Deadline deadline;

    /**
     * Creates a parsed add-order request with validated fields.
     * Indices refer to displayed lists and must be resolved during future model integration.
     */
    public AddClientOrderCommand(Index clientIndex, Index itemIndex, Quantity quantity, Deadline deadline) {
        requireAllNonNull(clientIndex, itemIndex, quantity, deadline);
        this.clientIndex = clientIndex;
        this.itemIndex = itemIndex;
        this.quantity = quantity;
        this.deadline = deadline;
    }

    /**
     * Reports that order execution is unavailable in this parsing increment, without modifying the model.
     *
     * @throws CommandException Always, until model and storage integration are implemented.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        throw new CommandException(MESSAGE_NOT_IMPLEMENTED);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof AddClientOrderCommand otherCommand)) {
            return false;
        }
        return clientIndex.equals(otherCommand.clientIndex)
                && itemIndex.equals(otherCommand.itemIndex)
                && quantity.equals(otherCommand.quantity)
                && deadline.equals(otherCommand.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientIndex.getZeroBased(), itemIndex.getZeroBased(), quantity, deadline);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("clientIndex", clientIndex)
                .add("itemIndex", itemIndex)
                .add("quantity", quantity)
                .add("deadline", deadline)
                .toString();
    }
}
