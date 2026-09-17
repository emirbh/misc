package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityRelativeExpirationDates;
import fpml.consolidated.com.validation.CommodityRelativeExpirationDatesTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityRelativeExpirationDatesValidator;
import fpml.consolidated.com.validation.datarule.CommodityRelativeExpirationDatesChoice;
import fpml.consolidated.com.validation.exists.CommodityRelativeExpirationDatesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityRelativeExpirationDates.class)
public class CommodityRelativeExpirationDatesMeta implements RosettaMetaData<CommodityRelativeExpirationDates> {

	@Override
	public List<Validator<? super CommodityRelativeExpirationDates>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityRelativeExpirationDates>create(CommodityRelativeExpirationDatesChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityRelativeExpirationDates, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityRelativeExpirationDates> validator(ValidatorFactory factory) {
		return factory.<CommodityRelativeExpirationDates>create(CommodityRelativeExpirationDatesValidator.class);
	}

	@Override
	public Validator<? super CommodityRelativeExpirationDates> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityRelativeExpirationDates>create(CommodityRelativeExpirationDatesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityRelativeExpirationDates> validator() {
		return new CommodityRelativeExpirationDatesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityRelativeExpirationDates> typeFormatValidator() {
		return new CommodityRelativeExpirationDatesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityRelativeExpirationDates, Set<String>> onlyExistsValidator() {
		return new CommodityRelativeExpirationDatesOnlyExistsValidator();
	}
}
