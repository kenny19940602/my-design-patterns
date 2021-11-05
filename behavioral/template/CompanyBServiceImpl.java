package behavioral.template;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CompanyBServiceImpl  extends AbstractMerchantService{

    Object hander(Object req){
        return handlerTempPlate(req);
    }
    //公司B是不走代理的
    @Override
    boolean isRequestByProxy(){
        return false;
    }
}
