package life

import scala.swing.{Panel, MainFrame, Swing, SimpleSwingApplication}
import java.awt.{Color, Graphics2D, Dimension}

object Timer {
  // From http://otfried.org/scala/timers.html
  def apply(interval: Int, repeats: Boolean = true)(op: => Unit) {
    val timeOut = new javax.swing.AbstractAction() {
      def actionPerformed(e : java.awt.event.ActionEvent) = op
    }
    val t = new javax.swing.Timer(interval, timeOut)
    t.setRepeats(repeats)
    t.start()
  }
}

class DataPanel() extends Panel {
  // From http://stackoverflow.com/a/6978542/770271

  var currentGeneration = Set((25,25), (25,26),
                              (26,26), (26,27),
                              (27,26))

  val frameDelay = 500 // 500 milliseconds
  Timer(500)
    {
      //TODO don't hardcode dims
      currentGeneration = Life.iterate(currentGeneration, (300/5, 300/5))
      this.repaint()
    }

  override def paintComponent(g: Graphics2D) {
    g.clearRect(0, 0, g.getClipBounds.width, g.getClipBounds.height)

    g.setColor(Color.BLACK)

    val dx = 5
    val dy = 5
    for {
      cell <- currentGeneration
      x1 = (cell._1 * dx).toInt
      y1 = (cell._2 * dy).toInt
      x2 = ((cell._1 + 1) * dx).toInt
      y2 = ((cell._2 + 1) * dy).toInt
    } g.fillRect(x1, y1, x2 - x1, y2 - y1)
  }
}


object Draw extends SimpleSwingApplication {
  // From http://stackoverflow.com/a/6978542/770271

  def top = new MainFrame {
    contents = new DataPanel() {
      preferredSize = new Dimension(300, 300)
      title = "Heelo Wordl!"
    }
  }
}
