package servicelayer;

import dao.impl.PaymentDAO;
import model.Payment;

import java.util.List;

public class PaymentService{
    private final PaymentDAO paymentDAO = new PaymentDAO();
    // Logic regarding payments

    public Payment getPayment(int id){
        return paymentDAO.getByID(id);
    }

    public List<Payment> listPayment(){
        return paymentDAO.getAll();
    }

    public void createPayment(int idPayment, String method){
        Payment p = new Payment(idPayment, method);
        paymentDAO.insert(p);
    }

    public void updatePayment(Payment p){
        paymentDAO.update(p);
    }

    public void deletePayment(Payment p){
        paymentDAO.delete(p);
    }
}
