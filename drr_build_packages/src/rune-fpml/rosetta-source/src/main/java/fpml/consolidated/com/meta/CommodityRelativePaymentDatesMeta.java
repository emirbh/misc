package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityRelativePaymentDates;
import fpml.consolidated.com.validation.CommodityRelativePaymentDatesTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityRelativePaymentDatesValidator;
import fpml.consolidated.com.validation.datarule.CommodityRelativePaymentDatesChoice0;
import fpml.consolidated.com.validation.datarule.CommodityRelativePaymentDatesChoice1;
import fpml.consolidated.com.validation.datarule.CommodityRelativePaymentDatesChoice2;
import fpml.consolidated.com.validation.exists.CommodityRelativePaymentDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityRelativePaymentDates.class)
public class CommodityRelativePaymentDatesMeta implements RosettaMetaData<CommodityRelativePaymentDates> {

	@Override
	public List<Validator<? super CommodityRelativePaymentDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityRelativePaymentDates>create(CommodityRelativePaymentDatesChoice0.class),
			factory.<CommodityRelativePaymentDates>create(CommodityRelativePaymentDatesChoice1.class),
			factory.<CommodityRelativePaymentDates>create(CommodityRelativePaymentDatesChoice2.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityRelativePaymentDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityRelativePaymentDates> validator(ValidatorFactory factory) {
		return factory.<CommodityRelativePaymentDates>create(CommodityRelativePaymentDatesValidator.class);
	}

	@Override
	public Validator<? super CommodityRelativePaymentDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityRelativePaymentDates>create(CommodityRelativePaymentDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityRelativePaymentDates> validator() {
		return new CommodityRelativePaymentDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityRelativePaymentDates> typeFormatValidator() {
		return new CommodityRelativePaymentDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityRelativePaymentDates, Set<String>> onlyExistsValidator() {
		return new CommodityRelativePaymentDatesOnlyExistsValidator();
	}
}
