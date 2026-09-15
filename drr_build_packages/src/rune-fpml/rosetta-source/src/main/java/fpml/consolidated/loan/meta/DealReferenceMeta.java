package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealReference;
import fpml.consolidated.loan.validation.DealReferenceTypeFormatValidator;
import fpml.consolidated.loan.validation.DealReferenceValidator;
import fpml.consolidated.loan.validation.exists.DealReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealReference.class)
public class DealReferenceMeta implements RosettaMetaData<DealReference> {

	@Override
	public List<Validator<? super DealReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealReference> validator(ValidatorFactory factory) {
		return factory.<DealReference>create(DealReferenceValidator.class);
	}

	@Override
	public Validator<? super DealReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealReference>create(DealReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealReference> validator() {
		return new DealReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DealReference> typeFormatValidator() {
		return new DealReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealReference, Set<String>> onlyExistsValidator() {
		return new DealReferenceOnlyExistsValidator();
	}
}
