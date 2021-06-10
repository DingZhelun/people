package com.people.people.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public interface PeopleService {
    JSONObject getPeopleList(int pageNum, int pageSize);

    JSONObject addPeople(JSONObject request);

    JSONObject updatePeople(JSONObject request);

    JSONObject deletePeople(String name);

    JSONObject searchPeople(JSONObject request);

    JSONObject searchRoom(JSONObject request);

    JSONObject searchGrade(JSONObject request);
}
