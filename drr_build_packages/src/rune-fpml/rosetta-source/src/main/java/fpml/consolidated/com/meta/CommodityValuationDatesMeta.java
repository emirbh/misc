package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityValuationDates;
import fpml.consolidated.com.validation.CommodityValuationDatesTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityValuationDatesValidator;
import fpml.consolidated.com.validation.datarule.CommodityValuationDatesChoice0;
import fpml.consolidated.com.validation.datarule.CommodityValuationDatesChoice1;
import fpml.consolidated.com.validation.exists.CommodityValuationDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityValuationDates.class)
public class CommodityValuationDatesMeta implements RosettaMetaData<CommodityValuationDates> {

	@Override
	public List<Validator<? super CommodityValuationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityValuationDates>create(CommodityValuationDatesChoice0.class),
			factory.<CommodityValuationDates>create(CommodityValuationDatesChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityValuationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityValuationDates> validator(ValidatorFactory factory) {
		return factory.<CommodityValuationDates>create(CommodityValuationDatesValidator.class);
	}

	@Override
	public Validator<? super CommodityValuationDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityValuationDates>create(CommodityValuationDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityValuationDates> validator() {
		return new CommodityValuationDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityValuationDates> typeFormatValidator() {
		return new CommodityValuationDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityValuationDates, Set<String>> onlyExistsValidator() {
		return new CommodityValuationDatesOnlyExistsValidator();
	}
}
