package com.allianz.example.service;

import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService extends BaseService<SettingEntity, SettingDTO, SettingRequestDTO,
        SettingMapper, SettingEntityRepository> {

    @Autowired
    SettingEntityRepository settingEntityRepository;

    @Autowired
    SettingMapper settingMapper;


    @Override
    protected SettingMapper getMapper() {
        return this.settingMapper;
    }

    @Override
    protected SettingEntityRepository getRepository() {
        return this.settingEntityRepository;
    }
}
