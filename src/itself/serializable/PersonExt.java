package itself.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/5 18:14
 * @description： 实现了外部化接口的实体类
 */
public class PersonExt implements Externalizable {

    private Integer id;

    private Integer phoneId;

    private Integer number;

    private String name;

    private Integer classId;

    private Integer age;

    private String address;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(id);
        out.writeInt(phoneId);
        out.writeInt(number);
        out.writeInt(classId);
        out.writeInt(age);

        out.writeUTF(name);
        out.writeUTF(address);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.id = in.readInt();
        this.phoneId = in.readInt();
        this.number = in.readInt();
        this.classId = in.readInt();
        this.age = in.readInt();

        this.name = in.readUTF();
        this.address = in.readUTF();
    }

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
