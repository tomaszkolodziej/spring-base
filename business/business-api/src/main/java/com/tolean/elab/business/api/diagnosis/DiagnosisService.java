package com.tolean.elab.business.api.diagnosis;

import com.tolean.smssender.response.ResponseStatusDetail;

/**
 * Created by Tomasz Kołodziej
 */
public interface DiagnosisService {

    ResponseStatusDetail testSendSms(String mobileNo);

}
