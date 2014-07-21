import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/* The Following codes are taken from http://stackoverflow.com/questions/13075564/limiting-length-of-input-in-jtextfield-is-not-working and we do not claim it as ours*/
public final class LengthRestrictedDocument extends PlainDocument {

  private final int limit;

  public LengthRestrictedDocument(int limit) {
    this.limit = limit;
  }

  @Override
  public void insertString(int offs, String str, AttributeSet a)
      throws BadLocationException {
    if (str == null)
      return;

    if ((getLength() + str.length()) <= limit) {
      super.insertString(offs, str, a);
    }
  }
}
