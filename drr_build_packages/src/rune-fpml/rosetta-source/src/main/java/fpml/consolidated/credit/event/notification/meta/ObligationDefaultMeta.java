package fpml.consolidated.credit.event.notification.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.credit.event.notification.ObligationDefault;
import fpml.consolidated.credit.event.notification.validation.ObligationDefaultTypeFormatValidator;
import fpml.consolidated.credit.event.notification.validation.ObligationDefaultValidator;
import fpml.consolidated.credit.event.notification.validation.exists.ObligationDefaultOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ObligationDefault.class)
public class ObligationDefaultMeta implements RosettaMetaData<ObligationDefault> {

	@Override
	public List<Validator<? super ObligationDefault>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ObligationDefault, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ObligationDefault> validator(ValidatorFactory factory) {
		return factory.<ObligationDefault>create(ObligationDefaultValidator.class);
	}

	@Override
	public Validator<? super ObligationDefault> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ObligationDefault>create(ObligationDefaultTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ObligationDefault> validator() {
		return new ObligationDefaultValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ObligationDefault> typeFormatValidator() {
		return new ObligationDefaultTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ObligationDefault, Set<String>> onlyExistsValidator() {
		return new ObligationDefaultOnlyExistsValidator();
	}
}
