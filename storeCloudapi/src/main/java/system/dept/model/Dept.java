package system.dept.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * Created by wangxy on 19/12/24.
 */

@SuppressWarnings("serial")//压下警告
@AllArgsConstructor //全参数的构造函数
@NoArgsConstructor //空参数的构造函数
@Accessors(chain = true) //现在流行的链式访问的风格
public class Dept implements Serializable {

    // 主键
    private String id;
    // 名称
    private String name;

    // 来自哪个数据库,因为微服务架构可以一个服务连接独立的一个数据库
    // 同一个消息可以存储到不同的数据库中
    private String dbSource;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDbSource() {
        return dbSource;
    }

    public void setDbSource(String dbSource) {
        this.dbSource = dbSource;
    }
}
