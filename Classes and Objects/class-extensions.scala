case class Circle(x: Double, y: Double, radius: Double)

implicit class CircleOps(c: Circle) {
  def circumference: Double = c.radius * math.Pi * 2
}