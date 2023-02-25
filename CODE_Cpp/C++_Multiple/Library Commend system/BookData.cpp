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
    MenuMap c;//ʵ����ͼ�����ϵͳ
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
                return;//�������˵�
			}
            default:{
            	cout << "����������������룡"<< endl;
                system("pause");
                system("cls");
				break;
			}
        }
    }
}
void BookData::lookUpBook(){//����ĳ�������Ϣ
    vector<TitleInfo>::iterator it;//���������
    cout << "��������Ҫ���ҵ�����:" << endl;
    cin >> bookTitle;
    for(it = BookArray.begin();it !=BookArray.end();it++){//�����鼮��Ϣ����
        if(it->getTitle() == bookTitle){
            cout << "\t\t\t\tFIVESTAR ͼ�����ϵͳ\n"
                 << "\t\t\t\t\t�������\n"
                 << "\t\t\t\tISBN  �ţ�"
                 << it->getISBN()
                 << "\n\t\t\t\t��    ��: "
                 << it->getTitle()
                 << "\n\t\t\t\t��    ��: "
                 << it->getAuthor()
                 << "\n\t\t\t\t�� �� ��: "
                 << it->getPub()
                 << "\n\t\t\t\t��������: "
                 << it->getDateAdded()
                 << "\n\t\t\t\t�� �� ��: "
                 << it->getQty()
                 << "\n\t\t\t\t�� �� ��: "
                 << it->getWholesale()
                 << "\n\t\t\t\t�� �� ��: "
                 << it->getRetail() << endl;
        }
    }
}
void BookData::addBook(){//����鼮��Ϣ
    cout << "������ISBN�ţ�" << endl;
    cin >> isbn;
    cout << "������������" << endl;
    cin >> bookTitle;
    cout << "���������ߣ�" << endl;
    cin >> author;
    cout << "����������磺" << endl;
    cin >> publisher;
    cout << "������洢���ڣ�(��ʽ:YYYY-MM-DD)" << endl;
    cin >> dateAdded;
    cout << "������������" << endl;
    cin >> qtyOnHand;
    cout << "�����������ۣ�" << endl;
    cin >> wholesale;
    cout << "���������ۼۣ�" << endl;
    cin >> retail;
    BookArray.push_back(TitleInfo(isbn, bookTitle, author, publisher, dateAdded, qtyOnHand, wholesale, retail));//���鼮��Ϣ��ӵ��鼮��Ϣ����
}
void BookData::modifyBook(){//�޸��鼮��Ϣ
    cout << "��������Ҫ�޸ĵ�ͼ���ISBN�ţ�" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){//�����鼮��Ϣ����
        if(it->getISBN() == isbn){//����ҵ�����Ӧ��ISBN��
            cout << "������ISBN�ţ�" << endl;
            cin >> isbn;
            cout << "������������" << endl;
            cin >> bookTitle;
            cout << "���������ߣ�" << endl;
            cin >> author;
            cout << "����������磺" << endl;
            cin >> publisher;
            cout << "������洢���ڣ�(��ʽ:YYYY-MM-DD)" << endl;
            cin >> dateAdded;
            cout << "������������" << endl;
            cin >> qtyOnHand;
            cout << "�����������ۣ�" << endl;
            cin >> wholesale;
            cout << "���������ۼۣ�" << endl;
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
    cout << "��������Ҫɾ����ͼ���ISBN�ţ�" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();){//�����鼮��Ϣ����
		if(it->getISBN() == isbn){
            cout << "��ȷ���Ƿ�ɾ����(Yes/No)" << endl;
            char str[4],*p;
            cin >> str;
            p = strupr(str);
            if(strcmp(p,"YES") == 0){
                it = BookArray.erase(it);//ɾ����Ӧ���鼮��Ϣ
            }
        }
        else{
        	++it;
		}
    }
}
void BookData::modifySaleTax(){
    cout << "��������Ҫ�޸ĵ�ͼ���ISBN�ţ�" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){
        if(it->getISBN() == isbn){
            cout << "�������µ�����˰�ʣ�(0<saleTax<1)" << endl;
            cin >> saleTax;
            it->setSaleTax(saleTax);
        }
    }
}
void BookData::readBookData(){
    ifstream fin;
    fin.open("BookData.txt");//���ļ�
    if(!fin){
        cout << "�ļ���ʧ�ܣ�" << endl;
        return;
    }
    else{
    	while(fin >> isbn >> bookTitle >> author >> publisher >> dateAdded >> qtyOnHand >> wholesale >> retail){
		BookArray.push_back(TitleInfo(isbn, bookTitle, author, publisher, dateAdded, qtyOnHand, wholesale, retail));//����ȡ��������ӵ��鼮��Ϣ����
        }
	}
    fin.close();
}
void BookData::saveBookData(){
    ofstream fout;
    fout.open("BookData.txt"); //���ļ�
    if(!fout){
        cout << "�ļ���ʧ�ܣ�" << endl;
        return;
    }
    else{
    	vector<TitleInfo>::iterator it;
        for(it = BookArray.begin();it !=BookArray.end();it++){
            fout << it->getISBN() << " " << it->getTitle() << " " << it->getAuthor() 
            << " " << it->getPub() << " " << it->getDateAdded() << " " << it->getQty() 
            << " " << it->getWholesale() << " " << it->getRetail() << endl;//���鼮��Ϣд���ļ�
        }
    }
    fout.close();
    vector<TitleInfo>().swap(BookArray);//����鼮��Ϣ����
}
void BookData::printBookData(){
    cout << "ISBN��" << " " << "����" << " " << "����" << " " << "������" << " " 
    << "��������" << " " << "�����" << " " << "������" << " " << "���ۼ�" << endl;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){
        cout << it->getISBN() << " " << it->getTitle() 
        << " " << it->getAuthor() << " " << it->getPub() 
        << " " << it->getDateAdded() << " " << it->getQty() 
        << " " << it->getWholesale() << " " << it->getRetail() << endl;//��ӡ�鼮��Ϣ
    }
}
void BookData::pifajia(){
    cout << "����\t������\t�������ܺ�" << endl;//��ӡ��ͷ
    double sum = 0;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++)
    {
        sum = it->getWholesale() * it->getQty();//�����������ܺ�
        cout << it->getTitle() << "\t" << it->getWholesale() << "\t" << sum << endl;
    }
}
void BookData::lingshoujia(){
    cout << "����\t���ۼ�\t���ۼ��ܺ�" << endl;
    double sum = 0;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++)
    {
        sum = it->getRetail() * it->getQty();
        cout << it->getTitle() << "\t" << it->getRetail() << "\t" << sum << endl;
    }
}
//���տ�����Ӵ�С�����г��鼮��Ϣ
void BookData::sortByQty(){
    cout << setw(50) << std::left << "����"<< " " << "�����" << endl;
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
    cout << setw(50) << std::left << "����"<< " " << "����" << endl;
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
    cout << "��������Ҫ����ͼ���ISBN�ţ�" << endl;
    cin >> isbn;
    vector<TitleInfo>::iterator it;
    for(it = BookArray.begin();it !=BookArray.end();it++){
        if(it->getISBN() == isbn){
        	system("cls");
    		cout << "��������Ҫ�����������" << endl;
    		cin >> Number;
    		do{
    			cout << "����������������룡" << endl;
                cout << "��������Ҫ�����������" << endl;
                cin >> Number;
			}while(Number < 1 || it->getQty() < Number);
            it->setQty(it->getQty() - Number);
            name = it->getTitle();
            price = it->getRetail();
            sale = it->getRetail() * Number;//�������۶�
            saleTax = sale * 0.06;//��������˰
            salemix = sale + saleTax;//�������۶˰
            
			//salelist booksale[count++] = salelist(name, isbn, Number,price,sale,saleTax,salemix);//��ӵ������嵥
        }
    }
}*/
