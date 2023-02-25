/*** 
 * @Author: hayee
 * @Date: 2022-06-17 00:39:35
 * @LastEditTime: 2022-06-18 11:54:37
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\Report.cpp
 * @ProgramDescription: 
 * @
 */
#include"Report.h"
#include"MenuMap.h"

void Report::menu(){//报表模块菜单
    MenuMap m;//实例化图书管理系统
    while(1){
        system("cls");
        m.Report_menu();
        int choice;
        cin >> choice;
        switch(choice){
            case 1:{
            	system("cls");
                report1();
                system("pause");
                system("cls");
				break;
			}
            case 2:{
            	system("cls");
                report2();
                system("pause");
                system("cls");
				break;
			}
            case 3:{
            	system("cls");
                report3();
                system("pause");
                system("cls");
				break;
			}
            case 4:{
            	system("cls");
                report4();
                system("pause");
                system("cls");
				break;
			}
            case 5:{
            	system("cls");
                report5();
                system("pause");
                system("cls");
				break;
			}
            case 6:{
            	system("cls");
                report6();
                system("pause");
                system("cls");
				break;
			}
            case 7:{
            	return;//返回主菜单
			}
            default:{
            	cout << "输入错误，请重新输入！" << endl;
                break;
			}
        }
    }
}
void Report::report1()//列出书库所有图书信息
{
    BookData b;//实例化书库管理系统
    b.readBookData();
    b.printBookData();
    b.saveBookData();
}
void Report::report2()//列出书库中所有图书的批发价及批发价总和
{
    BookData c;
    c.readBookData();
    c.pifajia();
    c.saveBookData();
}
void Report::report3()//列出书库中所有图书的零售价及零售价总和
{
    BookData d;
    d.readBookData();
    d.lingshoujia();
    d.saveBookData();
}
void Report::report4()//按照库存量从大到小排序列出书籍信息
{
    BookData e;
    e.readBookData();
    e.sortByQty();
    e.saveBookData();
}
void Report::report5()//按照书的批发价总额从大到小排序列出书籍信息
{
    BookData f;
    f.readBookData();
    f.sortBysumwholesale();
    f.pifajia();
    f.saveBookData();
}
void Report::report6()//按照进书日期从小到大排序列出书籍信息
{
    BookData g;
    g.readBookData();
    g.sortBydateAdded();
    g.saveBookData();
}
