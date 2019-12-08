package ru.kokovin.callreg.to;

public class CallTo {
    private String fullName;
    private int inbound;
    private int outbound;

    public CallTo(String fullName, int inbound, int outbound) {
        this.fullName = fullName;
        this.inbound = inbound;
        this.outbound = outbound;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getInbound() {
        return inbound;
    }

    public void setInbound(int inbound) {
        this.inbound = inbound;
    }

    public int getOutbound() {
        return outbound;
    }

    public void setOutbound(int outbound) {
        this.outbound = outbound;
    }

    @Override
    public String toString() {
        return "CallTo{" +
                "fullName='" + fullName + '\'' +
                ", inbound=" + inbound +
                ", outbound=" + outbound +
                '}';
    }
}
