package ru.izimin.jpaspecificationsdemo.rest.mapper;

import org.mapstruct.Mapper;
import ru.izimin.jpaspecificationsdemo.dao.entity.User;
import ru.izimin.jpaspecificationsdemo.rest.dto.UserDto;
import ru.izimin.jpaspecificationsdemo.rest.mapper.common.WebMapper;

@Mapper
public interface UserMapper extends WebMapper<User, UserDto> {
}
