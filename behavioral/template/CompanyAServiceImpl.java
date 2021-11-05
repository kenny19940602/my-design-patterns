package behavioral.template;

public abstract  class CompanyAServiceImpl  extends AbstractMerchantService{

    Object hander(Object req){
        return handlerTempPlate(req);
    }

    //走http代理的
    @Override
    boolean isRequestByProxy(){
        return true;
    }


}
