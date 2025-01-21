public class TestHandler {
    private Tester tester;
    
    public TestHandler() {
        this.tester = new Tester();
    }
 
    private int getNumberOfTests(TesterQuestionEnum question){
        switch (question) {
            case LINKED_LIST_GET_NODE:
                return 7;
            
            case LINKED_LIST_GET_BLOCK:
                return 8;

            case LINKED_LIST_ADD:
                return 8;

            case LINKED_LIST_ADD_LAST:
                return 5;

            case LINKED_LIST_ADD_FIRST:
                return 5;
            
            case LINKED_LIST_INDEX_OF:
                return 5;
            
            case LINKED_LIST_REMOVE_INDEX:
                return 17;
            
            case LINKED_LIST_REMOVE_NODE:
                return 18;
            
            case LINKED_LIST_REMOVE_ELEMENT:
                return 18;
            
            case MEMORY_SPACE_MALLOC:
                return 6;

            case MEMORY_SPACE_FREE:
                return 6;
            
            case MEMORY_SPACE_DEFRAG:
                return 5;
        
            default:
                break;
        }
        return 0;
    }

    private boolean runTest(TesterQuestionEnum question, int testNumber){
        switch (question) {
            case LINKED_LIST_GET_NODE:
                return getNodeTests(testNumber);
            
            case LINKED_LIST_ADD:
                return addTests(testNumber);
            
            case LINKED_LIST_ADD_LAST:
                return addLastTests(testNumber);

            case LINKED_LIST_ADD_FIRST:
                return addFirstTests(testNumber);
            
            case LINKED_LIST_INDEX_OF:
                return indexOfTests(testNumber);

            case LINKED_LIST_GET_BLOCK:
                return getBlockTests(testNumber);
            
            case LINKED_LIST_REMOVE_INDEX:
                return removeIndexTests(testNumber);

            case LINKED_LIST_REMOVE_NODE:
                return removeNodeTests(testNumber);

            case LINKED_LIST_REMOVE_ELEMENT:
                return removeElementTests(testNumber);

            case MEMORY_SPACE_MALLOC:
                return mallocTests(testNumber);

            case MEMORY_SPACE_FREE:
                return freeTests(testNumber);

            case MEMORY_SPACE_DEFRAG:
                return defragTests(testNumber);
            default:
                break;
        }
        return false;
    }

    private boolean runAllTests(TesterQuestionEnum question){
        int numberOfTests = getNumberOfTests(question);
        boolean passed = true;
        for (int i = 1; i <= numberOfTests; i++) {
            passed = runTest(question, i) && passed;
        }
        return passed;
    }


    public void conclusion() {
        this.tester.conclusion();
    }

    public void questionDecider(TesterQuestionEnum question, String[] args) {
        switch (question) {
            case LINKED_LIST_GET_NODE:
                this.mainGetNodeTest();
                break;
            case LINKED_LIST_ADD:
                this.mainAddNodeTest();
                break;
            case LINKED_LIST_ADD_FIRST:
                this.mainAddFirstTest();
                break;
            case LINKED_LIST_ADD_LAST:
                this.mainAddLastTest();
                break;
            case LINKED_LIST_INDEX_OF:
                this.mainIndexOfTest();
                break;
            case LINKED_LIST_GET_BLOCK:
                this.mainGetBlockTest();
                break;
            case LINKED_LIST_REMOVE_INDEX:
                this.mainRemoveIndexTest();
                break;
            case LINKED_LIST_REMOVE_ELEMENT:
                this.mainRemoveElementTest();
                break;
            case LINKED_LIST_REMOVE_NODE:
                this.mainRemoveNodeTest();
                break;
            case MEMORY_SPACE_MALLOC:
                this.mainMallocTest();
                break;
            case MEMORY_SPACE_FREE:
                this.mainFreeTest();
                break;
            case MEMORY_SPACE_DEFRAG:
                this.mainDefragTest();
                break;
            default:
                System.out.println("Invalid Question");
        }
    }


    //////////////////////////// LinkedList Tests ////////////////////////////
    ///// Add first /// 
    ///// tests handling /////
    private void mainAddFirstTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_ADD_FIRST);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_ADD_FIRST);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean addFirstTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return addFirstTest1();
            case 2:
                return addFirstTest2();
            case 3:
                return addFirstTest3();
            case 4:
                return addFirstTest4();
            case 5:
                return addFirstTest5();
            default:
                break;
        }
        return false;
    }

    /// Add first tests ///
    private boolean addFirstTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block) && list.getLast().block.equals(block) && list.getSize() == 1;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a single element to an empty list", expected, actual);
    }

    private boolean addFirstTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block2) && list.getLast().block.equals(block) && list.getSize() == 2;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a second element to the front of the list", expected, actual);
    }

    private boolean addFirstTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block3) && list.getLast().block.equals(block) && list.getSize() == 3;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a third element to the front of the list", expected, actual);
    }

    private boolean addFirstTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addFirst(block4);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block4) && list.getLast().block.equals(block) && list.getSize() == 4;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a fourth element to the front of the list", expected, actual);
    }

    private boolean addFirstTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addFirst(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addFirst(block5);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block5) && list.getLast().block.equals(block) && list.getSize() == 5;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a fifth element to the front of the list", expected, actual);
    }

    ///// Add last /// 
    ///// tests handling /////
    private void mainAddLastTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_ADD_LAST);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_ADD_LAST);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean addLastTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return addLastTest1();
            case 2:
                return addLastTest2();
            case 3:
                return addLastTest3();
            case 4:
                return addLastTest4();
            case 5:
                return addLastTest5();
            default:
                break;
        }
        return false;
    }

    ///// Add last tests /////
    private boolean addLastTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addLast(block);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block) && list.getLast().block.equals(block) && list.getSize() == 1 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a single element to an empty list", expected, actual);
    }

    private boolean addLastTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addLast(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addLast(block2);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block) && list.getLast().block.equals(block2) && list.getSize() == 2 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block, block2}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a second element to the end of the list", expected, actual);
    }

    private boolean addLastTest3(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addLast(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addLast(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block3) && list.getLast().block.equals(block2) && list.getSize() == 3 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block3, block, block2}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Add a third element to the end of the list", expected, actual);
    }

    private boolean addLastTest4(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addLast(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.getSize() == 3 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block2, block, block3}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a second element to the front of the list, then add a third element to the end of the list", expected, actual);
    }

    private boolean addLastTest5(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addLast(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.getSize() == 4 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block2, block, block3, block4}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a second element to the front of the list, then add a third and fourth element to the end of the list", expected, actual);
    }

    ///// Get Node /// 
    ///// tests handling /////
    private void mainGetNodeTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_GET_NODE);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_GET_NODE);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean getNodeTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return getNodeTest1();
            case 2:
                return getNodeTest2();
            case 3:
                return getNodeTest3();
            case 4:
                return getNodeTest4();
            case 5:
                return getNodeTest5();
            case 6:
                return getNodeTest6();
            case 7:
                return getNodeTest7();
            default:
                break;
        }
        return false;
    }

    ///// Get Node tests /////
    private boolean getNodeTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getNode(0).block.equals(block) && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the first element in the list", expected, actual);
    }

    private boolean getNodeTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getNode(1).block.equals(block) && list.getNode(0).block.equals(block2) && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the second element in the list", expected, actual);
    }

    private boolean getNodeTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getNode(2).block.equals(block3) && list.getNode(1).block.equals(block) && list.getNode(0).block.equals(block2);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the third element in the list", expected, actual);
    }

    private boolean getNodeTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getNode(-1);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get a negative index", expected, actual);
    }

    private boolean getNodeTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getNode(50);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is larger than size", expected, actual);
    }

    private boolean getNodeTest6() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getNode(0).block.equals(block2) && list.getNode(1).block.equals(block) && list.getNode(2).block.equals(block3) && list.getNode(3).block.equals(block4) && list.getSize() == 4;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is equal to size", expected, actual);
    }

    private boolean getNodeTest7() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getNode(4).block.equals(block5) && list.getNode(3).block.equals(block4) && list.getNode(2).block.equals(block3) && list.getNode(1).block.equals(block) && list.getNode(0).block.equals(block2) && list.getSize() == 5;
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is larger than size", expected, actual);
    }

    ///// Get Block /// 
    ///// tests handling /////
    private void mainGetBlockTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_GET_BLOCK);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_GET_BLOCK);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean getBlockTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return getBlockTest1();
            case 2:
                return getBlockTest2();
            case 3:
                return getBlockTest3();
            case 4:
                return getBlockTest4();
            case 5: 
                return getBlockTest5();
            case 6:
                return getBlockTest6();
            case 7:
                return getBlockTest7();
            case 8:
                return getBlockTest8();
            default:
                break;
        }
        return false;
    }

    ///// Get Block tests /////
    private boolean getBlockTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getBlock(0).equals(block) && list.getSize() == 1;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the first element in the list", expected, actual);
    }

    private boolean getBlockTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getBlock(1).equals(block) && list.getBlock(0).equals(block2) && list.getSize() == 2;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the second element in the list", expected, actual);
    }


    private boolean getBlockTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getBlock(2).equals(block3) && list.getBlock(1).equals(block) && list.getBlock(0).equals(block2);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the third element in the list", expected, actual);
    }

    private boolean getBlockTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getBlock(-1);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get a negative index", expected, actual);
    }


    private boolean getBlockTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getBlock(50);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is larger than size", expected, actual);
    }

    private boolean getBlockTest6() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getBlock(0).equals(block2) && list.getBlock(1).equals(block) && list.getBlock(2).equals(block3) && list.getBlock(3).equals(block4) && list.getSize() == 4;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is equal to size", expected, actual);
    }

    private boolean getBlockTest7() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getBlock(4).equals(block5) && list.getBlock(3).equals(block4) && list.getBlock(2).equals(block3) && list.getBlock(1).equals(block) && list.getBlock(0).equals(block2) && list.getSize() == 5;
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is larger than size", expected, actual);
    }

    private boolean getBlockTest8() {
        LinkedList list = new LinkedList();
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getBlock(0);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (NullPointerException e) {
            actual = TesterMessagesEnum.ERROR + " NullPointerException: " + e.getMessage();  
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index from an empty list", expected, actual);
    }

    ///// Add in index /// 
    ///// tests handling /////
    private void mainAddNodeTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_ADD);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_ADD);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean addTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return addTest1();
            case 2:
                return addTest2();
            case 3:
                return addTest3();
            case 4:
                return addTest4();
            case 5:
                return addTest5();
            case 6:
                return addTest6();
            case 7:
                return addTest7();
            case 8:
                return addTest8();
            default:
                break;
        }
        return false;
    }

    ///// Add in index tests /////
    private boolean addTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block) && list.getLast().block.equals(block) && list.getSize() == 1;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a single element to an empty list", expected, actual);
    }

    private boolean addTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(1, block2);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block) && list.getLast().block.equals(block2) && list.getSize() == 2;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a second element to the end of the list", expected, actual);
    }

    private boolean addTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(0, block2);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block2) && list.getLast().block.equals(block) && list.getSize() == 2;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a second element to the front of the list", expected, actual);
    }

    private boolean addTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(0, block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.add(1, block3);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block2) && list.getLast().block.equals(block) && list.getSize() == 3;
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a third element to the front of the list", expected, actual);
    }

    private boolean addTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(0, block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.add(1, block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.add(3, block4);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.getSize() == 4 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block2, block3, block, block4}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a fourth element to the front of the list", expected, actual);
    }

    private boolean addTest6() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(0, block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.add(1, block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.add(3, block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.add(2, block5);
        String expected = "true";
        String actual = "";
        try {
            actual += list.getNode(2).block.equals(block5) && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.getSize() == 5 && compareLinkedLists(list, createLinkedList(new MemoryBlock[]{block2, block3, block5, block, block4}));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Add a fifth element to the front of the list", expected, actual);
    }

    private boolean addTest7(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(0, block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.add(1, block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.add(3, block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.add(2, block5);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getNode(-1);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is larger than size", expected, actual);
    }    

    private boolean addTest8(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.add(0, block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.add(0, block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.add(1, block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.add(3, block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.add(2, block5);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            actual += list.getNode(50);
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("try to get an index that is larger than size", expected, actual);
    }

    ///// IndexOf tests /// 
    ///// tests handling /////
    private void mainIndexOfTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_INDEX_OF);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_INDEX_OF);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean indexOfTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return indexOfTest1();
            case 2:
                return indexOfTest2();
            case 3:
                return indexOfTest3();
            case 4:
                return indexOfTest4();
            case 5:
                return indexOfTest5();
            default:
                break;
        }
        return false;
    }

    ///// IndexOf tests /////
    private boolean indexOfTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        try {
            int index = list.indexOf(block);
            actual += list.getNode(index).block.equals(block);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the index of the first element in the list", expected, actual);
    }

    private boolean indexOfTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        try {
            int index = list.indexOf(block);
            actual += list.getNode(index).block.equals(block);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the index of the second element in the list", expected, actual);
    }


    private boolean indexOfTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addLast(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        String expected = "true";
        String actual = "";
        try {
            int index = list.indexOf(block2);
            actual += list.getNode(index).block.equals(block2);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the index of the second element in the list with addLast", expected, actual);
    }

    private boolean indexOfTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addLast(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException due to unfound index: index must be between 0 and size";
        String actual = "";
        int index = -2;
        try {
            index = list.indexOf(block4);
            actual += list.getNode(index).block.equals(block4);
        } catch (IllegalArgumentException e){
            if (index == -1) {
                actual = TesterMessagesEnum.ERROR + " IllegalArgumentException due to unfound index: " + e.getMessage();
            } else {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the index of an element that is not in the list", expected, actual);
    }

    private boolean indexOfTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addLast(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addFirst(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        try {
            int index = list.indexOf(block5);
            actual += list.getNode(index).block.equals(block5);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Get the index of the last element in the list", expected, actual);
    }

    ///// Remove Node tests ///
    /// tests handling ///
    private void mainRemoveNodeTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_REMOVE_NODE);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_REMOVE_NODE);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean removeNodeTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return removeNodeTest1();
            case 2:
                return removeNodeTest2();
            case 3:
                return removeNodeTest3();
            case 4:
                return removeNodeTest4();
            case 5:
                return removeNodeTest5();
            case 6:
                return removeNodeTest6();
            case 7:
                return removeNodeTest7();
            case 8:
                return removeNodeTest8();
            case 9:
                return removeNodeTest9();
            case 10:
                return removeNodeTest10();
            case 11:
                return removeNodeTest11();
            case 12:
                return removeNodeTest12();
            case 13:
                return removeNodeTest13();
            case 14:
                return removeNodeTest14();
            case 15:
                return removeNodeTest15();
            case 16:
                return removeNodeTest16();
            case 17:
                return removeNodeTest17();
            case 18:
                return removeNodeTest18();
            default:
                break;

        }
        return false;
    }

    ///// Remove Node tests /////
    private boolean removeNodeTest1() {
        LinkedList list = new LinkedList();
        Node n = null;
        String expected = TesterMessagesEnum.ERROR + " NullPointerException!";
        String actual = "";
        try {
            list.remove(n);
            actual += list.getSize() == 0;
        } catch (NullPointerException e){
            actual = TesterMessagesEnum.ERROR + " NullPointerException!";
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove a null node", expected, actual);
    }

    private boolean removeNodeTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            list.remove(list.getFirst());
            actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the first element in the list", expected, actual);
    }

    private boolean removeNodeTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block));
            list.remove(list.getFirst());
            actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the first element in the list (not the only one)", expected, actual);
    }

    private boolean removeNodeTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            list.remove(list.getLast());
            actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the last element in the list", expected, actual);
    }

    private boolean removeNodeTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block));
            list.remove(list.getLast());
            actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block2));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the last element in the list (not the only one)", expected, actual);
    }

    private boolean removeNodeTest6() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3));
            list.remove(list.getNode(1));
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove a middle element in the list", expected, actual);
    }

    private boolean removeNodeTest7() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(1)); // block removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            list.remove(list.getNode(2)); // block4 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove middle element in the list then remove last", expected, actual);
    }

    private boolean removeNodeTest8() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(1)); // block removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            list.remove(list.getNode(0)); // block2 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove middle element in the list then remove first", expected, actual);
    }

    private boolean removeNodeTest9(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(0)); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            list.remove(list.getNode(0)); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from start then remove from end of the list", expected, actual);
    }

    private boolean removeNodeTest10(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(3)); // block4 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            list.remove(list.getNode(0)); // block2 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block3) && list.indexOf(block2) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from end then remove from start of the list", expected, actual);
    }

    private boolean removeNodeTest11(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(3)); // block4 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            list.remove(list.getNode(1)); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from end then remove from middle of the list", expected, actual);
    }

    private boolean removeNodeTest12(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(0)); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            list.remove(list.getNode(1)); // block3 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Remove from start then remove from middle of the list", expected, actual);
    }

    private boolean removeNodeTest13(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(1)); // block removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            list.remove(list.getNode(1)); // block3 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from middle 2 times", expected, actual);
    }

    private boolean removeNodeTest14(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 5 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5));
            list.remove(list.getNode(2)); // block3 removed
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block3) == -1);
            list.remove(list.getNode(3)); // block5 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block5) == -1);
            list.remove(list.getNode(0)); // block2 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove middle then end, then start", expected, actual);
    }

    private boolean removeNodeTest15(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 5 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5));
            list.remove(list.getNode(2)); // block3 removed
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block3) == -1);
            list.remove(list.getNode(2)); // block4 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block4) == -1);
            list.remove(list.getNode(0)); // block2 removed
            actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block5) && list.indexOf(block2) == -1);
            list.remove(list.getNode(1)); // block5 removed
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block) && list.indexOf(block5) == -1);
            list.remove(list.getNode(0)); // block removed
            actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove all elements in the list", expected, actual);
    } 
    
    private boolean removeNodeTest16(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        boolean actualB = true;
        String actual = "";
        try {
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            list.remove(list.getNode(list.indexOf(block2)));
            actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove a non existing node", expected, actual);
    }

    private boolean removeNodeTest17(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(0)); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            list.remove(list.getNode(0)); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove back to back from start", expected, actual);
    }

    private boolean removeNodeTest18(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getLast()); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            list.remove(list.getLast()); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block) && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove back to back from end", expected, actual);
    }

    ///// remove element tests /////
    /// tests handling ///
    private void mainRemoveElementTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_REMOVE_ELEMENT);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_REMOVE_ELEMENT);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean removeElementTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return removeElementTest1();
            case 2:
                return removeElementTest2();
            case 3:
                return removeElementTest3();
            case 4:
                return removeElementTest4();
            case 5:
                return removeElementTest5();
            case 6:
                return removeElementTest6();
            case 7:
                return removeElementTest7();
            case 8:
                return removeElementTest8();
            case 9:
                return removeElementTest9();
            case 10:
                return removeElementTest10();
            case 11:
                return removeElementTest11();
            case 12:
                return removeElementTest12();
            case 13:
                return removeElementTest13();
            case 14:
                return removeElementTest14();
            case 15:
                return removeElementTest15();
            case 16:
                return removeElementTest16();
            case 17:
                return removeElementTest17();
            case 18:
                return removeElementTest18();
            default:
                break;
        }
        return false;
    }

        ///// Remove Element tests /////
        private boolean removeElementTest1() {
            LinkedList list = new LinkedList();
            MemoryBlock n = null;
            String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
            String actual = "";
            try {
                list.remove(n);
                actual += list.getSize() == 0;
            } catch (NullPointerException e){
                actual = TesterMessagesEnum.ERROR + " NullPointerException: " + e.getMessage();
            } catch (IllegalArgumentException e) {
                actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
            } catch (Exception e) { 
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove a null element", expected, actual);
        }
    
        private boolean removeElementTest2() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
                list.remove(block);
                actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove the first element in the list", expected, actual);
        }
    
        private boolean removeElementTest3() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block));
                list.remove(block2);
                actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove the first element in the list (not the only one)", expected, actual);
        }
    
        private boolean removeElementTest4() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
                list.remove(list.getLast().block);
                actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove the last element in the list", expected, actual);
        }
    
        private boolean removeElementTest5() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block));
                list.remove(list.getLast().block);
                actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block2));
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove the last element in the list (not the only one)", expected, actual);
        }
    
        private boolean removeElementTest6() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3));
                list.remove(list.getBlock(1));
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3));
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove a middle element in the list", expected, actual);
        }
    
        private boolean removeElementTest7() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(1)); // block removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
                list.remove(list.getBlock(2)); // block4 removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove middle element in the list then remove last", expected, actual);
        }
    
        private boolean removeElementTest8() {
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(1)); // block removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
                list.remove(list.getBlock(0)); // block2 removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove middle element in the list then remove first", expected, actual);
        }
    
        private boolean removeElementTest9(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(0)); // block2 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
                list.remove(list.getBlock(0)); // block removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove from start then remove from end of the list", expected, actual);
        }
    
        private boolean removeElementTest10(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(3)); // block4 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
                list.remove(list.getBlock(0)); // block2 removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block3) && list.indexOf(block2) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove from end then remove from start of the list", expected, actual);
        }
    
        private boolean removeElementTest11(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(3)); // block4 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
                list.remove(list.getBlock(1)); // block removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove from end then remove from middle of the list", expected, actual);
        }
    
        private boolean removeElementTest12(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(0)); // block2 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
                list.remove(list.getBlock(1)); // block3 removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block3) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            } 
            return this.tester.test("Remove from start then remove from middle of the list", expected, actual);
        }
    
        private boolean removeElementTest13(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(1)); // block removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
                list.remove(list.getBlock(1)); // block3 removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block3) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove from middle 2 times", expected, actual);
        }
    
        private boolean removeElementTest14(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            MemoryBlock block5 = new MemoryBlock(50, 5000);
            list.addLast(block5);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 5 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5));
                list.remove(list.getBlock(2)); // block3 removed
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block3) == -1);
                list.remove(list.getBlock(3)); // block5 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block5) == -1);
                list.remove(list.getBlock(0)); // block2 removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove middle then end, then start", expected, actual);
        }
    
        private boolean removeElementTest15(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            MemoryBlock block5 = new MemoryBlock(50, 5000);
            list.addLast(block5);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 5 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5));
                list.remove(list.getBlock(2)); // block3 removed
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block3) == -1);
                list.remove(list.getBlock(2)); // block4 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block4) == -1);
                list.remove(list.getBlock(0)); // block2 removed
                actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block5) && list.indexOf(block2) == -1);
                list.remove(list.getBlock(1)); // block5 removed
                actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block) && list.indexOf(block5) == -1);
                list.remove(list.getBlock(0)); // block3 removed
                actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null && list.indexOf(block) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove all elements in the list", expected, actual);
        } 
        
        private boolean removeElementTest16(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
            boolean actualB = true;
            String actual = "";
            try {
                actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
                list.remove(block2);
                actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            } catch (IllegalArgumentException e){
                actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove a non existing element", expected, actual);
        }
    
        private boolean removeElementTest17(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getBlock(0)); // block2 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
                list.remove(list.getBlock(0)); // block removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove back to back from start", expected, actual);
        }
        private boolean removeElementTest18(){
            LinkedList list = new LinkedList();
            MemoryBlock block = new MemoryBlock(10, 1000);
            list.addFirst(block);
            MemoryBlock block2 = new MemoryBlock(20, 2000);
            list.addFirst(block2);
            MemoryBlock block3 = new MemoryBlock(30, 3000);
            list.addLast(block3);
            MemoryBlock block4 = new MemoryBlock(40, 4000);
            list.addLast(block4);
            String expected = "true";
            String actual = "";
            boolean actualB = true;
            try {
                actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
                list.remove(list.getLast().block); // block2 removed
                actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
                list.remove(list.getLast().block); // block removed
                actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block) && list.indexOf(block3) == -1);
            } catch (Exception e) {
                actual = TesterMessagesEnum.ERROR + e.getMessage();
            }
            return this.tester.test("Remove back to back from end", expected, actual);
        }

    ///// remove Index tests /////
    /// tests handling ///
    private void mainRemoveIndexTest() {
        this.tester.reset(TesterQuestionEnum.LINKED_LIST_REMOVE_INDEX);
        boolean passed = runAllTests(TesterQuestionEnum.LINKED_LIST_REMOVE_INDEX);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean removeIndexTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return removeIndexTest1();
            case 2:
                return removeIndexTest2();
            case 3:
                return removeIndexTest3();
            case 4:
                return removeIndexTest4();
            case 5:
                return removeIndexTest5();
            case 6:
                return removeIndexTest6();
            case 7:
                return removeIndexTest7();
            case 8:
                return removeIndexTest8();
            case 9:
                return removeIndexTest9();
            case 10:
                return removeIndexTest10();
            case 11:
                return removeIndexTest11();
            case 12:
                return removeIndexTest12();
            case 13:
                return removeIndexTest13();
            case 14:
                return removeIndexTest14();
            case 15:
                return removeIndexTest15();
            case 16:
                return removeIndexTest16();
            case 17:
                return removeIndexTest17();
            default:
                break;
        }
        return false;
    }

    ///// Remove Index tests /////
    private boolean removeIndexTest1() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            list.remove(0);
            actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the first Index in the list", expected, actual);
    }

    private boolean removeIndexTest2() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block));
            list.remove(0);
            actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the first Index in the list (not the only one)", expected, actual);
    }

    private boolean removeIndexTest3() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            list.remove(list.getNode(list.getSize() - 1).block);
            actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the last Index in the list", expected, actual);
    }

    private boolean removeIndexTest4() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block));
            list.remove(list.getNode(list.getSize() - 1).block);
            actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block2));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove the last Index in the list (not the only one)", expected, actual);
    }

    private boolean removeIndexTest5() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3));
            list.remove(1);
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove a middle Index in the list", expected, actual);
    }

    private boolean removeIndexTest6() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(1); // block removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            list.remove(2); // block4 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove middle Index in the list then remove last", expected, actual);
    }

    private boolean removeIndexTest7() {
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(1); // block removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            list.remove(0); // block2 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove middle Index in the list then remove first", expected, actual);
    }

    private boolean removeIndexTest8(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(0); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            list.remove(0); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from start then remove from end of the list", expected, actual);
    }

    private boolean removeIndexTest9(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(3); // block4 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            list.remove(0); // block2 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block3) && list.indexOf(block2) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from end then remove from start of the list", expected, actual);
    }

    private boolean removeIndexTest10(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(3); // block4 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            list.remove(1); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from end then remove from middle of the list", expected, actual);
    }

    private boolean removeIndexTest11(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(0); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            list.remove(1); // block3 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        } 
        return this.tester.test("Remove from start then remove from middle of the list", expected, actual);
    }

    private boolean removeIndexTest12(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(1); // block removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
            list.remove(1); // block3 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove from middle 2 times", expected, actual);
    }

    private boolean removeIndexTest13(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 5 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5));
            list.remove(2); // block3 removed
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block3) == -1);
            list.remove(3); // block5 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4) && list.indexOf(block5) == -1);
            list.remove(0); // block2 removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove middle then end, then start", expected, actual);
    }

    private boolean removeIndexTest14(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        MemoryBlock block5 = new MemoryBlock(50, 5000);
        list.addLast(block5);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 5 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5));
            list.remove(2); // block3 removed
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block3) == -1);
            list.remove(2); // block4 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block5) && list.indexOf(block4) == -1);
            list.remove(0); // block2 removed
            actualB = (actualB && list.getSize() == 2 && list.getFirst().block.equals(block) && list.getLast().block.equals(block5) && list.indexOf(block2) == -1);
            list.remove(1); // block5 removed
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block) && list.indexOf(block5) == -1);
            list.remove(0); // block3 removed
            actual += (actualB && list.getSize() == 0 && list.getFirst() == null && list.getLast() == null && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove all Indexs in the list", expected, actual);
    } 
    
    private boolean removeIndexTest15(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        boolean actualB = true;
        String actual = "";
        try {
            actualB = (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
            list.remove(block2);
            actual += (actualB && list.getSize() == 1 && list.getFirst().block.equals(block) && list.getLast().block.equals(block));
        } catch (IllegalArgumentException e){
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove a non existing node", expected, actual);
    }

    private boolean removeIndexTest16(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(0); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block) && list.getLast().block.equals(block4) && list.indexOf(block2) == -1);
            list.remove(0); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block3) && list.getLast().block.equals(block4) && list.indexOf(block) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove back to back from start", expected, actual);
    }
    private boolean removeIndexTest17(){
        LinkedList list = new LinkedList();
        MemoryBlock block = new MemoryBlock(10, 1000);
        list.addFirst(block);
        MemoryBlock block2 = new MemoryBlock(20, 2000);
        list.addFirst(block2);
        MemoryBlock block3 = new MemoryBlock(30, 3000);
        list.addLast(block3);
        MemoryBlock block4 = new MemoryBlock(40, 4000);
        list.addLast(block4);
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            actualB = (actualB && list.getSize() == 4 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block4));
            list.remove(list.getNode(list.getSize() - 1).block); // block2 removed
            actualB = (actualB && list.getSize() == 3 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block3) && list.indexOf(block4) == -1);
            list.remove(list.getNode(list.getSize() - 1).block); // block removed
            actual += (actualB && list.getSize() == 2 && list.getFirst().block.equals(block2) && list.getLast().block.equals(block) && list.indexOf(block3) == -1);
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Remove back to back from end", expected, actual);
    }

    //////////////////////////// MemorySpace Tests ////////////////////////////
    ///// Malloc tests /////
    /// tests handling ///
    private void mainMallocTest() {
        this.tester.reset(TesterQuestionEnum.MEMORY_SPACE_MALLOC);
        boolean passed = runAllTests(TesterQuestionEnum.MEMORY_SPACE_MALLOC);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean mallocTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return mallocTest1();
            case 2:
                return mallocTest2();
            case 3:
                return mallocTest3();
            case 4:
                return mallocTest4();
            case 5:
                return mallocTest5();
            case 6:
                return mallocTest6();
            default:
                break; 
        }
        return false;
    }

    ///// Malloc tests /////
    private boolean mallocTest1() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(20 , 80) \n(0 , 20) ";
        String expected = "true";
        String actual = "";
        try {
            int address = memorySpace.malloc(20);
            actual += (address == 0 && memorySpace.toString().equals(expectedText));
            
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Malloc a block of memory", expected, actual);
    }

    private boolean mallocTest2() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(30 , 70) \n(0 , 10) (10 , 20) ";
        String expected = "true";
        String actual = "";
        try {
            int address1 = memorySpace.malloc(10);
            int address2 = memorySpace.malloc(20);
            actual += (address1 == 0 && address2 == 10 && memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Malloc 2 blocks of memory", expected, actual);
    }

    private boolean mallocTest3() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "\n(0 , 40) (40 , 40) (80 , 20) ";
        String expected = "true";
        String actual = "";
        try {
            int address1 = memorySpace.malloc(40);
            int address2 = memorySpace.malloc(40);
            int address3 = memorySpace.malloc(20);
            actual += (address1 == 0 && address2 == 40 && address3 == 80 && memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Malloc 3 blocks of memory to fill all memory space", expected, actual);
    }

    private boolean mallocTest4() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(60 , 40) \n(0 , 10) (10 , 10) (20 , 10) (30 , 30) ";
        String expected = "true";
        String actual = "";
        try {
            int address1 = memorySpace.malloc(10);
            int address2 = memorySpace.malloc(10);
            int address3 = memorySpace.malloc(10);
            int address4 = memorySpace.malloc(30);
            actual += (address1 == 0 && address2 == 10 && address3 == 20 && address4 == 30 && memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Malloc 4 blocks of memory", expected, actual);
    }

    private boolean mallocTest5() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(60 , 40) \n(0 , 10) (10 , 10) (20 , 10) (30 , 30) ";
        String expected = "true";
        String actual = "";
        try {
            int address1 = memorySpace.malloc(10);
            int address2 = memorySpace.malloc(10);
            int address3 = memorySpace.malloc(10);
            int address4 = memorySpace.malloc(30);
            int address5 = memorySpace.malloc(50);
            actual += (address1 == 0 && address2 == 10 && address3 == 20 && address4 == 30 && address5 == -1 && memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Malloc blocks of memory but will fail in last due to lack of space", expected, actual);
    }

    private boolean mallocTest6() {
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(0 , 100) \n";
        String expected = "true";
        String actual = "";
        try {
            int address1 = memorySpace.malloc(110);
            actual += (address1 == -1 && memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Malloc a block of memory bigger than memory space", expected, actual);
    }

    ///// Free tests /////
    /// tests handling ///
    private void mainFreeTest() {
        this.tester.reset(TesterQuestionEnum.MEMORY_SPACE_FREE);
        boolean passed = runAllTests(TesterQuestionEnum.MEMORY_SPACE_FREE);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }

    private boolean freeTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return freeTest1();
            case 2:
                return freeTest2();
            case 3:
                return freeTest3();
            case 4:
                return freeTest4();
            case 5:
                return freeTest5();
            case 6:
                return freeTest6();
            default:
                break;
        }
        return false;
    }

    ///// Free tests /////
    private boolean freeTest1(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(0 , 100) \n";
        String expected = "true";
        String actual = "";
        try {
            int address = memorySpace.malloc(100);
            memorySpace.free(address);
            actual += (memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Free a block of memory", expected, actual);
    }

    private boolean freeTest2(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(0 , 100)\n";
        String expected = TesterMessagesEnum.ERROR + " IllegalArgumentException: index must be between 0 and size";
        String actual = "";
        try {
            memorySpace.free(0);
            actual += (memorySpace.toString().equals(expectedText));
        } catch (IllegalArgumentException e) {
            actual = TesterMessagesEnum.ERROR + " IllegalArgumentException: " + e.getMessage();
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to free a block of memory when freeList is empty", expected, actual);
    }

    private boolean freeTest3(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "\n(0 , 100) ";
        String expected = "true";
        String actual = "";
        try {
            memorySpace.malloc(100);
            memorySpace.free(110);
            actual += (memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to free invalid address", expected, actual);
    }

    private boolean freeTest4(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(0 , 50) \n(50 , 50) ";
        String expected = "true";
        String actual = "";
        try {
            int address = memorySpace.malloc(50);
            memorySpace.malloc(50);
            memorySpace.free(address);
            memorySpace.free(address);
            actual += (memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to free address twice in a row", expected, actual);
    }

    private boolean freeTest5(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expected1 = "(95 , 5) \n(0 , 20) (20 , 75) ";
        String expected2 = "(95 , 5) (10 , 10) \n(20 , 75) (0 , 10) ";
        String expected = "true";
        String actual = "";
        boolean actualB = true;
        try {
            int address = memorySpace.malloc(20);
            int address1 = memorySpace.malloc(75);
            int address2 = memorySpace.malloc(10);
            actualB = (actualB && address == 0 && address1 == 20 && address2 == -1 && memorySpace.toString().equals(expected1));
            memorySpace.free(address);
            address2 = memorySpace.malloc(10);
            actual += (actualB && address2 == 0 && memorySpace.toString().equals(expected2));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to malloc after freed space", expected, actual);
    }

    private boolean freeTest6(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expected1 = "\n(0 , 5) (5 , 20) (25 , 20) (45 , 55) ";
        String expected2 = "(0 , 5) (25 , 20) \n(5 , 20) (45 , 55) ";
        String expected3 = "(0 , 5) (40 , 5) \n(5 , 20) (45 , 55) (25 , 15) ";
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
            int address4 = memorySpace.malloc(15);
            actual += (actualB && address4 == 25 && memorySpace.toString().equals(expected3));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Try to malloc after 2 frees that one doesn't fits", expected, actual);
    }
    
    ///// Defrag tests /////
    /// tests handling ///
    private void mainDefragTest() {
        this.tester.reset(TesterQuestionEnum.MEMORY_SPACE_DEFRAG);
        boolean passed = runAllTests(TesterQuestionEnum.MEMORY_SPACE_DEFRAG);
        if (passed) {
            this.tester.updatePoints();
        }
        System.out.println(tester);
    }
   
    private boolean defragTests(int testNumber) {
        switch (testNumber) {
            case 1:
                return defragTest1();
            case 2:
                return defragTest2();
            case 3:
                return defragTest3();
            case 4:
                return defragTest4();
            case 5:
                return defragTest5();
            default:
                break;
        }
        return false;
    }

    ///// Defrag tests /////
    private boolean defragTest1(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "(0 , 100) \n";
        String expected = "true";
        String actual = "";
        try {
            memorySpace.defrag();
            actual += (memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Defrag when freeList is empty", expected, actual);
    }

    private boolean defragTest2(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expectedText = "\n(0 , 100) ";
        String expected = "true";
        String actual = "";
        try {
            memorySpace.malloc(100);
            memorySpace.defrag();
            actual += (memorySpace.toString().equals(expectedText));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("Defrag when there is only one block", expected, actual);
    }

    private boolean defragTest3(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expected1 = "\n(0 , 5) (5 , 20) (25 , 20) (45 , 55) ";
        String expected2 = "(0 , 5) (5 , 20) \n(25 , 20) (45 , 55) ";
        String expected3 = "(0 , 25) \n(25 , 20) (45 , 55) ";
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
            memorySpace.free(address1);
            actualB = (actualB && memorySpace.toString().equals(expected2));
            memorySpace.defrag();
            actual += (actualB && memorySpace.toString().equals(expected3));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("defrag successfully 2 consecutive elements", expected, actual);
    }


    private boolean defragTest4(){
        MemorySpace memorySpace = new MemorySpace(100);
        String expected1 = "\n(0 , 5) (5 , 20) (25 , 20) (45 , 55) ";
        String expected2 = "(0 , 5) (5 , 20) (25 , 20) \n(45 , 55) ";
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
            memorySpace.free(address1);
            memorySpace.free(address2);
            actualB = (actualB && memorySpace.toString().equals(expected2));
            memorySpace.defrag();
            actual += (actualB && memorySpace.toString().equals(expected3));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("defrag successfully 3 elements", expected, actual);
    }

    private boolean defragTest5(){
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
            memorySpace.free(address1);
            memorySpace.defrag();
            actual += (actualB && memorySpace.toString().equals(expected3));
        } catch (Exception e) {
            actual = TesterMessagesEnum.ERROR + e.getMessage();
        }
        return this.tester.test("defrag successfully after failed defrag", expected, actual);
    }


    /// HELPER FUNCTIONS
    private LinkedList createLinkedList(MemoryBlock [] blocks) {
        LinkedList list = new LinkedList();
        for (int i = blocks.length - 1; i >= 0; i--) {
            list.addFirst(blocks[i]);
        }
        return list;
    }

    private boolean compareLinkedLists(LinkedList list1, LinkedList list2) {
        if (list1.getSize() != list2.getSize()) {
            return false;
        }
        ListIterator iterator1 = list1.iterator();
        ListIterator iterator2 = list2.iterator();
        while (iterator1.hasNext()) {
            MemoryBlock block1 = iterator1.next();
            MemoryBlock block2 = iterator2.next();
            if (!block1.equals(block2)) {
                return false;
            }
        }
        return true;
    }
}