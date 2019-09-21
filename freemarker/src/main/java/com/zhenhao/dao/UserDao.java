package com.zhenhao.dao;


import com.zhenhao.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Insert("insert into user(name,pwd) values(#{name},#{pwd})")
    public void userRegister(User user);

    @Select("select pwd from user where name=#{name}")
    public String getPwdByName(User user);


    @Select("select * from user")
    public List<User>  getUserList(User user);



    @Select("select * from user where name=#{name}")
    public User getUserByName(String name);


    @Update("update user set imgUrl=#{imgUrl} where name=#{name}")
    public void updateUser(User user);
}
