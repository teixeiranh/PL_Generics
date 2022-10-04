/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.time.LocalDate;
import java.util.*;

/**
 * @author DEI-ISEP
 */
public class Supermarket
{
    Map<Invoice, Set<Product>> sup;

    Supermarket()
    {
        sup = new HashMap<>();
    }

    // Reads invoices from a list of String
    void getInvoices(List<String> l) throws Exception
    {
        Set<Product> setOfProducts = new HashSet<>();

        for (int i = 0; i < l.size(); )
        {
            if (l.get(i).charAt(0) == 'I')
            {
                String[] splitString = l.get(i).split(",");
                i++;
                while (l.get(i).charAt(0) != 'I')
                {
                    String[] splitString2 = l.get(i).split(",");
                    setOfProducts.add(new Product(splitString2[1], Integer.parseInt(splitString2[2]), Long.parseLong(splitString2[3])));
                    if (i < l.size() - 1)
                    {
                        i++;
                    } else
                    {
                        break;
                    }
                }
                sup.put(new Invoice(splitString[1], splitString[2]), new HashSet<>(setOfProducts));
                setOfProducts.removeAll(setOfProducts);
            } else
            {
                break;
            }
        }
    }


    // returns a set in which each number is the number of products in the r
    // invoice
    Map<Invoice, Integer> numberOfProductsPerInvoice()
    {

        Map<Invoice, Integer> result = new HashMap<>();

        for (Invoice key : sup.keySet())
        {
            Set<Product> value = sup.get(key);
            result.put(key, value.size());
        }
        return result;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set<Invoice> betweenDates(LocalDate d1, LocalDate d2)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // converts a map of invoices and troducts to a map which key is a product
    // identification and the values are a set of the invoices in which it appears
    Map<String, Set<Invoice>> convertInvoices()
    {

        /* PSEUDOCODE
        para cada elemento do supermercado
            apanhar a descrição do producto e meter isso num set

        para cada elemento no set de descriçao do producto
            comparar com o set de cada invoice e, caso esteja presente, adicionar isso ao set dos invoices
        criar o elemento no map <String,Set<Invoice>
         */

        /* PSEUDOCODE2
        para cada invoice do supermercado
            apanhar a descrição do producto
            criar a key no map e adicionar o produto ao set desse supermercado
         */

        Map<String, Set<Invoice>> result = new HashMap<>();
        Set<String> listOfProducts = new HashSet<>();

        for (Invoice key : sup.keySet())
        {
            Set<Product> keyValues = sup.get(key);
            for (Product product : keyValues)
            {
                listOfProducts.add(product.getIdentification());
            }
        }

        for (String uniqueProduct : listOfProducts)
        {
            Set<Invoice> setOfInvoices = new HashSet<>();
            for (Invoice key : sup.keySet())
            {
                Set<Product> keyValues = sup.get(key);
                for (Product product2 : keyValues)
                {
                    if (product2.getIdentification().equals(uniqueProduct))
                    {
                        setOfInvoices.add(new Invoice(key.getReference(),null));
                    }
                }
            }
            result.put(uniqueProduct, new HashSet<>(setOfInvoices));
            setOfInvoices.removeAll(setOfInvoices);
        }
        return result;
    }
}
