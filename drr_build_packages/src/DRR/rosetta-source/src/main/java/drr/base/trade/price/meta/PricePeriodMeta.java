package drr.base.trade.price.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.base.trade.price.PricePeriod;
import drr.base.trade.price.validation.PricePeriodTypeFormatValidator;
import drr.base.trade.price.validation.PricePeriodValidator;
import drr.base.trade.price.validation.exists.PricePeriodOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=PricePeriod.class)
public class PricePeriodMeta implements RosettaMetaData<PricePeriod> {

	@Override
	public List<Validator<? super PricePeriod>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricePeriod, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricePeriod> validator(ValidatorFactory factory) {
		return factory.<PricePeriod>create(PricePeriodValidator.class);
	}

	@Override
	public Validator<? super PricePeriod> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricePeriod>create(PricePeriodTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricePeriod> validator() {
		return new PricePeriodValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricePeriod> typeFormatValidator() {
		return new PricePeriodTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricePeriod, Set<String>> onlyExistsValidator() {
		return new PricePeriodOnlyExistsValidator();
	}
}
