package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityNotionalQuantitySchedule;
import fpml.consolidated.com.validation.CommodityNotionalQuantityScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityNotionalQuantityScheduleValidator;
import fpml.consolidated.com.validation.datarule.CommodityNotionalQuantityScheduleChoice0;
import fpml.consolidated.com.validation.datarule.CommodityNotionalQuantityScheduleChoice1;
import fpml.consolidated.com.validation.exists.CommodityNotionalQuantityScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityNotionalQuantitySchedule.class)
public class CommodityNotionalQuantityScheduleMeta implements RosettaMetaData<CommodityNotionalQuantitySchedule> {

	@Override
	public List<Validator<? super CommodityNotionalQuantitySchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityNotionalQuantitySchedule>create(CommodityNotionalQuantityScheduleChoice0.class),
			factory.<CommodityNotionalQuantitySchedule>create(CommodityNotionalQuantityScheduleChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityNotionalQuantitySchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityNotionalQuantitySchedule> validator(ValidatorFactory factory) {
		return factory.<CommodityNotionalQuantitySchedule>create(CommodityNotionalQuantityScheduleValidator.class);
	}

	@Override
	public Validator<? super CommodityNotionalQuantitySchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityNotionalQuantitySchedule>create(CommodityNotionalQuantityScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityNotionalQuantitySchedule> validator() {
		return new CommodityNotionalQuantityScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityNotionalQuantitySchedule> typeFormatValidator() {
		return new CommodityNotionalQuantityScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityNotionalQuantitySchedule, Set<String>> onlyExistsValidator() {
		return new CommodityNotionalQuantityScheduleOnlyExistsValidator();
	}
}
