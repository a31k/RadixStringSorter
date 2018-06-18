# A simple Binary Search Tree implementation for integers
# Drake D. (a31k)
# 2018.06.15


class Node:

    left_ref = None
    right_ref = None
    data = None

    def __init__(self, data):
        self.data = str(data)

    def set_left(self, left_node):
        new_node = Node(str(left_node))
        self.left_ref = new_node

    def set_right(self, right_node):
        new_node = Node(str(right_node))
        self.right_ref = new_node

    def inorder_traversal(self):
        if self.left_ref is None and self.right_ref is None:
            return self.data

        if self.left_ref is not None and self.right_ref is not None:
            return self.left_ref.inorder_traversal() + ' ' + self.data + ' ' + self.right_ref.inorder_traversal()

        if self.left_ref is None:
            return self.data + ' ' + self.right_ref.inorder_traversal()

        if self.right_ref is None:
            return self.left_ref.inorder_traversal() + ' ' + self.data

    def preorder_traversal(self):
        if self.left_ref is None and self.right_ref is None:
            return self.data

        if self.left_ref is not None and self.right_ref is not None:
            return self.data + ' ' + self.left_ref.preorder_traversal() + ' ' + self.right_ref.preorder_traversal()

        if self.left_ref is None:
            return self.data + ' ' + self.right_ref.preorder_traversal()

        if self.right_ref is None:
            return self.data + ' ' + self.left_ref.preorder_traversal()

    def postorder_traversal(self):
        if self.left_ref is None and self.right_ref is None:
            return self.data

        if self.left_ref is None:
            return self.right_ref.postorder_traversal() + ' ' + self.data

        if self.right_ref is None:
            return self.left_ref.postorder_traversal() + ' ' + self.data

        if self.left_ref is not None and self.right_ref is not None:
            return self.left_ref.postorder_traversal() + ' ' + self.right_ref.postorder_traversal() + ' ' + self.data

    def search(self, key):
        if key == self.data:
            return self
        if key < int(self.data):
            return self.left_ref.search(key)
        if key > int(self.data):
            return self.right_ref.search(key)

    def insert(self, new_value):
        if new_value is None:
            print('Cannot add value "None"')

        if self.right_ref is None and self.left_ref is None:
            if int(self.data) < new_value:
                self.set_right(new_value)
            if int(self.data) > new_value:
                self.set_left(new_value)

        if self.right_ref is None and int(self.data) < new_value:
            self.set_right(new_value)
        if self.left_ref is None and int(self.data) > new_value:
            self.set_left(new_value)

        if new_value < int(self.data):
            return self.left_ref.insert(new_value)
        if new_value > int(self.data):
            return self.right_ref.insert(new_value)

    def inorder_successor(self):
        if self.left_ref is None and self.right_ref is None:
            return self.data
        else:
            return self.left_ref.inorder_successor()

    def delete(self, value):
        if self.data == value:
            if self.left_ref is None and self.right_ref is None:
                self.data = None

            if self.right_ref is not None and self.left_ref is not None:
                temp = self.right_ref.inorder_successor()
                self.right_ref.delete(self.inorder_successor())
                self.data = temp.data
                self.right_ref = temp.right_ref
                self.left_ref = temp.left_ref

            if self.left_ref is None:
                self.data = self.right_ref.data
                self.left_ref = self.right_ref.left_ref
                self.right_ref = self.right_ref.right_ref

            if self.right_ref is None:
                self.data = self.left_ref.data
                self.left_ref = self.left_ref.left_ref
                self.right_ref = self.left_ref.right_ref

        if int(self.data) < value:
            return self.right_ref.delete(value)
        if int(self.data) > value:
            return self.left_ref.delete(value)


# Testing below...

root = Node(10)
root.insert(5)
root.insert(2)
root.insert(11)
root.insert(12)
root.insert(14)
root.insert(13)

print('Inorder traversal : ' + str(root.inorder_traversal()))
print('Preorder traversal : ' + str(root.preorder_traversal()))
print('Postorder traversal : ' + str(root.postorder_traversal()))
