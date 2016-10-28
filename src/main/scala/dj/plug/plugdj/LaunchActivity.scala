package dj.plug.plugdj

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import dj.plug.plugdj.MainApplication._
import dj.plug.plugdj.player.PlayerActivity
import dj.plug.plugdj.rooms.RoomActivity

class LaunchActivity extends AppCompatActivity {
  implicit val context = this

  override def onResume(): Unit = {
    super.onResume()
    val intent = if (hasPlayerService) {
      new Intent(this, classOf[PlayerActivity])
    } else {
      new Intent(this, classOf[RoomActivity])
    }
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK)
    startActivity(intent)
    finishAfterTransition()
  }
}
