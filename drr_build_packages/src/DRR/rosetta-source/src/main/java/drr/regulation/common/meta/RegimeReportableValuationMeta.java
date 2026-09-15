package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.RegimeReportableValuation;
import drr.regulation.common.validation.RegimeReportableValuationTypeFormatValidator;
import drr.regulation.common.validation.RegimeReportableValuationValidator;
import drr.regulation.common.validation.exists.RegimeReportableValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=RegimeReportableValuation.class)
public class RegimeReportableValuationMeta implements RosettaMetaData<RegimeReportableValuation> {

	@Override
	public List<Validator<? super RegimeReportableValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegimeReportableValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegimeReportableValuation> validator(ValidatorFactory factory) {
		return factory.<RegimeReportableValuation>create(RegimeReportableValuationValidator.class);
	}

	@Override
	public Validator<? super RegimeReportableValuation> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegimeReportableValuation>create(RegimeReportableValuationTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportableValuation> validator() {
		return new RegimeReportableValuationValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportableValuation> typeFormatValidator() {
		return new RegimeReportableValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegimeReportableValuation, Set<String>> onlyExistsValidator() {
		return new RegimeReportableValuationOnlyExistsValidator();
	}
}
