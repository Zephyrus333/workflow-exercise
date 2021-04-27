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
    public void addBook() {
    	System.out.println("---新增图书---");
    	System.out.println("请输入图书名称：");
    	String Name = Scanner.next();
    	int addid = List.size()+1;
    	book b = new book(Name,addid);
    	list.add(b);
    	System.out.println("图书"+name+b.getInout());
    }




    public void saveBook() {
        File file =new File("book.txt");
        Writer out;
        try {
            out = new FileWriter(file);
            out.write("缂栧彿\t鍚嶇О\t鐘舵��");
            for(book b : list) {
                out.write("\r\n");
                out.write(b.getId()+"\t" + b.getName()+"\t" + b.getInout()+"\t 鍊熼槄浜猴細"+b.getLendName());
            }
            out.flush();
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("淇濆瓨鎴愬姛锛�");
    }
}
