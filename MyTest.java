public class MyTest {
    
    public static void main (String[] args){

        //testLinkedList();
        //testMemorySpace();

        //extraTest();
        mallocTest1();
    }

    public static void testLinkedList(){

        LinkedList l1 = new LinkedList();
        l1.addFirst(new MemoryBlock(100, 6));
        l1.addLast(new MemoryBlock(106, 8));
        l1.add(1, new MemoryBlock(250, 7));
        l1.add(0, new MemoryBlock(208, 8));
        System.out.println(l1 + "\n");

        System.out.println("Get last node: " + l1.getNode(l1.getSize() - 1));
        System.out.println("Get third block: " + l1.getBlock(2));
        System.out.println("Index of second block: " + l1.indexOf(new MemoryBlock(100, 6)) + "\n");
        
        System.out.println("Remove last node:");
        l1.remove(l1.getLast());
        System.out.println(l1 + "\n");

        System.out.println("Remove second index:");
        l1.remove(1);
        System.out.println(l1 + "\n");
        
        System.out.println("Remove first memory block:");
        l1.remove(new MemoryBlock(208, 8));
        System.out.println(l1 + "\n");
    }

    public static void testMemorySpace (){

        MemorySpace m1 = new MemorySpace(200);
        System.out.println(m1 + "\n");

        m1.malloc(4);
        System.out.println(m1 + "\n");

        m1.malloc(12);
        System.out.println(m1 + "\n");

        m1.malloc(8);
        System.out.println(m1 + "\n");

        m1.malloc(40);
        System.out.println(m1 + "\n");

        System.out.println("Free list base address 16:");
        m1.free(16);
        System.out.println(m1 + "\n");

        System.out.println("Free list base address 24:");
        m1.free(24);
        System.out.println(m1 + "\n");

        System.out.println("Test defrag:");
        m1.defrag();
        System.out.println(m1 + "\n");
    }

    public static void extraTest(){
        MemorySpace memorySpace = new MemorySpace(100);
        int address = memorySpace.malloc(20);
        System.out.println(memorySpace);


    } 


    public static void mallocTest1() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expected1 = "\n(0 , 5) (5 , 20) (25 , 20) (45 , 55) ";
        String expected2 = "(0 , 5) (25 , 20) \n(5 , 20) (45 , 55) ";
        String expected3 = "(0 , 45) \n(45 , 55) ";
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            int address = memorySpace.malloc(5);
            int address1 = memorySpace.malloc(20);
            int address2 = memorySpace.malloc(20);
            int address3 = memorySpace.malloc(55);
            actualB = (actualB && address == 0 && address1 == 5 && address2 == 25 && address3 == 45 && memorySpace.toString().equals(expected1));
            memorySpace.free(address);
            memorySpace.free(address2);
            actualB = (actualB && memorySpace.toString().equals(expected2));
            memorySpace.defrag();
            actualB = (actualB && memorySpace.toString().equals(expected2));
            System.out.println(memorySpace + "\n");
            memorySpace.free(address1);
            System.out.println(memorySpace + "\n");

            memorySpace.defrag();

            actual += (actualB && memorySpace.toString().equals(expected3));
            System.out.println(memorySpace);
            System.out.println(actual);

        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        System.out.println(expected);
        System.out.println(actual);
    }
}
