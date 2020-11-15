package com.example.lesson10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.lesson10.dao.*
import com.example.lesson10.model.*

class MainActivity : AppCompatActivity() {

    lateinit var db: AppDatabase
    lateinit var userDao: UserDao
    lateinit var libraryDao: LibraryDao
    lateinit var playlistDao: PlaylistDao
    lateinit var songDao: SongDao
    lateinit var playlistSongCrossRefDao: PlaylistSongCrossRefDao


    lateinit var users: List<User>
    lateinit var usersAndLibraries: List<UserAndLibrary>
    lateinit var usersWithPlaylists: List<UserWithPlaylists>
    lateinit var playlistsWithSongs: List<PlaylistWithSongs>
    lateinit var songs: List<Song>
    lateinit var playlists: List<Playlist>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MyApplication.instance.getDatabase()!!
        userDao = db.UserDao()
        libraryDao = db.LibraryDao()
        playlistDao = db.PlaylistDao()
        songDao = db.SongDao()
        playlistSongCrossRefDao = db.PlaylistSongCrossRefDao()

        users = userDao.getAll()
        usersAndLibraries = userDao.getUsersAndLibraries()
        usersWithPlaylists = userDao.getUsersWithPlaylists()

        playlistsWithSongs = playlistDao.getPlaylistsWithSongs()

        for (ps in playlistsWithSongs) {
            Log.e(
                "Playlist:",
                ps.playlist.playlistId.toString() + " " + ps.playlist.playlistName + " " + ps.playlist.userCreaterId
            )
            Log.e("     Songs:", "")

            for (s in ps.songs) {
                Log.e("         Song: ", s.songId.toString() + " " + s.songName + " " + s.artist)
            }

        }

    }

    fun onClick(view: View) {
        if (view.id == R.id.add_button_user) {
            var user = User()
            user.firstName = "Olzhas"
            user.lastName = "Dairov"
            var address = Address("Tole bi", "Almaty", "Almaty", "05000")
            user.address = address

            user.uid = userDao.insert(user)

            var library = Library()
            library.title = "Lib title"
            library.userOwnerId = user.uid
            library.libraryId = libraryDao.insert(library)

            Log.e("LibraryId:", library.libraryId.toString())
            Log.e("LibraryOwner:", library.userOwnerId.toString())



            for (i in 0..5) {
                var playlist = Playlist()
                playlist.playlistName = "Playlist $i"
                playlist.userCreaterId = user.uid
                playlistDao.insert(playlist)
            }

            for (i in 0..5) {
                var song = Song()
                song.artist = "Artist $i"
                song.songName = "Song $i"
                songDao.insert(song)
            }

            songs = songDao.getAll().takeLast(5)
            playlists = playlistDao.getAll(user.uid!!)

            for (s in songs) {
                for (p in playlists) {
                    var playlistSongCrossRef =
                        PlaylistSongCrossRef(p.playlistId!!,s.songId!!)
                    playlistSongCrossRefDao.insert(playlistSongCrossRef)
                }
            }


        } else if (view.id == R.id.delete_button) {
            if (users.isNotEmpty()) {
                userDao.delete(users.get(0))

                users = userDao.getAll()
                for (user in users) {
                    Log.e("User:", user.uid.toString() + " " + user.firstName + " " + user.lastName)
                    Log.e(
                        "Address:",
                        user.address!!.street + " " + user.address!!.state + " " + user.address!!.city + " " + user.address!!.postCode
                    )
                }
            }
        } else if(view.id == R.id.update_button){
            var user = users.get(0)
            user.firstName = "OtherName"
            userDao.update(user)
            var uuu = userDao.getAll()
            for (user in uuu) {
                Log.e("User:", user.uid.toString() + " " + user.firstName + " " + user.lastName)
                Log.e(
                    "Address:",
                    user.address!!.street + " " + user.address!!.state + " " + user.address!!.city + " " + user.address!!.postCode
                )
            }
        } else {
            libraryDao.deleteAll()
            playlistSongCrossRefDao.deleteAll()
            playlistDao.deleteAll()
            songDao.deleteAll()
            userDao.deleteAll()
        }

    }
}