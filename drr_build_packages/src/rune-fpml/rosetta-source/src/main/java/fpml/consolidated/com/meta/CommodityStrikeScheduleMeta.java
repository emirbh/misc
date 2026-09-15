package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommodityStrikeSchedule;
import fpml.consolidated.com.validation.CommodityStrikeScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommodityStrikeScheduleValidator;
import fpml.consolidated.com.validation.datarule.CommodityStrikeScheduleChoice;
import fpml.consolidated.com.validation.exists.CommodityStrikeScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommodityStrikeSchedule.class)
public class CommodityStrikeScheduleMeta implements RosettaMetaData<CommodityStrikeSchedule> {

	@Override
	public List<Validator<? super CommodityStrikeSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommodityStrikeSchedule>create(CommodityStrikeScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommodityStrikeSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommodityStrikeSchedule> validator(ValidatorFactory factory) {
		return factory.<CommodityStrikeSchedule>create(CommodityStrikeScheduleValidator.class);
	}

	@Override
	public Validator<? super CommodityStrikeSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommodityStrikeSchedule>create(CommodityStrikeScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommodityStrikeSchedule> validator() {
		return new CommodityStrikeScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommodityStrikeSchedule> typeFormatValidator() {
		return new CommodityStrikeScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommodityStrikeSchedule, Set<String>> onlyExistsValidator() {
		return new CommodityStrikeScheduleOnlyExistsValidator();
	}
}
