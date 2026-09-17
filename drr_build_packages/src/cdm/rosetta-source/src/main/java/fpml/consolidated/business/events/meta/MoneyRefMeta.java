package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.MoneyRef;
import fpml.consolidated.business.events.validation.MoneyRefTypeFormatValidator;
import fpml.consolidated.business.events.validation.MoneyRefValidator;
import fpml.consolidated.business.events.validation.exists.MoneyRefOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=MoneyRef.class)
public class MoneyRefMeta implements RosettaMetaData<MoneyRef> {

	@Override
	public List<Validator<? super MoneyRef>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MoneyRef, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MoneyRef> validator(ValidatorFactory factory) {
		return factory.<MoneyRef>create(MoneyRefValidator.class);
	}

	@Override
	public Validator<? super MoneyRef> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MoneyRef>create(MoneyRefTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MoneyRef> validator() {
		return new MoneyRefValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MoneyRef> typeFormatValidator() {
		return new MoneyRefTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MoneyRef, Set<String>> onlyExistsValidator() {
		return new MoneyRefOnlyExistsValidator();
	}
}
