package com.nc.hrm.controller.admin;

import com.nc.hrm.model.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminContractController {
    @Autowired
    ContractService contractService;

    @GetMapping("/admin/contract")
    public String getContracts(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("contracts", contractService.findAll(PageRequest.of(page,5)));
        return "admin/contracts";
    }
}
