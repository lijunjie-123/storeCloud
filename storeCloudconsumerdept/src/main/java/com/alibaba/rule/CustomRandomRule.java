package com.alibaba.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * Created by wangxy on 20/10/4.
 * 每个轮询4次
 */
public class CustomRandomRule extends AbstractLoadBalancerRule {

    // total=0 当total等于4的时候指针向下走
    // index=0 当前对外提供服务的服务器的地址
    // total 需要重新置为0 但是已经到达4次,index=1
    // 分析:我们4次,但是微服务只有8001 8002 8002 执行到3的时候要拉回重新执行
    private int total = 0; // 总共被调用的次数,目前要求每台调用4次
    private int curentIndex = 0;// 当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }

            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
            int serverCount = allList.size();
            if(serverCount == 0){
                return null;
            }

            //int index = chooseRandomInt(serverCount);
            //server = upList.get(index);
            //自己代码，每个服务调用4次在接着去走下个服务
            if(total<4){
                server = upList.get(curentIndex);
                total++;
            }else{
                total = 0;
                curentIndex++;
                if (curentIndex >= upList.size()) {
                    curentIndex = 0;
                }
            }

            if (server == null) {
                Thread.yield();
                continue;
            }
            if (server.isAlive()) {
                return (server);
            }

            server = null;
            Thread.yield();
        }
        return server;

    }




    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {
        // TODO Auto-generated method stub

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(),key);

    }
}
