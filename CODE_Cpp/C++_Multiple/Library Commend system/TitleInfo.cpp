/*** 
 * @Author: hayee
 * @Date: 2022-06-16 14:56:06
 * @LastEditTime: 2022-06-18 00:39:38
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\TitleInfo.cpp
 * @ProgramDescription: 
 * @
 */
#include"TitleInfo.h"

TitleInfo::TitleInfo(){
}
void TitleInfo::setTitle(string Title){
    bookTitle = Title;
}
void TitleInfo::setAuthor(string Author){
    author = Author;
}
void TitleInfo::setISBN(string ISBN){
    isbn = ISBN;
}
void TitleInfo::setPub(string Pub){
    publisher = Pub;
}
void TitleInfo::setDateAdded(string DateAdded){
    dateAdded = DateAdded;
}
void TitleInfo::setQty(int Qty){
    qtyOnHand = Qty;
}
void TitleInfo::setWholesale(double Wholesale){
    wholesale = Wholesale;
}
void TitleInfo::setRetail(double Retail){
    retail = Retail;
}
void TitleInfo::setSaleTax(double _SaleTax){
    saleTax = _SaleTax;
}
string TitleInfo::getTitle(){
    return bookTitle;
}
string TitleInfo::getAuthor(){
    return author;
}
string TitleInfo::getISBN(){
    return isbn;
}
string TitleInfo::getPub(){
    return publisher;
}
string TitleInfo::getDateAdded(){
    return dateAdded;
}
int TitleInfo::getQty(){
    return qtyOnHand;
}
double TitleInfo::getWholesale(){
    return wholesale;
}
double TitleInfo::getRetail(){
    return retail;
}
TitleInfo::TitleInfo(string newisbn,string newbookTitle,string newauthor,string newpublisher,string newdateAdded,int newqtyOnHand,double newwholesale,double newretail)
{
    isbn = newisbn;
    bookTitle = newbookTitle;
    author = newauthor;
    publisher = newpublisher;
    dateAdded = newdateAdded;
    qtyOnHand = newqtyOnHand;
    wholesale = newwholesale;
    retail = newretail;
    saleTax = 0.06;
}
