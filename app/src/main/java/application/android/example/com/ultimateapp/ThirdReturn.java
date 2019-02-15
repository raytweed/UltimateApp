package application.android.example.com.ultimateapp;

public class ThirdReturn {
    private   String Xname;
    private  String Xcontact;
    private  String Xemail;
    public  ThirdReturn(String YContact,String Yname,String Yemail){
        Xcontact=YContact;
        Xname=Yname;
        Xemail=Yemail;
    }

    public String getXname() {
        return Xname;
    }

    public String getXcontact() {
        return Xcontact;
    }

    public String getXemail() {
        return Xemail;
    }
}
