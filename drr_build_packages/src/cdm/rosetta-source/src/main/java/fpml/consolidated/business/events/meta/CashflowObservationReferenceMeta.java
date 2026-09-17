package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CashflowObservationReference;
import fpml.consolidated.business.events.validation.CashflowObservationReferenceTypeFormatValidator;
import fpml.consolidated.business.events.validation.CashflowObservationReferenceValidator;
import fpml.consolidated.business.events.validation.exists.CashflowObservationReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CashflowObservationReference.class)
public class CashflowObservationReferenceMeta implements RosettaMetaData<CashflowObservationReference> {

	@Override
	public List<Validator<? super CashflowObservationReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CashflowObservationReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CashflowObservationReference> validator(ValidatorFactory factory) {
		return factory.<CashflowObservationReference>create(CashflowObservationReferenceValidator.class);
	}

	@Override
	public Validator<? super CashflowObservationReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CashflowObservationReference>create(CashflowObservationReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CashflowObservationReference> validator() {
		return new CashflowObservationReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CashflowObservationReference> typeFormatValidator() {
		return new CashflowObservationReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CashflowObservationReference, Set<String>> onlyExistsValidator() {
		return new CashflowObservationReferenceOnlyExistsValidator();
	}
}
