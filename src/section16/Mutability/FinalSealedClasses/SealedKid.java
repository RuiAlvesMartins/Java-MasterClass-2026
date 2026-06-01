package section16.Mutability.FinalSealedClasses;

public sealed class SealedKid extends SpecialAbstractClass permits SealedKid.NestedSealedKid  {
    
    public final class NestedSealedKid extends SealedKid {

    }

}
