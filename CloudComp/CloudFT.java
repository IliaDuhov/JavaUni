public static int findMin(int[] arr) {
  if (arr.length == 1) {
    return arr[0];
  }

  int mid = arr.length / 2;
  int leftMin = findMin(Arrays.copyOfRange(arr, 0, mid));
  int rightMin = findMin(Arrays.copyOfRange(arr, mid, arr.length));

  return Math.min(leftMin, rightMin);
}

public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
}

public class Node {
  int value;
  Node next;

  public Node(int value) {
    this.value = value;
    this.next = null;
  }
}
public class LinkedList {
  Node head;
  Node tail;

  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  // Подсчет количества элементов
  public int size() {
    int count = 0;
    Node current = head;
    while (current != null) {
      count++;
      current = current.next;
    }
    return count;
  }

  // Добавление элемента в конец списка
  public void add(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
  }

  // Поиск элемента по его значению
  public Node find(int value) {
    Node current = head;
    while (current != null) {
      if (current.value == value) {
        return current;
      }
      current = current.next;
    }
    return null;
  }
}
