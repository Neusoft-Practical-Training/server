package practice.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import practice.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
