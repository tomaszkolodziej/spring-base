package com.tolean.elab.business.impl.diagnosis;

import com.tolean.elab.business.api.diagnosis.DiagnosisService;
import com.tolean.elab.commons.ProdProfile;
import com.tolean.smssender.SmsSender;
import com.tolean.smssender.response.ResponseStatusDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Tomasz Kołodziej
 */
@ProdProfile
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DiagnosisServiceImpl implements DiagnosisService {

    private final SmsSender smsSender;

    @Override
    public ResponseStatusDetail testSendSms(String mobileNo) {
        return smsSender.send("SMS diagnostyczyny - TEST POZYTYWNY", mobileNo);
    }

}
