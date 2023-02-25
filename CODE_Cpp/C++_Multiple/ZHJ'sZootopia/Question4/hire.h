/*** 
 * @Author: hayee
 * @Date: 2022-05-31 16:01:33
 * @LastEditTime: 2022-06-07 15:10:05
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\MyDongwuyuan\hire.h
 * @ProgramDescription: 
 * @千山我独行,不必相送
 */
#pragma once
#include<iostream>
#include<string>
#include<cmath>
using namespace std;
class hire 
{
private:
	double agi, str, sp;
	char character;
public:
    hire() {};
    hire(int n);
    hire(char c) : character(c){};
	void menu();
    double Fox();
	double Bunny();
	double Sloth();
	double hirescore();
    void minimenu();
	void WhetherToMeetTheResultsRequirements();
	void operator+(hire &c1);//重载运算符1
	void operator+(int n);//重载运算符2
	void WhetherToPartner(hire &c1);
	operator int() { return character; }
    void display();
};