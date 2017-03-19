package com.tolean.elab.business.impl.diagnosis;

import com.tolean.elab.business.api.diagnosis.DiagnosisService;
import com.tolean.elab.commons.profile.DevProfile;
import com.tolean.smssender.response.ResponseStatusDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by Tomasz Kołodziej
 */
@DevProfile
@Slf4j
@Service
public class DiagnosisServiceStubImpl implements DiagnosisService {

    @Override
    public ResponseStatusDetail testSendSms(String mobileNo) {
        log.info("Wiadomosc SMS zostala wyslana na numer " + mobileNo);
        return ResponseStatusDetail.ok();
    }

}
