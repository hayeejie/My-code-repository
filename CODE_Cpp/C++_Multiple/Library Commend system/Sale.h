/*** 
 * @Author: hayee
 * @Date: 2022-06-14 15:08:35
 * @LastEditTime: 2022-06-18 00:46:50
 * @LastEditors: hayee
 * @Github: hayeejie
 * @FilePath: \C++_Multiple\Library Commend system\Sale.h
 * @ProgramDescription: 
 * @
 */
#pragma once
#include"BookData.h"
#include"MenuMap.h"
#include <time.h>

class Sale:public BookData
{
    
    public:
        Sale();
        int num;
        void buyBooks();
        int sumsale();
        int sumsaleTax();
        int sumsaleIncludeTax();
        void printReport();
        void readSaleData();
        void saveSaleData();
};
