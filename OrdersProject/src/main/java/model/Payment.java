package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@JsonRootName("payment")
@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment {

    @JsonProperty("idPayment")
    @XmlElement(name = "idPayment")
    private int idPayment;

    @JsonProperty("method")
    @XmlElement(name = "method")
    private String method;

    public Payment() {}

    public Payment(int idPayment, String method) {
        this.idPayment = idPayment;
        this.method = method;
    }

    @Override
    public String toString() {
        return "Payment: { " +
                "idPayment = " + idPayment +
                ", method = " + method + " }";
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
