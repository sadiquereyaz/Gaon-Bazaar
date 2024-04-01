package com.reyaz.gaonbazar.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.reyaz.gaonbazar.model.table.CartItem
import kotlinx.coroutines.flow.Flow
import okhttp3.Challenge

@Dao
interface CartItemDao {
    @Query("SELECT * FROM CartItem")
//    fun getAllCartItems(): LiveData<List<CartItem>>
    fun getAllCartItems(): Flow<List<Challenge>>

    @Insert
    suspend fun insertCartItem(cartItem: CartItem)
    @Query("DELETE FROM CartItem WHERE id = :id")
    suspend fun deleteCartItemById(id: Int)
    @Query("UPDATE CartItem SET quantity = quantity + 1 WHERE id = :id")
    suspend fun increaseQuantity(id: Int)

    @Query("UPDATE CartItem SET quantity = quantity - 1 WHERE id = :id")
    fun decreaseQuantity(id: Int)

    @Query("SELECT SUM(quantity) FROM CartItem")
    fun getTotalQuantityInCart(): Flow<Int>

}