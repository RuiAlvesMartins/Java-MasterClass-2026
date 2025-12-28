package section10.Enums;

public enum BurgerToppings {
    
    MUSTARD,
    PICKLES,
    BACON,
    CHEDDAR,
    TOMATO;
    //  need to add ";" to the end of the list if you need to type more functionalities

    public double getPrice() {
        //  keyword THIS is passing the enum insance (calling this method) itself! 
        return switch (this) {
            case BACON -> 1.5;
            case CHEDDAR -> 1.0;
            default -> 0.0;
        };
    }

    //  ENUMS are CLASSES
    //  we can add FIELDS, METHODS, even CONSTRUCTORS if we want to;

}
