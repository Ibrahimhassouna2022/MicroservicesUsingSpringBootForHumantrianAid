
package com.Beneficiariesservice.Beneficiariesservice.VO;

import com.Beneficiariesservice.Beneficiariesservice.models.Beneficiary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Beneficiary beneficiary;
    private Finance finance;
}
