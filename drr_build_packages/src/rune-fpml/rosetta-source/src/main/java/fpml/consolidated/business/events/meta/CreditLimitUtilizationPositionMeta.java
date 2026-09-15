package fpml.consolidated.business.events.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.business.events.CreditLimitUtilizationPosition;
import fpml.consolidated.business.events.validation.CreditLimitUtilizationPositionTypeFormatValidator;
import fpml.consolidated.business.events.validation.CreditLimitUtilizationPositionValidator;
import fpml.consolidated.business.events.validation.datarule.CreditLimitUtilizationPositionChoice;
import fpml.consolidated.business.events.validation.exists.CreditLimitUtilizationPositionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CreditLimitUtilizationPosition.class)
public class CreditLimitUtilizationPositionMeta implements RosettaMetaData<CreditLimitUtilizationPosition> {

	@Override
	public List<Validator<? super CreditLimitUtilizationPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CreditLimitUtilizationPosition>create(CreditLimitUtilizationPositionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CreditLimitUtilizationPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CreditLimitUtilizationPosition> validator(ValidatorFactory factory) {
		return factory.<CreditLimitUtilizationPosition>create(CreditLimitUtilizationPositionValidator.class);
	}

	@Override
	public Validator<? super CreditLimitUtilizationPosition> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CreditLimitUtilizationPosition>create(CreditLimitUtilizationPositionTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitUtilizationPosition> validator() {
		return new CreditLimitUtilizationPositionValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CreditLimitUtilizationPosition> typeFormatValidator() {
		return new CreditLimitUtilizationPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CreditLimitUtilizationPosition, Set<String>> onlyExistsValidator() {
		return new CreditLimitUtilizationPositionOnlyExistsValidator();
	}
}
