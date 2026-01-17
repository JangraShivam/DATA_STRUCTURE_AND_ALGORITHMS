# Problem : Add 1 to a Linked List Number (GFG)

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class Solution:
    
    def addOneRecursive(self, head) -> int :
        # Base case return 1 to add 
        if head == None: return 1

        carry = self.addOneRecursive(head.next)
        sum = (head.data) + carry

        head.data = (sum % 10)
        return (sum//10)

    def addOneRecursively(self, head):
        # recusively
        carry = self.addOneRecursive(head)
        if carry != 0 :
            newNode = Node(carry)
            newNode.next = head
            head = newNode

        return head

    def addOneIterative(self,head):
        # reverse the list 
        prev = None
        current = head
        nextNode = head.next

        while current != None :
            current.next = prev
            prev = current
            current = nextNode
            if(nextNode != None): nextNode = nextNode.next

        # update head
        head = prev

        # add 1 to LL 
        carry = 1 
        while prev != None and carry != 0 :
            sum = (prev.data) + carry

            prev.data = (sum % 10)
            carry = (sum // 10)

            prev = prev.next

        # reverse the list again
        prev = None
        current = head
        nextNode = head.next
        while current != None :
            current.next = prev
            prev = current
            current = nextNode
            if(nextNode != None): nextNode = nextNode.next

        #update head
        head = prev

        # check if carry is not equal to zero
        if carry != 0 :
            newNode = Node(carry)
            # insert at head
            newNode.next = head
            head = newNode

        return head
    
    def addOne(self,head):
        # return self.addOneIterative(head)
        return self.addOneRecursively(head)