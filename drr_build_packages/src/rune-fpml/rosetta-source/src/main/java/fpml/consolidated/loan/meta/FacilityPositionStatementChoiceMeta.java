package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.FacilityPositionStatementChoice;
import fpml.consolidated.loan.validation.FacilityPositionStatementChoiceTypeFormatValidator;
import fpml.consolidated.loan.validation.FacilityPositionStatementChoiceValidator;
import fpml.consolidated.loan.validation.datarule.FacilityPositionStatementChoiceChoice;
import fpml.consolidated.loan.validation.exists.FacilityPositionStatementChoiceOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=FacilityPositionStatementChoice.class)
public class FacilityPositionStatementChoiceMeta implements RosettaMetaData<FacilityPositionStatementChoice> {

	@Override
	public List<Validator<? super FacilityPositionStatementChoice>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FacilityPositionStatementChoice>create(FacilityPositionStatementChoiceChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FacilityPositionStatementChoice, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FacilityPositionStatementChoice> validator(ValidatorFactory factory) {
		return factory.<FacilityPositionStatementChoice>create(FacilityPositionStatementChoiceValidator.class);
	}

	@Override
	public Validator<? super FacilityPositionStatementChoice> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FacilityPositionStatementChoice>create(FacilityPositionStatementChoiceTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPositionStatementChoice> validator() {
		return new FacilityPositionStatementChoiceValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FacilityPositionStatementChoice> typeFormatValidator() {
		return new FacilityPositionStatementChoiceTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityPositionStatementChoice, Set<String>> onlyExistsValidator() {
		return new FacilityPositionStatementChoiceOnlyExistsValidator();
	}
}
