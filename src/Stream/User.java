package Stream;
import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.RequestingUserName;
public class User{
	public static void main(String[] args){
		boolean userflag=true,userflag2=true;
		Game gm=new Game();
		NamePaw np=new NamePaw();
		RankingList rl=new RankingList();
		while (userflag) {
		do{
			System.out.println("-------------------");
			System.out.println("1. 注册2.登录 3.退出");
			Scanner input=new Scanner(System.in);
				int a=input.nextInt();
				switch(a){
					case 1:
						np.register();//调用注册方法
						if (np.npflag) {//判断回主菜单还是跳转登录
							break;
						}
					case 2:
						np.loginId();//调用注册方法
						break;
					case 3:
						System.out.println("欢迎再次使用");//退出游戏
						return;
				}
			}while(np.npflag);
			do{
				System.out.println("1. 开始新游戏   2.英雄榜  3.返回主菜单  4.退出游戏");
				Scanner input=new Scanner(System.in);
				int b=input.nextInt();
				switch(b){
				case 1:
					gm.gatGame(np.name);//游戏方法
					userflag2=true;
					break;
				case 2:
					rl.list();//排行榜方法
					userflag2=true;
					break;
				case 3://返回主菜单
					userflag2=false;
					break;
				case 4:
					System.out.println("欢迎再次使用");
					return;
				}
				}while(userflag2);
		}
	}
}
class NamePaw{
	String name=null;//游戏昵称
	String paw=null;//账号密码
	String botton=null;//接受用户输入，
	static String namearray[]=new String[10];//储存用户昵称
	String pawarray[]=new String[10];//储密码
	int index = -1;//计数器
	static int q=-1;//计数器，储存当前用户数组下标
	boolean npflag=true,npflag1=true,npflag2=true;
	public void register(){//注册方法
		npflag=true;
		while (npflag) {
			Scanner input=new Scanner(System.in);
			index = -1;// 归位，index不用了就可以归位
			System.out.println("-------注册--------");
			System.out.println("请注册用户名和密码：");
			name = input.next();
			paw = input.next();
			for (int i = 0; i < namearray.length; i++) {
				if (name.equals(namearray[i])) {
					index = i;
				}
			}
			if (index!= -1) {// -1代表没有查到这个数的情况
				System.out.println("用户名已存在");
				npflag1=true;
				while(npflag1){
					System.out.println("1.返回主菜单  2.重新注册");
					botton=input.next();
					if(botton.equals("1")){
						npflag=true;
						return;
							}else if(botton.equals("2")){
						npflag=true;
						npflag1=false;
					}else{
						npflag1=true;
					}
				}
			}else{
				String[] newnamearray= new String[namearray.length + 1];
				String[] newpawarray= new String[pawarray.length + 1];// 代码不要写死
				for (int i = 0; i < namearray.length; i++) {// 把老数组中的数据复制给新的
					newnamearray[i] = namearray[i];
					newpawarray[i]=pawarray[i];
				}
				newnamearray[namearray.length] = name;
				newpawarray[pawarray.length]=paw;// 把没有的数字赋值给新数组中最后一个位置中
				namearray = newnamearray;
				pawarray=newpawarray;
				newnamearray = null;
				newpawarray=null;
				newnamearray=null;
				npflag=false;
				System.out.println("注册成功，自动跳转登录");
			}
	}

	}
	public void loginId(){
		Scanner input=new Scanner(System.in);
		npflag=true;
		while(npflag){
			q=-1;
			System.out.println("-------登录--------");
			System.out.println("请输入用户名和密码");
			name=input.next();
			paw=input.next();
			for(int j=0;j<namearray.length;j++){
				npflag1=name.equals(namearray[j]);
				npflag2=paw.equals(pawarray[j]);
				q++;
				if(npflag2==true&&npflag1==true){
					break;
					}
			}
			if(!(npflag1&&npflag2)){
				npflag1=true;
				System.out.println("登录失败,密码或用户名错误");
				while(npflag1){
					System.out.println("1.返回主菜单  2.重新登录");
					botton=input.next();
					if(botton.equals("1")){
						npflag=true;
						return;
						}
					else if(botton.equals("2")){
						npflag1=false;
						npflag=true;
					}else{
						npflag1=true;
					}
				}}else{
				System.out.println("登录成功");
				name=namearray[q];
				npflag=false;
			}
		}
		npflag1=true;
			}
}
class RankingList{
	int score=1000;
	//Game gm=new Game(score);
	String[] list=new String[10];
	int[] scorearray=new int[10];
	public void list(){
	if (NamePaw.q>=10) {
		for(int i=0;i<10;i++){
			if(scorearray[i]<=1000){
			list[i]=null;
			scorearray[i]=1000;
			}
		}
	}
	for(int i=0;i<10;i++){
		if(Game.score>=scorearray[i]&&Game.score!=1000){
			for(int j=8;j>=i;j--){
			String newList=list[j];
			list[j+1]=newList;
			int newScore=scorearray[j];
			scorearray[j+1]=newScore;
			newList=null;
			}
			list[i]=NamePaw.namearray[NamePaw.q];
			scorearray[i]=Game.score;
			break;
		}
	}
		for(int i=0;i<10;i++){
			System.out.println("第"+(i+1)+"名  "+"\n\t昵称："+list[i]+"\t总分："+scorearray[i]);
		}
	}
}
class Game{
	String[] namearray=new String[10];
	static int score=1000;
	static int[] scorearray=new int[10];
	Scanner input=new Scanner(System.in);
		public void gatGame(String name){
			a(NamePaw.q);
		boolean gameFlag=false,gameFlag1=true;
		String gameName=null;
		if(score<100){
				System.out.println("您当前分数为"+score+",小于100，无法继续游戏");
				return;
			}
		do{
		System.out.println("尊进的玩家："+name+"， 欢迎进入石头剪刀布游戏");
		System.out.println("您当前分数为"+score);
		System.out.println("请选择您的对手  1：刘备 2：曹操 3：诸葛亮 4：路飞");
		int a=input.nextInt();
		if(a==1){
			gameFlag=true;
			gameName="刘备";
			System.out.println("玩家"+name+"，您的对手为刘备");
		}else if(a==2){
			gameFlag=true;
			System.out.println("玩家"+name+"，您的对手为曹操");
			gameName="曹操";
		}else if(a==3){
			gameFlag=true;
			System.out.println("玩家"+name+"，您的对手为诸葛亮");
			gameName="诸葛亮";
		}else if(a==4){
			gameFlag=true;
			System.out.println("玩家"+name+"，您的对手为路飞");
			gameName="路飞";
		}
		while(gameFlag){
			System.out.println("当前分数为"+score);
			System.out.println("游戏规则：石头大于剪刀，剪刀大于布，布大于石头，胜利分+100；失败-50");
			System.out.println("请出拳：1.石头 2.剪刀 3.布");
			int b=input.nextInt();
			Random random=new Random();
			int rd=random.nextInt(3);
			if(b==rd+1){
				if(b==1){
					System.out.println("您出的是：石头"+gameName+"出的是：石头");
					System.out.println("此局比赛结果为平局。您当前分数为"+score);
				}else 	if(b==2){
					System.out.println("您出的是：剪刀"+gameName+"出的是：剪刀");
					System.out.println("此局比赛结果为平局。您当前分数为"+score);
				}else 	if(b==3){
					System.out.println("您出的是：布"+gameName+"出的是：布");
					System.out.println("此局比赛结果为平局。您当前分数为"+score);
				}
			}else if(b==rd||(b==3&&rd==0)){
				if(b==1){
					System.out.println("您出的是：石头"+gameName+"出的是：剪刀");
					score=score+100;
					System.out.println("恭喜你，赢了，分数+100。您当前分数为"+score);
				}else 	if(b==2){
					System.out.println("您出的是：剪刀"+gameName+"出的是：布");
					score=score+100;
					System.out.println("恭喜你，赢了，分数+100。您当前分数为"+score);
				}else 	if(b==3){
					System.out.println("您出的是：布"+gameName+"出的是：石头");
					score=score+100;
					System.out.println("恭喜你，赢了，分数+100。您当前分数为"+score);
				}
			}else if(b-2==rd||(b==1&&rd==2)){
				if(b==1){
					System.out.println("您出的是：石头"+gameName+"出的是：布");
					score=score-50;
					System.out.println("很遗憾，您输了，分数-50。您当前分数为"+score);
				}else 	if(b==2){
					System.out.println("您出的是：剪刀"+gameName+"出的是：石头");
					score=score-50;
					System.out.println("很遗憾，您输了，分数-50。您当前分数为"+score);
				}else 	if(b==3){
					System.out.println("您出的是：布"+gameName+"出的是：剪刀");
					score=score-50;
					System.out.println("很遗憾，您输了，分数-50。您当前分数为"+score);
				}
			}
			//int[] newscorearray= new int[scorearray.length + 1];
			//for (int i = 0; i < namearray.length; i++) {// 把老数组中的数据复制给新的
				//	newpawarray[i]=pawarray[i];
	//			}
		//	newscorearray[scorearray.length]=score;
		//	scorearray=newscorearray;
	//		newscorearray=null;
				scorearray[NamePaw.q]=score;
				System.out.println("1.继续游戏 2.回到上一级菜单 3.返回游戏首页");
				int c=input.nextInt();
				if(c==1){
					gameFlag=true;
				}else if(c==2){
					break;
				}else if(c==3){
					return;
				}
		}
		
		}
			while(gameFlag1);
		}
		public void a(int q){
		if(q+1>=NamePaw.namearray.length){
			int[] newscorearray= new int[q+1];
				for (int i = 0; i < scorearray.length; i++) {// 把老数组中的数据复制给新的
					newscorearray[i]=scorearray[i];
				}
				for(int i=scorearray.length;i<=q;i++){
					newscorearray[i]=1000;
				}
				scorearray=newscorearray;
				newscorearray=null;
				score=scorearray[NamePaw.q];
		}else{
				score=scorearray[NamePaw.q];
			}
	}
		}
