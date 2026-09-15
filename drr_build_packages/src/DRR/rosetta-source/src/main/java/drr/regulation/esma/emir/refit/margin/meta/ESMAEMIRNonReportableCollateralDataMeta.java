package drr.regulation.esma.emir.refit.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.esma.emir.refit.margin.ESMAEMIRNonReportableCollateralData;
import drr.regulation.esma.emir.refit.margin.validation.ESMAEMIRNonReportableCollateralDataTypeFormatValidator;
import drr.regulation.esma.emir.refit.margin.validation.ESMAEMIRNonReportableCollateralDataValidator;
import drr.regulation.esma.emir.refit.margin.validation.exists.ESMAEMIRNonReportableCollateralDataOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ESMAEMIRNonReportableCollateralData.class)
public class ESMAEMIRNonReportableCollateralDataMeta implements RosettaMetaData<ESMAEMIRNonReportableCollateralData> {

	@Override
	public List<Validator<? super ESMAEMIRNonReportableCollateralData>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ESMAEMIRNonReportableCollateralData, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMAEMIRNonReportableCollateralData> validator(ValidatorFactory factory) {
		return factory.<ESMAEMIRNonReportableCollateralData>create(ESMAEMIRNonReportableCollateralDataValidator.class);
	}

	@Override
	public Validator<? super ESMAEMIRNonReportableCollateralData> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMAEMIRNonReportableCollateralData>create(ESMAEMIRNonReportableCollateralDataTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMAEMIRNonReportableCollateralData> validator() {
		return new ESMAEMIRNonReportableCollateralDataValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMAEMIRNonReportableCollateralData> typeFormatValidator() {
		return new ESMAEMIRNonReportableCollateralDataTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMAEMIRNonReportableCollateralData, Set<String>> onlyExistsValidator() {
		return new ESMAEMIRNonReportableCollateralDataOnlyExistsValidator();
	}
}
