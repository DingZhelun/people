package com.people.people.dao;

import com.alibaba.fastjson.JSONObject;
import com.people.people.model.People;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleDao {
    @Select("SELECT * FROM people")
    List<People> getPeopleList();

    @Insert("INSERT INTO people(name,state,salary,grade,room,telnum,picture,keywords)VALUES(#{name},#{state},#{salary},#{grade},#{room},#{telnum},#{picture},#{keywords})")
    int addPeople(JSONObject request);

    @Update("UPDATE people SET Name=#{name},State=#{state},Salary=#{salary},Grade=#{grade},Room=#{room},Telnum=#{telnum},Picture=#{picture},Keywords=#{keywords} WHERE Name=#{name}")
    void updatePeople(JSONObject request);

    @Delete("DELETE FROM people WHERE name=#{name}")
    void deletePeople(@Param("name") String name);

    @Select("SELECT * FROM people WHERE Name=#{name}")
    List<People> searchPeople(JSONObject request);
}
