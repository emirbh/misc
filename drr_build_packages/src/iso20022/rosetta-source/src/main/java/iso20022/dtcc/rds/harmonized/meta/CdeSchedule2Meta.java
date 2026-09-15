package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdeSchedule2;
import iso20022.dtcc.rds.harmonized.validation.CdeSchedule2TypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.CdeSchedule2Validator;
import iso20022.dtcc.rds.harmonized.validation.exists.CdeSchedule2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CdeSchedule2.class)
public class CdeSchedule2Meta implements RosettaMetaData<CdeSchedule2> {

	@Override
	public List<Validator<? super CdeSchedule2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CdeSchedule2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CdeSchedule2> validator(ValidatorFactory factory) {
		return factory.<CdeSchedule2>create(CdeSchedule2Validator.class);
	}

	@Override
	public Validator<? super CdeSchedule2> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CdeSchedule2>create(CdeSchedule2TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CdeSchedule2> validator() {
		return new CdeSchedule2Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CdeSchedule2> typeFormatValidator() {
		return new CdeSchedule2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CdeSchedule2, Set<String>> onlyExistsValidator() {
		return new CdeSchedule2OnlyExistsValidator();
	}
}
