package fpml.consolidated.loan.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.loan.CovenantObligationIdentifier;
import fpml.consolidated.loan.CovenantObligationSummary;
import fpml.consolidated.loan.validation.CovenantObligationSummaryTypeFormatValidator;
import fpml.consolidated.loan.validation.CovenantObligationSummaryValidator;
import fpml.consolidated.loan.validation.datarule.CovenantObligationIdentifierChoice;
import fpml.consolidated.loan.validation.exists.CovenantObligationSummaryOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=CovenantObligationSummary.class)
public class CovenantObligationSummaryMeta implements RosettaMetaData<CovenantObligationSummary> {

	@Override
	public List<Validator<? super CovenantObligationSummary>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<CovenantObligationIdentifier>create(CovenantObligationIdentifierChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CovenantObligationSummary, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CovenantObligationSummary> validator(ValidatorFactory factory) {
		return factory.<CovenantObligationSummary>create(CovenantObligationSummaryValidator.class);
	}

	@Override
	public Validator<? super CovenantObligationSummary> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CovenantObligationSummary>create(CovenantObligationSummaryTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CovenantObligationSummary> validator() {
		return new CovenantObligationSummaryValidator();
	}

	@Deprecated
	@Override
	public Validator<? super CovenantObligationSummary> typeFormatValidator() {
		return new CovenantObligationSummaryTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CovenantObligationSummary, Set<String>> onlyExistsValidator() {
		return new CovenantObligationSummaryOnlyExistsValidator();
	}
}
