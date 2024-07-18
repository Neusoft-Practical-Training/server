package practice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("provinces")
public class Province {
    private Integer id;
    private String name;
}
