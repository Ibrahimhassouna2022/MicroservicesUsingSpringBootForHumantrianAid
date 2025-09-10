/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Financeservice.Financeservice.financeRepository;

import com.Financeservice.Financeservice.models.Finance;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ABu_Alkhel
 */
public interface FinanceRepository extends JpaRepository<Finance, Long>{
    
}
