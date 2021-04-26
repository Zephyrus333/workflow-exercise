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
    public void bookList(){
        System.out.println("---图书清单---");
        System.out.println("编号\t名称\t状态");
        for (book b:list)
        {
            System.out.println(b.getId()+"\t" + b.getName()+"\t" + b.getInout()+"\t 借阅人："+b.getLendName());
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
