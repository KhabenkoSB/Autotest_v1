public class Calculator {

    public int firstParameter;
    public int secondParameter;

    public Calculator(int firstParameter, int secondParameter) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
    }

    public int getResult(){
        return firstParameter+secondParameter;

    }
}
