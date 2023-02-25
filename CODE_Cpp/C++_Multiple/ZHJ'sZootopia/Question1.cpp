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
                display();
				break;
			case 2:
				Bunny();
                display();
				break;
			case 3:
				Sloth();
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
int main()
{
	hire app1;
	app1.showmenu();
	return 0;
}