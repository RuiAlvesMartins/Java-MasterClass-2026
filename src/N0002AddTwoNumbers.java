public class N0002AddTwoNumbers {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //todo remove static
    public static ListNode addTwoNumbersTakeOne(ListNode l1, ListNode l2) {

        int cycles = 1;
        ListNode ln1 = l1;
        //  gets value from first node;
        long n1 = ln1 == null ? 0l : ln1.val;
        
        if (ln1 != null) {
            while (ln1.next != null) {
            
                ln1 = ln1.next;
                n1 = n1 + (long) (ln1.val * (long) Math.pow(10, cycles)); 
                // System.out.println("n1 = " + n1 + " at cycle #" + cycles);
                cycles++;

            }
        }

        cycles = 1;
        ListNode ln2 = l2;
        //  gets value from first node;
        long n2 = ln2 == null ? 0l : ln2.val;
        
        if (ln2 != null) {
            while (ln2.next != null) {
            
                ln2 = ln2.next;
                n2 = n2 + (long) (ln2.val * (long) Math.pow(10, cycles)); 
                // System.out.println("n2 = " + n2 + " at cycle #" + cycles);
                cycles++;

            }
        }

        long result = n1 + n2;
        long temp = result;
        int resultDigits = 1;
        while (temp > 9) {
            temp = temp / 10;
            resultDigits++;
        }
        // System.out.println("resultDigits = #" + resultDigits);

        ListNode l3 = new ListNode((int) (result / (long) Math.pow(10, resultDigits - 1)));
        temp = result;
        // System.out.println("------");
        // System.out.println(l3.val);
        for(int i = resultDigits - 1; i>0; i--) {
            temp = temp - (long) (l3.val * (long) Math.pow(10, i));
            l3 = new ListNode((int) (temp/(long)Math.pow(10, i - 1)), l3);
            // System.out.println(l3.val);
        }
        // System.out.println("------");

        System.out.println("result of %s + %s = %s".formatted(n1, n2, result));

        return l3;

    }

    public static ListNode addTwoNumbersTakeTwo(ListNode l1, ListNode l2) {
        System.out.println("-".repeat(30));
        return addTwoNumbersTakeTwo(l1, l2, 0);
    }

    private static ListNode addTwoNumbersTakeTwo(ListNode l1, ListNode l2, int carry) {

        ListNode l3 = new ListNode();

        if (l1 != null && l2 != null) {

            int sum = l1.val + l2.val + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;

            //  l1.next && l2.next NOT null;
            if (l1.next != null && l2.next != null) {
                l3 = new ListNode(sum, addTwoNumbersTakeTwo(l1.next, l2.next, carry));
            }
            //  l1.next null;
            if (l1.next == null && l2.next != null) {
                l3 = new ListNode(sum, addTwoNumbersTakeTwo(null, l2.next, carry));
            }
            //  l2.next null;
            if (l1.next != null && l2.next == null) {
                l3 = new ListNode(sum, addTwoNumbersTakeTwo(l1.next, null, carry));
            }
            //  l1.next && l2.next NULL;
            if (l1.next == null && l2.next == null) {
                if (carry > 0) {
                    l3 = new ListNode(sum, new ListNode(carry));
                    System.out.println(l3.next.val);
                }
                else {
                    l3 = new ListNode(sum);
                }
                
            }
        }

        if (l1 == null) {
            
            int sum = l2.val + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;

            if (l2.next != null) {
                l3 = new ListNode(sum, addTwoNumbersTakeTwo(null, l2.next, carry));
            }
            else {
                if (carry > 0) {
                    l3 = new ListNode(sum, new ListNode(carry));
                    System.out.println(l3.next.val);
                }
                else {
                    l3 = new ListNode(sum);
                }
            }

        }

        if (l2 == null) {
            
            int sum = l1.val + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;

            if (l1.next != null) {
                l3 = new ListNode(sum, addTwoNumbersTakeTwo(l1.next, null, carry));
            }
            else {
                if (carry > 0) {
                    l3 = new ListNode(sum, new ListNode(carry));
                    System.out.println(l3.next.val);
                }
                else {
                    l3 = new ListNode(sum);
                }
            }

        }

        System.out.println(l3.val);
        return l3;
    }


    public static void main(String[] args) {
        
        ListNode ln1 = new ListNode(3);
        ListNode ln2 = new ListNode(4, ln1);
        ListNode ln3 = new ListNode(2, ln2);

        ListNode ln4 = new ListNode(4);
        ListNode ln5 = new ListNode(6, ln4);
        ListNode ln6 = new ListNode(5, ln5);

        // addTwoNumbersTakeTwo(ln3, ln6);

        ListNode ln7 = new ListNode(0);

        ListNode ln8 = new ListNode(0);

        // addTwoNumbersTakeTwo(ln7, ln8);

        ListNode ln9 = new ListNode(9);
        ListNode ln10 = new ListNode(9, ln9);
        ListNode ln11 = new ListNode(9, ln10);
        ListNode ln12 = new ListNode(9, ln11);
        ListNode ln13 = new ListNode(9, ln12);
        ListNode ln14 = new ListNode(9, ln13);
        ListNode ln15 = new ListNode(9, ln14);

        ListNode ln16 = new ListNode(9);
        ListNode ln17 = new ListNode(9, ln16);
        ListNode ln18 = new ListNode(9, ln17);
        ListNode ln19 = new ListNode(9, ln18);

        addTwoNumbersTakeTwo(ln15, ln19);

        ListNode ln20 = new ListNode(9);

        ListNode ln21 = new ListNode(9);
        ListNode ln22 = new ListNode(9, ln21);
        ListNode ln23 = new ListNode(9, ln22);
        ListNode ln24 = new ListNode(9, ln23);
        ListNode ln25 = new ListNode(9, ln24);
        ListNode ln26 = new ListNode(9, ln25);
        ListNode ln27 = new ListNode(9, ln26);
        ListNode ln28 = new ListNode(9, ln27);
        ListNode ln29 = new ListNode(9, ln28);
        ListNode ln30 = new ListNode(1, ln29);

        addTwoNumbersTakeTwo(ln20, ln30);

        // System.out.println("10 ^ 0 = " + (int) Math.pow(10, 0));
        // System.out.println("465 / 100 = " + 465/100);


    }

}
