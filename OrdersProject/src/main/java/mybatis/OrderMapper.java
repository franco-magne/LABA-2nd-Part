package mybatis;

import model.Order;
import model.Product;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM `e-commerce`.order WHERE (idOrder = #{idOrder})")
    Order getByID(int id);

    @Select("SELECT * FROM `e-commerce`.order")
    List<Order> getAll();

    @Insert("INSERT INTO `e-commerce`.order (idUser, totalPrice, orderDate, idPayment, isPaid) VALUES (#{user.idUser}, #{totalPrice}, " +
            "#{orderDate}, #{payment.idPayment}, #{isPaid})")
    void insert(Order order);

    @Update("UPDATE `e-commerce`.order SET idUser = #{idUser}, totalPrice = #{totalPrice}, orderDate = #{orderDate}, " +
            "idPayment = #{idPayment}, isPaid = #{isPaid} WHERE (idOrder = #{idOrder})")
    void update(Order order);

    @Delete("DELETE FROM `e-commerce`.order WHERE (idOrder = #{idOrder})")
    void delete(Order order);

}
