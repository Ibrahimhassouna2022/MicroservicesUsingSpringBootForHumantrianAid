/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Financeservice.Financeservice.Financeservice;

import com.Financeservice.Financeservice.VO.Beneficiary;
import com.Financeservice.Financeservice.VO.ResponseTemplateVO;
import com.Financeservice.Financeservice.financeRepository.FinanceRepository;
import com.Financeservice.Financeservice.models.Finance;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ABu_Alkhel
 */
@Service
@RequiredArgsConstructor
public class FinanceService {
    private final FinanceRepository repository;
    private final RestTemplate restTemplate;

   public Finance getFinanceById(Long id) {
    return repository.findById(id)
            .orElseThrow(() -> new RuntimeException(" المشروع غير موجود بالرقم: " + id));
}


    public Finance addRecord(Finance record) {
        return repository.save(record);
    }

    public List<Finance> getAllRecords() {
        return repository.findAll();
    }

    public double getAvailableBudget() {
        double income = repository.findAll().stream()
                .filter(r -> r.getType().equalsIgnoreCase("INCOME"))
                .mapToDouble(Finance::getAmount)
                .sum();

        double expenses = repository.findAll().stream()
                .filter(r -> r.getType().equalsIgnoreCase("EXPENSE"))
                .mapToDouble(Finance::getAmount)
                .sum();

        return income - expenses;
    }

    public ResponseTemplateVO getFinanceWithBeneficiary(Long financeId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Finance record = repository.findById(financeId).orElse(null);

        Beneficiary beneficiary = restTemplate.getForObject(
                "http://BENEFICIARYSERVICE/api/beneficiaries/" + financeId,
                Beneficiary.class
        );

        vo.setFinanceRecord(record);
        vo.setBeneficiary(beneficiary);
        return vo;
    }
 public Finance updateRemaining(Finance record) {
     Finance existing = repository.findById(record.getId())
            .orElseThrow(() -> new RuntimeException("المشروع غير موجود"));

     existing.setRemaining(record.getRemaining());

     return repository.save(existing);
}


}