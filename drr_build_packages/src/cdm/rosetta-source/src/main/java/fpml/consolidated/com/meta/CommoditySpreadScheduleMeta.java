package fpml.consolidated.com.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.com.CommoditySpreadSchedule;
import fpml.consolidated.com.validation.CommoditySpreadScheduleTypeFormatValidator;
import fpml.consolidated.com.validation.CommoditySpreadScheduleValidator;
import fpml.consolidated.com.validation.datarule.CommoditySpreadScheduleChoice;
import fpml.consolidated.com.validation.exists.CommoditySpreadScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CommoditySpreadSchedule.class)
public class CommoditySpreadScheduleMeta implements RosettaMetaData<CommoditySpreadSchedule> {

	@Override
	public List<Validator<? super CommoditySpreadSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CommoditySpreadSchedule>create(CommoditySpreadScheduleChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CommoditySpreadSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CommoditySpreadSchedule> validator(ValidatorFactory factory) {
		return factory.<CommoditySpreadSchedule>create(CommoditySpreadScheduleValidator.class);
	}

	@Override
	public Validator<? super CommoditySpreadSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CommoditySpreadSchedule>create(CommoditySpreadScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySpreadSchedule> validator() {
		return new CommoditySpreadScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CommoditySpreadSchedule> typeFormatValidator() {
		return new CommoditySpreadScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CommoditySpreadSchedule, Set<String>> onlyExistsValidator() {
		return new CommoditySpreadScheduleOnlyExistsValidator();
	}
}
