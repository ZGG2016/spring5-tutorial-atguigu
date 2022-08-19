package ioc.demo12;

public class MyCommonBean {
    private String commonName;

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    @Override
    public String toString() {
        return "MyCommonBean{" +
                "commonName='" + commonName + '\'' +
                '}';
    }
}
