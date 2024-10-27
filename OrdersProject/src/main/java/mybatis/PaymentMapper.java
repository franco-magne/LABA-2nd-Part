package mybatis;

import model.Payment;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PaymentMapper {

    @Select("SELECT * FROM payment WHERE (idPayment = #{idPayment}")
    Payment getByID(int id);

    @Select("SELECT * FROM payment")
    List<Payment> getAll();

    @Insert("INSERT INTO payment (method) VALUES (#{method})")
    void insert(Payment payment);

    @Update("UPDATE payment SET method = #{method} WHERE (idPayment = #{idPayment})")
    void update(Payment payment);

    @Delete("DELETE FROM payment WHERE (idPayment = #{idPayment})")
    void delete(Payment payment);

}
