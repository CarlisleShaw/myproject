package com.example.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.myproject.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM users WHERE u_id = #{id};")
    User findById(int id);

    @Select("SELECT * FROM users WHERE u_name = #{name};")
    User findByName(String name);

    @Select("set @var1=(SELECT COUNT(*) FROM users)+1;insert into users (u_id,u_name,u_passwd) values(@var1,#{name},#{passwd});")
    void insert(String name, String passwd);

    @Select("exists (select * from users where u_name=#{name});")
    Boolean IsNameExist(String name);

}