/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

/**
 * @author DEI-ISEP
 */
public class Product implements Comparable<Product>
{
    private String identification;
    private int quantity;
    private long price;

    Product(String identification, int quantity, long price)
    {
        this.identification = identification;
        this.quantity = quantity;
        this.price = price;
    }

    Product(String identification)
    {
        this(identification, 0, 0);
    }

    public String getIdentification()
    {
        return identification;
    }

    public void setIdentification(String identification)
    {
        this.identification = identification;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj)
    {

        if (obj == null)
        {
            return false;
        }

        if (obj.getClass() != this.getClass())
        {
            return false;
        }

        final Product other = (Product) obj;
        if (this.identification == null || this.identification != other.identification)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int h1=this.identification.hashCode();
        return h1;
    }

    @Override
    public int compareTo(Product p)
    {
        int comparison=this.identification.compareTo(p.identification);

        if (comparison > 0)
        {
            return 1;
        } else if (comparison < 0)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

}