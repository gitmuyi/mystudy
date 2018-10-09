package com.yyc.security;


import com.yyc.security.config.RedisService;
import com.yyc.security.entity.SysUser;
import com.yyc.security.entity.SysUserExample;
import com.yyc.security.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {

    @Autowired
    private RedisService redisService;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SysUserService sysUserService;

   /* @Test
    public void contextLoads() {
        redisService.set("test", 123);
        Object o = redisService.get("test");
        System.out.println(o);
    }*/

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

        List<SysUser> list = sysUserService.selectByExample(sysUserExample);
        System.out.println(list);
    }

    @Test
    public void testInsert() {

        SysUser sysUser = new SysUser();
        sysUser.setPassword("1112");
        sysUser.setUserName("1562");
        sysUser.setName("1232");
        sysUser.setDeleteFlag("0");
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("cc");
        int i = sysUserService.insert(sysUser);
    }

    @Test
    public void testSelect() {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andIdEqualTo("");
        sysUserService.selectByExample(sysUserExample);
    }
}
