package fpml.consolidated.riskdef.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.riskdef.ValuationReference;
import fpml.consolidated.riskdef.validation.ValuationReferenceTypeFormatValidator;
import fpml.consolidated.riskdef.validation.ValuationReferenceValidator;
import fpml.consolidated.riskdef.validation.exists.ValuationReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ValuationReference.class)
public class ValuationReferenceMeta implements RosettaMetaData<ValuationReference> {

	@Override
	public List<Validator<? super ValuationReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuationReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuationReference> validator(ValidatorFactory factory) {
		return factory.<ValuationReference>create(ValuationReferenceValidator.class);
	}

	@Override
	public Validator<? super ValuationReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuationReference>create(ValuationReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReference> validator() {
		return new ValuationReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuationReference> typeFormatValidator() {
		return new ValuationReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuationReference, Set<String>> onlyExistsValidator() {
		return new ValuationReferenceOnlyExistsValidator();
	}
}
