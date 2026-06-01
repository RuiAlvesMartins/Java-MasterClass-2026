package section16.Mutability.FinalSealedClasses;

public sealed abstract class SpecialAbstractClass permits SpecialAbstractClass.Kid, FinalKid, SealedKid, NonSealedKid {
    
    final class Kid extends SpecialAbstractClass {}

}
