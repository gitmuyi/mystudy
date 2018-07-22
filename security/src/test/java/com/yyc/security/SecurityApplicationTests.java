package com.yyc.security;

import com.yyc.security.dao.SysUserMapper;
import com.yyc.security.pojo.SysUser;
import com.yyc.security.pojo.SysUserExample;
import com.yyc.security.redis.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {

    @Autowired
    private RedisService redisService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Test
    public void contextLoads() {
        redisService.set("test", 123);
        Object o = redisService.get("test");
        System.out.println(o);
    }

    @Test
    public void insert() {
        String sql = "insert into  sys_user(id,user_name,password,create_time,create_user)values(SEQ_SYS_USER.NEXTVAL,'测试','123456',sysdate,'创建人')";
        jdbcTemplate.execute(sql);
    }

    @Test
    public void testOracle() {
        String sql = "SELECT * FROM  sys_user";
        List<SysUser> list = jdbcTemplate.query(sql, new SysUserRow());
        System.out.println(list);
    }

    class SysUserRow implements RowMapper {

        @Override
        public Object mapRow(ResultSet resultSet, int i) throws SQLException {
            SysUser user = new SysUser();
            user.setId(resultSet.getString("id"));
            user.setUserName(resultSet.getString("user_name"));
            user.setPassword(resultSet.getString("password"));
            return user;
        }
    }

    @Test
    public void testUser() {
        SysUserExample sysUserExample = new SysUserExample();
        SysUserExample.Criteria criteria = sysUserExample.createCriteria();
        criteria.andCreateTimeIsNull();
        criteria.andDeleteFlagEqualTo((short) 0);

        List<SysUser> list = sysUserMapper.selectByExample(sysUserExample);
        System.out.println(list);
    }
}
