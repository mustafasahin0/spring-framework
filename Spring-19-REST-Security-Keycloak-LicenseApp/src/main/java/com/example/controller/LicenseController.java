package com.example.controller;

import com.example.model.License;
import com.example.service.LicenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/organization/{organizationId}/license")
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("organizationId") Long organizationId, @PathVariable("licenseId") Long licenseId) throws Exception {
        License license = licenseService.getLicense(licenseId, organizationId);
        return ResponseEntity.ok(license);
    }

    @RolesAllowed({"ADMIN", "USER"})
    @PutMapping
    public ResponseEntity<License> updateLicense(@RequestBody License request) {
        return ResponseEntity.ok(licenseService.updateLicense(request));
    }

    @PostMapping
    public ResponseEntity<License> createLicense(@RequestBody License request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(licenseService.createLicense(request));
    }

    @DeleteMapping(value = "/{licenseId}")
    public ResponseEntity<String> deleteLicense(@PathVariable("licenseId") Long licenseId, @PathVariable String organizationId) throws Exception {
        return ResponseEntity.ok(licenseService.deleteLicense(licenseId));
    }

    @GetMapping
    public List<License> getLicenses(@PathVariable("organizationId") Long organizationId) {
        return licenseService.getLicensesByOrganization(organizationId);
    }
}
