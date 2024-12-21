package com.lijin.study.springcloud.service.dao.mybatis;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 分页插件
 */
@Component
@Intercepts({@Signature(type = Executor.class, method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query",
                args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PagerInterceptor implements Interceptor {

    private static final Logger log = LoggerFactory.getLogger(PagerInterceptor.class);

    @SuppressWarnings("rawtypes")
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        log.info("执行 PagerInterceptor...");
        // 只拦截selectByExample方法，判断是否需要分页
        if (statement.getId().endsWith("selectByExample") || statement.getId().endsWith("selectByExampleWithBLOBs")) {
            Object parameter = args[1];
            if (parameter instanceof BaseExample example) {
                // 如果需要分页，则添加分页子句
                if (example.isPagination()) {
                    Executor executor = (Executor) invocation.getTarget();
                    RowBounds rowBounds = (RowBounds) args[2];
                    ResultHandler resultHandler = (ResultHandler) args[3];
                    CacheKey cacheKey;
                    BoundSql boundSql;
                    if (args.length == 4) {
                        //4 个参数时
                        boundSql = statement.getBoundSql(parameter);
                        cacheKey = executor.createCacheKey(statement, parameter, rowBounds, boundSql);
                    } else {
                        //6 个参数时
                        cacheKey = (CacheKey) args[4];
                        boundSql = (BoundSql) args[5];
                    }

                    // 添加分页信息
                    String pageSql = boundSql.getSql() + " limit " + example.getStartNum() + " , " + example.getPageSize();
                    BoundSql pageBoundSql = new BoundSql(statement.getConfiguration(), pageSql, boundSql.getParameterMappings(), parameter);

                    List<ParameterMapping> lst = boundSql.getParameterMappings();
                    if (lst != null && !lst.isEmpty()) {
                        for (ParameterMapping pm : lst) {
                            String nm = pm.getProperty();
                            if (boundSql.hasAdditionalParameter(nm)) {
                                pageBoundSql.setAdditionalParameter(nm, boundSql.getAdditionalParameter(nm));
                            }
                        }
                    }

                    return executor.query(statement, parameter, RowBounds.DEFAULT, resultHandler, cacheKey, pageBoundSql);
                }
            }
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        if (o instanceof Executor) {
            return Plugin.wrap(o, this);
        }
        return o;
    }

}