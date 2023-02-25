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
	void menu();
    void showmenu();
    double Fox();
	double Bunny();
	double Sloth();
	double hirescore();
    void display();
    void WhetherToMeetTheResultsRequirements();
    void minimenu();
    void WhetherToPartner(hire &c1);
    void operator+(hire &c1);//重载运算符1
};
void hire::menu(){
	cout << "Select a numerical option" << endl;
	cout << "=== menu ===" << endl;
	cout << "1.Fox" << endl;
	cout << "2.Bunny" << endl;
	cout << "3.Sloth" << endl;
	cout << "4.Quit" << endl;
}
void hire::showmenu() {
	int flag = 1;
	while (flag == 1)
	{
		menu();
		int i;
		cin >> i;
		switch(i){
			case 1:
				Fox();
                WhetherToMeetTheResultsRequirements();
                display();
				break;
			case 2:
				Bunny();
                WhetherToMeetTheResultsRequirements();
                display();
				break;
			case 3:
				Sloth();
                WhetherToMeetTheResultsRequirements();
                display();
				break;
			case 4:
				cout << "Good bye!" << endl;
				flag = 0;
				break;
			default:
				cout << "Indvalid option" << endl;
				break;
		}
	}	
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
void hire::display(){
	cout << "agility is" << agi << "," << "strength is " << str << "," << "speed is" << sp << endl;
}
int main()
{
	hire app1;
	app1.showmenu();
	return 0;
}