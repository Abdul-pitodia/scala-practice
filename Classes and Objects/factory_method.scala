trait Button {
  def display: String
}

case class WindowsButton() extends Button {
  def display = "I am a windows button"
}

class LinuxButton extends Button {
  def display = "I am a linux button"
}

trait DialogBox {
  def render = s"Rendering... ${this.createButton.display}"

  def createButton: Button
}

class LinuxDialog extends DialogBox {
  def createButton = new LinuxButton
}

class WindowsDialog extends DialogBox {
  def createButton = new WindowsButton
}

val wd: DialogBox = new WindowsDialog
wd.render
