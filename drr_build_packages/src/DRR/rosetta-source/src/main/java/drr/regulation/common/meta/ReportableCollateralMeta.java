package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.ReportableCollateral;
import drr.regulation.common.validation.ReportableCollateralTypeFormatValidator;
import drr.regulation.common.validation.ReportableCollateralValidator;
import drr.regulation.common.validation.exists.ReportableCollateralOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ReportableCollateral.class)
public class ReportableCollateralMeta implements RosettaMetaData<ReportableCollateral> {

	@Override
	public List<Validator<? super ReportableCollateral>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportableCollateral, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportableCollateral> validator(ValidatorFactory factory) {
		return factory.<ReportableCollateral>create(ReportableCollateralValidator.class);
	}

	@Override
	public Validator<? super ReportableCollateral> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportableCollateral>create(ReportableCollateralTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportableCollateral> validator() {
		return new ReportableCollateralValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportableCollateral> typeFormatValidator() {
		return new ReportableCollateralTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportableCollateral, Set<String>> onlyExistsValidator() {
		return new ReportableCollateralOnlyExistsValidator();
	}
}
