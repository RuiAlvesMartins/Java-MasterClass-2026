package section16.FinalSealedClasses;

public sealed class SealedKid extends SpecialAbstractClass permits SealedKid.NestedSealedKid  {
    
    public final class NestedSealedKid extends SealedKid {

    }

}
