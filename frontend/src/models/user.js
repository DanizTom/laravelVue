export default class User {
  constructor(username, email, password,firstname,lastname,age,usertype, usertypeProfile) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.firstname=firstname;
    this.lastname=lastname;
    this.age=age;
    this.usertype=usertype;
    this.usertypeProfile=usertypeProfile;
  }
}
