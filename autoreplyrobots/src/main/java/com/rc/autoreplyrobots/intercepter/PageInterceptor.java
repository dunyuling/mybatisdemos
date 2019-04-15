package com.rc.autoreplyrobots.intercepter;

import com.rc.autoreplyrobots.common.Page;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

/**
 * @ClassName PageInterceptor
 * @Description 分页拦截器类
 * @Author liux
 * @Date 19-4-15 下午2:25
 * @Version 1.0
 */
@Intercepts({@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class,Integer.class})})
public class PageInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();

        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        //配置文件中SQL语句的ID
        String id = mappedStatement.getId();
        if (id.matches(".+ByPage2$")) {
            BoundSql boundSql = statementHandler.getBoundSql();
            //原始SQL语句
            String sql = boundSql.getSql();

            //查询总条数
            String countSql = "select count(*) from (" + sql + ") o";
            Connection connection = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = connection.prepareStatement(countSql);
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            Map<String, Object> parameterMap = (Map<String, Object>) boundSql.getParameterObject();
            Page page = (Page) parameterMap.get("page");
            if (resultSet.next()) {
                page.setTotalNumber(resultSet.getInt(1));
            }

            //改造后带分页语句的查询
            String pageSql = sql + " limit " + page.getDbIndex() + ", " + page.getDbNumber();
            metaObject.setValue("delegate.boundSql.sql", pageSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
