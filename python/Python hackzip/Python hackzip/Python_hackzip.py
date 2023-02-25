#!/usr/bin/python
#coding=utf-8

import zipfile
import threading
import string
import random
import datetime

global i,flag
i = 0
flag = True

def openFile(zFile,password):
    try:
        zFile.extractall(pwd=password)
        print('发现正确的密码:' ,password)
        return password
        flag = False
    except:
        global i
        i=i+1
        print('密码错误第{}次'.format(i))

def main():
    zFile = zipfile.ZipFile('E:\\spss-27\\SPSS 27.zip')
    j=4
    randomPsw = string.ascii_letters + string.digits
    while j <10:
        for pw in range(62**j):
            password = ''.join(random.sample(randomPsw,j))
            print(password)
            if flag is True:
                t = threading.Thread(target=openFile, args=(zFile,password))
                t.start
                t.join
                j = j + 1

if __name__ == '__main__':
    main()