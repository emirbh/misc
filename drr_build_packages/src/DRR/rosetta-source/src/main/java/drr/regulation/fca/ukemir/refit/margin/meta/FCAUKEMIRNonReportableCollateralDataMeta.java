package drr.regulation.fca.ukemir.refit.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.fca.ukemir.refit.margin.FCAUKEMIRNonReportableCollateralData;
import drr.regulation.fca.ukemir.refit.margin.validation.FCAUKEMIRNonReportableCollateralDataTypeFormatValidator;
import drr.regulation.fca.ukemir.refit.margin.validation.FCAUKEMIRNonReportableCollateralDataValidator;
import drr.regulation.fca.ukemir.refit.margin.validation.exists.FCAUKEMIRNonReportableCollateralDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=FCAUKEMIRNonReportableCollateralData.class)
public class FCAUKEMIRNonReportableCollateralDataMeta implements RosettaMetaData<FCAUKEMIRNonReportableCollateralData> {

	@Override
	public List<Validator<? super FCAUKEMIRNonReportableCollateralData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FCAUKEMIRNonReportableCollateralData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FCAUKEMIRNonReportableCollateralData> validator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRNonReportableCollateralData>create(FCAUKEMIRNonReportableCollateralDataValidator.class);
	}

	@Override
	public Validator<? super FCAUKEMIRNonReportableCollateralData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FCAUKEMIRNonReportableCollateralData>create(FCAUKEMIRNonReportableCollateralDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRNonReportableCollateralData> validator() {
		return new FCAUKEMIRNonReportableCollateralDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FCAUKEMIRNonReportableCollateralData> typeFormatValidator() {
		return new FCAUKEMIRNonReportableCollateralDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FCAUKEMIRNonReportableCollateralData, Set<String>> onlyExistsValidator() {
		return new FCAUKEMIRNonReportableCollateralDataOnlyExistsValidator();
	}
}
