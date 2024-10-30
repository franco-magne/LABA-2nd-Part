package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import patterns.proxy.IPayment;
import patterns.proxy.PaymentProxy;
import patterns.strategy.IPaymentStrategy;

@JsonRootName("payment")
@XmlRootElement(name = "payment")
@XmlAccessorType(XmlAccessType.FIELD)
public class Payment implements IPayment {
    private static final Logger logger = LogManager.getLogger(Payment.class);
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

    @Override
    public void processPayment() {
        logger.info("Processing payment with the method: " + method);

        if (method == null || method.isEmpty()) {
            logger.info("Error: Payment method is invalid.");
        } else {
            logger.info("Payment processed successfully with ID: " + idPayment);
        }
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
