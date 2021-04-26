package book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class booklist {
    Scanner scanner = new Scanner(System.in);
    List<book> list = new ArrayList<book>();

    public booklist(){

    }



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
    public void returnBook(){
        System.out.println("---归还图书---");
        System.out.print("请输入图书名称:");
        String name = scanner.next();
        for(book b:list){
            if (b.getName().equals(name)){
                if (b.isInout()){
                    System.out.println("图书未借出，归还失败");
                }else {
                    b.setInout(true);
                    b.setLendName(null);
                    System.out.println("归还成功");
                    return;
                }
            }
        }

    }

    public void saveBook() {
        File file =new File("book.txt");
        Writer out;
        try {
            out = new FileWriter(file);
            out.write("编号\t名称\t状态");
            for(book b : list) {
                out.write("\r\n");
                out.write(b.getId()+"\t" + b.getName()+"\t" + b.getInout()+"\t 借阅人："+b.getLendName());
            }
            out.flush();
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("保存成功！");
    }
}
