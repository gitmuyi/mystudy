import com.alibaba.fastjson.JSONObject;
import com.yyc.common.entity.Student;
import com.yyc.common.entity.User;
import com.yyc.common.utils.EncryptUtil;
import org.junit.Test;

import java.util.*;

/**
 * @Auther: yangyongcui
 * @Date: 2019/3/9: 14:21
 * @Description:
 */
/*@SpringBootTest
@RunWith(SpringRunner.class)*/
public class MyCommonTest {
    @Test
    public void listCopy() {
        List<User> list = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            User user = new User();
            user.setAge(10);
            Random random = new Random();
            user.setName("我是名称" + random.nextInt(100));
            list.add(user);
        }
        Object clone = ((ArrayList<User>) list).clone();
        System.out.println(clone);
    }

    @Test
    public void test01() {
        String str = "H2JY857900L50000020181019X107";

        String substring = str.substring(str.length() - 4, str.length());
        System.out.println(substring.substring(0, 1));
    }

    @Test
    public void test02() {
        User user = new User();
        user.setName("122");
        user.setAge(15);
        System.out.println(user);
        String s = JSONObject.toJSONString(user);
        EncryptUtil instance = EncryptUtil.getInstance();
        String src = instance.AESencode(s, "8512");
        System.out.println(src);
        String tgt = instance.AESdecode(src, "8512");
        System.out.println(tgt);
      //  User user1 = JSONObject.parseObject(tgt, User.class);
        //System.out.println(user1.getName());
        //C4DC5EDE7E5D271A9BCAE54F87DC03BC982B42041D063A1785765C9BAA4C1A10
    }

}
