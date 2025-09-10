/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Financeservice.Financeservice.controller;

import com.Financeservice.Financeservice.Financeservice.FinanceService;
import com.Financeservice.Financeservice.VO.ResponseTemplateVO;
import com.Financeservice.Financeservice.models.Finance;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final FinanceService service;

    public FinanceController(FinanceService service) {
        this.service = service;
    }

    @PostMapping
    public Finance addRecord(@RequestBody Finance record) {
        return service.addRecord(record);
    }

    @GetMapping
    public List<Finance> getAll() {
        return service.getAllRecords();
    }

    @GetMapping("/budget")
    public double getBudget() {
        return service.getAvailableBudget();
    }

    @GetMapping("/{id}")
    public Finance getFinanceById(@PathVariable Long id) {
        return service.getFinanceById(id);
    }

    @PutMapping("/updateRemaining")
    public Finance updateRemaining(@RequestBody Finance record) {
        return service.updateRemaining(record);
    }

    @GetMapping("/{id}/withBeneficiary")
    public ResponseTemplateVO getFinanceWithBeneficiary(@PathVariable Long id) {
        return service.getFinanceWithBeneficiary(id);
    }
}
