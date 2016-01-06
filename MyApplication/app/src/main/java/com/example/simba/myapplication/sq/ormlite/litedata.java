package com.example.simba.myapplication.sq.ormlite;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.simba.myapplication.sq.User;
import com.example.simba.myapplication.sq.ormlite.DatabaseHelper;
import com.example.simba.myapplication.recycleview.MainActivity;
import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Simba on 2016/01/05.
 */
public class litedata extends OrmLiteBaseActivity<DatabaseHelper> {

   // private TextView mTextView;
    private RuntimeExceptionDao<User, Integer> mUserDAO;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        mUserDAO = getHelper().getUserDataDao();

       // mTextView = (TextView)findViewById(R.id.message);

        deleteAll();
      //  mTextView.append("\n#######Begin to Insert#########\n");
        insertTest();
        display();
     //   mTextView.append("\n#######Begin to Update#########\n");
        user.setUsername("update");
        update(user);
        display();
      //  mTextView.append("\n#######Begin to Delete#########\n");
        delete("name2");
        display();
      /*  mTextView.append("\n#######Begin to Search#########\n");
        mTextView.append(search("name1").toString());*/
    }

    /**
     * 插入值测试
     */
    private void insertTest()
    {
        for (int i = 0; i < 5; i++)
        {
            user = new User();
            user.setUsername("name" + i);
            user.setPassword("test_pass " + i);
            mUserDAO.createIfNotExists(user);
        }
    }

    /**
     * 更新
     *
     * @param user 待更新的user
     */
    private void update(User user)
    {
        mUserDAO.createOrUpdate(user);
        // mUserDAO.update(user);
    }

    /**
     * 按照指定的id 与 username 删除一项
     *
     * @param
     * @param username
     * @return 删除成功返回true ，失败返回false
     */
    private int delete(String username)
    {
        try
        {
            // 删除指定的信息，类似delete User where 'id' = id ;
            DeleteBuilder<User, Integer> deleteBuilder = mUserDAO.deleteBuilder();
            deleteBuilder.where().eq("username", username);

            return deleteBuilder.delete();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 按照id查询user
     *
     * @param
     * @return
     */
    private User search(String username)
    {
        try
        {
            // 查询的query 返回值是一个列表
            // 类似 select * from User where 'username' = username;
            List<User> users = mUserDAO.queryBuilder().where().eq("username", username).query();
            if (users.size() > 0)
                return users.get(0);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除全部
     */
    private void deleteAll()
    {
        mUserDAO.delete(queryAll());
    }

    /**
     * 查询所有的
     */
    private List<User> queryAll()
    {
        List<User> users = mUserDAO.queryForAll();
        return users;
    }

    /**
     * 显示所有的
     */
    private void display()
    {
        List<User> users = queryAll();
        for (User user : users)
        {
            Log.i("!!!!!!!!!!!!!!!!", "display: "+user.toString());
        }
    }
}
