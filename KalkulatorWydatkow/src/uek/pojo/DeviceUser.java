package uek.pojo;

public class DeviceUser {
    private String token;
    private String groupid;
    private double contrib;

    public DeviceUser()
    {}

    public DeviceUser(String token, String groupid, double contrib) {
        this.token = token;
        this.groupid = groupid;
        this.contrib = contrib;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public double getContrib() {
        return contrib;
    }

    public void setContrib(double contrib) {
        this.contrib = contrib;
    }
}
