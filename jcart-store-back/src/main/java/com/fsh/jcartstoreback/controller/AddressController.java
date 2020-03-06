package com.fsh.jcartstoreback.controller;

import com.fsh.jcartstoreback.dto.in.AddressCreateInDTO;
import com.fsh.jcartstoreback.dto.in.AddressUpdateInDTO;
import com.fsh.jcartstoreback.dto.out.AddressListOutDTO;
import com.fsh.jcartstoreback.po.Address;
import com.fsh.jcartstoreback.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/getAddressByCustomerId")
    public List<AddressListOutDTO> getAddressByCustomerId(@RequestAttribute Integer customerId){

        List<Address> addresses = addressService.getByCustomerId(customerId);

        List<AddressListOutDTO> collect = addresses.stream().map(address -> {
            AddressListOutDTO addressListOutDTO = new AddressListOutDTO();
            addressListOutDTO.setAddressId(address.getAddressId());
            addressListOutDTO.setContent(address.getContent());
            addressListOutDTO.setReceiverName(address.getReceiverName());
            addressListOutDTO.setReceiverMobile(address.getReceiverMobile());
            addressListOutDTO.setContent(address.getContent());
            return addressListOutDTO;
        }).collect(Collectors.toList());

        return collect;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody AddressCreateInDTO addressCreateInDTO,
                          @RequestAttribute Integer customerId){
        Address address = new Address();
        address.setCustomerId(customerId);
        address.setTag(addressCreateInDTO.getTag());
        address.setReceiverMobile(addressCreateInDTO.getReceiverMobile());
        address.setReceiverName(addressCreateInDTO.getReceiverName());
        address.setContent(addressCreateInDTO.getContent());

        addressService.create(address);
        Integer addressId = address.getAddressId();

        return addressId;
    }

    @PostMapping("/update")
    public void update(@RequestBody AddressUpdateInDTO addressUpdateInDTO,
                       @RequestAttribute Integer customerId){
        Address address = new Address();
        address.setAddressId(addressUpdateInDTO.getAddressId());
        address.setReceiverName(addressUpdateInDTO.getReceiverName());
        address.setReceiverMobile(addressUpdateInDTO.getReceiverMobile());
        address.setContent(addressUpdateInDTO.getContent());
        addressService.update(address);
    }

    @PostMapping
    public void delete(@RequestBody Integer addressId){
            addressService.delete(addressId);
    }

}
