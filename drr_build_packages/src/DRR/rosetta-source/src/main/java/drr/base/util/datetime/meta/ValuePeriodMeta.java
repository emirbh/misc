package drr.base.util.datetime.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.util.datetime.ValuePeriod;
import drr.base.util.datetime.validation.ValuePeriodTypeFormatValidator;
import drr.base.util.datetime.validation.ValuePeriodValidator;
import drr.base.util.datetime.validation.exists.ValuePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ValuePeriod.class)
public class ValuePeriodMeta implements RosettaMetaData<ValuePeriod> {

	@Override
	public List<Validator<? super ValuePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ValuePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ValuePeriod> validator(ValidatorFactory factory) {
		return factory.<ValuePeriod>create(ValuePeriodValidator.class);
	}

	@Override
	public Validator<? super ValuePeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ValuePeriod>create(ValuePeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ValuePeriod> validator() {
		return new ValuePeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ValuePeriod> typeFormatValidator() {
		return new ValuePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ValuePeriod, Set<String>> onlyExistsValidator() {
		return new ValuePeriodOnlyExistsValidator();
	}
}
