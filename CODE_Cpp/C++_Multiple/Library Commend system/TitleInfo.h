/*** 
 * @Author: hayee
 * @Date: 2022-06-14 15:01:58
 * @LastEditTime: 2022-06-18 10:25:16
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\TitleInfo.h
 * @ProgramDescription: 
 * @
 */
#pragma once
#include<iostream>
#include<fstream>
#include<string>
#include<cstring>
#include<iomanip>
using namespace std;

class TitleInfo{
    protected:
        int qtyOnHand;
        double wholesale;
        double retail;
        double saleTax;
        string isbn;
        string bookTitle;
        string author;
        string publisher;
        string dateAdded;
    public:
        TitleInfo();
        TitleInfo(string newisbn, string newbookTitle, string newauthor, string newpublisher, string newdateAdded, int newqtyOnHand, double newwholesale, double newretail);
        void setTitle(string Title);
        void setAuthor(string Author);
        void setISBN(string ISBN);
        void setPub(string Pub);
        void setDateAdded(string DateAdded);
        void setQty(int Qty);
        void setWholesale(double Wholesale);
        void setRetail(double Retail);
        void setSaleTax(double _SaleTax);
        string getTitle();
        string getAuthor();
        string getISBN();
        string getPub();
        string getDateAdded();
        int getQty();
        double getWholesale();
        double getRetail();
};
