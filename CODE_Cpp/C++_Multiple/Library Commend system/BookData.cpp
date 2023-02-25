/*** 
 * @Author: hayee
 * @Date: 2022-06-14 16:50:51
 * @LastEditTime: 2022-06-18 11:51:14
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\BookData.cpp
 * @ProgramDescription: 
 * @
 */
#include"BookData.h"

BookData::BookData(){
}
void BookData::bookMenu(){
    MenuMap c;//实例化图书管理系统
    while(1){
        system("cls");
        c.Bookmanager_menu();
        int choice;
        cin >> choice;
        switch(choice){
            case 1:{
            	system("cls");
            	readBookData();
                lookUpBook();
                saveBookData();
                system("pause");
				break;
			}
            case 2:{
            	system("cls");
            	readBookData();
                addBook();
                saveBookData();
                system("pause");
				break;
			}
            case 3:{
            	system("cls");
            	readBookData();
                modifyBook();
                saveBookData();
                system("pause");
				break;
			}
            case 4:{
            	system("cls");
            	readBookData();
                deleteBook();
                saveBookData();
                system("pause");
				break;
			}
            case 5:{
            	system("cls");
            	readBookData();
                modifySaleTax();
                saveBookData();
                system("pause");
				break;
			}
            case 6:{
                return;//返回主菜单
			}
            default:{
            	cout << "输入错误，请重新输入！"<< endl;
                system("pause");
                system("cls");
				break;
			}
        }
    }
}
void BookData::lookUpBook(){//查找某本书的信息
    vector<TitleInfo>::iterator it;//定义迭代器
    cout << "请输入你要查找的书名:" << endl;
    cin >> bookTitle;
    for(it = BookArray.begin();it !=BookArray.end();it++){//遍历书籍信息数组
        if(it->getTitle() == bookTitle){
            cout << "\t\t\t\tFIVESTAR 图书管理系统\n"
                 << "\t\t\t\t\t书的资料\n"
                 << "\t\t\t\tISBN  号："
                 << it->getISBN()
                 << "\n\t\t\t\t书    名: "
                 << it->getTitle()
                 << "\n\t\t\t\t作    者: "
                 << it->getAuthor()
                 << "\n\t\t\t\t出 版 社: "
                 << it->getPub()
                 << "\n\t\t\t\t进书日期: "
                 << it->getDateAdded()
                 << "\n\t\t\t\t库 存 量: "
                 << it->getQty()
                 << "\n\t\t\t\t批 发 价: "
                 << it->getWholesale()
                 << "\n\t\t\t\t零 售 价: "
                 << it->getRetail() << endl;
        }
    }
}
void BookData::addBook(){//添加书籍信息
    cout << "请输入ISBN号：" << endl;
    cin >> isbn;
    cout << "请输入书名：" << endl;
    cin >> bookTitle;
    cout << "请输入作者：" << endl;
    cin >> author;
    cout << "请输入出版社：" << endl;
    cin >> publisher;
    cout << "请输入存储日期：(格式:YYYY-MM-DD)" << endl;
    cin >> dateAdded;
    cout << "请输入库存量：" << endl;
    cin >> qtyOnHand;
    cout << "请输入批发价：" << endl;
    cin >> wholesale;
    cout << "请输入零售价：" << endl;
    cin >> retail;
    BookArray.push_back(TitleInfo(isbn, bookTitle, author, publisher, dateAdded, qtyOnHand, wholesale, retail));//将书籍信息添加到书籍信息数组
}
void BookData::modifyBook(){//修改书籍信息
    cout << "请输入你要修改的图书的ISBN号：" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){//遍历书籍信息数组
        if(it->getISBN() == isbn){//如果找到了相应的ISBN号
            cout << "请输入ISBN号：" << endl;
            cin >> isbn;
            cout << "请输入书名：" << endl;
            cin >> bookTitle;
            cout << "请输入作者：" << endl;
            cin >> author;
            cout << "请输入出版社：" << endl;
            cin >> publisher;
            cout << "请输入存储日期：(格式:YYYY-MM-DD)" << endl;
            cin >> dateAdded;
            cout << "请输入库存量：" << endl;
            cin >> qtyOnHand;
            cout << "请输入批发价：" << endl;
            cin >> wholesale;
            cout << "请输入零售价：" << endl;
            cin >> retail;
            it->setISBN(isbn);
            it->setTitle(bookTitle);
            it->setAuthor(author);
            it->setPub(publisher);
            it->setDateAdded(dateAdded);
            it->setQty(qtyOnHand);
            it->setWholesale(wholesale);
            it->setRetail(retail);
        }
    }
}
void BookData::deleteBook(){
    cout << "请输入你要删除的图书的ISBN号：" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();){//遍历书籍信息数组
		if(it->getISBN() == isbn){
            cout << "请确认是否删除：(Yes/No)" << endl;
            char str[4],*p;
            cin >> str;
            p = strupr(str);
            if(strcmp(p,"YES") == 0){
                it = BookArray.erase(it);//删除相应的书籍信息
            }
        }
        else{
        	++it;
		}
    }
}
void BookData::modifySaleTax(){
    cout << "请输入你要修改的图书的ISBN号：" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){
        if(it->getISBN() == isbn){
            cout << "请输入新的销售税率：(0<saleTax<1)" << endl;
            cin >> saleTax;
            it->setSaleTax(saleTax);
        }
    }
}
void BookData::readBookData(){
    ifstream fin;
    fin.open("BookData.txt");//打开文件
    if(!fin){
        cout << "文件打开失败！" << endl;
        return;
    }
    else{
    	while(fin >> isbn >> bookTitle >> author >> publisher >> dateAdded >> qtyOnHand >> wholesale >> retail){
		BookArray.push_back(TitleInfo(isbn, bookTitle, author, publisher, dateAdded, qtyOnHand, wholesale, retail));//将读取的内容添加到书籍信息数组
        }
	}
    fin.close();
}
void BookData::saveBookData(){
    ofstream fout;
    fout.open("BookData.txt"); //打开文件
    if(!fout){
        cout << "文件打开失败！" << endl;
        return;
    }
    else{
    	vector<TitleInfo>::iterator it;
        for(it = BookArray.begin();it !=BookArray.end();it++){
            fout << it->getISBN() << " " << it->getTitle() << " " << it->getAuthor() 
            << " " << it->getPub() << " " << it->getDateAdded() << " " << it->getQty() 
            << " " << it->getWholesale() << " " << it->getRetail() << endl;//将书籍信息写入文件
        }
    }
    fout.close();
    vector<TitleInfo>().swap(BookArray);//清空书籍信息数组
}
void BookData::printBookData(){
    cout << "ISBN号" << " " << "书名" << " " << "作者" << " " << "出版社" << " " 
    << "进书日期" << " " << "库存量" << " " << "批发价" << " " << "零售价" << endl;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){
        cout << it->getISBN() << " " << it->getTitle() 
        << " " << it->getAuthor() << " " << it->getPub() 
        << " " << it->getDateAdded() << " " << it->getQty() 
        << " " << it->getWholesale() << " " << it->getRetail() << endl;//打印书籍信息
    }
}
void BookData::pifajia(){
    cout << "书名\t批发价\t批发价总和" << endl;//打印表头
    double sum = 0;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++)
    {
        sum = it->getWholesale() * it->getQty();//计算批发价总和
        cout << it->getTitle() << "\t" << it->getWholesale() << "\t" << sum << endl;
    }
}
void BookData::lingshoujia(){
    cout << "书名\t零售价\t零售价总和" << endl;
    double sum = 0;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++)
    {
        sum = it->getRetail() * it->getQty();
        cout << it->getTitle() << "\t" << it->getRetail() << "\t" << sum << endl;
    }
}
//按照库存量从大到小排序列出书籍信息
void BookData::sortByQty(){
    cout << setw(50) << std::left << "书名"<< " " << "库存量" << endl;
    vector<TitleInfo>::iterator pos1,pos2,it;
    for(vector<TitleInfo>::size_type index = 0 ; index <= BookArray.size();index++){//
        pos1 = pos2 = BookArray.begin();
        ++pos2;
        while(pos2 != BookArray.end()){
        	if(pos1->getQty() < pos2->getQty()){
                std::iter_swap(pos1,pos2);
            }
            ++pos1;
            ++pos2;
        }
	}
    for(it = BookArray.begin();it !=BookArray.end();it++){
        cout << setw(50) << std::left << it->getTitle() << " " << it->getQty() << endl;
    }
}
void BookData::sortBysumwholesale(){
	vector<TitleInfo>::iterator pos1,pos2;
    for(vector<TitleInfo>::size_type index = 0 ; index <= BookArray.size();index++){//
        pos1 = pos2 = BookArray.begin();
        ++pos2;
        while(pos2 != BookArray.end()){
        	if((pos1->getQty()) * (pos1->getWholesale()) < (pos2->getQty()) * (pos2->getWholesale())){
                std::iter_swap(pos1,pos2);
            }
            ++pos1;
            ++pos2;
        }
	}
}
void BookData::sortBydateAdded(){
    cout << setw(50) << std::left << "书名"<< " " << "日期" << endl;
    vector<TitleInfo>::iterator pos1,pos2,it;
    for(vector<TitleInfo>::size_type index = 0 ; index <= BookArray.size();index++){//
        pos1 = pos2 = BookArray.begin();
        ++pos2;
        while(pos2 != BookArray.end()){
        	if(pos1->getDateAdded() > pos2->getDateAdded()){
                std::iter_swap(pos1,pos2);
            }
            ++pos1;
            ++pos2;
        }
	}
    for(it = BookArray.begin();it !=BookArray.end();it++){
        cout << setw(50) << std::left << it->getTitle() << " " << it->getDateAdded() << endl;
    }
}
/*void BookData::buyBook(){
	system("cls");
    cout << "请输入你要购买图书的ISBN号：" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){
        if(it->getISBN() == isbn){
        	system("cls");
    		cout << "请输入你要购买的数量：" << endl;
    		cin >> Number;
    		do{
    			cout << "输入错误，请重新输入！" << endl;
                cout << "请输入你要购买的数量：" << endl;
                cin >> Number;
			}while(Number < 1 || it->getQty() < Number);
            it->setQty(it->getQty() - Number);
            name = it->getTitle();
            price = it->getRetail();
            sale = it->getRetail() * Number;//计算销售额
            saleTax = sale * 0.06;//计算销售税
            salemix = sale + saleTax;//计算销售额含税
            
			//salelist booksale[count++] = salelist(name, isbn, Number,price,sale,saleTax,salemix);//添加到销售清单
        }
    }
}*/
