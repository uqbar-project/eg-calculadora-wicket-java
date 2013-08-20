package uqbar.calculadora.ui.wicket;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IFormSubmittingComponent;
import org.apache.wicket.model.IModel;
import org.uqbar.commons.model.UserException;

/**
 * @author jfernandes
 *
 */
public class FormCopado<T> extends Form<T> {
	private static final long serialVersionUID = 7709352038539637936L;

	public FormCopado(String id) {
		super(id);
	}

	public FormCopado(String id, IModel model) {
		super(id, model);
	}

	@Override
	public void process(IFormSubmittingComponent submittingComponent) {
		try {
			super.process(submittingComponent);
		} catch (WicketRuntimeException e) {
			if (e.getCause() instanceof UserException) {
				this.error(e.getCause().getMessage());
			} else {
				throw e;
			}
		}
	}
	
}