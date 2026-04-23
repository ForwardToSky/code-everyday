package com.example.demo

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class FriendServiceTest {

    private lateinit var service: FriendService
    private lateinit var people: List<Friend>

    @BeforeEach
    fun setup() {
        people = listOf(
            Friend(1, "Alex", "011-1111111", listOf(2, 3)),
            Friend(2, "Ben", "012-2222222", listOf(1, 4)),
            Friend(3, "Cathy", "013-3333333", listOf(1)),
            Friend(4, "Diana", "014-4444444", listOf(2)),
            Friend(5, "Evan", "015-5555555", listOf())
        )

        service = FriendService(people)
    }

    // =========================
    // BASIC OPERATIONS
    // =========================

    @Test
    fun `getAll should return all people`() {
        val result = service.getAll()
        assertEquals(5, result.size)
    }

    @Test
    fun `add should insert new friend`() {
        val newFriend = Friend(6, "Frank", "016-6666666", listOf())

        val result = service.add(newFriend)

        assertEquals(6, result.size)
        assertTrue(result.any { it.id == 6 })
    }

    @Test
    fun `update should modify existing friend`() {
        val updated = Friend(1, "Alex Updated", "011-9999999", listOf(2))

        val result = service.update(updated)

        val found = result.find { it.id == 1 }
        assertEquals("Alex Updated", found?.name)
        assertEquals("011-9999999", found?.phoneNumber)
    }

    @Test
    fun `delete should remove friend by id`() {
        val result = service.delete(1)

        assertEquals(4, result.size)
        assertFalse(result.any { it.id == 1 })
    }

    // =========================
    // RELATIONSHIP FUNCTIONS
    // =========================

    @Test
    fun `getDirectFriends should return direct connections`() {
        val result = service.getDirectFriends(1)

        val ids = result.map { it.id }
        assertEquals(setOf(2, 3), ids.toSet())
    }

    @Test
    fun `getFriendOfFriend should return second level connections`() {
        val result = service.getFriendOfFriend(1)

        val ids = result.map { it.id }

        // Alex -> (2,3)
        // 2 -> (1,4), 3 -> (1)
        // Expected: 4 only
        assertEquals(setOf(4), ids.toSet())
    }

    @Test
    fun `getNotConnectedPeople should return unrelated users`() {
        val result = service.getNotConnectedPeople(1)

        val ids = result.map { it.id }

        // Alex connections:
        // Direct: 2,3
        // FoF: 4
        // Remaining: 5
        assertEquals(setOf(5), ids.toSet())
    }
}