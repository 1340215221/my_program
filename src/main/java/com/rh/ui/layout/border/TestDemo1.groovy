package com.rh.ui.layout.border

class TestDemo1 {

    public static void main(String[] args) {
        def p = {
            println getUserName()
            def p1 = {
                println getUserName()
            }
            def homen = new Homen()
            p1.delegate = homen
            p1()
        }

        def user = new User()
        p.delegate = user

        p()
    }

    static class User {
        String getUserName() {
            'user'
        }
    }

    static class Homen {
        String getUserName() {
            'homen'
        }
    }

}
