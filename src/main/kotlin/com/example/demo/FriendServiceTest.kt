package com.example.demo

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FriendServiceTest {

    private val people = MockFriendData.people

    private val service = FriendService(people)

    @Test
    fun `direct friends`() {
        val result = service.getDirectFriends(1)
        assertEquals(1, result.size)
        assertEquals("Ben", result[0].name)
    }

    @Test
    fun `friend of friend`() {
        val result = service.getFriendOfFriend(1)
        val names = result.map { it.name }

        assertTrue(names.contains("Cathy"))
        assertFalse(names.contains("Ben"))
        assertFalse(names.contains("Alex"))
    }

    @Test
    fun `not connected`() {
        val result = service.getNotConnectedPeople(1)
        val names = result.map { it.name }

        assertTrue(names.contains("Ivan"))
        assertTrue(names.contains("Quinn"))
        assertFalse(names.contains("Ben"))
        assertFalse(names.contains("Cathy"))
    }

    @Test
    fun `add friend`() {
        val newFriend = Friend(100, "Test", "012-0000000", emptyList())
        val result = service.add(newFriend)

        assertTrue(result.any { it.id == 100 })
    }

    @Test
    fun `update friend`() {
        val updated = Friend(1, "Alex Updated", "011-4829137", listOf(2))
        val result = service.update(updated)

        assertEquals("Alex Updated", result.first { it.id == 1 }.name)
    }

    @Test
    fun `delete friend`() {
        val result = service.delete(1)
        assertFalse(result.any { it.id == 1 })
    }
}