package fpml.consolidated.ird.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.ird.BondReference;
import fpml.consolidated.ird.validation.BondReferenceTypeFormatValidator;
import fpml.consolidated.ird.validation.BondReferenceValidator;
import fpml.consolidated.ird.validation.exists.BondReferenceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BondReference.class)
public class BondReferenceMeta implements RosettaMetaData<BondReference> {

	@Override
	public List<Validator<? super BondReference>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BondReference, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BondReference> validator(ValidatorFactory factory) {
		return factory.<BondReference>create(BondReferenceValidator.class);
	}

	@Override
	public Validator<? super BondReference> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BondReference>create(BondReferenceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BondReference> validator() {
		return new BondReferenceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BondReference> typeFormatValidator() {
		return new BondReferenceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BondReference, Set<String>> onlyExistsValidator() {
		return new BondReferenceOnlyExistsValidator();
	}
}
