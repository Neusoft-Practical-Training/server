package practice.userservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import practice.entity.GridMember;

@Mapper
public interface GridMemberMapper extends BaseMapper<GridMember> {
}
