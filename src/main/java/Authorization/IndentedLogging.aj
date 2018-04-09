package Authorization;

public abstract aspect IndentedLogging {
    protected int _indentationLevel = 0;
    protected abstract pointcut loggedOperations();
    before() : loggedOperations() {
        _indentationLevel++;
    }
    after() : loggedOperations() {
        _indentationLevel--;
    }
    before() : call(* java.io.PrintStream.println(..))
            && within(IndentedLogging+) {
        for (int i = 0, spaces = _indentationLevel * 4;
             i < spaces; ++i) {
            System.out.print(" ");
        }
    }
}