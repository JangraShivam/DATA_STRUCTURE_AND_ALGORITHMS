# Singly Circular Linked List

class Node:

    def __init__(self, data: int) -> None:
        self.data = data
        self.next = self

class SinglyCircularLL:

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
            self.iterator.next = newNode

    def deleteByValue(self, value: int) -> None:

        if self.iterator == None:
            print("List is empty")
            return

        if self.iterator.next == self.iterator and self.iterator.data == value:
            del self.iterator
            self.iterator = None
            return
        
        current = self.iterator
        nextNode = current.next

        while nextNode != self.iterator:
            if nextNode.data == value:
                current.next = nextNode.next
                nextNode.next = None
                del nextNode

                nextNode = current.next
            else:
                current = nextNode
                nextNode = nextNode.next

    def print(self) -> None:
        length = self.getLength()
        itr = self.iterator

        print("List : ",end="")
        for i in range(0, length) :
            print(itr.data,"->",end="")
            itr = itr.next
        
        print(itr.data)


# main
list1 = SinglyCircularLL()

list1.insert(10)
list1.insert(20)
list1.insert(30)
list1.insert(20)
list1.print()

if list1.search(20):
    print("Target Found")
else:
    print("Target not found")

list1.deleteByValue(20)
list1.print()