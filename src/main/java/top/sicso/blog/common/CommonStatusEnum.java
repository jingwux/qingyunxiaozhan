package top.sicso.blog.common;

public enum CommonStatusEnum {

    AVAILABLE(0),
    DISABLE(1);

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
