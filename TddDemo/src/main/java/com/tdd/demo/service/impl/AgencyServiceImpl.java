package com.tdd.demo.service.impl;

import com.tdd.demo.entity.Agency;
import com.tdd.demo.service.AgencyService;
import org.springframework.stereotype.Service;

@Service
public class AgencyServiceImpl implements AgencyService {
    @Override
    public Agency findAgencyById(Long id) {
        return new Agency();
    }
}
