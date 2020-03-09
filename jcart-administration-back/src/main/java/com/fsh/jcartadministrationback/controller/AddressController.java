package com.fsh.jcartadministrationback.controller;

import com.fsh.jcartadministrationback.dto.out.AddressListOutDTO;
import com.fsh.jcartadministrationback.dto.out.AddressShowOutDTO;
import com.fsh.jcartadministrationback.po.Address;
import com.fsh.jcartadministrationback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Mr.Blake
 * @create 2020-02-25 22:33
 */
@RestController
@RequestMapping("/address")
public class AddressController {


    @Autowired
    private AddressService addressService;

    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(
            @RequestParam Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public AddressShowOutDTO getById(@RequestParam Integer addressId){

        Address address = addressService.getById(addressId);

        AddressShowOutDTO addressShowOutDTO = new AddressShowOutDTO();
        addressShowOutDTO.setAddressId(address.getAddressId());
        addressShowOutDTO.setReceiverMobile(address.getReceiverMobile());
        addressShowOutDTO.setReceiverName(address.getReceiverName());
        addressShowOutDTO.setContent(address.getContent());
        addressShowOutDTO.setTag(address.getTag());

        return addressShowOutDTO;
    }

}
