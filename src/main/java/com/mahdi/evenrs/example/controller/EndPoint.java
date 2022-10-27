package com.mahdi.evenrs.example.controller;

import com.mahdi.evenrs.example.model.Setting;
import com.mahdi.evenrs.example.model.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/v1/")
public class EndPoint {

    @Autowired
    SettingRepository settingRepository;

    @PostMapping(path = "/new")
    public @ResponseBody
    String create(HttpServletRequest httpRequest,@RequestParam(value = "name", required = false) String name, // resid digital
                      @RequestParam("value") String value) {
        Setting setting = new Setting();
        setting.setName(name);
        setting.setValue(value);
        settingRepository.save(setting);
        return "ok";
    }

    @PostMapping(path = "/update")
    public @ResponseBody
    String update(HttpServletRequest httpRequest,@RequestParam(value = "id", required = false) String id,@RequestParam(value = "name", required = false) String name, // resid digital
                      @RequestParam("value") String value) {
        Optional<Setting> setting = settingRepository.findById(Long.parseLong(id));
        setting.get().setName(name);
        setting.get().setValue(value);
        settingRepository.save(setting.get());
        return "update";
    }

    @PostMapping(path = "/delete")
    public @ResponseBody
    String delete(HttpServletRequest httpRequest,@RequestParam(value = "id", required = false) String id, // resid digital
                  @RequestParam("value") String value) {
        Optional<Setting> setting = settingRepository.findById(Long.parseLong(id));
        settingRepository.delete(setting.get());
        return "delete";
    }
}
