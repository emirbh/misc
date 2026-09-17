package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditEventType;
import fpml.consolidated.business.events.validation.CreditEventTypeTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditEventTypeValidator;
import fpml.consolidated.business.events.validation.exists.CreditEventTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditEventType.class)
public class CreditEventTypeMeta implements RosettaMetaData<CreditEventType> {

	@Override
	public List<Validator<? super CreditEventType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CreditEventType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditEventType> validator(ValidatorFactory factory) {
		return factory.<CreditEventType>create(CreditEventTypeValidator.class);
	}

	@Override
	public Validator<? super CreditEventType> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditEventType>create(CreditEventTypeTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventType> validator() {
		return new CreditEventTypeValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditEventType> typeFormatValidator() {
		return new CreditEventTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditEventType, Set<String>> onlyExistsValidator() {
		return new CreditEventTypeOnlyExistsValidator();
	}
}
