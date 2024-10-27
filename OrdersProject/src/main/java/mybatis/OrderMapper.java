package mybatis;

import model.Order;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface OrderMapper {

    @Select("SELECT * FROM order WHERE (idOrder = #{idOrder})")
    Order getByID(int id);

    @Select("SELECT * FROM order")
    List<Order> getAll();

    @Insert("INSERT INTO order (idUser, totalPrice, orderDate, idPayment, isPaid) VALUES (#{idUser}, #{totalPrice}, " +
            "#{orderDate}, #{idPayment}, #{isPaid})")
    void insert(Order order);

    @Update("UPDATE order SET idUser = #{idUser}, totalPrice = #{totalPrice}, orderDate = #{orderDate}, " +
            "idPayment = #{idPayment}, isPaid = #{isPaid} WHERE (idOrder = #{idOrder})")
    void update(Order order);

    @Delete("DELETE FROM order WHERE (idOrder = #{idOrder})")
    void delete(Order order);

}
