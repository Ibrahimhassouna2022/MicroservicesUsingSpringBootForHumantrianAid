/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Beneficiariesservice.Beneficiariesservice.Beneficiariesserviceservice;

import com.Beneficiariesservice.Beneficiariesservice.VO.Finance;
import com.Beneficiariesservice.Beneficiariesservice.VO.ResponseTemplateVO;
import com.Beneficiariesservice.Beneficiariesservice.models.Beneficiary;
import com.Beneficiariesservice.Beneficiariesservice.repositoryBeneficiries.BeneficiaryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class BeneficiaryService {

    private final BeneficiaryRepository repository;
    private final RestTemplate restTemplate;

    public Beneficiary registerBeneficiary(Beneficiary beneficiary) {

        Finance finance = restTemplate.getForObject(
                "http://FINANCESERVICE/api/finance/" + beneficiary.getFinanceId(),
                Finance.class
        );

        if (finance == null) {
            throw new RuntimeException("  المشروع غير موجود");
        }

        if (finance.getRemaining() <= 0) {
            throw new RuntimeException("  لا يوجد رصيد كافي في المشروع: " + finance.getDescription());
        }
        double costPerBeneficiary = 100;
        finance.setRemaining(finance.getRemaining() - costPerBeneficiary);

        restTemplate.put("http://FINANCESERVICE/api/finance/updateRemaining", finance);

        return repository.save(beneficiary);
    }

    public List<Beneficiary> getAllBeneficiaries() {
        return repository.findAll();
    }

    public Beneficiary getBeneficiary(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ResponseTemplateVO getBeneficiaryWithFinance(Long beneficiaryId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Beneficiary beneficiary = repository.findById(beneficiaryId).orElse(null);

        Finance finance = restTemplate.getForObject(
                "http://FINANCESERVICE/api/finance/budget",
                Finance.class
        );

        vo.setBeneficiary(beneficiary);
        vo.setFinance(finance);
        return vo;
    }
}
