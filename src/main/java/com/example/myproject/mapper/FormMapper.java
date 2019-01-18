package com.example.myproject.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.example.myproject.model.Form;

import java.util.*;
import java.util.ArrayList;

@Mapper
public interface FormMapper {

    @Select("SELECT * FROM forms WHERE f_id = #{id};")
    Form findById(int id);

    @Select("SELECT * FROM forms WHERE f_uid = #{id};")
    ArrayList<Form> findByUserId(int id);
    // @Select("SELECT * FROM users WHERE u_name = #{name};")
    // User findByName(String name);

    // @Select("set @var1=(SELECT COUNT(*) FROM users)+1;insert into users (u_id,u_name,u_passwd) values(@var1,#{name},#{passwd});")
    // void insert(String name, String passwd);

    // @Select("exists (select * from users where u_name=#{name});")
    // Boolean IsNameExist(String name);

}