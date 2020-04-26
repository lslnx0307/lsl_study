package com.lsl.dao;

import com.lsl.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package com.lsl.dao
 * @Description: :
 * @time 2020/3/6 16:16
 */
@Repository
public interface UserDao {

    @Select("select * from t_user where id= #{id} and age = #{age}")
    User selectById(@Param("id") Integer id, @Param("age") Integer age);

    @Select("update t_user set age = #{age} where id = #{id}")
    void updateUser(@Param("id") Integer id, @Param("age") Integer age);

    @Update("select count(*) from t_user where id= #{id} and age = #{age}")
    int updateUser1(@Param("id") Integer id, @Param("age") Integer age);
}
