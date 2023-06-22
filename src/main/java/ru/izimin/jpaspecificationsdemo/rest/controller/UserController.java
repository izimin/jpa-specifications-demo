package ru.izimin.jpaspecificationsdemo.rest.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.SortDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.izimin.jpaspecificationsdemo.dao.entity.User;
import ru.izimin.jpaspecificationsdemo.dao.specification.UserSpecification;
import ru.izimin.jpaspecificationsdemo.rest.dto.UserDto;
import ru.izimin.jpaspecificationsdemo.rest.dto.UserSearchRequest;
import ru.izimin.jpaspecificationsdemo.rest.dto.common.PageDto;
import ru.izimin.jpaspecificationsdemo.rest.mapper.UserMapper;
import ru.izimin.jpaspecificationsdemo.service.UserService;

@Tag(name = "UserController", description = "API для работы с пользователями")
@RequestMapping("api/v1/users")
@RestController
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Operation(summary = "Поиск пользователей",
            description = "поиск пользователей с фильтрацией по полям и пагинацией (size, page/offset)")
    @GetMapping("/find")
    public ResponseEntity<PageDto<UserDto>> findUsers(UserSearchRequest request,
                                                      @SortDefault(sort = "name") Pageable pageable) {
        Specification<User> specification = UserSpecification.builder()
                .name(request.getName())
                .birthDate(request.getBirthDate())
                .phone(request.getPhone())
                .build()
                .buildSpecification();

        Page<User> userPage = service.findAll(specification, pageable);

        return ResponseEntity.ok(mapper.toPageDto(userPage));
    }
}
