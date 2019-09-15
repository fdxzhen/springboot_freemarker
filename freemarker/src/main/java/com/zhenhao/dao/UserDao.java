package com.zhenhao.dao;


import com.zhenhao.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    @Insert("insert into user(name,pwd) values(#{name},#{pwd})")
    public void userRegister(User user);

    @Select("select pwd from user where name=#{name}")
    public String getPwdByName(User user);

}
