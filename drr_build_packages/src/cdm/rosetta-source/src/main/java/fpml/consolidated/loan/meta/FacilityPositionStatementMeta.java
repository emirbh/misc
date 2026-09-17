package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityPositionStatement;
import fpml.consolidated.loan.validation.FacilityPositionStatementTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityPositionStatementValidator;
import fpml.consolidated.loan.validation.datarule.FacilityPositionStatementChoice0;
import fpml.consolidated.loan.validation.datarule.FacilityPositionStatementChoice1;
import fpml.consolidated.loan.validation.exists.FacilityPositionStatementOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityPositionStatement.class)
public class FacilityPositionStatementMeta implements RosettaMetaData<FacilityPositionStatement> {

	@Override
	public List<Validator<? super FacilityPositionStatement>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityPositionStatement>create(FacilityPositionStatementChoice0.class),
			factory.<FacilityPositionStatement>create(FacilityPositionStatementChoice1.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityPositionStatement, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityPositionStatement> validator(ValidatorFactory factory) {
		return factory.<FacilityPositionStatement>create(FacilityPositionStatementValidator.class);
	}

	@Override
	public Validator<? super FacilityPositionStatement> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityPositionStatement>create(FacilityPositionStatementTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPositionStatement> validator() {
		return new FacilityPositionStatementValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPositionStatement> typeFormatValidator() {
		return new FacilityPositionStatementTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityPositionStatement, Set<String>> onlyExistsValidator() {
		return new FacilityPositionStatementOnlyExistsValidator();
	}
}
