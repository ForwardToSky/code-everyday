Installation can take a look on the word document namely, "Prerequisite.docx" located on the same path

sample json value:
```json
{
  "people": [
    { "id": 1, "name": "Alex", "phoneNumber": "011-4829137", "friends": [2] },
    { "id": 2, "name": "Ben", "phoneNumber": "013-9052746", "friends": [3] },
    { "id": 3, "name": "Cathy", "phoneNumber": "010-7382915", "friends": [4] },
    { "id": 4, "name": "Diana", "phoneNumber": "016-1948572", "friends": [5] },
    { "id": 5, "name": "Ethan", "phoneNumber": "015-6601928", "friends": [6] },
    { "id": 6, "name": "Frank", "phoneNumber": "012-5839104", "friends": [7] },
    { "id": 7, "name": "Hannah", "phoneNumber": "017-2093846", "friends": [8] },
    { "id": 8, "name": "Ivan", "phoneNumber": "019-8472610", "friends": [9] },
    { "id": 9, "name": "Grace", "phoneNumber": "014-3950182", "friends": [10] },
    { "id": 10, "name": "Kevin", "phoneNumber": "018-6729041", "friends": [11] },
    { "id": 11, "name": "Liam", "phoneNumber": "011-9304756", "friends": [12] },
    { "id": 12, "name": "Mia", "phoneNumber": "010-2847591", "friends": [13] },
    { "id": 13, "name": "Noah", "phoneNumber": "013-7609182", "friends": [14] },
    { "id": 14, "name": "Olivia", "phoneNumber": "015-3489271", "friends": [15] },
    { "id": 15, "name": "Peter", "phoneNumber": "012-9051836", "friends": [16] },
    { "id": 16, "name": "Quinn", "phoneNumber": "016-5719023", "friends": [] }
  ]
}
---

1. Create a Kotlin data class Friend with the following properties:

id: Int
name: String
phoneNumber: String
friends: List<Int>

2. Data Handling

Assume all people are stored in a list or map.

You must be able to:

Retrieve a person by their id
Access their direct friends using the friends list

3. Functions to Implement

Implement the following functions:

(a) Direct Friends

Return all direct friends of a given person.

(b) Friend of Friend

Return all second-level connections (friends of friends), excluding direct friends and duplicates.

(c) Not Connected People

Return all people who are NOT:

direct friends
friends of friends
themselves
