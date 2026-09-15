package drr.regulation.fca.ukemir.refit.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.fca.ukemir.refit.valuation.FCAValuationReport;
import drr.regulation.fca.ukemir.refit.valuation.validation.FCAValuationReportTypeFormatValidator;
import drr.regulation.fca.ukemir.refit.valuation.validation.FCAValuationReportValidator;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1001_05;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1002_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1002_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1002_04;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1003_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1003_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1003_05;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1004_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1004_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1004_04;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1004_05;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1008_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1008_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1009_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1009_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1009_04;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1009_06;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_1009_08;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2001_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2022_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2022_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2022_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2023_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2023_04;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2023_06;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2023_07;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2024_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2025_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2025_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2151_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2151_02;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2151_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2151_04;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2151_05;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2153_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2153_04;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2154_01;
import drr.regulation.fca.ukemir.refit.valuation.validation.datarule.FCAValuationReportUKEMIR_VR_2154_03;
import drr.regulation.fca.ukemir.refit.valuation.validation.exists.FCAValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=FCAValuationReport.class)
public class FCAValuationReportMeta implements RosettaMetaData<FCAValuationReport> {

	@Override
	public List<Validator<? super FCAValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1001_05.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1002_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1002_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1002_04.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1003_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1003_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1003_05.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1004_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1004_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1004_04.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1004_05.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1008_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1008_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1009_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1009_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1009_04.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1009_06.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_1009_08.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2001_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2022_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2022_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2022_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2023_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2023_04.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2023_06.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2023_07.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2024_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2025_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2025_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2151_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2151_02.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2151_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2151_04.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2151_05.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2153_03.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2153_04.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2154_01.class),
			factory.<FCAValuationReport>create(FCAValuationReportUKEMIR_VR_2154_03.class)
		);
	}
	
	@Override
	public List<Function<? super FCAValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super FCAValuationReport> validator(ValidatorFactory factory) {
		return factory.<FCAValuationReport>create(FCAValuationReportValidator.class);
	}

	@Override
	public Validator<? super FCAValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<FCAValuationReport>create(FCAValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super FCAValuationReport> validator() {
		return new FCAValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super FCAValuationReport> typeFormatValidator() {
		return new FCAValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FCAValuationReport, Set<String>> onlyExistsValidator() {
		return new FCAValuationReportOnlyExistsValidator();
	}
}
