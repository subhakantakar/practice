// https://leetcode.com/problems/add-two-numbers/

package v3;

public class AddTwoNumbers {
  public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  private ListNode reverse(ListNode node) {
    if (node == null || node.next == null) {
      return node;
    }

    ListNode next = node.next;
    ListNode curr = node;
    ListNode prev = null;
    while (next != null) {
      curr.next = prev;
      prev = curr;
      curr = next;
      next = next.next;
    }
    curr.next = prev;
    return curr;
  }

  private void print(ListNode node) {
    ListNode temp = node;
    while(temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
    System.out.print("\n");
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    print(l1);
    print(l2);

    ListNode new_list = null;
    ListNode temp_l1 = l1;
    ListNode temp_l2 = l2;
    int reminder = 0;
    while (temp_l1 != null || temp_l2 != null) {

      int val = reminder + ((temp_l1 != null) ? temp_l1.val:0) + ((temp_l2 != null) ? temp_l2.val:0);
      if (val >= 10) {
        val = val-10;
        reminder = 1;
      } else {
        reminder = 0;
      }

      ListNode n = new ListNode(val);
      if (new_list != null) {
        n.next = new_list;
      }
      new_list = n;
      if (temp_l1 != null)  {
        temp_l1 = temp_l1.next;
      }
      if (temp_l2 != null)  {
        temp_l2 = temp_l2.next;
      }
    }
    if (reminder == 1) {
      ListNode n = new ListNode(1);
      n.next = new_list;
      new_list = n;
    }
    print(new_list);
    return reverse(new_list);
  }

  public static void main(String[] argv) {
    ListNode input1 = new ListNode(2);
    input1.next = new ListNode(4);
    input1.next.next = new ListNode(9);

    ListNode input2 = new ListNode(5);
    input2.next = new ListNode(6);
    input2.next.next = new ListNode(4);
    input2.next.next.next = new ListNode(9);

    AddTwoNumbers atn = new AddTwoNumbers();
    ListNode result = atn.addTwoNumbers(input1, input2);
    atn.print(result);


  }
}
