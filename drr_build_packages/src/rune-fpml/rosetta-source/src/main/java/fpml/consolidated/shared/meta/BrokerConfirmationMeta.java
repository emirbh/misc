package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BrokerConfirmation;
import fpml.consolidated.shared.validation.BrokerConfirmationTypeFormatValidator;
import fpml.consolidated.shared.validation.BrokerConfirmationValidator;
import fpml.consolidated.shared.validation.exists.BrokerConfirmationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BrokerConfirmation.class)
public class BrokerConfirmationMeta implements RosettaMetaData<BrokerConfirmation> {

	@Override
	public List<Validator<? super BrokerConfirmation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BrokerConfirmation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BrokerConfirmation> validator(ValidatorFactory factory) {
		return factory.<BrokerConfirmation>create(BrokerConfirmationValidator.class);
	}

	@Override
	public Validator<? super BrokerConfirmation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BrokerConfirmation>create(BrokerConfirmationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BrokerConfirmation> validator() {
		return new BrokerConfirmationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BrokerConfirmation> typeFormatValidator() {
		return new BrokerConfirmationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BrokerConfirmation, Set<String>> onlyExistsValidator() {
		return new BrokerConfirmationOnlyExistsValidator();
	}
}
