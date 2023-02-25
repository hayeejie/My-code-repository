/*** 
 * @Author: hayee
 * @Date: 2022-06-14 14:29:27
 * @LastEditTime: 2022-06-18 11:57:18
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\main.cpp
 * @ProgramDescription: 
 * @
 */
#include"TitleInfo.h"
#include"MenuMap.h"
#include"BookData.h"
#include"Report.h"
#include"Sale.h"


int main()
{
    MenuMap menuMap;
    Sale s;
    BookData a;
    Report r;
    int flag=1;
    while(flag){
        menuMap.main_menu();
        int choice;
        cin >> choice;
        switch(choice){
            case 1:{
            	system("cls");
                //s.buyBooks();
                system("pause");
                system("cls");
				break;
			}
                
            case 2:{
            	system("cls");
                a.bookMenu();
                system("pause");
                system("cls");
                break;
			}
                
            case 3:{
            	system("cls");
                r.menu();
                system("pause");
                system("cls");
				break;
			}
            case 4:{
            	system("cls");
                cout << "退出系统" << endl;
                return 0;
			}
            default:{
            	cout << "输入错误，请重新输入！" << endl;
				break;
			}
        }
    }
    return 0;
}
