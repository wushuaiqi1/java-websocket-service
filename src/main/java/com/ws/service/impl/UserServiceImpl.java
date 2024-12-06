package com.ws.service.impl;

import com.ws.annotation.LogExecutionTime;
import com.ws.service.IUserService;
import org.springframework.stereotype.Service;

@Service
@LogExecutionTime()
public class UserServiceImpl implements IUserService {
    @Override
    public String getUserNameById(Integer id) {
        return null;
    }
}
