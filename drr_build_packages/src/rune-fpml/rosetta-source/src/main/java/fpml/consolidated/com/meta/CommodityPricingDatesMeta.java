package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityPricingDates;
import fpml.consolidated.com.validation.CommodityPricingDatesTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityPricingDatesValidator;
import fpml.consolidated.com.validation.datarule.CommodityPricingDatesChoice0;
import fpml.consolidated.com.validation.datarule.CommodityPricingDatesChoice1;
import fpml.consolidated.com.validation.exists.CommodityPricingDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityPricingDates.class)
public class CommodityPricingDatesMeta implements RosettaMetaData<CommodityPricingDates> {

	@Override
	public List<Validator<? super CommodityPricingDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityPricingDates>create(CommodityPricingDatesChoice0.class),
			factory.<CommodityPricingDates>create(CommodityPricingDatesChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityPricingDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityPricingDates> validator(ValidatorFactory factory) {
		return factory.<CommodityPricingDates>create(CommodityPricingDatesValidator.class);
	}

	@Override
	public Validator<? super CommodityPricingDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityPricingDates>create(CommodityPricingDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPricingDates> validator() {
		return new CommodityPricingDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityPricingDates> typeFormatValidator() {
		return new CommodityPricingDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityPricingDates, Set<String>> onlyExistsValidator() {
		return new CommodityPricingDatesOnlyExistsValidator();
	}
}
