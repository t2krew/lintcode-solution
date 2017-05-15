# 102.带环链表 / linked-list-cycle
# http://www.lintcode.com/zh-cn/problem/linked-list-cycle/

# 给定一个链表，判断它是否有环。

# 给出 -21->10->4->5, tail connects to node index 1，返回 true

"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    """
    @param head: The first node of the linked list.
    @return: True if it has a cycle, or false
    """
    def hasCycle(self, head):
        # write your code here
        fast = slow = head
        while(fast is not None and fast and fast.next is not None) :
            fast = fast.next.next
            slow = slow.next
            if fast == slow:
                break
        if fast is None or fast.next is None:
            return False
        else:
            return True