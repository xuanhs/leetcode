package itself.serializable;

import java.io.Serializable;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/5 19:26
 * @description： 序列化
 */
public class PersonSer implements Serializable {
    private Integer id;

    private Integer phoneId;

    private Integer number;

    private String name;

    private Integer classId;

    private Integer age;

    private String address;

    public Integer getId() {
        return id;
    }

    public Integer getPhoneId() {
        return phoneId;
    }

    public Integer getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Integer getClassId() {
        return classId;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhoneId(Integer phoneId) {
        this.phoneId = phoneId;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonExt{" +
                "id=" + id +
                ", phoneId=" + phoneId +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", classId=" + classId +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
