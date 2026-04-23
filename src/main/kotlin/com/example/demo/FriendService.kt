package com.example.demo

class FriendService(private val people: List<Friend>) {

    // =========================
    // BASIC OPERATIONS
    // =========================

    fun getAll(): List<Friend> {
        // TODO:
        // Return all people in the system
        return emptyList()
    }

    fun add(friend: Friend): List<Friend> {
        // TODO:
        // Add a new friend into the list
        // Hint: return a new list (do NOT modify original list)
        return emptyList()
    }

    fun update(friend: Friend): List<Friend> {
        // TODO:
        // Update existing friend by matching ID
        // Hint: use map() and replace the matching record
        return emptyList()
    }

    fun delete(id: Int): List<Friend> {
        // TODO:
        // Remove friend by ID
        return emptyList()
    }

    // =========================
    // RELATIONSHIP FUNCTIONS
    // =========================

    fun getDirectFriends(id: Int): List<Friend> {
        // TODO:
        // Step 1: find the person by ID
        // Step 2: get their friends (List<Int>)
        // Step 3: convert IDs → Friend objects
        return emptyList()
    }

    fun getFriendOfFriend(id: Int): List<Friend> {
        // TODO:
        // Step 1: get direct friends
        // Step 2: find friends of those friends
        // Step 3: remove:
        //   - self
        //   - direct friends
        // Step 4: remove duplicates
        return emptyList()
    }

    fun getNotConnectedPeople(id: Int): List<Friend> {
        // TODO:
        // Step 1: get direct friends
        // Step 2: get friend of friends
        // Step 3: exclude:
        //   - self
        //   - direct friends
        //   - friend of friends
        return emptyList()
    }
}