package com.iocs.core.exception;
// try with resource and multi catch block
public class TryWithResource {

    static{
        try{
            throw new Exception();
        }catch (Exception e){

        }
    }

    public static void main(String[] args) {

        try(Resource r = new Resource();){
            r.test();
        }catch (Exception1|Exception2 e) {
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void test() throws Exception1,Exception2{

    }
}
