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

void Report::menu(){//����ģ��˵�
    MenuMap m;//ʵ����ͼ�����ϵͳ
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
            	return;//�������˵�
			}
            default:{
            	cout << "����������������룡" << endl;
                break;
			}
        }
    }
}
void Report::report1()//�г��������ͼ����Ϣ
{
    BookData b;//ʵ����������ϵͳ
    b.readBookData();
    b.printBookData();
    b.saveBookData();
}
void Report::report2()//�г����������ͼ��������ۼ��������ܺ�
{
    BookData c;
    c.readBookData();
    c.pifajia();
    c.saveBookData();
}
void Report::report3()//�г����������ͼ������ۼۼ����ۼ��ܺ�
{
    BookData d;
    d.readBookData();
    d.lingshoujia();
    d.saveBookData();
}
void Report::report4()//���տ�����Ӵ�С�����г��鼮��Ϣ
{
    BookData e;
    e.readBookData();
    e.sortByQty();
    e.saveBookData();
}
void Report::report5()//��������������ܶ�Ӵ�С�����г��鼮��Ϣ
{
    BookData f;
    f.readBookData();
    f.sortBysumwholesale();
    f.pifajia();
    f.saveBookData();
}
void Report::report6()//���ս������ڴ�С���������г��鼮��Ϣ
{
    BookData g;
    g.readBookData();
    g.sortBydateAdded();
    g.saveBookData();
}
