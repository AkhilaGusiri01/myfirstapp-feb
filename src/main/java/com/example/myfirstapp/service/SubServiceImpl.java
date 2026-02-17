package com.example.myfirstapp.service;

import org.springframework.stereotype.Service;
import com.example.myfirstapp.service.interfaces.SubService;

@Service
public class SubServiceImpl implements SubService {

    @Override
    public int sub(int val1, int val2) {
        return val1 - val2;
       
    }
}