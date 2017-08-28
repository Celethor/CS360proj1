package proj1.cs360;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.browser.Browser;

public class GUITest extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GUITest(Composite parent, int style) {
		super(parent, style);
		
		List list = new List(this, SWT.BORDER);
		list.setBounds(10, 10, 158, 460);
		
		Browser browser = new Browser(this, SWT.NONE);
		browser.setUrl("www.google.com");
		browser.setBounds(200, 35, 268, 168);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
