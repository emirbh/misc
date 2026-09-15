package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.BasketChange;
import fpml.consolidated.business.events.validation.BasketChangeTypeFormatValidator;
import fpml.consolidated.business.events.validation.BasketChangeValidator;
import fpml.consolidated.business.events.validation.exists.BasketChangeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=BasketChange.class)
public class BasketChangeMeta implements RosettaMetaData<BasketChange> {

	@Override
	public List<Validator<? super BasketChange>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasketChange, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super BasketChange> validator(ValidatorFactory factory) {
		return factory.<BasketChange>create(BasketChangeValidator.class);
	}

	@Override
	public Validator<? super BasketChange> typeFormatValidator(ValidatorFactory factory) {
		return factory.<BasketChange>create(BasketChangeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super BasketChange> validator() {
		return new BasketChangeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super BasketChange> typeFormatValidator() {
		return new BasketChangeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketChange, Set<String>> onlyExistsValidator() {
		return new BasketChangeOnlyExistsValidator();
	}
}
