#pragma once
#include"TitleInfo.h"
#include"MenuMap.h"
#include<algorithm>
#include<windows.h>
#include<vector>
#define FILENAME "Book.txt"
/*struct salelist{//声明一个结构体类型salelist
	string name;   //声明一个name
	string isbn;
	int Number;     //声明一个整形变量number
	double price;
	double sale;
	double saleTax;
	double salemix;
	salelist() {};
	salelist(string _name, string _isbn, int _Number,double _price,double _sale,double _saleTax,double _salemix) : name(_name), isbn(_isbn),
	Number(_Number), price(_price), sale(_sale), saleTax(_saleTax), salemix(_salemix) {}
}booksale[100];*/
class BookData:public TitleInfo
{
        private:
        	string name;
			string isbn;
			int Number;
			double price;
			double sale;
			double saleTax;
			double salemix;
			int count;
        public:
			//salelist booksale;
            BookData();
            vector<TitleInfo>BookArray;
            void bookMenu();
            void lookUpBook();
            void addBook();
            void modifyBook();
            void deleteBook();
        	void modifySaleTax();
            void readBookData();
            void saveBookData();
            void printBookData();
            void pifajia();
            void lingshoujia();
            void sortByQty();
            void sortBysumwholesale();
            void sortBydateAdded();
            //void buyBook();
            //salelist operator++(int){++count;return count;}
};
