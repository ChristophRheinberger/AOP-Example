package Authorization;

import java.security.BasicPermission;

public class BankingPermission extends BasicPermission {

    public BankingPermission(String name) {
        super(name);
    }

    public BankingPermission(String name, String actions) {
        super(name, actions);
    }
}
