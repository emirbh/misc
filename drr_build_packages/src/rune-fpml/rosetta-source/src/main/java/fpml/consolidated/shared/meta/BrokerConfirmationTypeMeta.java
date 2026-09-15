package fpml.consolidated.shared.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.shared.BrokerConfirmationType;
import fpml.consolidated.shared.validation.BrokerConfirmationTypeTypeFormatValidator;
import fpml.consolidated.shared.validation.BrokerConfirmationTypeValidator;
import fpml.consolidated.shared.validation.exists.BrokerConfirmationTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BrokerConfirmationType.class)
public class BrokerConfirmationTypeMeta implements RosettaMetaData<BrokerConfirmationType> {

	@Override
	public List<Validator<? super BrokerConfirmationType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BrokerConfirmationType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BrokerConfirmationType> validator(ValidatorFactory factory) {
		return factory.<BrokerConfirmationType>create(BrokerConfirmationTypeValidator.class);
	}

	@Override
	public Validator<? super BrokerConfirmationType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BrokerConfirmationType>create(BrokerConfirmationTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BrokerConfirmationType> validator() {
		return new BrokerConfirmationTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BrokerConfirmationType> typeFormatValidator() {
		return new BrokerConfirmationTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BrokerConfirmationType, Set<String>> onlyExistsValidator() {
		return new BrokerConfirmationTypeOnlyExistsValidator();
	}
}
