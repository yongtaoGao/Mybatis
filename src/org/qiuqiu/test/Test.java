package org.qiuqiu.test;

import java.io.IOException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.SqlMapperException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.qiuqiu.vo.Person;

public class Test {

	public static void main(String[] args) {
		SqlSessionFactory factory = null;
		SqlSession sqlSession=null;
		try {
			/*
			 * 通过实例化一个SqlSessionFactoryBuilder()对象获得一个SqlSessionFactory对象，
			 * 通过factory的实例获得一个SqlSession搬运工，实现对数据库数据的“搬运”
			 */
			//在定义sqlSessionFactory时需要指定MyBatis主配置文件
			 factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("Configuration.xml"));
			 sqlSession = factory.openSession();
			 System.out.println("这里是gyt的调试语句1");
			 
			 Person p = (Person) sqlSession.selectOne("com.qiuqiu.dao.PersonDao.selectUserById", 2);
			 System.out.println("从数据库中查询到的记录的id为："+p.getId());    
			 //System.out.println("这里是gyt的调试语句2");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
}
