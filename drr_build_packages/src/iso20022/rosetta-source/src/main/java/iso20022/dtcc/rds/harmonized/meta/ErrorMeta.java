package iso20022.dtcc.rds.harmonized.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import iso20022.dtcc.rds.harmonized.validation.ErrorTypeFormatValidator;
import iso20022.dtcc.rds.harmonized.validation.ErrorValidator;
import iso20022.dtcc.rds.harmonized.validation.exists.ErrorOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=iso20022.dtcc.rds.harmonized.Error.class)
public class ErrorMeta implements RosettaMetaData<iso20022.dtcc.rds.harmonized.Error> {

	@Override
	public List<Validator<? super iso20022.dtcc.rds.harmonized.Error>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super iso20022.dtcc.rds.harmonized.Error, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super iso20022.dtcc.rds.harmonized.Error> validator(ValidatorFactory factory) {
		return factory.<iso20022.dtcc.rds.harmonized.Error>create(ErrorValidator.class);
	}

	@Override
	public Validator<? super iso20022.dtcc.rds.harmonized.Error> typeFormatValidator(ValidatorFactory factory) {
		return factory.<iso20022.dtcc.rds.harmonized.Error>create(ErrorTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super iso20022.dtcc.rds.harmonized.Error> validator() {
		return new ErrorValidator();
	}

	@Deprecated
	@Override
	public Validator<? super iso20022.dtcc.rds.harmonized.Error> typeFormatValidator() {
		return new ErrorTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super iso20022.dtcc.rds.harmonized.Error, Set<String>> onlyExistsValidator() {
		return new ErrorOnlyExistsValidator();
	}
}
