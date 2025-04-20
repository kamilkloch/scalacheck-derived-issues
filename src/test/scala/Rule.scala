sealed trait Rule

object Rule {
  case object UseFirst extends Rule

  case object UseSecond extends Rule

  case class FirstOf(rules: Seq[Rule], default: Rule) extends Rule
}