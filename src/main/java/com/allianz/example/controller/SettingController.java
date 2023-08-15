package com.allianz.example.controller;

import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.service.SettingService;
import com.allianz.example.util.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("setting")
public class SettingController extends BaseController<
        SettingEntity,
        SettingDTO,
        SettingRequestDTO,
        SettingMapper,
        SettingEntityRepository,
        SettingService> {

    @Autowired
    SettingService settingService;

    @Override
    protected SettingService getService() {
        return this.settingService;
    }
}
