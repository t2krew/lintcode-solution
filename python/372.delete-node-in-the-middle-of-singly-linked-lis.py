# 给定一个单链表中的一个等待被删除的节点(非表头或表尾)。请在在O(1)时间复杂度删除该链表节点。

# Exa
# 给定 1->2->3->4，和节点 3，删除 3 之后，链表应该变为 1->2->4。

"""
Definition of ListNode
class ListNode(object):

    def __init__(self, val, next=None):
        self.val = val
        self.next = next
"""
class Solution:
    # @param node: the node in the list should be deleted
    # @return: nothing
    def deleteNode(self, node):
        # write your code here
        if node is None:
            return
        if node.next is not None:
            node.val = node.next.val
            node.next = node.next.next