package jqchen.dentalforum.data.bean;

/**
 * Created by jqchen on 2016/12/13.
 * Use to
 */
public class PostThemBean {
    private boolean isSelected;
    private String them;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getThem() {
        return them;
    }

    public void setThem(String them) {
        this.them = them;
    }

    public PostThemBean() {

    }
}
