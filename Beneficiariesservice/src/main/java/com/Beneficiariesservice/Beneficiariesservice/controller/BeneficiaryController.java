/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Beneficiariesservice.Beneficiariesservice.controller;

import com.Beneficiariesservice.Beneficiariesservice.Beneficiariesserviceservice.BeneficiaryService;
import com.Beneficiariesservice.Beneficiariesservice.VO.ResponseTemplateVO;
import com.Beneficiariesservice.Beneficiariesservice.models.Beneficiary;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiaryController {
    private final BeneficiaryService service;

    public BeneficiaryController(BeneficiaryService service) {
        this.service = service;
    }

    @PostMapping
    public Beneficiary addBeneficiary(@RequestBody Beneficiary beneficiary) {
        return service.registerBeneficiary(beneficiary);
    }

    @GetMapping
    public List<Beneficiary> getAll() {
        return service.getAllBeneficiaries();
    }

    @GetMapping("/{id}")
    public Beneficiary getOne(@PathVariable Long id) {
        return service.getBeneficiary(id);
    }

    @GetMapping("/{id}/withFinance")
    public ResponseTemplateVO getBeneficiaryWithFinance(@PathVariable Long id) {
        return service.getBeneficiaryWithFinance(id);
    }
}