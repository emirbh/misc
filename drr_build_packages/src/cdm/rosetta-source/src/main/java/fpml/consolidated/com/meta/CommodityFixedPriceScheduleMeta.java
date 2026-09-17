package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityFixedPriceSchedule;
import fpml.consolidated.com.validation.CommodityFixedPriceScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityFixedPriceScheduleValidator;
import fpml.consolidated.com.validation.datarule.CommodityFixedPriceScheduleChoice0;
import fpml.consolidated.com.validation.datarule.CommodityFixedPriceScheduleChoice1;
import fpml.consolidated.com.validation.exists.CommodityFixedPriceScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityFixedPriceSchedule.class)
public class CommodityFixedPriceScheduleMeta implements RosettaMetaData<CommodityFixedPriceSchedule> {

	@Override
	public List<Validator<? super CommodityFixedPriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityFixedPriceSchedule>create(CommodityFixedPriceScheduleChoice0.class),
			factory.<CommodityFixedPriceSchedule>create(CommodityFixedPriceScheduleChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityFixedPriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityFixedPriceSchedule> validator(ValidatorFactory factory) {
		return factory.<CommodityFixedPriceSchedule>create(CommodityFixedPriceScheduleValidator.class);
	}

	@Override
	public Validator<? super CommodityFixedPriceSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityFixedPriceSchedule>create(CommodityFixedPriceScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFixedPriceSchedule> validator() {
		return new CommodityFixedPriceScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityFixedPriceSchedule> typeFormatValidator() {
		return new CommodityFixedPriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityFixedPriceSchedule, Set<String>> onlyExistsValidator() {
		return new CommodityFixedPriceScheduleOnlyExistsValidator();
	}
}
