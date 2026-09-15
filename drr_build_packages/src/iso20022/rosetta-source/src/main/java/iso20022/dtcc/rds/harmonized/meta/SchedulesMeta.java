package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.Schedules;
import iso20022.dtcc.rds.harmonized.validation.SchedulesTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.SchedulesValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.SchedulesOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Schedules.class)
public class SchedulesMeta implements RosettaMetaData<Schedules> {

	@Override
	public List<Validator<? super Schedules>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Schedules, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Schedules> validator(ValidatorFactory factory) {
		return factory.<Schedules>create(SchedulesValidator.class);
	}

	@Override
	public Validator<? super Schedules> typeFormatValidator(ValidatorFactory factory) {
		return factory.<Schedules>create(SchedulesTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super Schedules> validator() {
		return new SchedulesValidator();
	}

	@Deprecated
	@Override
	public Validator<? super Schedules> typeFormatValidator() {
		return new SchedulesTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Schedules, Set<String>> onlyExistsValidator() {
		return new SchedulesOnlyExistsValidator();
	}
}
