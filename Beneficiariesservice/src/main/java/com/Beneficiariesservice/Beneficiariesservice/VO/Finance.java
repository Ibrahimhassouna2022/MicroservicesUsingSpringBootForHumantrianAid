/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Beneficiariesservice.Beneficiariesservice.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * @author ABu_Alkhel
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Finance {
    private Long id;
    private String description;
    private double amount;
    private String type;
      private double remaining; 
}

