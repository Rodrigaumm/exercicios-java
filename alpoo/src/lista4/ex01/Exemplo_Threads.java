package lista4.ex01;

class Tarefa_1 extends Thread
{
	public Tarefa_1(String name)
	{
		super(name);
                //super() serve para chamar o construtor da superclasse. Ele sempre é chamado, 
                //mesmo quando não está explícito no código.
                //Quando for explicitado, deve ser o primeiro item dentro do construtor
	}
	public void run()
                //run() serve para confirmar a classe Thread que vai ser executada.
	{
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Fluxo de programa que está rodando \"1\"");
		System.out.println(" ");
		try
		{
			Thread.sleep(5000);//tempo em milissegundos de interrupção
                        // o método sleep() deve sempre ser chamado dentro da estrutura
                        // try-catch, pois a thread que tenta interromper pode estar
                        //paralisada pelo sistema operacional ou outro fluxo do
                        //sistema. No JAVA é lançado uma exceção chamada InterruptedException
		}
		catch(InterruptedException e)
		{
		}
		String A = getName();// serve para imprimir seu próprio nome
		System.out.println("Nome da Thread = "+A);
		int b = getPriority(); // mostra seu grau de prioridade
		System.out.println("Uma Thread de prioridade "+b);
	
		for(int i=0;i<=10;i++) // programa 1 fica rodando por baixo, direto
		{
			System.out.print("-"+i);
		}
		System.out.println(" ");
		System.out.println(" ");
	}
}

class Tarefa_2 extends Thread
{
	public Tarefa_2(String name)
	{
		super(name);
	}
	public void run()
	{
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Fluxo de programa \" 2\"");
		System.out.println(" ");
		
		String A = getName();
		System.out.println("Nome da Thread = "+A);
		int b = getPriority();
		System.out.println("Uma Thread de prioridade "+b); 
		for(int i=10;i>=0;i--)// programa 2 roda com prioridade menor
		{
			System.out.print("-"+i);
		}
		System.out.println(" ");
		System.out.println(" ");
	}	
}

class Tarefa_3 extends Thread
{
	public Tarefa_3(String name)
	{
		super(name);
	}
	public void run()
	{
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Fluxo de programa \" 3\"");
		System.out.println(" ");


		String A = getName();
		System.out.println("Nome da Thread = "+A);
		int b = getPriority();
		System.out.println("Uma Thread de prioridade "+b); 
		for(int i=20;i>=10;i--)
		{
			System.out.print("-*");
		}
		System.out.println(" ");
		System.out.println(" ");
	}	
}

class Tarefa_4 extends Thread {
	public Tarefa_4 (String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Fluxo de programa \" 4\"");
		System.out.println(" ");


		String A = getName();
		System.out.println("Nome da Thread = "+A);
		int b = getPriority();
		System.out.println("Uma Thread de prioridade "+b); 
		for(int i=20;i>=10;i--)
		{
			System.out.print("-$");
		}
		System.out.println(" ");
		System.out.println(" ");
	}
}

class Tarefa_5 extends Thread {
	public Tarefa_5 (String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(" ");
		System.out.println(" ");
		System.out.print("Fluxo de programa \" 5\"");
		System.out.println(" ");


		String A = getName();
		System.out.println("Nome da Thread = "+A);
		int b = getPriority();
		System.out.println("Uma Thread de prioridade "+b); 
		for(int i=20;i>=10;i--)
		{
			System.out.print("-&");
		}
		System.out.println(" ");
		System.out.println(" ");
	}
}


public class Exemplo_Threads
{

	public static void main ( String arg[])
	{
		Tarefa_1 T1 = new Tarefa_1("Tarefa_1");// cria o objeto Tarefa
		T1.setPriority(10);//prioriza a execução da Thread
		
		Tarefa_2 T2 = new Tarefa_2("Tarefa_2");
		T2.setPriority(1);
		
		Tarefa_3 T3 = new Tarefa_3("Tarefa_3");
		T3.setPriority(4);
		
		Tarefa_4 T4 = new Tarefa_4("Tarefa_4");
		T4.setPriority(6);
		
		Tarefa_5 T5 = new Tarefa_5("Tarefa_5");
		T5.setPriority(8);
		
		T1.start();	
		
		T2.start();
	
		T3.start();	
		
		T4.start();
		
		T5.start();
	}
}

