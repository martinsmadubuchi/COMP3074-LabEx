# COMP3074 – Lab 4: Room Customer Lab (Kotlin + Jetpack Compose + Room)

Android app that stores customers in a SQLite database using the Room library.

- Single Room entity / table: `customers` (`id`, `name`, `age`, `isActive`)
- Customers are displayed with a `LazyColumn` (lazy list)
- Customers can be added (form + Add Customer button) and removed (Delete button)
- The list updates automatically because the DAO returns `Flow<List<Customer>>`

## Structure
```
ca.gbc.comp3074.madubuchi_ihechu.lab4/
├── MainActivity.kt
├── data/
│   ├── Customer.kt        (@Entity "customers")
│   ├── CustomerDAO.kt     (@Insert, @Delete, @Query, search)
│   └── AppDatabase.kt     (RoomDatabase singleton)
├── ui/
│   ├── CustomerScreen.kt     (Compose UI + LazyColumn)
│   └── CustomerViewModel.kt  (ViewModel + Factory)
├── DatabaseHelper.kt  (earlier SQLiteOpenHelper version - not used by the app)
└── CustomerModel.kt   (used by DatabaseHelper)
```

`res/layout/activity_main.xml` is the layout from the earlier SQLite version. The Compose app doesn't use it.
