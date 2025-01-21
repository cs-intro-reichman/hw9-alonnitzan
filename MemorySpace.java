/**
 * Represents a managed memory space. The memory space manages a list of allocated 
 * memory blocks, and a list free memory blocks. The methods "malloc" and "free" are 
 * used, respectively, for creating new blocks and recycling existing blocks.
 */
public class MemorySpace {
	
	// A list of the memory blocks that are presently allocated
	private LinkedList allocatedList;

	// A list of memory blocks that are presently free
	private LinkedList freeList;

	/**
	 * Constructs a new managed memory space of a given maximal size.
	 * 
	 * @param maxSize
	 *            the size of the memory space to be managed
	 */
	public MemorySpace(int maxSize) {
		// initiallizes an empty list of allocated blocks.
		allocatedList = new LinkedList();
	    // Initializes a free list containing a single block which represents
	    // the entire memory. The base address of this single initial block is
	    // zero, and its length is the given memory size.
		freeList = new LinkedList();
		freeList.addLast(new MemoryBlock(0, maxSize));
	}

	/**
	 * Allocates a memory block of a requested length (in words). Returns the
	 * base address of the allocated block, or -1 if unable to allocate.
	 * 
	 * This implementation scans the freeList, looking for the first free memory block 
	 * whose length equals at least the given length. If such a block is found, the method 
	 * performs the following operations:
	 * 
	 * (1) A new memory block is constructed. The base address of the new block is set to
	 * the base address of the found free block. The length of the new block is set to the value 
	 * of the method's length parameter.
	 * 
	 * (2) The new memory block is appended to the end of the allocatedList.
	 * 
	 * (3) The base address and the length of the found free block are updated, to reflect the allocation.
	 * For example, suppose that the requested block length is 17, and suppose that the base
	 * address and length of the the found free block are 250 and 20, respectively.
	 * In such a case, the base address and length of of the allocated block
	 * are set to 250 and 17, respectively, and the base address and length
	 * of the found free block are set to 267 and 3, respectively.
	 * 
	 * (4) The new memory block is returned.
	 * 
	 * If the length of the found block is exactly the same as the requested length, 
	 * then the found block is removed from the freeList and appended to the allocatedList.
	 * 
	 * @param length
	 *        the length (in words) of the memory block that has to be allocated
	 * @return the base address of the allocated block, or -1 if unable to allocate
	 */
	public int malloc(int length) {		
		
		Node currentFree = freeList.getFirst();
		Node allocatedNode = null;

		while (currentFree != null){
			if (currentFree.block.length >= length){
				allocatedNode = currentFree;
				currentFree = null;
			}
			else{
				currentFree = currentFree.next;
			}
		}

		if(allocatedNode == null){
			return -1;
		}
		
		else if (allocatedNode.block.length > length){
			MemoryBlock newMemory = new MemoryBlock(allocatedNode.block.baseAddress, length);
			allocatedList.addLast(newMemory);

			allocatedNode.block.length = allocatedNode.block.length - length;
			allocatedNode.block.baseAddress = allocatedNode.block.baseAddress + length;

			return newMemory.baseAddress;
		}
		
		// when lengths equals
		else{
			freeList.remove(allocatedNode);
			allocatedList.addLast(allocatedNode.block);

			return allocatedNode.block.baseAddress;
		}
	}

	/**
	 * Frees the memory block whose base address equals the given address.
	 * This implementation deletes the block whose base address equals the given 
	 * address from the allocatedList, and adds it at the end of the free list. 
	 * 
	 * @param baseAddress
	 *            the starting address of the block to freeList
	 */
	public void free(int address) {

		Node currentAllocated = allocatedList.getFirst();
		Node wantedNode = null;

		while (currentAllocated != null){
			if (currentAllocated.block.baseAddress == address){
				wantedNode = currentAllocated;
				currentAllocated = null;
			}
			else{
				currentAllocated = currentAllocated.next;
			}
		}

		if (wantedNode != null){
			allocatedList.remove(wantedNode);
			freeList.addLast(wantedNode.block);
		}

	}
	
	/**
	 * A textual representation of the free list and the allocated list of this memory space, 
	 * for debugging purposes.
	 */
	public String toString() {
		return freeList.toString() + "\n" + allocatedList.toString();		
	}
	
	/**
	 * Performs defragmantation of this memory space.
	 * Normally, called by malloc, when it fails to find a memory block of the requested size.
	 * In this implementation Malloc does not call defrag.
	 */
	public void defrag() {
		/// TODO: Implement defrag test
		
		
		Node n1 = freeList.getFirst();
		Node found1 = null;
		Node found2 = null;

		int n1Index = 0;
		int n2Index = 0;

		while (n1 != null){

			Node n2 = freeList.getFirst();

			while (n2 != null){

				if (n1.block.baseAddress + n1.block.length == n2.block.baseAddress){
					found1 = n1;
					found2 = n2;

					n1 = null;
					n2 = null;
				}

				else{
					n2 = n2.next;
					n2Index ++;
				}

			}

			if (found1 == null && found2 == null){
				n1 = n1.next;
				n1Index ++;
			}

		}

		if (found1 != null && found2 != null){

			// which one is before int the list
			if (n1Index < n2Index){
				freeList.remove(found2);
				found1.block.length = found1.block.length + found2.block.length;
			}

			else{
				freeList.remove(found1);
				found2.block.length = found2.block.length + found1.block.length;
			}

		}

	}
}
