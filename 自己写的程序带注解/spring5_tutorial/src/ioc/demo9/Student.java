package ioc.demo9;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String[] arrs;

    private List<String> lsts;

    private Map<String,String> maps;

    private Set<String> sets;

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setLsts(List<String> lsts) {
        this.lsts = lsts;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    @Override
    public String toString() {
        return "Student{" +
                "arrs=" + Arrays.toString(arrs) +
                ", lsts=" + lsts +
                ", maps=" + maps +
                ", sets=" + sets +
                '}';
    }
}
