package mybatis;

import java.io.FileReader;
import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Bootstrap {
	public static void main(String[] args) throws IOException {
		
		System.out.println(Resources.getResourceURL("mybatis.xml").getPath());

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(new FileReader("./src/mybatis/mybatis.xml"));
		SqlSession session=factory.openSession();
		DeviceMapper mapper = session.getMapper(DeviceMapper.class);
		mapper.getALL().forEach((e)->  System.out.println(e.toString()));
		System.out.println(mapper.getClass().getName());
	}

}
