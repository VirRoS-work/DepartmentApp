package com.virros.department.controllers;

import com.virros.department.model.dto.DepartmentDto;
import com.virros.department.model.dto.DepartmentFondDto;
import com.virros.department.services.DepartmentService;
import com.virros.department.validation.exceptions.EntityNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/departments")
@Api(value = "Департаменты", description = "Контроллер обеспечивает работу с департаментами" )
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation("D3 / Удаление департамента. Удаление возможно, только если в нем нет ни одного сотрудника.")
    public ResponseEntity<?> deleteDepartmentById(@PathVariable Integer id) {

        service.deleteDepartmentById(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "D4 / Просмотр сведений о департаменте по его id.")
    public ResponseEntity<?> getInformationAboutDepartment(@PathVariable Integer id) throws EntityNotFoundException {

        DepartmentDto result = service.getDepartmentDto(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found!"));

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}/sub_departments")
    @ApiOperation(value = "D5 / Предоставление информации о департаментах, находящихся в непосредственном подчинении.")
    public ResponseEntity<?> getInformationAboutSubDepartments(@PathVariable Integer id) throws EntityNotFoundException {

        List<DepartmentDto> result = service.getSubDepartmentsDto(id);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}/sub_departments_all")
    @ApiOperation(value = "D6 / Предоставление информации о всех департаментах, находящихся в подчинении.")
    public ResponseEntity<?> getInformationAboutSubAllDepartments(@PathVariable Integer id) throws EntityNotFoundException {

        List<DepartmentDto> result = service.getSubDepartmentsDtoAll(id);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}/over_department_all")
    @ApiOperation(value = "D8 / Получение информации о всех вышестоящих департаментах данного департамента.")
    public ResponseEntity<?> getInformationAboutOverAllDepartments(@PathVariable Integer id) throws EntityNotFoundException {

        List<DepartmentDto> result = service.getOverDepartmentDtoAll(id);

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/name/{name}")
    @ApiOperation(value = "D9 / Поиск департамента по наименованию.")
    public ResponseEntity<?> getInformationAboutDepartmentByName(@PathVariable String name) throws EntityNotFoundException {

        DepartmentDto result = service.getDepartmentDtoByName(name)
                .orElseThrow(() -> new EntityNotFoundException("Department not found!"));

        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/{id}/fond")
    @ApiOperation(value = "D10 / Получение информации о фонде заработной платы департамента.")
    public ResponseEntity<?> getInformationAbountFondDepartmentById(@PathVariable Integer id) throws EntityNotFoundException {

        DepartmentFondDto result = service.getDepartmentFondDtoById(id)
                .orElseThrow(() -> new EntityNotFoundException("Department not found!"));

        return ResponseEntity.ok().body(result);
    }
}
