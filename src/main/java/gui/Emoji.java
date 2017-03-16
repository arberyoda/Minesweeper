package gui;

import javax.swing.*;
import java.awt.*;

/**
 * The class Emoji provides the various emojis.
 *
 * @author Arber Heqimi
 * @version 1.0
 */
public class Emoji
{
    private static final Image IMAGE_SMILING_FACE_WITH_SMILING_EYES = new ImageIcon("src/main/resources/image/emoji/smiling-face-with-smiling-eyes.png").getImage();
    private static final Image IMAGE_SMILING_FACE_WITH_SUNGLASSES = new ImageIcon("src/main/resources/image/emoji/smiling-face-with-sunglasses.png").getImage();
    private static final Image IMAGE_DIZZY_FACE = new ImageIcon("src/main/resources/image/emoji/dizzy-face.png").getImage();
    private static final Image IMAGE_FEARFUL_FACE = new ImageIcon("src/main/resources/image/emoji/fearful-face.png").getImage();
    private static final Image IMAGE_SMIRKING_FACE = new ImageIcon("src/main/resources/image/emoji/smirking-face.png").getImage();
    private static final Image IMAGE_BOMB = new ImageIcon("src/main/resources/image/emoji/bomb.png").getImage();
    private static final Image IMAGE_TRIANGULAR_FLAG = new ImageIcon("src/main/resources/image/emoji/triangular-flag.png").getImage();
    private static final Image IMAGE_PARTY_POPPER = new ImageIcon("src/main/resources/image/emoji/party-popper.png").getImage();
    private static final Image IMAGE_COLLISION = new ImageIcon("src/main/resources/image/emoji/collision.png").getImage();
    private static final Image IMAGE_LEFT_ARROW = new ImageIcon("src/main/resources/image/emoji/left-arrow.png").getImage();
    private static final Image IMAGE_RIGHT_ARROW = new ImageIcon("src/main/resources/image/emoji/right-arrow.png").getImage();

    public Emoji()
    {
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji smiling face with smiling eyes
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getSmilingFaceWithSmilingEyes()
    {
        Image imageSmilingFaceWithSmilingEyesResize = IMAGE_SMILING_FACE_WITH_SMILING_EYES.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imageSmilingFaceWithSmilingEyesResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji smiling face with sunglasses
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getSmilingFaceWithSunglasses()
    {
        Image imageSmilingFaceWithSunglassesResize = IMAGE_SMILING_FACE_WITH_SUNGLASSES.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imageSmilingFaceWithSunglassesResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji dizzy face
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getDizzyFace()
    {
        Image imageDizzyFaceResize = IMAGE_DIZZY_FACE.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imageDizzyFaceResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji fearful face
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getFearfulFace()
    {
        Image imageFearfulFaceResize = IMAGE_FEARFUL_FACE.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imageFearfulFaceResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji smirking face
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getSmirkingFace()
    {
        Image imageSmirkingFaceResize = IMAGE_SMIRKING_FACE.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imageSmirkingFaceResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji bomb
     *
     * @return The scaled emoji width 35 height 35
     */
    public static Image getBomb()
    {
        Image imageEmojiBombResize = IMAGE_BOMB.getScaledInstance(35, 35, Image.SCALE_SMOOTH);

        return imageEmojiBombResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji triangular flag
     *
     * @return The scaled emoji width 35 height 35
     */
    public static Image getTriangularFlag()
    {
        Image imageTriangularFlagResize = IMAGE_TRIANGULAR_FLAG.getScaledInstance(35, 35, Image.SCALE_SMOOTH);

        return imageTriangularFlagResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji party popper
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getPartyPopper()
    {
        Image imagePartyPopperResize = IMAGE_PARTY_POPPER.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imagePartyPopperResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji collision
     *
     * @return The scaled emoji width 50 height 50
     */
    public static Image getCollision()
    {
        Image imageCollisionResize = IMAGE_COLLISION.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

        return imageCollisionResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji left arrow
     *
     * @return The scaled emoji width 20 height 20
     */
    public static Image getLeftArrow()
    {
        Image imageLeftArrowResize = IMAGE_LEFT_ARROW.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        return imageLeftArrowResize;
    }

    /**
     * Returns a scaled emoji as an Image
     * <br><br>
     * Emoji right arrow
     *
     * @return The scaled emoji width 20 height 20
     */
    public static Image getRightArrow()
    {
        Image imageRightArrowResize = IMAGE_RIGHT_ARROW.getScaledInstance(20, 20, Image.SCALE_SMOOTH);

        return imageRightArrowResize;
    }
}
