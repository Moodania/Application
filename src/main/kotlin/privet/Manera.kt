package privet;

import com.mood.Moodania.DataAccessLayer.Entities.UserEntity
import java.util.UUID

class Manera {
     fun manera(args : Array<String>){
         var list = mutableListOf(UserEntity(), UserEntity())
         list.map { it.id = UUID.randomUUID() }
        println(list.map { it -> it.id })
    }
}