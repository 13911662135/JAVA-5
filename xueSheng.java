package moNiXueShengChuLi;

import java.io.*;
//import java.net.URLEncoder;
import java.util.Scanner;

public class xueSheng {
    public static void main(String args[]){
        File file = new File("D:\\java","A.txt");
        int i,j=0;
        while(j == 0){
            for(i = 0;i < 1;i++){
                try{
                    //第一部分 学生信息互动，这里可以放在学生类里
                    System.out.print("请输入学生姓名:");
                    Scanner xingMing = new Scanner(System.in);
                    String xm = xingMing.next();

                    System.out.print("请输入学生学号:");
                    Scanner xueHao = new Scanner(System.in);
                    String xh = xueHao.next();

                    System.out.print("请输入学生年龄:");
                    Scanner nianLing = new Scanner(System.in);
                    String nl = nianLing.next();

                    System.out.print("请输入学生性别:");
                    Scanner xingBie = new Scanner(System.in);
                    String xb = xingBie.next();
                    //第一部分结束

                    //第二部分 用输入流获取文本信息，将其变成字节型后进行处理。
                    File file2 = new File("D:\\java\\B.txt");
                    FileReader wenBen = new FileReader(file2);
                    //BufferedReader br = new BufferedReader(wenBen);
                    //String bc = br.readLine();
                    Long l = file2.length();
                    byte[] q= new byte[l.intValue()];
                    //int ziShu = bc.length();
                    int ziShu = q.length/2;
                    int f,g = 0;
                    char [] zuoYe = new char[ziShu];
                    while((f = wenBen.read())!=-1 )
                    {
                        zuoYe[g] = (char)f;
                        g++;
                    }
                    //System.out.print(zuoYe);
                    int biaodian = ziShu/7;
                    char [] zuoye = new char[ziShu+biaodian];
                    int zi = 1,cha = 0,z = 0;
                    char douhao = '，';
                    char juhao = '。';
                    for(i=0;i<ziShu;i++){
                        System.out.print(zuoYe[i]);
                        if( zi % 7 == 0 && zi % 14 != 0 && zi <= ziShu ){
                            System.out.print(",");
                            zuoye[z+cha] = douhao;
                            cha++;
                        }else if(zi % 14 == 0 && zi <= ziShu){
                            System.out.println("。");
                            zuoye[z+cha] = juhao;
                            cha++;
                        }else if( zi > ziShu){
                            break;
                        }
                        zuoye[z+cha] = zuoYe[i];
                        //zuoye[z] = zuoYe[i];
                        z++;
                        zi++;
                    }
                    //第二部分结束

                    //第三部分 加工信息，将获得的字符串，字符数组全部转换成字节数组并通过输出流输出在文本A中
                    int zishu = zuoye.length;
                    String zy = new String(zuoye);

                    byte [] a = xm.getBytes();
                    byte [] b = xh.getBytes();
                    byte [] c = nl.getBytes();
                    byte [] d = xb.getBytes();
                    byte [] e = zy.getBytes();
                    OutputStream out = new FileOutputStream(file);
                    out.write(a);  //姓名
                    out.write('\n');
                    out.write(d);  //性别
                    out.write('\n');
                    out.write(c);  //年龄
                    out.write('\n');
                    out.write(b);  //学号
                    out.write('\n');
                    for(i=0;i<zishu;i++){
                        out.write(e[i]);
                        if(i%8 == 0 && i%16 == 0 && i != 0){
                            out.write('\n');
                        }
                    }
                    out.close();
                    j = 1;
                }
                catch(Exception e){
                System.out.println("发生错误，请重头重新输入");
            }
        }
    }
    }
}
