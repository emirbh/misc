package drr.regulation.fca.ukemir.refit.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.fca.ukemir.refit.trade.FCAUKEMIRNonReportable;
import drr.regulation.fca.ukemir.refit.trade.validation.FCAUKEMIRNonReportableTypeFormatValidator;
import drr.regulation.fca.ukemir.refit.trade.validation.FCAUKEMIRNonReportableValidator;
import drr.regulation.fca.ukemir.refit.trade.validation.exists.FCAUKEMIRNonReportableOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=FCAUKEMIRNonReportable.class)
public class FCAUKEMIRNonReportableMeta implements RosettaMetaData<FCAUKEMIRNonReportable> {

	@Override
	public List<Validator<? super FCAUKEMIRNonReportable>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FCAUKEMIRNonReportable, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FCAUKEMIRNonReportable> validator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRNonReportable>create(FCAUKEMIRNonReportableValidator.class);
	}

	@Override
	public Validator<? super FCAUKEMIRNonReportable> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRNonReportable>create(FCAUKEMIRNonReportableTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRNonReportable> validator() {
		return new FCAUKEMIRNonReportableValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRNonReportable> typeFormatValidator() {
		return new FCAUKEMIRNonReportableTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FCAUKEMIRNonReportable, Set<String>> onlyExistsValidator() {
		return new FCAUKEMIRNonReportableOnlyExistsValidator();
	}
}
