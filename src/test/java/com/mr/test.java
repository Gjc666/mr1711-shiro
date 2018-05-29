package com.mr;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * Created by ${Gjc} on 2018/5/29.
 */
public class test {

    public static void main(String[] args) {
        String password = "666";
        //md5直接加密
        Md5Hash md5Hash = new Md5Hash(password);
        System.out.println(md5Hash);
        //202cb962ac59075b964b07152d234b70:md5一次加密123
        //fae0b27c451c728867a567e8c1bb4e53:md5一次加密666
        //MD5+盐值：加密
        String name = "ls";
        Md5Hash md5 = new Md5Hash(password,name);
        System.out.println(md5);
        //cdc6d1963928d5c349a4eebf11c8b4a5 :zs
        //eabe51b927419df61f1ea47105eebd56 :ls

        //MD5+盐值：加密
        Md5Hash md5hashIterations = new Md5Hash(password,name ,1000 );
        System.out.println(md5hashIterations);
        //a0a7ba6618c7fbda2778303c64fd4803:zs + 123 +1000次
        //fd00b461859cd20bcb4b28263f3c5f98: ls + 666 + 1000
    }
}
