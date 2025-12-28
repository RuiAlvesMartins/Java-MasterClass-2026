package section7.POJOs;

public record StudentRECORD(String id, String name, String dateOfBirth, String classList) {

    //  RECORD will generate all variables on it's header as PRIVATE and FINAL (a.k.a. COMPONENT FIELDS);
    //  it generates a full CONSTRUCTOR, as well as a no-args constructor;
    //  it generates a TOSTRING();
    //  it generates PUBLIC GETTERS for each field, but the name omits the "get" and it's just the name of the field;
    //  it does NOT generate SETTERS!

}
