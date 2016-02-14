Welcome to Facebook!

This is just a simple shared plaintext pad, with no execution capabilities.

When you know what language you'd like to use for your interview,
simply choose it from the dropdown in the top bar.

Enjoy your interview!

Queue
 2
 nodesincurlevel = 1
 nodeinnextlevel = 0

  2
  4, 5
  ncur = 2
  n =0

Input:
      2
    4 -> 5
  1  ->    8
Print:
  1 4 2 5 8

      7
    8
  9  10
11  8  19
Print:
11 9 8 8 7 10 19

11 is distance of 3 from 7
 9  of 2 from 7
 8 of 1 from 7
 8 of 1 from 7


Node {
  Node * lc;
  Node * rc;
  int val;
  int distance;
  Node * next;
}

void printByCol(Node * root) {


}

class Node:
  def __init__(self, val):
    self.val = val
    self.distance = None
    self.left, self.right = None, None

def print_column_order(root, distance_from_root):
  if not root:
    return
  if distance_from_root == root.distance:
    print root.val
  else:
    #if distance_from_root < 0:
    if distance_from_root > root.distance:
      print_column_order(root.right, distance_from_root)
      print_column_order(root.left, distance_from_root)
    else:
      print_column_order(root.left, distance_from_root)
      #if distance_from_root > 0:
      print_column_order(root.right, distance_from_root)

min_dist, max_dist = 0, 0
def populate_tree_with_distance(root, dist):
  if not root:
    return
  root.distance = dist
  if dist < min_dist:
    min_dist = dist
  if dist > max_dist:
    max_dist = dist
  populate_tree_with_distance(root.left, dist-1)
  populate_tree_with_distance(root.right, dist+1)

def print_column_wise(root):
    for i in range(min_dist, max_dist+1):
      print_column_order(root, i)

def main():
  populate_tree_with_distance(root, 0)
  print_column_wise(root)



  #1 empty binary tree
  #2

     2
    1
  -1

  #3
  3
    4
      5

  #4
          7
        8
    10
  16   11
    17    12
       18

