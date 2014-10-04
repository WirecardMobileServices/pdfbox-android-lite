package org.apache.pdfbox.pdmodel.graphics.blend;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSBase;
import org.apache.pdfbox.cos.COSName;

import java.util.HashMap;
import java.util.Map;

/**
 * Blend mode.
 *
 * @author K�hn & Weyh Software, GmbH
 */
public abstract class BlendMode
{
    private static final Map<COSName, BlendMode> BLEND_MODES = createBlendModeMap();

    private static Map<COSName, BlendMode> createBlendModeMap()
    {
        Map<COSName, BlendMode> map = new HashMap<COSName, BlendMode>();
        map.put(COSName.NORMAL, BlendMode.NORMAL);
        map.put(COSName.COMPATIBLE, BlendMode.COMPATIBLE);
        map.put(COSName.MULTIPLY, BlendMode.MULTIPLY);
        map.put(COSName.SCREEN, BlendMode.SCREEN);
        map.put(COSName.OVERLAY, BlendMode.OVERLAY);
        map.put(COSName.DARKEN, BlendMode.DARKEN);
        map.put(COSName.LIGHTEN, BlendMode.LIGHTEN);
        map.put(COSName.COLOR_DODGE, BlendMode.COLOR_DODGE);
        map.put(COSName.COLOR_BURN, BlendMode.COLOR_BURN);
        map.put(COSName.HARD_LIGHT, BlendMode.HARD_LIGHT);
        map.put(COSName.SOFT_LIGHT, BlendMode.SOFT_LIGHT);
        map.put(COSName.DIFFERENCE, BlendMode.DIFFERENCE);
        map.put(COSName.EXCLUSION, BlendMode.EXCLUSION);
        // TODO - non-separable blending modes
        return map;
    }

    /**
     * Determines the blend mode from the BM entry in the COS ExtGState.
     *
     * @param cosBlendMode name or array
     * @return blending mode
     */
    public static BlendMode getInstance(COSBase cosBlendMode)
    {
        BlendMode result = null;
        if (cosBlendMode instanceof COSName)
        {
            result = BLEND_MODES.get(cosBlendMode);
        }
        else if (cosBlendMode instanceof COSArray)
        {
            COSArray cosBlendModeArray = (COSArray) cosBlendMode;
            for (int i = 0; i < cosBlendModeArray.size(); i++)
            {
                result = BLEND_MODES.get(cosBlendModeArray.get(i));
                if (result != null)
                {
                    break;
                }
            }
        }
        if (result != null)
        {
            return result;
        }
        return BlendMode.COMPATIBLE;
    }

    public static SeparableBlendMode NORMAL = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return srcValue;
        }
    };

    public static SeparableBlendMode COMPATIBLE = NORMAL;

    public static SeparableBlendMode MULTIPLY = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return srcValue * dstValue;
        }
    };

    public static SeparableBlendMode SCREEN = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return srcValue + dstValue - srcValue * dstValue;
        }
    };

    public static SeparableBlendMode OVERLAY = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return (dstValue <= 0.5) ? 2 * dstValue * srcValue : 2 * (srcValue + dstValue - srcValue
                    * dstValue) - 1;
        }
    };

    public static SeparableBlendMode DARKEN = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return Math.min(srcValue, dstValue);
        }
    };

    public static SeparableBlendMode LIGHTEN = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return Math.max(srcValue, dstValue);
        }
    };

    public static SeparableBlendMode COLOR_DODGE = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return (srcValue < 1) ? Math.min(1, dstValue / (1 - srcValue)) : 1;
        }
    };

    public static SeparableBlendMode COLOR_BURN = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return (srcValue > 0) ? 1 - Math.min(1, (1 - dstValue) / srcValue) : 0;
        }
    };

    public static SeparableBlendMode HARD_LIGHT = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return (srcValue <= 0.5) ? 2 * dstValue * srcValue :
                    2 * (srcValue + dstValue - srcValue * dstValue) - 1;
        }
    };

    public static SeparableBlendMode SOFT_LIGHT = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            if (srcValue <= 0.5)
            {
                return dstValue - (1 - 2 * srcValue) * dstValue * (1 - dstValue);
            }
            else
            {
                float D = (dstValue <= 0.25) ? ((16 * dstValue - 12) * dstValue + 4) * dstValue
                        : (float) Math .sqrt(dstValue);
                return dstValue + (2 * srcValue - 1) * (D - dstValue);
            }
        }
    };

    public static SeparableBlendMode DIFFERENCE = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return Math.abs(dstValue - srcValue);
        }
    };

    public static SeparableBlendMode EXCLUSION = new SeparableBlendMode()
    {
        public float blendChannel(float srcValue, float dstValue)
        {
            return dstValue + srcValue - 2 * dstValue * srcValue;
        }
    };

    BlendMode()
    {
    }
}
