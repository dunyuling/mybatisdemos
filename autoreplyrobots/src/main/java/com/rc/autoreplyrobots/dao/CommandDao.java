package com.rc.autoreplyrobots.dao;

import com.rc.autoreplyrobots.db.DBAccess;
import com.rc.autoreplyrobots.model.Command;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName CommandDao
 * @Description 数据库-指令处理类
 * @Author liux
 * @Date 19-4-11 下午5:51
 * @Version 1.0
 */
public class CommandDao {

    /*
     * @Author liux
     * @Description 查询命令列表
     * @Date 19-4-11 下午6:19
     * @param name
     * @param description
     * @return java.util.List<com.rc.autoreplyrobots.model.Command>
     **/
    public List<Command> queryCommandList(String name, String description) throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();

        Command command = new Command();
        command.setName(name);
        command.setDescription(description);

        List<Command> messages = sqlSession.selectList("com.rc.autoreplyrobots.model.Command.queryCommandList", command);
        sqlSession.close();
        return messages;
    }

    /*
     * @Author liux
     * @Description 删除一条命令
     * @Date 19-4-11 下午6:19
     * @param id
     * @return void
     **/
    public void deleteOne(int id) throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();
        sqlSession.delete("com.rc.autoreplyrobots.model.Command.deleteOne", id);
        //必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }


    /*
     * @Author liux
     * @Description 删除多条命令
     * @Date 19-4-11 下午6:18
     * @param idList
     * @return void
     **/
    public void deleteBatch(List<Integer> idList) throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();
        sqlSession.delete("com.rc.autoreplyrobots.model.Command.deleteBatch", idList);
        //必须提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    /*
     * @Author liux
     * @Description 新增一条指令
     * @Date 19-4-11 下午10:49
     * @param
     * @return void
     **/
    public void insertOne() throws IOException {
        Command command = new Command("f", "f desc");
        SqlSession sqlSession = DBAccess.getSqlSession();

        sqlSession.insert("com.rc.autoreplyrobots.model.Command.insert", command);
        //必须提交事务
        sqlSession.commit();

        for (int i = 0; i < 3; i++) {
            new CommandContentDao().insertOne("f" + (i + 1) + " content", command.getId());
        }

        sqlSession.close();
    }
}
