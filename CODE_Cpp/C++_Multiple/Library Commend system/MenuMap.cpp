/*** 
 * @Author: hayee
 * @Date: 2022-06-18 11:41:16
 * @LastEditTime: 2022-06-18 12:09:47
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\MenuMap.cpp
 * @ProgramDescription: 
 * @
 */
#include"MenuMap.h"

void MenuMap::main_menu(){
    cout << "HAYEE 图书管理系统" << endl;
    cout << "主菜单" << endl;
    cout << "1.收银模块" << endl;
    cout << "2.书库管理模块" << endl;
    cout << "3.报表模块" << endl;
    cout << "4.退出系统" << endl;
    cout << "输入选择(1-4):" << endl;
}
void MenuMap::Bookmanager_menu(){
    cout << "HAYEE 图书管理系统" << endl;
    cout << "书库管理模块" << endl;
    cout << "1.查找某本书的信息" << endl;
    cout << "2.增加书" << endl;
    cout << "3.修改书的信息" << endl;
    cout << "4.删除书" << endl;
    cout << "5.修改书的销售税率" << endl;
    cout << "6.退出系统" << endl;
    cout << "输入选择(1-6):" << endl;
}
void MenuMap::Report_menu(){
    cout << "HAYEE 图书管理系统" << endl;
    cout << "报表模块" << endl;
    cout << "1.书库列表" << endl;
    cout << "2.批发价列表" << endl;
    cout << "3.零售价列表" << endl;
    cout << "4.按书的数量列表" << endl;
    cout << "5.按书的价值额列表" << endl;
    cout << "6.按进书日期列表" << endl;
    cout << "7.退出系统" << endl;
    cout << "输入选择(1-7):" << endl;
}
