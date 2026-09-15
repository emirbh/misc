package drr.base.trade.quantity.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.quantity.NotionalPeriod;
import drr.base.trade.quantity.validation.NotionalPeriodTypeFormatValidator;
import drr.base.trade.quantity.validation.NotionalPeriodValidator;
import drr.base.trade.quantity.validation.exists.NotionalPeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=NotionalPeriod.class)
public class NotionalPeriodMeta implements RosettaMetaData<NotionalPeriod> {

	@Override
	public List<Validator<? super NotionalPeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NotionalPeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super NotionalPeriod> validator(ValidatorFactory factory) {
		return factory.<NotionalPeriod>create(NotionalPeriodValidator.class);
	}

	@Override
	public Validator<? super NotionalPeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<NotionalPeriod>create(NotionalPeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super NotionalPeriod> validator() {
		return new NotionalPeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super NotionalPeriod> typeFormatValidator() {
		return new NotionalPeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NotionalPeriod, Set<String>> onlyExistsValidator() {
		return new NotionalPeriodOnlyExistsValidator();
	}
}
