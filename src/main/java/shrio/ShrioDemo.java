package shrio;

import javax.sql.DataSource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class ShrioDemo {

	
	@Test
	public void testAuthenticationIniRealm () {

	    IniRealm iniRealm = new IniRealm("classpath:user.ini");

	    DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
	    defaultSecurityManager.setRealm(iniRealm);

	    SecurityUtils.setSecurityManager(defaultSecurityManager);
	    Subject subject = SecurityUtils.getSubject();

	    UsernamePasswordToken token = new UsernamePasswordToken("admin", "123456");
	    subject.login(token);

	    System.out.println("是否认证：" + subject.isAuthenticated());

	    subject.checkRole("admin");
	    subject.checkPermission("user:delete");

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

	    System.out.println("是否认证：" + subject.isAuthenticated());
	}
	
	
	
	
	
}
