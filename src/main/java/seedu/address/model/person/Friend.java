package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents the list of friends that a user can have
 */
public class Friend {

    public static final String MESSAGE_CONSTRAINTS = "Friend names must be one of the persons in the list.";
    public final Name friendName;

    public Friend(Name friendName) {
        requireNonNull(friendName);
        this.friendName = friendName;
    }

    public Name getFriendName() {
        return friendName;
    }

    @Override
    public String toString() {
        return friendName.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Friend // instanceof handles nulls
                && friendName.equals(((Friend) other).friendName)); // state check
    }

    @Override
    public int hashCode() {
        return friendName.hashCode();
    }
}
