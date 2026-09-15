package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdePriceSchedule;
import iso20022.dtcc.rds.harmonized.validation.CdePriceScheduleTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.CdePriceScheduleValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.CdePriceScheduleOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CdePriceSchedule.class)
public class CdePriceScheduleMeta implements RosettaMetaData<CdePriceSchedule> {

	@Override
	public List<Validator<? super CdePriceSchedule>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CdePriceSchedule, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CdePriceSchedule> validator(ValidatorFactory factory) {
		return factory.<CdePriceSchedule>create(CdePriceScheduleValidator.class);
	}

	@Override
	public Validator<? super CdePriceSchedule> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CdePriceSchedule>create(CdePriceScheduleTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CdePriceSchedule> validator() {
		return new CdePriceScheduleValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CdePriceSchedule> typeFormatValidator() {
		return new CdePriceScheduleTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CdePriceSchedule, Set<String>> onlyExistsValidator() {
		return new CdePriceScheduleOnlyExistsValidator();
	}
}
