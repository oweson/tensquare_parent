package entity;

public class StatusCode {
    /**
     * 1 成功
     */
    public static final int OK = 20000;
    /**
     * 2 失败
     */
    public static final int ERROR = 20001;
    /**
     * 3 用户名或密码错误
     */
    public static final int LOGINERROR = 20002;
    /**
     * 4 权限不足
     */
    public static final int ACCESSERROR = 20003;
    /**
     * 5 远程调用失败
     */
    public static final int REMOTEERROR = 20004;
    /**
     * 6 重复操作
     */
    public static final int REPERROR = 20005;
}
