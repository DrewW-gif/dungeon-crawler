# Dungeon Crawler Game

When I was a kid, I loved the old text-based Infocom games, like *Zork* and *Hitchhiker’s Guide to the Galaxy*. You can still find emulators of them online. I always wondered how they were built.

In this project, you’ll build your own **text-based dungeon crawler** using object-oriented programming in Java. Your game will simulate a player exploring a dungeon made up of rooms that contain monsters and items.

---

## Provided Classes

You are given the following classes:

- `Game`
- `Player`
- `Map`
- `Room`
- `Item`
- `Monster`

Each class contains **TODOs** that you must complete.

---

## Class Responsibilities

| Class | Responsibility |
|---|---|
| `Game` | User input + game loop |
| `Player` | Tracks state (health, inventory, position) |
| `Map` | Owns grid of `Room`s |
| `Room` | Contains `Item`s + `Monster`s |
| `Item` / `Monster` | Data + description |

---

# Project Progression (Checkpoints)

You should complete each checkpoint before moving on. You don't need to actually get graded on each step before moving on, but it is highly recommended to follow this progression so you can make sure each step is building properly on the previous one.

---

## Checkpoint 1: Items, Monsters, and Rooms

### Your Tasks
- Complete `Monster`
  - Randomly select a monster type
  - Implement `toString()`
- Complete `Item`
  - Randomly select an item type
  - Implement `toString()`
- Complete `Room`
  - Generate random numbers of items and monsters
  - Create and populate `ArrayList`s
  - Implement `toString()` to display contents

### You are done when:
- You can run:

    `Room room = new Room();`
  
    `System.out.println(room);`

- The output shows a list of items and monsters

---

## Checkpoint 2: Map Creation

### Your Tasks
- Initialize a 2D array of `Room` objects in `Map`
- Use nested loops to populate every location
- Implement `getRoom(row, column)`

### You are done when:
- You can run:

    `Map map = new Map(5, 6);`
  
    `System.out.println(map.getRoom(0, 0));`
  
    `System.out.println(map.getRoom(2, 3));`

- No `null` values appear

---

## Checkpoint 3: Player Setup

### Your Tasks
- Initialize player fields:
  - Name
  - Health
  - `(x, y)` position
  - Inventory (`ArrayList<Item>`)
- Implement:
  - `moveTo(int x, int y)`
  - `getRoom(Map map)`
  - `look(Map map)`

### You are done when:
- You can run:

    `Player p = new Player(100, "Hero", 0, 0);`

    `Map map = new Map(5, 6);`

    `System.out.println(p.look(map));`
  
    `p.moveTo(1, 2);`
  
    `System.out.println(p.look(map));`

---

## Checkpoint 4: LOOK Command

### Your Tasks
- In `Game`, implement:
  - `LOOK`
  - `SEARCH`
- These should print the current room description

### You are done when:
- Typing `LOOK` shows room contents

---

## ✅ Checkpoint 5: Player Movement

### Your Tasks
- Implement movement commands:
  - `MOVE UP`
  - `MOVE DOWN`
  - `MOVE LEFT`
  - `MOVE RIGHT`
- Validate movement **before moving**
- Prevent movement outside the map

### Rules
- Invalid moves should display an error message
- Valid moves should:
  - Update player position
  - Print coordinates
  - Print room contents

### You are done when:
- Movement works in all directions
- The player cannot leave the map
- No crashes occur at the edges

---

## Checkpoint 6: Inventory (UWHS Only)

### Your Tasks
- Implement:
  - `addItemToInventory(Item item)`
  - `removeItemFromInventory(Item item)`
  - `hasItem(String itemName)`
- Add commands:
  - `TAKE <item>`
  - `DROP <item>`

### You are done when:
- Items can move between the room and the inventory
- `hasItem()` works correctly

---

## Checkpoint 7: Combat System (UWHS Only)

### Your Tasks
- Add:
  - Player health system
  - Monster health system
  - Item damage values
  - Equip system
- Implement `FIGHT`

### You are done when:
- The player can fight a monster
- Health updates correctly
- Monsters can be removed when defeated

---

# Extension Ideas

If you finish early, try tackling these features:

- Boss monsters
- Win condition
- Map visualization (grid printout)
- Advanced command parsing (example: `TAKE SWORD`)
- Random events

---

#  Rubric

| Criteria | Points | Points (UWHS) |
|---|---:|---:|
| Submitted properly to GitHub and compiles | 50 | 50 |
| Checkpoint 1 | 20 | 10 |
| Checkpoint 2 | 20 | 10 |
| Checkpoint 3 | 10 | 10 |
| Checkpoint 4 | Included above | Included above |
| Checkpoint 5 | Included above | Included above |
| Checkpoint 6 | N/A | 10 |
| Checkpoint 7 | N/A | 10 |
| **TOTAL** | **100** | **100** |

---

# Important Tips

- Build and test one checkpoint at a time  
- Do not move forward if something is broken  
- Use `.equals()` for string comparison, not `==`  
- Initialize all `ArrayList`s before using them  
- Be consistent with row/column vs x/y  

---

# Final Advice

This project is about **building step by step**. Early programmers who created games like *Zork* did not write everything at once—they built systems incrementally and tested constantly.

Do the same:

- Get one part working  
- Then build on top of it  
