package logic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Default
@Stateless
@LocalBean
public class Logic implements ILogic {
    public String get() {
        return "Hola Mundo";
    }
}
