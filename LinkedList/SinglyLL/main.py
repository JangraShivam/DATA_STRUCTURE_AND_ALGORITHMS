# Singly Linked List

class Node :
    data = None
    next = None

    def __init__(self, data: int)-> None :
        self.data = data
        self.next = None
    

class SinglyLL:
    head = None
    tail = None

    def __init__(self) -> None:
        return
    
    # Search in List
    def search(self,target: int) -> bool :
        itr = self.head
        while itr != None :
            if(itr.data == target): 
                return True
            itr = itr.next
        
        return False

    # get list length
    def getLength(self) -> int :
        itr = self.head
        length = 0
        while itr != None :
            length+=1
            itr = itr.next
        
        return length
    
    # insert at head
    def insertAtHead(self, value: int) -> None:
        # Create the node to add with given value
        newNode = Node(value)

        # check if both head and tail ptr is None
        if self.head == None and self.tail == None :
            self.head = newNode
            self.tail = newNode
        else :
            # attach newnode next to head node
            newNode.next = self.head
            # move head to new node
            self.head = newNode
        

    # insert at tail
    def insertAtTail(self, value: int):
        # Create the node to add with given value
        newNode = Node(value)

        # check if both head and tail ptr is None
        if self.head == None and self.tail == None :
            self.head = newNode
            self.tail = newNode
        else :
            # attach new node to tail
            self.tail.next = newNode
            # move tail to new node
            self.tail = newNode


    # Insert At position (0 based)
    def insertAtPosition(self, position: int,value: int) -> None:

        # pos < 0 or pos > length -> not a valid position
        if(position < 0 or position >= self.getLength()) :
            print("Not a valid position")
            return

        # pos = 0 -> insert at head
        if(position == 0 or (self.head == None and self.tail == None)) :
            self.insertAtHead(value)
            return


        currPosition = 0 # track current position
        currentNode = self.head # node at current position
        previousNode = None # node previous then current node

        # Traverse the list until position is reached or list end
        while(currPosition < position and currentNode != None) :
            currPosition+=1
            previousNode = currentNode
            currentNode = currentNode.next
        

        # create the Node to be added
        newNode = Node(value)

        # adding logic (if pos > length of list -> add in the end)
        previousNode.next = newNode
        newNode.next = currentNode


    # Delete node from head
    def deleteFromHead(self) -> None :
        
        # check if list is empty
        if(self.head == None and self.tail == None) :
            print("List is Empty")
            return

        # check if only one node is in list
        if(self.head == self.tail) :
            del self.head
            self.head = None
            self.tail = None
            return

        # more than one element
        newHead = self.head.next
        self.head.next = None
        del self.head
        self.head = newHead
        
        return 
    

    # Delete node from tail
    def deleteFromTail(self) -> None:
        
        # check if list is empty
        if(self.head == None and self.tail == None) :
            print("List is Empty")
            return 

        # check if only one node is in list
        if(self.head == self.tail) :
            del self.head
            self.head = None
            self.tail = None
            return

        # more than one element
        newTail = self.head
        
        while (newTail.next != self.tail) :
            newTail = newTail.next
        
        newTail.next = None
        del self.tail
        self.tail = newTail

        return


    # Delete node from pos
    def deleteFromPosition(self, position: int) -> None:
        
        # check if position < 0 -> not a valid position
        if(position < 0 or position >= self.getLength()) :
            print("Not a valid position")
            return

        if(position == 0) :
            self.deleteFromHead()
            return

        if(position == self.getLength() - 1) :
            self.deleteFromTail()
            return 

        # deletion logic
        currPos = 0
        currentNode = self.head
        prevNode = self.tail

        while(currPos < position) :
            currPos+=1
            prevNode = currentNode
            currentNode =  currentNode.next

        prevNode.next = currentNode.next
        currentNode.next = None
        del currentNode

        return 

    def deleteByValue(self, value: int) -> None:
        
        currentNode = self.head
        prevNode = None
        while currentNode != None :
            nextNode = currentNode.next

            if currentNode.data == value :
                if currentNode == self.head : self.deleteFromHead()
                elif currentNode ==  self.tail: self.deleteFromTail()
                else :
                    prevNode.next = currentNode.next
                    currentNode.next = None
                    del currentNode
            else : prevNode = currentNode
            currentNode = nextNode; 
        

    def printList(self) -> None:
        itr = self.head
        print("list : ",end="")
        while itr != None :
            print(itr.data,"->",end="")
            itr = itr.next
        
        print("N")





# Main
list1 = SinglyLL()
list1.insertAtHead(10) # 10 -> N
list1.insertAtHead(20) # 20 -> 10 -> N
list1.insertAtHead(30) # 30 -> 20 -> 10 -> N
list1.insertAtHead(40) # 40 -> 30 -> 20 -> 10 -> N
list1.printList()

list1.insertAtTail(50) # 40 -> 30 -> 20 -> 10 -> 50 -> N
list1.insertAtTail(60) # 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> N
list1.insertAtTail(70) # 40 -> 30 -> 20 -> 10 -> 50 -> 60 -> 70 -> N
list1.printList()

list1.insertAtPosition(2,80) # 40 -> 30 -> 80 -> 20 -> 10 -> 50 -> 60 -> 70 ->  N
list1.insertAtPosition(5,90) # 40 -> 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
list1.printList()

if(list1.search(90)) :
    print("Target Found")
else :
    print("target Not found")


list1.deleteFromHead() # 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> 70 -> N
list1.printList()

list1.deleteFromTail() # 30 -> 80 -> 20 -> 10 -> 90 -> 50 -> 60 -> N
list1.printList()

list1.deleteFromPosition(3) # 30 -> 80 -> 20 -> 90 -> 50 -> 60 -> N
list1.printList()

list1.deleteFromHead() # 80 -> 20 -> 90 -> 50 -> 60 -> N
list1.printList()

list1.deleteFromTail() # 80 -> 20 -> 90 -> 50 -> N
list1.printList()

list1.deleteFromPosition(3) # 80 -> 20 -> 90 -> N
list1.printList()

list1.deleteFromHead() # 20 -> 90 -> N
list1.printList()

list1.deleteFromTail() # 20 -> N
list1.printList()

list1.deleteFromPosition(3) # not valid , 20 -> N
list1.printList()

list1.insertAtHead(20)
list1.insertAtHead(30)
list1.insertAtHead(20)
list1.printList()

list1.deleteByValue(20)
list1.printList()

