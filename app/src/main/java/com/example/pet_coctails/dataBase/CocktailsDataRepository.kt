package com.example.pet_coctails.dataBase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CocktailsDataRepository (private val cocktailsDao: CocktailsDao) {

    //todo всё же не до конца понятно как работают такое функции, которые вызывают сами себя

    suspend fun insertNewCocktailData(CocktailsDataEntity: CocktailsDataEntity) {
        withContext(Dispatchers.IO) {
            cocktailsDao.insertNewCocktailData(CocktailsDataEntity)
        }
    }

//    suspend fun getAllCocktailData(): List<CocktailsTuple> {
//        return withContext(Dispatchers.IO) {
//            return@withContext cocktailsDao.getCocktailData()
//        }
//    }

    suspend fun removeCocktailDataById(id: Long) {
        withContext(Dispatchers.IO) {
            cocktailsDao.deleteCocktailDataById(id)
        }
    }
}