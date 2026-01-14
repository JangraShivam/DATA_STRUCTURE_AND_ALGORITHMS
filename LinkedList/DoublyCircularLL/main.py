# Doubly Circular Linked List

class Node:

    def __init__(self, data: int) -> None:
        self.data = data
        self.next = self
        self.prev = self

class DoublyCircularLL:

    def __init__(self):
        self.iterator = None

    def getLength(self) -> int:
        itr = self.iterator
        length = 1
        itr = itr.next
        
        while itr != self.iterator:
            length += 1
            itr = itr.next
        
        return length
    
    def search(self, target: int) -> bool :
        itr = self.iterator
        length = self.getLength()

        for i in range(0, length):
            if itr.data == target: return True
            itr = itr.next

        return False
    
    def insert(self, value: int) -> None:
        newNode = Node(value)

        if self.iterator == None:
            self.iterator = newNode
        else:
            newNode.next = self.iterator.next
            newNode.next.prev = newNode
            self.iterator.next = newNode
            newNode.prev = self.iterator

    def deleteByValue(self, value: int) -> None:

        if self.iterator == None:
            print("List is empty")
            return

        if self.iterator.next == self.iterator and self.iterator.data == value:
            del self.iterator
            self.iterator = None
            return
        
        current = self.iterator.next
        

        while current != self.iterator:
            nextNode = current.next
            if current.data == value:
                current.prev.next = nextNode
                nextNode.prev = current.prev
                current.next = None
                current.prev = None
                del current
            
            current = nextNode

    def print(self) -> None:
        length = self.getLength()
        itr = self.iterator

        print("List : ",end="")
        for i in range(0, length) :
            print(itr.data,"->",end="")
            itr = itr.next
        
        print(itr.data)

    def printReverse(self) -> None:
        length = self.getLength()
        itr = self.iterator

        print("List : ",end="")
        for i in range(0, length) :
            print(itr.data,"->",end="")
            itr = itr.prev
        
        print(itr.data)


# main
list1 = DoublyCircularLL()

list1.insert(10)
list1.insert(40)
list1.insert(30)
list1.insert(20)
list1.print()
list1.printReverse()

if list1.search(20):
    print("Target Found")
else:
    print("Target not found")

list1.deleteByValue(20)
list1.print()
list1.printReverse()