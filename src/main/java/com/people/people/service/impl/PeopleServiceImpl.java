package com.people.people.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.people.people.dao.PeopleDao;
import com.people.people.model.People;
import com.people.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "PeopleService")
public class PeopleServiceImpl implements PeopleService {
    @Autowired
    private PeopleDao peopleDao;

    @Override
    public JSONObject getPeopleList(int pageNum, int pageSize) {
        JSONObject result = new JSONObject();
        try {
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<People> pageInfo = new PageInfo(peopleDao.getPeopleList());

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query error！");
        }
        return result;
    }

    @Override
    public JSONObject addPeople(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            peopleDao.addPeople(request);
            result.put("code", "0");
            result.put("msg", "operation success！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "add people error!");
        }
        return result;
    }

    @Override
    public JSONObject updatePeople(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            peopleDao.updatePeople(request);
            result.put("code", "0");
            result.put("msg", "operation success！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "update people error!");
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public JSONObject deletePeople(String name) {
        JSONObject result = new JSONObject();
        try {
            peopleDao.deletePeople(name);
            result.put("code", "0");
            result.put("msg", "operation success！");
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "delete people error!");
        }
        return result;
    }

    @Override
    public JSONObject searchPeople(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            int pageNum = request.getInteger("pageNum");
            int pageSize = request.getInteger("pageSize");
            PageHelper.startPage(pageNum, pageSize);
            PageInfo<People> pageInfo = new PageInfo(peopleDao.searchPeople(request));

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query people error!");
        }
        return result;
    }

    public JSONObject searchRoom(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            int pageNum = request.getInteger("pageNum");
            int pageSize = request.getInteger("pageSize");
            PageInfo<People> pageInfo = new PageInfo(peopleDao.searchRoom(request));

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query error！");
        }
        return result;
    }

    public JSONObject searchGrade(JSONObject request) {
        JSONObject result = new JSONObject();
        try {
            int pageNum = request.getInteger("pageNum");
            int pageSize = request.getInteger("pageSize");
            PageInfo<People> pageInfo = new PageInfo(peopleDao.searchGrade(request));

            result.put("code", "0");
            result.put("msg", "operation success！");
            result.put("data", pageInfo.getList());
            result.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            result.put("code", "500");
            result.put("msg", "query error！");
        }
        return result;
    }
}
