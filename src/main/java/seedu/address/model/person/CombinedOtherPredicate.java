package seedu.address.model.person;

import java.util.function.Predicate;

/**
 * Combines the predicates to allow SetPredicate to be called
 */
public class CombinedOtherPredicate implements Predicate<Person> {

    private final Predicate<Person> predicate1;
    private final OtherListPredicate otherListPredicate;

    public CombinedOtherPredicate(Predicate<Person> predicate, OtherListPredicate otherListPredicate) {
        this.predicate1 = predicate;
        this.otherListPredicate = otherListPredicate;
    }

    @Override
    public boolean test(Person person) {
        if (predicate1.test(person) && otherListPredicate.test(person)) {
            return true;
        }
        return false;
    }
}
