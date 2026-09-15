package drr.regulation.esma.emir.refit.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.esma.emir.refit.valuation.ESMAValuationReport;
import drr.regulation.esma.emir.refit.valuation.validation.ESMAValuationReportTypeFormatValidator;
import drr.regulation.esma.emir.refit.valuation.validation.ESMAValuationReportValidator;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1001_05;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1002_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1002_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1002_04;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1003_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1003_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1003_05;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1004_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1004_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1004_04;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1004_05;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1008_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1008_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1009_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1009_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1009_04;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1009_06;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_1009_08;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2001_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2022_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2022_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2022_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2023_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2023_04;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2023_06;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2023_07;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2024_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2025_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2025_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2151_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2151_02;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2151_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2151_04;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2151_05;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2153_03;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2153_04;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2154_01;
import drr.regulation.esma.emir.refit.valuation.validation.datarule.ESMAValuationReportEMIR_VR_2154_03;
import drr.regulation.esma.emir.refit.valuation.validation.exists.ESMAValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ESMAValuationReport.class)
public class ESMAValuationReportMeta implements RosettaMetaData<ESMAValuationReport> {

	@Override
	public List<Validator<? super ESMAValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1001_05.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1002_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1002_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1002_04.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1003_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1003_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1003_05.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1004_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1004_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1004_04.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1004_05.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1008_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1008_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1009_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1009_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1009_04.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1009_06.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_1009_08.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2001_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2022_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2022_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2022_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2023_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2023_04.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2023_06.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2023_07.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2024_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2025_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2025_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2151_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2151_02.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2151_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2151_04.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2151_05.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2153_03.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2153_04.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2154_01.class),
			factory.<ESMAValuationReport>create(ESMAValuationReportEMIR_VR_2154_03.class)
		);
	}
	
	@Override
	public List<Function<? super ESMAValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ESMAValuationReport> validator(ValidatorFactory factory) {
		return factory.<ESMAValuationReport>create(ESMAValuationReportValidator.class);
	}

	@Override
	public Validator<? super ESMAValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ESMAValuationReport>create(ESMAValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ESMAValuationReport> validator() {
		return new ESMAValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ESMAValuationReport> typeFormatValidator() {
		return new ESMAValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ESMAValuationReport, Set<String>> onlyExistsValidator() {
		return new ESMAValuationReportOnlyExistsValidator();
	}
}
