package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class revise1 {
    Scanner scanner = new Scanner(System.in);
    List<book> list = new ArrayList<book>();
    public void reviseBook(){
        System.out.println("---修改图书---");
        System.out.println("输入修改图书名称：");
        String name = scanner.next();
        for(book b:list){
            if (b.getName().equals(name)){
                System.out.println("输入修改后的图书名称：");
                String rname = scanner.next();
                b.setName(rname);
                System.out.println("修改成功");
            }
        }
        System.out.println("未找到该图书");
    }
}
