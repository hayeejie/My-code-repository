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
/*void Sale::buyBooks(){//����ͼ��
    BookData book;
    book.readBookData();
    book.buyBook();
    cout << "�Ƿ��������(y/n)" << endl;
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
        cout << "������ϣ�" << endl;
        printReport();//��ӡ�����嵥
    }
    book.saveBookData();
}
void Sale::printReport(){
    time_t t = time(0);  // get time now
    char tmp[32];
    strftime(tmp, sizeof(tmp), "%Y��%m��%d��",localtime(&t));//��ȡ��ǰʱ��
    cout << "\t\t\t\t���۱���\n" << endl;
    cout << "    ���ڣ�" << tmp << endl << endl;//��ӡ����
    cout << "*****************************************************************************************" << endl;
    cout << setw(16) << std::left << "����";
    cout << setw(16) << std::left << "ISBN��";
    cout << setw(50) << std::left << "����";
    cout << setw(18) << std::left << "����";
    cout << setw(14) << std::left << "���" << endl;
    for (auto i = 0 ;i < 100 ; i++ ){
        cout << setw(16) << std::left << booksale[i].Number;//���� 
        cout << setw(16) << std::left << booksale[i].isbn;//ISBN�� 
        cout << setw(50) << std::left << booksale[i].name << "RMB " ;//���� 
        cout << setw(14) << std::left << booksale[i].price << "RMB " ;//���� 
        cout << setw(14) << std::left << booksale[i].sale << endl;//��� 
    }
    cout << "*****************************************************************************************" << endl;
    cout << "\t\t���ۺϼƣ�  RMB " << sumsale() << endl;
    cout << "\t\t����˰��    RMB " << sumsaleTax() << endl;
    cout << "\t\tӦ���ܺͣ�  RMB " << sumsaleIncludeTax() << endl;
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
