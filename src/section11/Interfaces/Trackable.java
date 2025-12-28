package section11.Interfaces;

public interface Trackable {

    //  Any method in an interface MUST be ABSTRACT!
    //  If you try to give it a method body, it will result in compiler error!
    //          void track() {};            //  compiler error!

    void track();

}
