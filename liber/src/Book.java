import java.sql.Date;

class Book{
    private int codeBook;
    private String nameBook;
    private double purchasePrice;
    private double salePrice;
    private String publishingCo;
    private Date publishDate;
    private String genreBook;
    private int codeWriter;
    private int amountSold;
    private int amountAvaiable;
    private int amountBought;

    public Book(int codeBook, String nameBook, double purchasePrice, double salePrice, String publishingCo, Date publishDate, String genreBook, int codeWriter, int amountBought) throws InvalidPriceException, InvalidAmountException{
        if(salePrice <= purchasePrice){
            throw new InvalidPriceException("The sale price cannot be less than purchase price!!!");
        }else if(purchasePrice <= 0 || salePrice <= 0){
            throw new InvalidPriceException("The purchase price or the sale price cannot be less than or equal to zero!!!");
        }else if(amountBought <= 0){
            throw new InvalidAmountException("The amount bought cannot be less than or equal to zero!!");
        }else{
            this.codeBook = codeBook;
            this.nameBook = nameBook;
            this.purchasePrice = purchasePrice;
            this.salePrice = salePrice;
            this.publishingCo = publishingCo;
            this.publishDate = publishDate;
            this.genreBook = genreBook;
            this.codeWriter = codeWriter;
            this.amountBought = amountBought;
        }
    }

    public int getCodeBook(){
        return this.codeBook;
    }
    public String getNameBook(){
        return this.nameBook;
    }
    public double getSalePrice(){
        return this.salePrice;
    }
    public double getPurchasePrice(){
        return this.purchasePrice;
    }
    public void setSalePrice(double newPrice){
        this.salePrice = newPrice;
    }
    public String getPublishingCo(){
        return this.publishingCo;
    }
    public Date getPublishDate(){
        return this.publishDate;
    }
    public String getGenreBook(){
        return this.genreBook;
    }
    public int getCodeWriter(){
        return this.codeWriter;
    }
    public int getAmountBought(){
        return this.amountBought;
    }
    public int getAmountSold(){
        return this.amountSold;
    }
    public int getAmountAvaiable(){
        return this.amountAvaiable;
    }
}