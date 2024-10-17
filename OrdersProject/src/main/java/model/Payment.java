package model;

public class Payment {
    private int idPayment;
    private String method;

    public Payment(int idPayment, String method) {
        this.idPayment = idPayment;
        this.method = method;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
