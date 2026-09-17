package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.AbstractApplicablePartyProfileObjects;
import fpml.consolidated.loan.validation.AbstractApplicablePartyProfileObjectsTypeFormatValidator;
import fpml.consolidated.loan.validation.AbstractApplicablePartyProfileObjectsValidator;
import fpml.consolidated.loan.validation.exists.AbstractApplicablePartyProfileObjectsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=AbstractApplicablePartyProfileObjects.class)
public class AbstractApplicablePartyProfileObjectsMeta implements RosettaMetaData<AbstractApplicablePartyProfileObjects> {

	@Override
	public List<Validator<? super AbstractApplicablePartyProfileObjects>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super AbstractApplicablePartyProfileObjects, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super AbstractApplicablePartyProfileObjects> validator(ValidatorFactory factory) {
		return factory.<AbstractApplicablePartyProfileObjects>create(AbstractApplicablePartyProfileObjectsValidator.class);
	}

	@Override
	public Validator<? super AbstractApplicablePartyProfileObjects> typeFormatValidator(ValidatorFactory factory) {
		return factory.<AbstractApplicablePartyProfileObjects>create(AbstractApplicablePartyProfileObjectsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super AbstractApplicablePartyProfileObjects> validator() {
		return new AbstractApplicablePartyProfileObjectsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super AbstractApplicablePartyProfileObjects> typeFormatValidator() {
		return new AbstractApplicablePartyProfileObjectsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AbstractApplicablePartyProfileObjects, Set<String>> onlyExistsValidator() {
		return new AbstractApplicablePartyProfileObjectsOnlyExistsValidator();
	}
}
