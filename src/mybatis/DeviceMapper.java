package mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
/****
 * Device 数据访问接口
 * 
 * **/
@Mapper
public interface DeviceMapper {
	
	Device getDeviceByID(long id);
	
	List<Device>  getALL();
	List<Map<String,Object>>  getALLByMap();
}
