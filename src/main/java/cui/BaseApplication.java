package cui;

import domain.DomainController;

import java.util.Scanner;

public abstract class BaseApplication {
    protected final DomainController dc;
    protected final Scanner scanner;

    public BaseApplication(DomainController dc, Scanner scanner) {
        this.dc = dc;
        this.scanner = scanner;
    }

    public abstract void start();
}
