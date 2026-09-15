package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.DealIdentifier;
import fpml.consolidated.loan.validation.DealIdentifierTypeFormatValidator;
import fpml.consolidated.loan.validation.DealIdentifierValidator;
import fpml.consolidated.loan.validation.exists.DealIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=DealIdentifier.class)
public class DealIdentifierMeta implements RosettaMetaData<DealIdentifier> {

	@Override
	public List<Validator<? super DealIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DealIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super DealIdentifier> validator(ValidatorFactory factory) {
		return factory.<DealIdentifier>create(DealIdentifierValidator.class);
	}

	@Override
	public Validator<? super DealIdentifier> typeFormatValidator(ValidatorFactory factory) {
		return factory.<DealIdentifier>create(DealIdentifierTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super DealIdentifier> validator() {
		return new DealIdentifierValidator();
	}

	@Deprecated
	@Override
	public Validator<? super DealIdentifier> typeFormatValidator() {
		return new DealIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DealIdentifier, Set<String>> onlyExistsValidator() {
		return new DealIdentifierOnlyExistsValidator();
	}
}
