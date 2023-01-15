package ru.kata.spring.boot_security.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;

   @Column(name = "name")
   private String name;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "age")
   private int age;

   @Column(name = "email")
   private String email;

   @Column(name = "password")
   private String password;
   @ManyToMany(cascade = CascadeType.ALL)
   @JoinTable(
           name = "user_role"
           , joinColumns = @JoinColumn(name = "user_id")
           , inverseJoinColumns = @JoinColumn(name = "role_id")
   )
   private List<Role> roles;



   public User() {}

   public User(String name, String lastName, int age, String email, String password) {
      this.name = name;
      this.lastName = lastName;
      this.age = age;
      this.email = email;
      this.password = password;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      this.age = age;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public List<Role> getRoles() {
      return roles;
   }

   public void setRoles(List<Role> roles) {
      this.roles = roles;
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", lastName='" + lastName + '\'' +
              ", age=" + age +
              ", email='" + email + '\'' +
              ", password='" + password + '\'' +
              '}';
   }
   public void addRoleToUser(Role role) {
      if(roles==null) {
         roles = new ArrayList<>();
      }
      roles.add(role);
   }

}

