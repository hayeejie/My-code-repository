/*** 
 * @Author: hayee
 * @Date: 2022-04-19 18:37:10
 * @LastEditTime: 2022-06-07 14:49:05
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\DongwuYuan\hire.cpp
 * @ProgramDescription: 
 * @千山我独行,不必相送
 */
#include"hire.h"
#include"elite.h"
hire::hire(char c) {
	this->character = c;
}
hire::hire(double agility, double strength, double speed) {
	this->agility = agility;
	this->speed= speed;
	this->strength = strength;
}
void hire::operator +(hire& h1) {
	if ((character == 'l' && h1.character == 'l'))
		cout << "很遗憾，你们不适合组队" << endl;
	else if ((character == 'm' && h1.character == 'm'))
		cout << "不错，你们可以组队" << endl;
	else
		cout << "恭喜，你们是完美搭档！" << endl;
}
void hire::menu() {
	agility = strength = speed = 0;
	cout << "=============" << endl;
	cout << "===1.fox  ===" << endl;
	cout << "===2.bunny===" << endl;
	cout << "===3.sloth===" << endl;
	cout << "=============" << endl;
}
double hire::fox() {
	agility = strength = speed = 0;
	cout << "Enter agility " << endl;
	cin >> agility;
	cout << " Enter strength" << endl;
	cin >> strength;
	cout << "Hire score:" << hirescore() << endl;
	return hirescore();
}
double hire::bunny() {
	agility = strength = speed = 0;
	cout << "Enter agility " << endl;
	cin >> agility;
	cout << " Enter speed" << endl;
	cin >> speed;
	cout << "Hire score:" << hirescore() << endl;
	return hirescore();
}
double hire::sloth() {
	agility = strength = speed = 0;
	cout << "Enter strength " << endl;
	cin >> strength;
	cout << " Enter speed" << endl;
	cin >> speed;
	cout << "Hire score:" << hirescore() << endl;
	return hirescore();
}
void hire::choose1(hire& h) {
	(*this) + h;
}
double hire::hirescore() {
	return 1.0 * agility + 2.16 * strength + 3.24 * speed;
}
void hire::display() {
	cout << "agility is" << agility << "," << "strength is " << strength << "," << "speed is" << speed << endl;
}
