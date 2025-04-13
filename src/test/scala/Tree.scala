sealed trait Tree

object Tree {

  case class Node(one: Tree, two: Tree, three: Tree) extends Tree

  case class Leaf(x: Int) extends Tree
}