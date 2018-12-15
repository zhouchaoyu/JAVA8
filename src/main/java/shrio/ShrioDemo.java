package shrio;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.junit.jupiter.api.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j()
public class ShrioDemo {

	
	@Test
	@SneakyThrows
	public void testAuthenticationIniRealm () {

	    IniRealm iniRealm = new IniRealm("classpath:user.ini");
	    
	    //设置安全管理器
	    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
	    //设置验证域
	    defaultSecurityManager.setRealm(iniRealm);
	    
	    
	    SecurityUtils.setSecurityManager(defaultSecurityManager);
	    Subject subject = SecurityUtils.getSubject();//可以通过工具类获取验证主体
	    

	    UsernamePasswordToken token = new UsernamePasswordToken("chaoyu", "123456");
	    subject.login(token);
	    log.info("登录成功。。" + subject.isAuthenticated());
	    PrincipalCollection principals = subject.getPrincipals();
	    log.info(subject.getClass().getName());
	    principals.asList().forEach(e -> log.info(e.toString()));
	    log.info(subject.hasRole("admin")==true?"有权限":"没有权限");
	    subject.checkRole("admin");
	    subject.checkPermission("user:delete");
	    log.info("运行到这里了");
	    
	    
	    

	}
	
	
	//@Test
	public void testAuthenticationCustomSQL() {

	    JdbcRealm jdbcRealm = new JdbcRealm();
	    DataSource druidDataSource = null;
		jdbcRealm.setDataSource(druidDataSource);
	    jdbcRealm.setPermissionsLookupEnabled(true);

	    /**
	     * @see org.apache.shiro.realm.jdbc.JdbcRealm
	     */
	    String sql = "select pwd from t_user where user_name = ?";
	    jdbcRealm.setAuthenticationQuery(sql);

	    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
	    defaultSecurityManager.setRealm(jdbcRealm);

	    SecurityUtils.setSecurityManager(defaultSecurityManager);
	    Subject subject = SecurityUtils.getSubject();

	    UsernamePasswordToken token = new UsernamePasswordToken("test", "123");
	    subject.login(token);

	    System.out.println("�Ƿ���֤��" + subject.isAuthenticated());
	}
	
	
	
	
	
}
