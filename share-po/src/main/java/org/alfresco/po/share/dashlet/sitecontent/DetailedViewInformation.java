package org.alfresco.po.share.dashlet.sitecontent;

import org.alfresco.po.share.FactoryPage;
import org.alfresco.po.share.ShareLink;
import org.alfresco.po.share.site.document.DocumentDetailsPage;
import org.openqa.selenium.WebDriver;

/**
 * Hold information about the Detailed View inside site content dashlet.
 * 
 * @author Shan Nagarajan
 * @since 1.6.1
 */
public class DetailedViewInformation extends SimpleViewInformation
{
    private int likecount;
    private String fileSize;
    private ShareLink comment;
    private String description;
    private double version;
    private ShareLink like;
    private ShareLink favorite;
    private boolean favouriteEnabled;
    private boolean likeEnabled;
    private WebDriver driver;
    private FactoryPage factoryPage;
    
    public DetailedViewInformation(WebDriver driver,
                                   final ShareLink thumbnail,
                                   final ShareLink contentDetail,
                                   final ShareLink user,
                                   final String contentStatus, 
                                   final ShareLink comment,
                                   final ShareLink like,
                                   final ShareLink favourite,
                                   int likeCount,
                                   String fileSize,
                                   String desc, 
                                   double version,
                                   boolean favouriteEnabled,
                                   boolean likeEnabled,
                                   FactoryPage factoryPage)
    {
        super(driver, thumbnail, contentDetail, user, contentStatus, false, factoryPage);

        if (null == driver)
        {
            throw new UnsupportedOperationException("Drone is required, It can't be null.");
        }

        if (null == comment)
        {
            throw new UnsupportedOperationException("Comment link is required");
        }

        if (null == like)
        {
            throw new UnsupportedOperationException("Like link is required");
        }

        if (null == favourite)
        {
            throw new UnsupportedOperationException("Favourite link is required");
        }

        this.driver = driver;
        this.comment = comment;
        this.like = like;
        this.favorite = favourite;
        this.likecount = likeCount;
        this.fileSize = fileSize;
        this.description = desc;
        this.version = version;
        this.favouriteEnabled = favouriteEnabled;
        this.likeEnabled = likeEnabled;
        this.factoryPage = factoryPage;
    }

    public boolean isLikeEnabled()
    {
        return likeEnabled;
    }

    public boolean isFavouriteEnabled()
    {
        return favouriteEnabled;
    }

    public int getLikecount()
    {
        return likecount;
    }

    public String getFileSize()
    {
        return fileSize;
    }

    public ShareLink getComment()
    {
        return comment;
    }

    public String getDescription()
    {
        return description;
    }

    public double getVersion()
    {
        return version;
    }

    public ShareLink getLike()
    {
        return like;
    }

    public ShareLink getFavorite()
    {
        return favorite;
    }

    /**
     * Mimics the action of clicking comment.
     * 
     * @return {@link DocumentDetailsPage}
     */
    public DocumentDetailsPage clickComment()
    {
        comment.click();
        return factoryPage.instantiatePage(driver, DocumentDetailsPage.class);
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("DetailedViewInformation [likecount=");
        builder.append(likecount);
        builder.append(", fileSize=");
        builder.append(fileSize);
        builder.append(", comment=");
        builder.append(comment.toString());
        builder.append(", description=");
        builder.append(description);
        builder.append(", version=");
        builder.append(version);
        builder.append(", like=");
        builder.append(like.toString());
        builder.append(", favorite=");
        builder.append(favorite.toString());
        builder.append(", toString()=");
        builder.append(super.toString());
        builder.append("]");
        return builder.toString();
    }
}
