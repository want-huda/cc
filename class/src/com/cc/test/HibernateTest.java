package com.cc.test;
import com.cc.pojo.User;
import com.cc.util.HiberanteUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class HibernateTest {
    @Test
    public void insertData(){
        //1、解析hibernate配置文件
        Configuration configuration = new Configuration().configure();

        //2、通过生成的配置对象构建会话工厂
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        //3、通过会话工厂生成会话对象
        Session session = sessionFactory.openSession();

        //4、通过会话对象操作对象，实现数据库操作
        User user = new User();
        user.setUsername("曹文杰");
        user.setPassword("111111");
        user.setAddress("湖北黄石");
        user.setSalary(1.0);
        session.save(user);

        //5、关闭资源
        session.close();
        sessionFactory.close();

    }

    @Test
    //查询数据库中的数据
    public void queryData(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        User user = session.get(User.class,1);
        System.out.println("user信息" + user);
        session.close();
        sessionFactory.close();
    }

    @Test
    //更新数据库中的数据
    public void updataData(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        //开启事务
        Transaction transaction = session.beginTransaction();

        User user= session.get(User.class,1);
        user.setSalary(100000.00);
        session.update(user);

        //提交事务
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    //删除数据库中的数据
    public void deleteData(){
        SessionFactory sessionFactory =HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction =session.beginTransaction();

        User user = session.get(User.class,1);
        session.delete(user);

        transaction.commit();

        session.close();;
        sessionFactory.close();
    }

    @Test
    //瞬时态实体对象：实体对象没有主键值，与session没有关联;对于瞬时态对象，使用saveOrUpdate方法时，执行的是添加操作
    public void testSavwOrUpdate(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

//        User user = new User();
//        user.setUsername("pan123hao");
//        user.setPassword("123123123");
//        user.setAddress("湖北黄石");
//        user.setSalary(234124.51124);
//        session.saveOrUpdate(user);
    //托管态实体对象：实体对象有主键值，与session对象没有关联;对于托管态对象，使用saveOrUpdate方法时，执行的是对已存在id修改操作
        Transaction transaction = session.beginTransaction();

//        User user = new User();
//        user.setUid(1);
//        user.setUsername("pan123");
//        user.setPassword("123123");
//        user.setAddress("湖北黄石");
//        user.setSalary(234124.54);
//        session.saveOrUpdate(user);

    //持久态实体对象：实体对象有主键值，与session对象有关联；对于持久态对象，使用saveOrUpdate方法时，执行的是修改操作
        User user = session.get(User.class,1);
        user.setUsername("曹文杰");

        session.saveOrUpdate(user);

        transaction.commit();

        session.close();
        sessionFactory.close();
    }

 /*   @Test
    public void testCache(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user1 = session.get(User.class,1);
        System.out.println("第一次查询id为1的用户数据" + user1);

        User user2 = session.get(User.class,1);
        System.out.println("第二次查询id为1的用户数据" + user2);

        session.close();
        sessionFactory.close();
    }*/

    @Test
    public void testSaveOrUpdate(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        //瞬时态
        /*User user = new User();
        user.setUsername("caowenjie");
        user.setPassword("123456");
        user.setAddress("湖北黄石");
        user.setSalary(10.22);
        session.saveOrUpdate(user);*/

        //托管态

        /*Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setUid(5);
        user.setUsername("caowenjie");
        user.setPassword("123456");
        user.setAddress("湖北黄石");
        user.setSalary(10.22);
        session.saveOrUpdate(user);

        transaction.commit();*/

        Transaction transaction = session.beginTransaction();
        //持久态
        User user = session.get(User.class, 2);
        user.setUsername("曹文杰");
        session.saveOrUpdate(user);

        transaction.commit();

        session.close();
        sessionFactory.close();

    }
    @Test
    public void testCache(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        User user1 = session.get(User.class, 3);
        System.out.println("第一次查询id 3数据："+user1);

        User user2 = session.get(User.class, 3);
        System.out.println("第二次查询id 3数据："+user2);
    }
    @Test
    public void testTransaction(){
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            sessionFactory = HiberanteUtil.getSessionFactory();
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            User user = session.get(User.class, 2);
            user.setUsername("啊杰");

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }finally {
            if (session != null) {
                session.close();
            }
            if (sessionFactory != null) {
                sessionFactory.close();
            }
        }

    }
    @Test
    public void testQuery(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

       /* Session session = HiberanteUtil.getSession();
        Transaction transaction = session.beginTransaction();

        //查询所有数据
        String hql = "from User";
        Query<User> query = session.createQuery(hql, User.class);
        List<User> userList = query.list();

        transaction.commit();
        for(User user : userList){
            System.out.println(user);
        }*/

        //2.查询字段数据
      /*  String hql = "select username from User";
        Query<String> query = session.createQuery(hql, String.class);
        List<String> username = query.list();
        for (String uesrname : username){
            System.out.println(username);
        }*/

        //3.查询薪资、薪资
        /*String hql = "select username, salary from User";
        Query<Object[]> query = session.createQuery(hql, Object[].class);
        List<Object[]> objects = query.list();
        for(Object[] object : objects){
            System.out.println(object[0]+"===>"+object[1]);
        }*/

        //4.条件查询
        /*String hql = "from User where username = ?0 and address = ?1";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter(0, "曹文杰");
        query.setParameter(1,"黄石");
        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user);
        }*/

        String hql = "from User where username = :username and address = :address";
        Query<User> query = session.createQuery(hql, User.class);
        query.setParameter("username", "曹文杰");
        query.setParameter("address", "黄石");
        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.close();
        sessionFactory.close();
    }
    @Test
    public void testCriteria(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        //查询所有
        /*CriteriaQuery<User> criteriaBuilderQuery = criteriaBuilder.createQuery(User.class);

        Root<User> root = criteriaBuilderQuery.from(User.class);
        Query<User> query = session.createQuery(criteriaBuilderQuery);

        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user);
        }*/

        //查询某个属性
       /* CriteriaQuery<String> criteriaBuilderQuery =  criteriaBuilder.createQuery(String.class);
        Root<User> root = criteriaBuilderQuery.from(User.class);
        criteriaBuilderQuery.select(root.get("username"));
        Query<String> query = session.createQuery(criteriaBuilderQuery);

        List<String> names = query.list();
        for(String name : names){
            System.out.println(name);
        }*/

        CriteriaQuery<User> criteriaBuilderQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaBuilderQuery.from(User.class);
        criteriaBuilderQuery.where(criteriaBuilder.equal(root.get("username"), "曹文杰"));
        Query<User> query = session.createQuery(criteriaBuilderQuery);

        List<User> userList = query.list();
        for(User user : userList){
            System.out.println(user);
        }

        session.close();
        sessionFactory.close();
    }

    @Test
    public void testSQLQuery(){
        SessionFactory sessionFactory = HiberanteUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        /*String sql = "select * from tb_user";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(User.class);
        for (User user : userList){
            System.out.println(user);
        }*/

        String sql = "select * from tb_user where name = ? and addr = ?";
        NativeQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.addEntity(User.class);
        sqlQuery.setParameter(1, "曹文杰");
        sqlQuery.setParameter(2,"黄石");
        List<User> list = sqlQuery.list();
        for (User user : list){
            System.out.println(user);
        }
    }
}
