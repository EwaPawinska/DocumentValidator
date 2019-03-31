package validator;

public class PolishIDValidator implements Validator{

    @Override
    public Boolean validate(String ducumentID) {
        if(!validateFormat(ducumentID)){
            return null;
        }
        return computeCheckSum(ducumentID) == 0.00;
    }

    public Boolean validateFormat(String document){
        return null;
    }

    public int computeCheckSum(String ducumentID) {
        return -1;
    }
}
