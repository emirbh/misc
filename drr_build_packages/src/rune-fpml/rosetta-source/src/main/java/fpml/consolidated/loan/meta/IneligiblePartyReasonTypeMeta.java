package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.IneligiblePartyReasonType;
import fpml.consolidated.loan.validation.IneligiblePartyReasonTypeTypeFormatValidator;
import fpml.consolidated.loan.validation.IneligiblePartyReasonTypeValidator;
import fpml.consolidated.loan.validation.exists.IneligiblePartyReasonTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=IneligiblePartyReasonType.class)
public class IneligiblePartyReasonTypeMeta implements RosettaMetaData<IneligiblePartyReasonType> {

	@Override
	public List<Validator<? super IneligiblePartyReasonType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super IneligiblePartyReasonType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super IneligiblePartyReasonType> validator(ValidatorFactory factory) {
		return factory.<IneligiblePartyReasonType>create(IneligiblePartyReasonTypeValidator.class);
	}

	@Override
	public Validator<? super IneligiblePartyReasonType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<IneligiblePartyReasonType>create(IneligiblePartyReasonTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super IneligiblePartyReasonType> validator() {
		return new IneligiblePartyReasonTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super IneligiblePartyReasonType> typeFormatValidator() {
		return new IneligiblePartyReasonTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super IneligiblePartyReasonType, Set<String>> onlyExistsValidator() {
		return new IneligiblePartyReasonTypeOnlyExistsValidator();
	}
}
