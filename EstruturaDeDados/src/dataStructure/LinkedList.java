package dataStructure;

public class LinkedList {
	
	//3 campos
	private Node head;
	
	private Node tail;//cauda
	
	private int length;
	

	class Node{//Classe interna Nó
		
		String data;
		
		Node next;//referenciando o proximo nó
		
		//Constutor
		Node(String data){
			this.data = data;
		}
	}
	
	//Construtor da lista que vai iniciar os 3 campos
	public LinkedList(String data) {
		length = 1;
		Node newNode = new Node(data);
		head = newNode;
		tail = newNode;	
	}
	
	public void getHead() {
		if(this.head == null) {
			System.out.println("Lista Vazia");
			
		}else {
			System.out.println("Head: " + head.data);
		}
		
	}
	
	public void getTail() {
		if(this.tail == null) {
			System.out.println("Lista vazia");
		}else {
			System.out.println("Tail: " + head.data);
		}
		
	}
	
	public void getLength() {//mostrar o tamanho
		System.out.println("Length: " + this.length);
		
	}
	
	public void makeEmpty() {
		head = null;
		tail = null;
		length = 0;
		
	}
	
	public void print() {
		System.out.println("________________________________");
		Node temp = this.head;//temporario vai iniciar na cabeça
		while(temp != null) {//enquanto minha lista nao for vazia
			System.out.println(temp.data);
			temp = temp.next;//A lista vai viajando cada posicao
			
		}
		System.out.println("________________________________");
	}
	
	public void append(String data) {
		Node newNode = new Node(data);
		if(length == 0) {
			head = newNode;
			tail = newNode;
		}else {
			//implemnto o nó cauda atual para o novo nó e depois a cauda atual sera o novo nó tail da minha lista
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}
	
	//vamos remover um valor da lista e diminuir o tambem o tamanho
	public Node removeLastList(){
		if(length == 0) return null; // se a lista estiver vazia retorna null
		Node pre = head;// sempre começar pela a cabeça
		Node temp = null;
		
		
		while(pre.next != tail) {
			pre = pre.next;
		}
		
		temp = tail;
		tail = pre;
		tail.next = null;
		
		length--;
		if(length == 0) {
			head = null;
			tail = null;
		}
		return temp;
		
		
	}	
	
	//Operação preprend inserindo elemento no inicio da lista
	public void prepend(String data) {
		Node newNode = new Node(data);
		if(length == 0) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.next = head;
			head = newNode;
		}
		
		length++;
		
	}
	
	
	//Removendo o primeiro elemento
	public Node removeFirst() {
		if(length == 0) return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if(length == 0) {
			head = null;
			tail = null;
		}
		return temp;
		
	}
	//metodo que realiza a leitura 
	public Node get(int index) {
		if(index < 0 || index >= length) return null;
		Node temp = head;
		for(int i = 0; i<index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	//Metodo set
	public boolean set(int index, String data) {
		Node temp = get(index);
		if(temp != null) {
			temp.data = data;
			return true;
		}
		return false;
	}
	
	
	//implementando metodo que iria inserir um elemnto na posição desejada após fazer a leitura
	public boolean insert(int index, String data) {
		
		if(index < 0 || index > length) return false;
		if(index == 0) {
			prepend(data);
			return true;
		}
		if(index == length) {
			append(data);
			return true;
		}
		
		Node newNode = new Node(data);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}
	
	//Me permite remover um elemento dado uma determinada posição
	public Node remove(int index) {
		if(index < 0 || index >= length) return null;
		if(index == 0) return removeFirst();
		if(index == length -1)return removeLastList();
		
		Node prev = get(index -1);
		Node temp = prev.next;
		
		prev.next = temp.next;
		temp.next = null;
		length--;
		
		return temp;
		
	}

	
	
	
	
	
	
	
	//testando metodos
	public static void main(String[] args) {
		LinkedList list = new LinkedList("elemento 1");
		list.append("elemento 2");
		list.append("elemento 3");
		list.prepend("elemento 0");
		
		list.remove(2);
		list.print();
		
//		list.insert(3, "elemento 2.5");
		
//		System.out.println(list.get(2).data);
		
//		System.out.println(list.removeFirst());
//		list.print();
//		
//		list.set(1, "elemento 0.5");
//		list.print();
//		
//		list.getHead();
//		list.getTail();
//		list.getLength();
//		list.print();
//		list.makeEmpty();
		
	}
	
	
}
