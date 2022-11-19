
public class PhoneNumberTaskController {

    PhoneNumberTask usecase = new PhoneNumberTask();

    public boolean passer(int actual_number, String pressed_number){
        int input_number = Integer.parseInt(pressed_number.substring(0,9));
        return(usecase.check_correctness(actual_number, input_number));

    }
}
