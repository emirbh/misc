package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractPartyProfileId;
import fpml.consolidated.loan.validation.AbstractPartyProfileIdTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractPartyProfileIdValidator;
import fpml.consolidated.loan.validation.exists.AbstractPartyProfileIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractPartyProfileId.class)
public class AbstractPartyProfileIdMeta implements RosettaMetaData<AbstractPartyProfileId> {

	@Override
	public List<Validator<? super AbstractPartyProfileId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractPartyProfileId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractPartyProfileId> validator(ValidatorFactory factory) {
		return factory.<AbstractPartyProfileId>create(AbstractPartyProfileIdValidator.class);
	}

	@Override
	public Validator<? super AbstractPartyProfileId> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractPartyProfileId>create(AbstractPartyProfileIdTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractPartyProfileId> validator() {
		return new AbstractPartyProfileIdValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractPartyProfileId> typeFormatValidator() {
		return new AbstractPartyProfileIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractPartyProfileId, Set<String>> onlyExistsValidator() {
		return new AbstractPartyProfileIdOnlyExistsValidator();
	}
}
