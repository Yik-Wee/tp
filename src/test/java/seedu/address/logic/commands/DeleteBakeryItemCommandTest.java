package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;

/**
 * Contains unit tests for {@code DeleteBakeryItemCommand}.
 */
public class DeleteBakeryItemCommandTest {

    @Test
    public void equals() {
        DeleteBakeryItemCommand deleteFirstCommand = new DeleteBakeryItemCommand(INDEX_FIRST_PERSON);
        DeleteBakeryItemCommand deleteSecondCommand = new DeleteBakeryItemCommand(INDEX_SECOND_PERSON);

        // same object -> returns true
        assertTrue(deleteFirstCommand.equals(deleteFirstCommand));

        // same values -> returns true
        DeleteBakeryItemCommand deleteFirstCommandCopy = new DeleteBakeryItemCommand(INDEX_FIRST_PERSON);
        assertTrue(deleteFirstCommand.equals(deleteFirstCommandCopy));

        // different types -> returns false
        assertFalse(deleteFirstCommand.equals(1));

        // null -> returns false
        assertFalse(deleteFirstCommand.equals(null));

        // different bakery item -> returns false
        assertFalse(deleteFirstCommand.equals(deleteSecondCommand));
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        DeleteBakeryItemCommand deleteBakeryItemCommand = new DeleteBakeryItemCommand(targetIndex);
        String expected = DeleteBakeryItemCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, deleteBakeryItemCommand.toString());
    }
}
