/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Modelo.Test;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.jgap.InvalidConfigurationException;

/**
 *
 * @author barcelona
 */
@ManagedBean(name="beanTest")
@SessionScoped
public class BeanTest {
Test ts =  new Test();

    public Test getTs() {
        return ts;
    }

    public void setTs(Test ts) {
        this.ts = ts;
    }

public void output(){
ts.getPresentacion();
}
public boolean veer_bool(){
return ts.isVer();

}
}
