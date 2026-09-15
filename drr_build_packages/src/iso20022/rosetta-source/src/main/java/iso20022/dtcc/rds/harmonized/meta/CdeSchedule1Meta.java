package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.CdeSchedule1;
import iso20022.dtcc.rds.harmonized.validation.CdeSchedule1TypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.CdeSchedule1Validator;
import iso20022.dtcc.rds.harmonized.validation.exists.CdeSchedule1OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CdeSchedule1.class)
public class CdeSchedule1Meta implements RosettaMetaData<CdeSchedule1> {

	@Override
	public List<Validator<? super CdeSchedule1>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CdeSchedule1, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CdeSchedule1> validator(ValidatorFactory factory) {
		return factory.<CdeSchedule1>create(CdeSchedule1Validator.class);
	}

	@Override
	public Validator<? super CdeSchedule1> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CdeSchedule1>create(CdeSchedule1TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CdeSchedule1> validator() {
		return new CdeSchedule1Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CdeSchedule1> typeFormatValidator() {
		return new CdeSchedule1TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CdeSchedule1, Set<String>> onlyExistsValidator() {
		return new CdeSchedule1OnlyExistsValidator();
	}
}
