package cdm.product.template.meta;

import cdm.product.template.ExtensionEvent;
import cdm.product.template.validation.ExtensionEventTypeFormatValidator;
import cdm.product.template.validation.ExtensionEventValidator;
import cdm.product.template.validation.datarule.ExtensionEventFpML_ird_42;
import cdm.product.template.validation.exists.ExtensionEventOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=ExtensionEvent.class)
public class ExtensionEventMeta implements RosettaMetaData<ExtensionEvent> {

	@Override
	public List<Validator<? super ExtensionEvent>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ExtensionEvent>create(ExtensionEventFpML_ird_42.class)
		);
	}
	
	@Override
	public List<Function<? super ExtensionEvent, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ExtensionEvent> validator(ValidatorFactory factory) {
		return factory.<ExtensionEvent>create(ExtensionEventValidator.class);
	}

	@Override
	public Validator<? super ExtensionEvent> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ExtensionEvent>create(ExtensionEventTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ExtensionEvent> validator() {
		return new ExtensionEventValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ExtensionEvent> typeFormatValidator() {
		return new ExtensionEventTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ExtensionEvent, Set<String>> onlyExistsValidator() {
		return new ExtensionEventOnlyExistsValidator();
	}
}
