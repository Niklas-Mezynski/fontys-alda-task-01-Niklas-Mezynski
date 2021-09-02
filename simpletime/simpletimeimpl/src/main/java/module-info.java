module simpletimeimpl {
    requires simpletimeapi;
    uses simpletimeapi.AbstractAPFactory;
    provides simpletimeapi.AbstractAPFactory with simpletime.APFactory;
}
