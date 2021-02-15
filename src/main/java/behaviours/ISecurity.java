package behaviours;

import people.Visitor;

public interface ISecurity {
    public abstract boolean isAllowedTo(Visitor visitor);
}
