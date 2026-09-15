package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityStatement;
import fpml.consolidated.loan.validation.FacilityStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityStatementValidator;
import fpml.consolidated.loan.validation.datarule.FacilityStatementChoice;
import fpml.consolidated.loan.validation.exists.FacilityStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityStatement.class)
public class FacilityStatementMeta implements RosettaMetaData<FacilityStatement> {

	@Override
	public List<Validator<? super FacilityStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityStatement>create(FacilityStatementChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityStatement> validator(ValidatorFactory factory) {
		return factory.<FacilityStatement>create(FacilityStatementValidator.class);
	}

	@Override
	public Validator<? super FacilityStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityStatement>create(FacilityStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityStatement> validator() {
		return new FacilityStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityStatement> typeFormatValidator() {
		return new FacilityStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityStatement, Set<String>> onlyExistsValidator() {
		return new FacilityStatementOnlyExistsValidator();
	}
}
