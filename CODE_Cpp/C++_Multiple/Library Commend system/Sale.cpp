/*** 
 * @Author: hayee
 * @Date: 2022-06-16 20:31:27
 * @LastEditTime: 2022-06-18 08:53:13
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\Sale.cpp
 * @ProgramDescription: 
 * @
 */

#include"Sale.h"

Sale::Sale(){
}
/*void Sale::buyBooks(){//购买图书
    BookData book;
    book.readBookData();
    book.buyBook();
    cout << "是否继续购买？(y/n)" << endl;
    char str[2],*p;
    cin >> str;
    p=strupr(str);
    cout << str;
    if(strcmp(p,"Y") == 0){
        buyBooks();
    }
    else
    {
        system("cls");
        cout << "购买完毕！" << endl;
        printReport();//打印购买清单
    }
    book.saveBookData();
}
void Sale::printReport(){
    time_t t = time(0);  // get time now
    char tmp[32];
    strftime(tmp, sizeof(tmp), "%Y年%m月%d日",localtime(&t));//获取当前时间
    cout << "\t\t\t\t销售报告\n" << endl;
    cout << "    日期：" << tmp << endl << endl;//打印日期
    cout << "*****************************************************************************************" << endl;
    cout << setw(16) << std::left << "数量";
    cout << setw(16) << std::left << "ISBN号";
    cout << setw(50) << std::left << "书名";
    cout << setw(18) << std::left << "单价";
    cout << setw(14) << std::left << "金额" << endl;
    for (auto i = 0 ;i < 100 ; i++ ){
        cout << setw(16) << std::left << booksale[i].Number;//数量 
        cout << setw(16) << std::left << booksale[i].isbn;//ISBN号 
        cout << setw(50) << std::left << booksale[i].name << "RMB " ;//书名 
        cout << setw(14) << std::left << booksale[i].price << "RMB " ;//单价 
        cout << setw(14) << std::left << booksale[i].sale << endl;//金额 
    }
    cout << "*****************************************************************************************" << endl;
    cout << "\t\t销售合计：  RMB " << sumsale() << endl;
    cout << "\t\t零售税：    RMB " << sumsaleTax() << endl;
    cout << "\t\t应付总和：  RMB " << sumsaleIncludeTax() << endl;
}
int Sale::sumsale(){
    int sum = 0;
    for(auto i = 0 ;i < 100 ; i++ ){
        sum += booksale[i].sale;
    }
    return sum;
}
int Sale::sumsaleTax(){
    int sum = 0;
    for(auto i = 0 ;i < 100 ; i++ ){
        sum += booksale[i].saleTax;
    }
    return sum;
}
int Sale::sumsaleIncludeTax(){
    int sum = 0;
    for(auto i = 0 ;i < 100 ; i++ ){
        sum += booksale[i].salemix;
    }
    return sum;
}*/
