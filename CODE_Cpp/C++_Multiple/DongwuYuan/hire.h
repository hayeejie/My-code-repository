/*** 
 * @Author: hayee
 * @Date: 2022-04-19 18:27:04
 * @LastEditTime: 2022-06-07 14:55:01
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\DongwuYuan\hire.h
 * @ProgramDescription: 
 * @千山我独行,不必相送
 */
#pragma once
#include<iostream>
using namespace std;

class hire {
public:
	hire() {};
	hire(char c);
	hire(double agility, double strength, double speed);
	void menu();
	void choose1(hire& h);
	double fox();
	double bunny();
	double sloth();
	void operator +(hire& h1);
	double hirescore();
	void display();
private:
	double agility = 0; 
	double strength = 0; 
	double speed = 0;
	char character;
};