package mybatis;

import model.Store;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface StoreMapper {

    @Select("SELECT * FROM store WHERE (idStore = #{idStore})")
    Store getByID(int id);

    @Select("SELECT * FROM store")
    List<Store> getAll();

    @Insert("INSERT INTO store (name, address, reputation, idCountry) VALUES (#{name}, #{address}, #{reputation}, #{country.idCountry})")
    void insert(Store store);

    @Update("UPDATE store SET name = #{name}, address = #{address}, reputation = #{reputation}, idCountry = #{country.idCountry} " +
            "WHERE (idStore = #{idStore})")
    void update(Store store);

    @Delete("DELETE FROM store WHERE (idStore = #{idStore})")
    void delete(Store store);

}
