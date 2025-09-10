/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Beneficiariesservice.Beneficiariesservice.repositoryBeneficiries;

import com.Beneficiariesservice.Beneficiariesservice.models.Beneficiary;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ABu_Alkhel
 */
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long>{
    
}
