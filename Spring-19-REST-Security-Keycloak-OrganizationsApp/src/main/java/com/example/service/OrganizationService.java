package com.example.service;

import com.example.model.Organization;

public interface OrganizationService {
    Organization findById(Long organizationId) throws Exception;

    Organization create(Organization organization);

    void delete(Long organizationId);
}
