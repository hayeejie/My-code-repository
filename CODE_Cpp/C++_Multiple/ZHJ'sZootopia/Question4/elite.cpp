/*** 
 * @Author: hayee
 * @Date: 2022-05-31 16:01:58
 * @LastEditTime: 2022-06-07 15:33:04
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\MyDongwuyuan\elite.cpp
 * @ProgramDescription: 
 * @千山我独行,不必相送
 */
#include"elite.h"
#include"hire.h"
elite::elite(double insight, double logic){
    this->insight = insight;
    this->logic = logic;
}
void elite::showmenu() {
    insight = logic = 0;
	int flag = 1;
	while (flag == 1)
	{
		menu();
		int i;
		cin >> i;
		switch(i){
			case 1:
				Fox();
				hire::display();
				WhetherToMeetTheResultsRequirements();
                judge();
                display();
                flag = 0;
				break;
			case 2:
				Bunny();
				hire::display();
				WhetherToMeetTheResultsRequirements();
                judge();
                display();
                flag = 0;
				break;
			case 3:
				Sloth();
				hire::display();
				WhetherToMeetTheResultsRequirements();
                judge();
                display();
                flag = 0;
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
void elite::judge() {
	while (true) {
		cout << "insight:" << endl;
		cin >> insight;
		cout << "logic:" << endl;
		cin >> logic;
		if ((insight < 0 || insight > 100) || (logic < 0 || logic > 100)) {
			cout << "Invalid values" << endl;
			break;
		}
		else if (insight >= 95 && logic >= 95) {
			cout << "Congratulations! Welcome to join our elite team!" << endl;
			break;
		}
		else {
			cout << "Unfortunately, you are not fit to our elite team." << endl;
			break;
		}
	}
}
void elite::display(){
	cout << "insight is" << insight << "," << "logic is " << logic << endl;
}