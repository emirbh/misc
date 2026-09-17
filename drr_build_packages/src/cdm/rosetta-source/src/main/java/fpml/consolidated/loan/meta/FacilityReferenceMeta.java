package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityReference;
import fpml.consolidated.loan.validation.FacilityReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityReferenceValidator;
import fpml.consolidated.loan.validation.exists.FacilityReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityReference.class)
public class FacilityReferenceMeta implements RosettaMetaData<FacilityReference> {

	@Override
	public List<Validator<? super FacilityReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityReference> validator(ValidatorFactory factory) {
		return factory.<FacilityReference>create(FacilityReferenceValidator.class);
	}

	@Override
	public Validator<? super FacilityReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityReference>create(FacilityReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityReference> validator() {
		return new FacilityReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityReference> typeFormatValidator() {
		return new FacilityReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityReference, Set<String>> onlyExistsValidator() {
		return new FacilityReferenceOnlyExistsValidator();
	}
}
