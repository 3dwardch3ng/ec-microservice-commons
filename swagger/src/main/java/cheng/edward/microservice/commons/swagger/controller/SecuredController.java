package cheng.edward.microservice.commons.swagger.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@SecurityRequirement(name = "Authentication Token")
public interface SecuredController {
}
