package tom.springboot.springbootwebapp.domain.monitor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metrics {
    private Integer mem;
    @JsonProperty("mem.free")//这是jackson的注解
    private Integer memfree;


    public Integer getMemfree() {
        return memfree;
    }

    public void setMemfree(Integer memfree) {
        this.memfree = memfree;
    }

    public Integer getMem() {
        return mem;
    }

    public void setMem(Integer mem) {
        this.mem = mem;
    }
}
