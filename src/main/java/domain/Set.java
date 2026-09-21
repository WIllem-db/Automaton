package domain;

public class Set {
    private RepTarget repTarget;

    public void setRepTarget(RepTarget repTarget) {
        this.repTarget = new RepTarget.fixed(12);
    }

    public RepTarget getRepTarget() {
        return repTarget;
    }
}
