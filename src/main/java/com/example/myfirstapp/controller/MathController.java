package com.example.myfirstapp.controller;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myfirstapp.service.interfaces.AddService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MathController {

    private final AddService addService;
    private final ApplicationContext applicationContext;

    @PostConstruct
    public void init() {
        log.info("MathController.init() called. Controller instance: {}", this);
        log.info("MathController.init()=====start");

        printBeans();

        log.info("MathController.init()=====ended");
    }

    @GetMapping("/add")
    public int addGet(@RequestParam int val1, @RequestParam int val2) {
        log.info("Received request to /add with val1={} and val2={}", val1, val2);

        int result = addService.add(val1, val2);

        log.info("Computed add({}, {}) = {}", val1, val2, result);
        return result;
    }

    public void printBeans() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

        log.info("Beans in the application context:");
        for (String beanName : beanNames) {
            log.info(beanName);
        }
    }
}
