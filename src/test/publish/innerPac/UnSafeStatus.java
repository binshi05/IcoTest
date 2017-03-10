package test.publish.innerPac;

/**
 * Created by shibin on 2017/2/24.
 * 作用域 private 只能本class引用
 *        public
 */
public class UnSafeStatus {
    private String[] status = {"OK","RUNNING","STOP"};
    public String[] getStatus(){
        return status;
    }
    private String get0() {
        return status[0];
    }
}
