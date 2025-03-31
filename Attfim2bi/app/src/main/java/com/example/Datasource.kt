package com.example.att_fim2bi.data
import com.example.att_fim2bi.Product
import com.example.att_fim2bi.R

class Datasource {
    fun loadProducts(): List<Product>{
        return listOf<Product>(
            Product(R.string.nome1, R.string.preco1, R.drawable.product1),
            Product(R.string.nome2, R.string.preco2, R.drawable.product2),
            Product(R.string.nome3, R.string.preco3, R.drawable.product3),
            Product(R.string.nome4, R.string.preco4, R.drawable.product4),
            Product(R.string.nome5, R.string.preco5, R.drawable.product5),
            Product(R.string.nome6, R.string.preco6, R.drawable.product6),
            Product(R.string.nome7, R.string.preco7, R.drawable.product7),
            Product(R.string.nome8, R.string.preco8, R.drawable.product8),
            Product(R.string.nome9, R.string.preco9, R.drawable.product9),
            Product(R.string.nome10, R.string.preco10, R.drawable.product10),
            )
    }
}
