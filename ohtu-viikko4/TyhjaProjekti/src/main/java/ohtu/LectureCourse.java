/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author cocacoca
 */
public class LectureCourse {
private int week1;
private int week2;
private int week3;
private int week4;
private String name;
private String term;



 public void setWeek1(int value) {
   this.week1 = value;
 }

 public Integer getWeek1() {
   return week1;
 }

 public void setWeek2(int value) {
   this.week2 = value;
 }

 public Integer getWeek2() {
   return week2;
 }

 public void setWeek3(int value) {
   this.week3 = value;
 }

 public Integer getWeek3() {
   return week3;
 }

 public void setWeek4(int value) {
   this.week4 = value;
 }

 public Integer getWeek4() {
   return week4;
 }
 public void setName(String name) {
   this.name = name;
 }

 public String getName() {
   return name;
 }

 public void setTerm(String term) {
   this.term = term;
 }

 public String getTerm() {
   return term;
 }

 @Override
 public String toString() {
   return "Kurssi: " + name + ", " + term;
 }
}
