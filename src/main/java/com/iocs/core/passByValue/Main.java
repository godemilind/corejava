package com.iocs.core.passByValue;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.method1();
    }

    public void method1(){
        Integer i = 1;
        Email email = new Email("Message");
        method2(email);
        System.out.println(email);
    }

    public void method2(Email email){
        email.setMessage("Updated Message");
    }

    class Email{
        private String message;

        private Integer messageCount;

        public Email(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "Email{" +
                    "message='" + message + '\'' +
                    '}';
        }
    }

}
