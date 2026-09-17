package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.ActionOnExpiration;
import fpml.consolidated.business.events.validation.ActionOnExpirationTypeFormatValidator;
import fpml.consolidated.business.events.validation.ActionOnExpirationValidator;
import fpml.consolidated.business.events.validation.datarule.ActionOnExpirationChoice;
import fpml.consolidated.business.events.validation.exists.ActionOnExpirationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ActionOnExpiration.class)
public class ActionOnExpirationMeta implements RosettaMetaData<ActionOnExpiration> {

	@Override
	public List<Validator<? super ActionOnExpiration>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ActionOnExpiration>create(ActionOnExpirationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ActionOnExpiration, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ActionOnExpiration> validator(ValidatorFactory factory) {
		return factory.<ActionOnExpiration>create(ActionOnExpirationValidator.class);
	}

	@Override
	public Validator<? super ActionOnExpiration> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ActionOnExpiration>create(ActionOnExpirationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ActionOnExpiration> validator() {
		return new ActionOnExpirationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ActionOnExpiration> typeFormatValidator() {
		return new ActionOnExpirationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ActionOnExpiration, Set<String>> onlyExistsValidator() {
		return new ActionOnExpirationOnlyExistsValidator();
	}
}
