package behaviours;

import people.Visitor;

public interface ITicketed {
    public abstract double defaultPrice();
    public abstract double priceFor(Visitor visitor);
}
