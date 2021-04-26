package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lend1 {
    Scanner scanner = new Scanner(System.in);
    List<book> list = new ArrayList<book>();
    public void lendBook(){
        System.out.println("---借出图书---");
        System.out.println("请输入图书名称：");
        String name=scanner.next();
        for(book b:list){
            if (b.getName().equals(name)){
                if (b.isInout()){
                    System.out.println("输入借阅人名称");
                    String lendname=scanner.next();
                    b.setLendName(lendname);
                    b.setInout(false);
                    System.out.println("借阅成功");
                    return;
                }else {
                    System.out.println("已借出，借阅失败");
                }
            }
        }
        System.out.println("查无此书");

    }
}
