package mybatis;

import model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE (idUser = #{idUser})")
    User getByID(int id);

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Insert("INSERT INTO user (firstName, lastName, email, address, phoneNumber, idCountry) VALUES (#{firstName}, " +
            "#{lastName}, #{email}, #{address}, #{phoneNumber}, #{idCountry})")
    void insert(User user);

    @Update("UPDATE user SET firstName = #{firstName}, lastName = #{lastName}, email = #{email}, address = #{address}, " +
            "phoneNumber = #{phoneNumber}, idCountry = #{idCountry} WHERE (idUser = #{idUser})")
    void update(User user);

    @Delete("DELETE FROM user WHERE (idUser = #{idUser})")
    void delete(User user);

}
