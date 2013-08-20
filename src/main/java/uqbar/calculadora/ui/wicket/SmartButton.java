package uqbar.calculadora.ui.wicket;

import org.apache.wicket.markup.html.form.Button;
import org.uqbar.commons.model.UserException;

/**
 * Boton que maneja UserException's
 * 
 * @author jfernandes
 */
public abstract class SmartButton extends Button {

	protected SmartButton(String id) {
		super(id);
	}
	
	@Override
	public void onSubmit() {
		try {
			this.onSmartSubmit();
		}
		catch(UserException e) {
			error(e.getMessage());
		}
	}

	protected abstract void onSmartSubmit();
	
}