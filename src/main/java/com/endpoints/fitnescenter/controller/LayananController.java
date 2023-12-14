package com.endpoints.fitnescenter.controller;

import com.endpoints.fitnescenter.Model.request.OrderRequest;
import com.endpoints.fitnescenter.Model.request.TambahPertemuanRequest;
import com.endpoints.fitnescenter.Model.response.OrderResponse;
import com.endpoints.fitnescenter.Model.response.WebResponseSuccess;
import com.endpoints.fitnescenter.entity.MenuLayanan;
import com.endpoints.fitnescenter.entity.OrderPaket;
import com.endpoints.fitnescenter.entity.User;
import com.endpoints.fitnescenter.repository.MenuLayananRepository;
import com.endpoints.fitnescenter.repository.OrderPaketRepository;
import com.endpoints.fitnescenter.service.LayananService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(
        path = "/api/paket"
)
public class LayananController {

    private final OrderPaketRepository orderPaketRepository;

    private final MenuLayananRepository menuLayananRepository;

    private final LayananService layananService;

    @GetMapping
    public List<MenuLayanan> getPaket(){
        return layananService.getPaket();
    }

    @GetMapping(
            path = "/get-order-paket"
    )
    public Optional<OrderPaket> getPaketOrder(User user){
        return layananService.getOrderPaketUser(user);
    }


    @PostMapping(
            path = "/order-paket"
    )
    public WebResponseSuccess<OrderResponse> orderPaket(User user, @RequestBody OrderRequest request){
        OrderResponse orderResponse = layananService.orderPaket(user, request);
        return WebResponseSuccess.<OrderResponse>builder().data(orderResponse).build();
    }

    @PostMapping(
            path = "/tambah-pertemuan"
    )
    public WebResponseSuccess<String> tambahPertemuan(User user, @RequestBody TambahPertemuanRequest request){
        layananService.tambahPertemuan(user, request);
        return WebResponseSuccess.<String>builder().data("Berhasil tambah pertemuan").build();
    }

    @DeleteMapping(
            path = "/hapus-order-tambahan/{idOrder}/{idTambahanPertemuan}"
    )
    public WebResponseSuccess<String> hapusOrder(
                                                    User user,
                                                    @PathVariable(name = "idOrder") String idOrder,
                                                    @PathVariable(name = "idTambahanPertemuan") Integer idTambahanPertemuan){
        layananService.hapusOrderTambahanPertemuan(user, idOrder, idTambahanPertemuan);
        return WebResponseSuccess.<String>builder().data("Menghapus order tambahan pertemuan sukses").build();
    }

    @DeleteMapping(
            path = "/hapus-order-paket/{idOrder}"
    )
    public WebResponseSuccess<String> hapusOrderPaket(User user, @PathVariable(name = "idOrder") String idOrder){
        layananService.hapusOrderPaket(user, idOrder);
        return WebResponseSuccess.<String>builder().data("Menghapus paket order sukses").build();
    }


}
