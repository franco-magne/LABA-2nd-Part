package mybatis;

import model.Country;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CountryMapper {

    @Select("SELECT * FROM country WHERE idCountry = #{idCountry}")
    Country getByID(int id);

    @Select("SELECT * FROM country")
    List<Country> getAll();

    @Insert("INSERT INTO country (name) VALUES (#{name})")
    void insert(Country country);

    @Update("UPDATE country SET name = #{name} WHERE (idCountry = #{idCountry})")
    void update(Country country);

    @Delete("DELETE FROM country WHERE (idCountry = #{idCountry})")
    void delete(Country country);

}
