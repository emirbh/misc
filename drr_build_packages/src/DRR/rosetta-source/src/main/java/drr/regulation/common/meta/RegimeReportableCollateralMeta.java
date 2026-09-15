package drr.regulation.common.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.common.RegimeReportableCollateral;
import drr.regulation.common.validation.RegimeReportableCollateralTypeFormatValidator;
import drr.regulation.common.validation.RegimeReportableCollateralValidator;
import drr.regulation.common.validation.exists.RegimeReportableCollateralOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=RegimeReportableCollateral.class)
public class RegimeReportableCollateralMeta implements RosettaMetaData<RegimeReportableCollateral> {

	@Override
	public List<Validator<? super RegimeReportableCollateral>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RegimeReportableCollateral, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super RegimeReportableCollateral> validator(ValidatorFactory factory) {
		return factory.<RegimeReportableCollateral>create(RegimeReportableCollateralValidator.class);
	}

	@Override
	public Validator<? super RegimeReportableCollateral> typeFormatValidator(ValidatorFactory factory) {
		return factory.<RegimeReportableCollateral>create(RegimeReportableCollateralTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportableCollateral> validator() {
		return new RegimeReportableCollateralValidator();
	}

	@Deprecated
	@Override
	public Validator<? super RegimeReportableCollateral> typeFormatValidator() {
		return new RegimeReportableCollateralTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RegimeReportableCollateral, Set<String>> onlyExistsValidator() {
		return new RegimeReportableCollateralOnlyExistsValidator();
	}
}
