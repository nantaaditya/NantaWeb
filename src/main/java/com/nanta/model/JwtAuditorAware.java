package com.nanta.model;

import org.springframework.data.domain.AuditorAware;
import org.springframework.util.StringUtils;

import com.nanta.base.Initiator;
import com.nanta.util.Credential;

public class JwtAuditorAware implements AuditorAware<String> {

  @Override
  public String getCurrentAuditor() {
    return StringUtils.isEmpty(Credential.getUsername()) ? Initiator.NAME
        : Credential.getUsername();
  }
}