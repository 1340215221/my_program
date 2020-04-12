class User {
    Integer age = 1
}

def user1 = {
    Integer age = 1;
}

def user2 = {
    println age
}

user2.delegate = new User()
user2()