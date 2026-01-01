package christmas.service;

public class Validator {
    public void validateDateNumber(String date){
        try {
            int num = Integer.parseInt(date);

            if (!(num >= 1 && num <= 31)){
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }


}
