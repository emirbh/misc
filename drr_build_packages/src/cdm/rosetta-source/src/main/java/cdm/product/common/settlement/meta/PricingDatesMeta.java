package cdm.product.common.settlement.meta;

import cdm.product.common.settlement.PricingDates;
import cdm.product.common.settlement.validation.PricingDatesTypeFormatValidator;
import cdm.product.common.settlement.validation.PricingDatesValidator;
import cdm.product.common.settlement.validation.datarule.PricingDatesOneOf0;
import cdm.product.common.settlement.validation.exists.PricingDatesOnlyExistsValidator;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 6.23.0
 */
@RosettaMeta(model=PricingDates.class)
public class PricingDatesMeta implements RosettaMetaData<PricingDates> {

	@Override
	public List<Validator<? super PricingDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<PricingDates>create(PricingDatesOneOf0.class)
		);
	}
	
	@Override
	public List<Function<? super PricingDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super PricingDates> validator(ValidatorFactory factory) {
		return factory.<PricingDates>create(PricingDatesValidator.class);
	}

	@Override
	public Validator<? super PricingDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<PricingDates>create(PricingDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super PricingDates> validator() {
		return new PricingDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super PricingDates> typeFormatValidator() {
		return new PricingDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingDates, Set<String>> onlyExistsValidator() {
		return new PricingDatesOnlyExistsValidator();
	}
}
