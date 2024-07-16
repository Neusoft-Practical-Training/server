package practice.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import practice.entity.Admin;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {
}
