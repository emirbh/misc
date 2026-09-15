package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.ValuationDatesReference;
import fpml.consolidated.ird.validation.ValuationDatesReferenceTypeFormatValidator;
import fpml.consolidated.ird.validation.ValuationDatesReferenceValidator;
import fpml.consolidated.ird.validation.exists.ValuationDatesReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationDatesReference.class)
public class ValuationDatesReferenceMeta implements RosettaMetaData<ValuationDatesReference> {

	@Override
	public List<Validator<? super ValuationDatesReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationDatesReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationDatesReference> validator(ValidatorFactory factory) {
		return factory.<ValuationDatesReference>create(ValuationDatesReferenceValidator.class);
	}

	@Override
	public Validator<? super ValuationDatesReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationDatesReference>create(ValuationDatesReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationDatesReference> validator() {
		return new ValuationDatesReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationDatesReference> typeFormatValidator() {
		return new ValuationDatesReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationDatesReference, Set<String>> onlyExistsValidator() {
		return new ValuationDatesReferenceOnlyExistsValidator();
	}
}
