import com.lsl.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shiliang.li
 * @version 1.0.0
 * @Title: lsl_study
 * @Package PACKAGE_NAME
 * @Description: :
 * @time 2020/3/6 16:18
 */


public class MybatisTest {

    @Test
    public void test01() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        User user = mapper.selectById(1, 18);
//        System.out.println(user.toString());
//        mapper.updateUser(1,20);
        int i = mapper.updateUser1(2, 19);
        System.out.println(i);
    }

    @Test
    public void test02() {
        int[] array = new int[]{1,1,2,2,3,4,4};
        System.out.println(getDoubleInt(array));
    }

    private Integer getDoubleInt(int[] array) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i : array) {
            if (list.contains(i)) {
                return i;
            } else {
                list.add(i);
            }
        }
        return null;
    }

}
