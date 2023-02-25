/*** 
 * @Author: hayee
 * @Date: 2022-06-07 14:37:12
 * @LastEditTime: 2022-06-07 15:53:58
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\MyDongwuyuan\hire.cpp
 * @ProgramDescription: 
 * @
 */
#include"hire.h"
#include"elite.h"
hire::hire(int n){
	if (n>=0&&n<=50)
		character = 'L';
	else if(n>50&&n<=80)
		character = 'M';
	else if(n>80&&n<=100)
		character = 'H';
	else
	cout << "n必须是不大于100的非负整数" << endl;
}
void hire::menu(){
	cout << "Select a numerical option" << endl;
	cout << "=== menu ===" << endl;
	cout << "1.Fox" << endl;
	cout << "2.Bunny" << endl;
	cout << "3.Sloth" << endl;
	cout << "4.Quit" << endl;
}
double hire::Fox() {
	agi = str = sp = 0;
	cout << "Enter agility:" << endl;
	cin >> agi;
	cout << "Enter strength:" << endl;
	cin >> str;
	hirescore();
	cout << "Hire Score:" << hirescore() << endl;
	return hirescore();
}
double hire::Bunny(){
	agi = str = sp = 0;
	cout << "Enter agility:" << endl;
	cin >> agi;
	cout << "Enter speed:" << endl;
	cin >> sp;
	hirescore();
	cout << "Hire Score:" << hirescore() << endl;
	return hirescore();
}
double hire::Sloth(){
	agi = str = sp = 0;
	cout << "Enter strength:" << endl;
	cin >> str;
	cout << "Enter speed:" << endl;
	cin >> sp;
	hirescore();
	cout << "Hire Score:" << hirescore() << endl;
	return hirescore();
}
double hire::hirescore() {
	return 1.8 * agi + 2.16 * str + 3.24 * sp;
}
void hire::WhetherToMeetTheResultsRequirements() {
	double r = hirescore();
	if (r>31.3)
	{
		cout << "恭喜，你被录用了！" << endl;
		cout << "请选择搭档:" << endl;
		minimenu();
	}
}
void hire::minimenu() {
	int flag = 1;
	while (flag == 1) {
		menu();
		int j;
		hire fox;
		hire bunny;
		hire sloth;
		cout << "请输入搭档的编号:" << endl;
		cin >> j;
    	cout << "请输入你的性格(L/M/H):" << endl;
    	cin >> character;
		switch (j)
		{
			case 1:
				WhetherToPartner(fox);
                flag = 0;
				break;
			case 2:
				WhetherToPartner(bunny);
                flag = 0;
				break;
			case 3:
				WhetherToPartner(sloth);
                flag = 0;
				break;
			case 4:
				cout << "good bye!!" << endl;
				flag = 0;
				break;
			default:
				cout << "Invalid option" << endl;
				break;
		}
	}
}
void hire::WhetherToPartner(hire &c1){
	cout << "请输入搭档的性格(L/M/H):" << endl;
	cin >> c1.character;
	(*this) + c1;
}
void hire::operator + (hire &c1) {
	if (character == 'L' && c1.character == 'L')
	{
		cout << "很遗憾，你们不适合组队" << endl;
	}else if (character == 'M' && c1.character == 'M')
	{
		cout << "不错，你们可以组队" << endl;
	}else
	{
		cout << "恭喜，你们是完美搭档！" << endl;
	}
}
void hire::operator + (int n){
	hire a(n);
	if (character == 'L' && a.character == 'L')
	{
		cout << "很遗憾，你们不适合组队" << endl;
	}else if (character == 'M' && a.character == 'M')
	{
		cout << "不错，你们可以组队" << endl;
	}else
	{
		cout << "恭喜，你们是完美搭档！" << endl;
	}
}
void hire::display(){
	cout << "agility is" << agi << "," << "strength is " << str << "," << "speed is" << sp << endl;
}