package com.rc.autoreplyrobots.service;

import com.rc.autoreplyrobots.common.Constant;
import com.rc.autoreplyrobots.dao.CommandDao;
import com.rc.autoreplyrobots.model.Command;
import com.rc.autoreplyrobots.model.CommandContent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName CommandService
 * @Description TODO
 * @Author liux
 * @Date 19-4-11 下午6:12
 * @Version 1.0
 */
public class CommandService {

    /*
     * @Author liux
     * @Description 查询命令列表
     * @Date 19-4-11 下午6:20
     * @param name
     * @param description
     * @return java.util.List<com.rc.autoreplyrobots.model.Command>
     **/
    public List<Command> queryCommands(String name, String description) throws IOException {
        return new CommandDao().queryCommandList(name, description);
    }

    /*
     * @Author liux
     * @Description 删除一条命令
     * @Date 19-4-11 上午9:44
     * @param
     * @return void
     **/
    //TODO 删除相应的 content
    public void deleteOne(String id) throws IOException {
        if (null != id && !"".equals(id)) {
            new CommandDao().deleteOne(Integer.parseInt(id));
        }
    }

    /*
     * @Author liux
     * @Description 删除多条命令
     * @Date 19-4-11 下午1:18
     * @param ids
     * @return void
     **/
    public void deleteBatch(String ids) throws IOException {
        if (null != ids && !"".equals(ids)) {
            List<Integer> idList = new ArrayList<>();
            for (String idStr : ids.split(",")) {
                idList.add(Integer.parseInt(idStr));
            }
            new CommandDao().deleteBatch(idList);
        }
    }

    /*
     * @Author liux
     * @Description 通过指令查询自动回复的内容
     * @Date 19-4-11 下午4:22
     * @param null
     * @return
     **/
    public String queryByName(String name) throws IOException {
        CommandDao commandDao = new CommandDao();
        if (Constant.HELP_COMMAND.equals(name)) {
            List<Command> commands = commandDao.queryCommandList(null, null);
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < commands.size(); i++) {
                if (i != 0) {
                    builder.append("<br/>");
                }
                builder.append("回复[").append(commands.get(i).getName())
                        .append("]可以查看").append(commands.get(i).getDescription());
            }
            return builder.toString();
        }

        //TODO 进行具体随机选择
        List<Command> commands = commandDao.queryCommandList(name, null);
        if (commands.size() > 0) {
            List<CommandContent> commandContents = commands.get(0).getCommandContents();
            int randomIndex = new Random().nextInt(commandContents.size());
            return commandContents.get(randomIndex).getContent();
        }
        return Constant.NO_MATCH_CONTENT;
    }
}