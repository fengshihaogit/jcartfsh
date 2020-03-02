package com.fsh.jcartstoreback.controller;


import at.favre.lib.crypto.bcrypt.BCrypt;
import com.fsh.jcartstoreback.constant.ClientExceptionConstant;
import com.fsh.jcartstoreback.dto.in.*;
import com.fsh.jcartstoreback.dto.out.CustomerGetProfileOutDTO;
import com.fsh.jcartstoreback.dto.out.CustomerLoginOutDTO;
import com.fsh.jcartstoreback.exception.ClientException;
import com.fsh.jcartstoreback.po.Customer;
import com.fsh.jcartstoreback.service.CustomerService;
import com.fsh.jcartstoreback.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public Integer register(@RequestBody CustomerRegisterInDTO customerRegisterInDTO){

        Integer register = customerService.register(customerRegisterInDTO);

        return register;
    }

    @GetMapping("/login")
    public CustomerLoginOutDTO login (CustomerLoginInDTO customerLoginInDTO) throws ClientException {

        Customer customer = customerService.getByUsername(customerLoginInDTO.getUsername());
        if(customer == null){
            throw new ClientException(ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRCODE, ClientExceptionConstant.CUSTOMER_USERNAME_NOT_EXIST_ERRMSG);
        }

        String password = customer.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerLoginInDTO.getPassword().toCharArray(), password);

        if (result.verified){
            CustomerLoginOutDTO customerLoginOutDTO = jwtUtil.issueToken(customer);
            return customerLoginOutDTO;
        }else {
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }

    }

    @GetMapping("/getProfile")
    public CustomerGetProfileOutDTO getProfile(@RequestAttribute Integer customerId){

        Customer customer = customerService.getById(customerId);
        CustomerGetProfileOutDTO customerGetProfileOutDTO = new CustomerGetProfileOutDTO();
        customerGetProfileOutDTO.setCustomerId(customer.getCustomerId());
        customerGetProfileOutDTO.setUsername(customer.getUsername());
        customerGetProfileOutDTO.setRealName(customer.getRealName());
        customerGetProfileOutDTO.setMobile(customer.getMobile());
        customerGetProfileOutDTO.setEmail(customer.getEmail());
        customerGetProfileOutDTO.setEmailVerified(customer.getEmailVerified());
        return customerGetProfileOutDTO;
    }

    @PostMapping("/updateProfile")
    public void updateProfile(@RequestBody CustomerUpdateProfileInDTO customerUpdateProfileInDTO,
                              @RequestAttribute Integer customerId){

        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setRealName(customerUpdateProfileInDTO.getRealName());
        customer.setMobile(customerUpdateProfileInDTO.getMobile());
        customer.setEmail(customerUpdateProfileInDTO.getEmail());
        customerService.update(customer);
    }

    @PostMapping("/changePwd")
    public void changePwd(@RequestBody CustomerChangePwdInDTO customerChangePwdInDTO,
                          @RequestAttribute Integer customerId) throws ClientException {

        Customer serviceById = customerService.getById(customerId);
        String encPwdDB = serviceById.getEncryptedPassword();
        BCrypt.Result result = BCrypt.verifyer().verify(customerChangePwdInDTO.getOriginPwd().toCharArray(), encPwdDB);

        if(result.verified){
            String newPwd = customerChangePwdInDTO.getNewPwd();
            String bcryHashString = BCrypt.withDefaults().hashToString(12, newPwd.toCharArray());
            serviceById.setEncryptedPassword(bcryHashString);
            customerService.update(serviceById);
        }else{
            throw new ClientException(ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRCODE, ClientExceptionConstant.CUSTOMER_PASSWORD_INVALID_ERRMSG);
        }


    }

    @GetMapping("/getPwdResetCode")
    public String getPwdResetCode(@RequestParam String email){
        return null;
    }

    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody CustomerResetPwdInDTO customerResetPwdInDTO){

    }



}
