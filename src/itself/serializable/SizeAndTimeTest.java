package itself.serializable;

import java.io.*;

/**
 * @author ：zhenjie.xuan
 * @date ：Created in 2021/7/5 18:13
 * @description：测试序列化大小和时间
 */
public class SizeAndTimeTest {

    private final static String OUTPUT_FILE = "./test.txt";

    private final static String OUTPUT_FILE_SER = "./testSer.txt";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PersonExt personExt = getPersonExt();
        PersonSer personSer = getPersonSer();

        FileOutputStream fileOutputStream
                = new FileOutputStream(OUTPUT_FILE);
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        personExt.writeExternal(objectOutputStream);

        objectOutputStream.flush();
        objectOutputStream.close();
        fileOutputStream.close();

        FileOutputStream fileOutputStream1
                = new FileOutputStream(OUTPUT_FILE_SER);
        ObjectOutputStream objectOutputStream1
                = new ObjectOutputStream(fileOutputStream1);
        objectOutputStream1.writeObject(personSer);

        objectOutputStream1.flush();
        objectOutputStream1.close();
        fileOutputStream1.close();



        File file = new File(OUTPUT_FILE);
        System.out.println(file.length());

        File file1 = new File(OUTPUT_FILE_SER);
        System.out.println(file1.length());
    }

    private static PersonSer getPersonSer() {
        PersonSer personSer =  new PersonSer();
        personSer.setId(1);
        personSer.setName("myName");
        personSer.setAddress("my address: 广东省深圳市");
        personSer.setAge(18);
        personSer.setClassId(12);
        personSer.setNumber(162050);
        personSer.setPhoneId(1831822);

        return personSer;
    }

    private static PersonExt getPersonExt() {
        PersonExt personExt =  new PersonExt();
        personExt.setId(1);
        personExt.setName("myName");
        personExt.setAddress("my address: 广东省深圳市");
        personExt.setAge(18);
        personExt.setClassId(12);
        personExt.setNumber(162050);
        personExt.setPhoneId(1831822);

        return personExt;
    }
}
