package fpml.consolidated.asset.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.asset.CommodityBusinessCalendar;
import fpml.consolidated.asset.validation.CommodityBusinessCalendarTypeFormatValidator;
import fpml.consolidated.asset.validation.CommodityBusinessCalendarValidator;
import fpml.consolidated.asset.validation.exists.CommodityBusinessCalendarOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityBusinessCalendar.class)
public class CommodityBusinessCalendarMeta implements RosettaMetaData<CommodityBusinessCalendar> {

	@Override
	public List<Validator<? super CommodityBusinessCalendar>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CommodityBusinessCalendar, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityBusinessCalendar> validator(ValidatorFactory factory) {
		return factory.<CommodityBusinessCalendar>create(CommodityBusinessCalendarValidator.class);
	}

	@Override
	public Validator<? super CommodityBusinessCalendar> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityBusinessCalendar>create(CommodityBusinessCalendarTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBusinessCalendar> validator() {
		return new CommodityBusinessCalendarValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityBusinessCalendar> typeFormatValidator() {
		return new CommodityBusinessCalendarTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityBusinessCalendar, Set<String>> onlyExistsValidator() {
		return new CommodityBusinessCalendarOnlyExistsValidator();
	}
}
