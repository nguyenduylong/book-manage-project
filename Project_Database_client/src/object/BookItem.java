package object;

import java.util.Date;

public class BookItem
{
    private final String mType;
    private final String mName;
    private final String mAuthor;
    private final String mPublishingCompany;
    private final int mPrice;
    private final int mQuantity;
    private final Date mDate;
    private final int mView;
    private final String mThumbnail;
    private final String mID;

    public BookItem(String mType, String mName, String mAuthor, String mPublishingCompany, int mPrice, int mQuantity, Date mDate, int mView, String mThumbnail, String mID)
    {
        this.mType = mType;
        this.mName = mName;
        this.mAuthor = mAuthor;
        this.mPublishingCompany = mPublishingCompany;
        this.mPrice = mPrice;
        this.mQuantity = mQuantity;
        this.mDate = mDate;
        this.mView = mView;
        this.mThumbnail = mThumbnail;
        this.mID = mID;
    }

    public String getmType()
    {
        return mType;
    }

    public String getmName()
    {
        return mName;
    }

    public String getmAuthor()
    {
        return mAuthor;
    }

    public String getmPublishingCompany()
    {
        return mPublishingCompany;
    }

    public int getmPrice()
    {
        return mPrice;
    }

    public int getmQuantity()
    {
        return mQuantity;
    }

    public Date getmDate()
    {
        return mDate;
    }

    public int getmView()
    {
        return mView;
    }

    public String getmThumbnail()
    {
        return mThumbnail;
    }

    public String getmID() 
    {
        return mID;
    }
}
