/*** 
 * @Author: hayee
 * @Date: 2022-05-31 16:01:44
 * @LastEditTime: 2022-06-07 15:16:37
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\MyDongwuyuan\elite.h
 * @ProgramDescription: 
 * @千山我独行,不必相送
 */
#pragma once
#include<iostream>
#include<string>
#include<cmath>
#include"hire.h"
using namespace std;
class elite :public hire {
public:
	elite() {};
	elite(double insight, double logic);
	void showmenu();
	void judge();
	void display();
private:
	double insight;
	double logic;
};