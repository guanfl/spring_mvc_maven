/**
* ClassName : SerializeProtoBuffVo.java
* Create on ：2016年6月22日
* Copyrights 2016 guanfl All rights reserved.
* Email : guanfl@163.com
*/
package com.spring.mvc.entity.serialized;

import com.google.protobuf.InvalidProtocolBufferException;
import com.spring.mvc.entity.proto.UserVoProto;

public class SerializeProtoBuffVo {
    public static void main(String args[]){
        //UserVoProto.UserVo-->innerClass-->Builder<===>同时继承和实现的都是相同的接口
        //
        UserVoProto.UserVo.Builder builder = UserVoProto.UserVo.newBuilder();
        builder.setName("zhangsan");
        builder.setAge(30);
        builder.setPhone(1375523590);
        
        UserVoProto.UserVo.Builder builder1 = UserVoProto.UserVo.newBuilder();
        builder1.setName("lisi");
        builder1.setAge(12);
        builder1.setPhone(1243675586);
        
        UserVoProto.UserVo.Builder builder2 = UserVoProto.UserVo.newBuilder();
        builder2.setName("wangba");
        builder2.setAge(99999);
        builder2.setPhone(979792286);
        
        
        builder.addFriends(builder2);
        builder.addFriends(builder1);
        
        UserVoProto.UserVo vo = builder.build(); //通过内部类的方式来生成对象
        
        //序列化
        byte[] userbytes = vo.toByteArray();
        int size = vo.getSerializedSize();
        System.out.println("序列化之后的size: " + size);
        
        for(byte b : userbytes){
            System.out.print((char)b);
        }

        //反序列化
        try {
            UserVoProto.UserVo reverseVO = vo.parseFrom(userbytes);
            System.out.println("\n\n" + reverseVO);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
