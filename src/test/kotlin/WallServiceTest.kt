package ru.netology.dz2_3_attachments

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPost() {
        val newComment = Comment(1)
        val newLike = Like(1, true, false)
        var newPostSource = PostSource(platform = "android", data = "profile_photo")
        var newRepostsInfo = RepostsInfo(12)
        var newPost = Post(comments = newComment,
            likes = newLike,
            postSource = newPostSource,
            reposts = newRepostsInfo)
        val result = WallService.addPost(newPost).id

        assertEquals(1, result)
    }

    @Test
    fun updatePostSuccess() {
        var newComment = Comment(1)
        var newLike = Like(1, true, false)
        var newPostSource = PostSource(platform = "android", data = "profile_photo")
        var newRepostsInfo = RepostsInfo(12)
        var newPost = Post(comments = newComment,
            likes = newLike,
            postSource = newPostSource,
            reposts = newRepostsInfo)
        WallService.addPost(newPost)

        newComment = Comment(5)
        newLike = Like(4, true, false)
        newPostSource = PostSource(platform = "android", data = "profile_photo")
        newRepostsInfo = RepostsInfo(12)
        newPost = Post(comments = newComment,
            likes = newLike,
            postSource = newPostSource,
            reposts = newRepostsInfo)
        WallService.addPost(newPost)

        newPost = Post(id = 1, comments = newComment, likes = newLike, postSource = newPostSource,
            reposts = newRepostsInfo, views = 21)
        val result = WallService.updatePost(newPost)

        assertTrue(result)

    }

    @Test
    fun updatePostFailure() {
        var newComment = Comment(1)
        var newLike = Like(1, true, false)
        var newPostSource = PostSource(platform = "android", data = "profile_photo")
        var newRepostsInfo = RepostsInfo(12)
        var newPost = Post(comments = newComment,
            likes = newLike,
            postSource = newPostSource,
            reposts = newRepostsInfo)
        WallService.addPost(newPost)

        newComment = Comment(5)
        newLike = Like(4, true, false)
        newPostSource = PostSource(platform = "android", data = "profile_photo")
        newRepostsInfo = RepostsInfo(12)
        newPost = Post(comments = newComment,
            likes = newLike,
            postSource = newPostSource,
            reposts = newRepostsInfo)
        WallService.addPost(newPost)

        newPost = Post(id = 3, comments = newComment, likes = newLike, postSource = newPostSource,
            reposts = newRepostsInfo,views = 21)
        val result = WallService.updatePost(newPost)

        assertFalse(result)

    }

}