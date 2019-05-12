package com.virros.department.controllers;

import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.services.DepartmentService;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/departments")
@Api(value = "Департаменты", description = "Контроллер обеспечивает работу с департаментами" )
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "D4 / Просмотр сведений о департаменте по его id.")
    public ResponseEntity<?> getInformationAboutDepartment(@PathVariable Integer id) throws EntityNotFoundException {

        DepartmentDto result = service.getDepartmentDto(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Department not found!")
                );

        return ResponseEntity.ok().body(result);
    }
}
