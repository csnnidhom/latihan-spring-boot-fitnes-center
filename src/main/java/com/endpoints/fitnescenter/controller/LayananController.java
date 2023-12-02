package com.endpoints.fitnescenter.controller;

import com.endpoints.fitnescenter.Model.response.MenuResponse;
import com.endpoints.fitnescenter.Model.response.WebResponseSuccess;
import com.endpoints.fitnescenter.entity.Layanan;
import com.endpoints.fitnescenter.repository.LayananRepository;
import com.endpoints.fitnescenter.service.LayananService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LayananController {

    @Autowired
    private LayananRepository layananRepository;

    @Autowired
    private LayananService layananService;

    @GetMapping(
            path = "/api/menu"
    )
    public WebResponseSuccess<MenuResponse> get_menu(Layanan layanan){
        MenuResponse response = layananService.get_menu(layanan);
        return WebResponseSuccess.<MenuResponse>builder().data(response).build();
    }

}
