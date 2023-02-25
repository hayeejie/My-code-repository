/*** 
 * @Author: hayee
 * @Date: 2022-06-07 16:04:16
 * @LastEditTime: 2022-06-22 22:17:59
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\ZHJ'sZootopia\Question3.cpp
 * @ProgramDescription: 
 * @
 */
#include<iostream>
#include<string>
#include<cmath>
using namespace std;
class hire 
{
private:
	char character;
public:
    hire() {};
    hire(int n);
    hire(char c): character(c) {};
    void operator+(hire &c1);//重载运算符1
    void operator+(int n);//重载运算符2
    operator int() { return character; } //类型转换函数
};
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
void hire::operator + (hire &c1) {  //重载运算符1
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
void hire::operator + (int n){  //重载运算符2
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
int main()
{
	hire appl1('L');
    hire app2(51);
    app2 + appl1;
    appl1 + 10;
    cout << "10+appl1 = " << 10 + appl1 << endl;
	return 0;
}