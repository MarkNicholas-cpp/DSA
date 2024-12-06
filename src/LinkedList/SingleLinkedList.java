package LinkedList;

public class SingleLinkedList {
    Node head = null;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ======================== INSERTION METHODS ========================
    public void insertBeg(int data) {
        var newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insertEnd(int data) {
        var newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        var temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    public void insertAtPos(int pos, int data) {
        if (pos < 0 || pos > length())
            throw new IllegalStateException("Invalid Position for length " + length());
        if (pos == 0) {
            insertBeg(data);
            return;
        }
        if (pos == length()) {
            insertEnd(data);
            return;
        }
        var newNode = new Node(data);
        var temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void insertMid(int data) {
        if (head == null) {
            insertBeg(data);
            return;
        }
        int midPos = length() / 2;
        insertAtPos(midPos, data);
    }

    // ======================== DELETION METHODS ========================
    public void deleteBeg() {
        if (head == null)
            return;
        head = head.next;
    }

    public void deleteEnd() {
        if (head == null)
            return;
        if (head.next == null) {
            head = null;
            return;
        }
        var temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void deleteAtPos(int pos) {
        if (head == null)
            throw new IllegalStateException("Cannot delete from an empty list");
        if (pos < 0 || pos >= length())
            throw new IllegalStateException("Invalid Position for length " + length());
        if (pos == 0) {
            deleteBeg();
            return;
        }
        var temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    // ======================== UPDATE METHODS ========================
    public void updateNodeAt(int pos, int data) {
        var temp = nodeAt(pos);
        temp.data = data;
    }

    // ======================== READING METHODS ========================
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        var temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int length() {
        var temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    // ======================== OTHER UTILITY METHODS ========================
    private Node nodeAt(int pos) {
        if (pos < 0 || pos >= length())
            throw new IllegalStateException("Invalid Position for length " + length());
        var temp = head;
        for (int i = 0; i < pos; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void cycleToAPos(int pos) {
        var temp = head;
        while (temp.next != null)
            temp = temp.next;
        var node = nodeAt(pos);
        temp.next = node;
    }

    // ======================== PROBLEMS ========================

    public static SingleLinkedList mergeTwoLists(SingleLinkedList list1, SingleLinkedList list2) {
        var newList = new SingleLinkedList();
        var i = list1.head;
        var j = list2.head;
        while (i != null && j != null) {
            if (i.data < j.data) {
                newList.insertEnd(i.data);
                i = i.next;
            } else {
                newList.insertEnd(j.data);
                j = j.next;
            }
        }
        while (i != null) {
            newList.insertEnd(i.data);
            i = i.next;
        }
        while (j != null) {
            newList.insertEnd(j.data);
            j = j.next;
        }
        return newList;
    }

    public static SingleLinkedList deleteDuplicates(SingleLinkedList list) {
        var i = list.head; // Pointer to track the last unique node
        var j = list.head; // Pointer to traverse the list
        while (j != null) {
            if (i.data != j.data) {
                i.next = j;
                i = i.next;
            }
            j = j.next;
        }
        return list;
    }

    public boolean hasCycle() {
        return hasCycle(this);
    }

    public static boolean hasCycle(SingleLinkedList list) {
        var slow = list.head;
        var fast = list.head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    // intersectingLists done in leetCode
    public void removeElements(int data) {
        var count = 0;
        var temp = head;
        while (temp != null) {
            if (temp.data == data) {
                deleteAtPos(count);
                count--;
            }
            temp = temp.next;
            count++;
        }
    }

    public static int ListToDecimal(SingleLinkedList list) {
        var temp = list.head;
        int decimal = 0;

        // Traverse the list
        while (temp != null) {
            // Shift left (multiply by 2) and add the current bit
            decimal = decimal * 2 + temp.data;
            temp = temp.next;
        }

        return decimal;
    }

}
