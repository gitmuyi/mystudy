import com.yyc.common.entity.User;
import com.yyc.common.entity.User1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

        String substring = str.substring(str.length()-4, str.length());
        System.out.println(substring.substring(0,1));
    }
}
