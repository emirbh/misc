package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdeStrikePriceSchedule;
import iso20022.dtcc.rds.harmonized.validation.CdeStrikePriceScheduleTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.CdeStrikePriceScheduleValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.CdeStrikePriceScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CdeStrikePriceSchedule.class)
public class CdeStrikePriceScheduleMeta implements RosettaMetaData<CdeStrikePriceSchedule> {

	@Override
	public List<Validator<? super CdeStrikePriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CdeStrikePriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CdeStrikePriceSchedule> validator(ValidatorFactory factory) {
		return factory.<CdeStrikePriceSchedule>create(CdeStrikePriceScheduleValidator.class);
	}

	@Override
	public Validator<? super CdeStrikePriceSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CdeStrikePriceSchedule>create(CdeStrikePriceScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CdeStrikePriceSchedule> validator() {
		return new CdeStrikePriceScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CdeStrikePriceSchedule> typeFormatValidator() {
		return new CdeStrikePriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CdeStrikePriceSchedule, Set<String>> onlyExistsValidator() {
		return new CdeStrikePriceScheduleOnlyExistsValidator();
	}
}
