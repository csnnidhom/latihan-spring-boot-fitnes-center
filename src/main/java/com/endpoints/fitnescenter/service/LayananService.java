package com.endpoints.fitnescenter.service;

import com.endpoints.fitnescenter.Model.response.MenuResponse;
import com.endpoints.fitnescenter.entity.Layanan;
import org.springframework.stereotype.Service;

@Service
public class LayananService {

    public MenuResponse get_menu(Layanan layanan){
        return MenuResponse.builder()
                .menu_name(layanan.getMenu_name())
                .duration(layanan.getDuration())
                .build();
    }
}
