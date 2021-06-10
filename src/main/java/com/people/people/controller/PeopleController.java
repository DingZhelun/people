package com.people.people.controller;

import com.alibaba.fastjson.JSONObject;
import com.people.people.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {
    @Autowired
    private PeopleService peopleService;

    @RequestMapping(value = "/peopleList", method = RequestMethod.GET)
    public JSONObject getPeopleList(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {
        return peopleService.getPeopleList(pageNum, pageSize);
    }

    @RequestMapping(value = "/updatePeople", method = RequestMethod.POST)
    public JSONObject updatePeople(@RequestBody JSONObject request) {
        return peopleService.updatePeople(request);
    }

    @RequestMapping(value = "/addPeople", method = RequestMethod.POST)
    public JSONObject addPeople(@RequestBody JSONObject request) {
        return peopleService.addPeople(request);
    }

    @RequestMapping(value = "/deletePeople", method = RequestMethod.GET)
    public JSONObject deletePeople(@RequestParam("name") String name) {
        return peopleService.deletePeople(name);
    }

    @RequestMapping(value = "searchPeople",method = RequestMethod.POST)
    public JSONObject searchPeople(@RequestBody JSONObject request){
        return peopleService.searchPeople(request);
    }

    @RequestMapping(value = "searchRoom",method = RequestMethod.POST)
    public JSONObject searchRoom(@RequestBody JSONObject request){
        return peopleService.searchRoom(request);
    }

    @RequestMapping(value = "searchGrade",method = RequestMethod.POST)
    public JSONObject searchGrade(@RequestBody JSONObject request){
        return peopleService.searchRoom(request);
    }

}
