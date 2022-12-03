public class Complex {
    private double re, im;
    public void setRe (double re){
        this.re=re;
    }
    public double getRe(){
        return re;
    }
    public void setIm (double im){
        this.im=im;
    }
    public double getIm(){
        return im;
    }
    public Complex(){}                       // конструктор по умолчанию
    public Complex (double re, double im){   // конструктор с 2мя параментрами
        this.re=re;
        this.im=im;
    }
    public double mod(){
        return Math.sqrt(Math.pow(re,2)+Math.pow(im, 2));
    }
    public double arg(){
        return Math.atan2(re, im);
    }
    public void operationsum(double newRe, double newIm){re+=newRe; im+=newIm;}
    public void operationsub(double newRe, double newIm){re-=2*newRe; im-=2*newIm;}
    public String toString() {
        return re + " " + im;
    }
}
