package org.apache.pdfbox.cos;

import java.util.Calendar;

import org.apache.pdfbox.pdmodel.common.COSObjectable;

/**
 * An unmodifiable COSDictionary.
 *
 * @author John Hewson
 */
final class UnmodifiableCOSDictionary extends COSDictionary
{
    /**
     * @inheritDoc
     */
    UnmodifiableCOSDictionary(COSDictionary dict)
    {
        super();
        items = dict.items;
    }

    /**
     * @inheritDoc
     */
    public void clear()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setItem(COSName key, COSBase value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setItem(COSName key, COSObjectable value)
    {
       throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setItem(String key, COSObjectable value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setBoolean(String key, boolean value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setBoolean(COSName key, boolean value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setItem(String key, COSBase value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setName(String key, String value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setName(COSName key, String value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setDate(String key, Calendar date)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setDate(COSName key, Calendar date)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setEmbeddedDate(String embedded, String key, Calendar date)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setEmbeddedDate(String embedded, COSName key, Calendar date)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setString(String key, String value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setString(COSName key, String value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setEmbeddedString(String embedded, String key, String value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setEmbeddedString(String embedded, COSName key, String value)
    {
       throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setInt(String key, int value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setInt(COSName key, int value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setLong(String key, long value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setLong(COSName key, long value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setEmbeddedInt(String embeddedDictionary, String key, int value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setEmbeddedInt(String embeddedDictionary, COSName key, int value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setFloat(String key, float value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void setFloat(COSName key, float value)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void removeItem(COSName key)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void addAll(COSDictionary dic)
    {
        throw new UnsupportedOperationException();
    }

    /**
     * @inheritDoc
     */
    public void mergeInto(COSDictionary dic)
    {
        throw new UnsupportedOperationException();
    }
}
