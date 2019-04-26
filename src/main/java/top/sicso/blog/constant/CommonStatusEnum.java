package top.sicso.blog.constant;

public enum CommonStatusEnum {

    ZERO(0),
    ONE(1);

    private int resourceStatus;
    private String resourceStatusValue;

    CommonStatusEnum(int resourceStatus) {
        this.resourceStatus = resourceStatus;
    }

    public int getResourceStatus() {
        return resourceStatus;
    }


    public String getResourceStatusValue() {
        return resourceStatusValue;
    }

}
