package mybatis;

import model.Category;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("SELECT * FROM category WHERE idCategory = #{idCategory}")
    Category getByID(int id);

    @Select("SELECT * FROM category")
    List<Category> getAll();

    @Insert("INSERT INTO category (name) VALUES (#{name})")
    void insert(Category category);

    @Update("UPDATE category SET name = #{name} WHERE (idCategory = #{idCategory})")
    void update(Category category);

    @Delete("DELETE FROM category WHERE (idCategory = #{idCategory})")
    void delete(Category category);

}
