package drr.regulation.mas.rewrite.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.mas.rewrite.margin.MASMarginReport;
import drr.regulation.mas.rewrite.margin.validation.MASMarginReportTypeFormatValidator;
import drr.regulation.mas.rewrite.margin.validation.MASMarginReportValidator;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0001_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0001a_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0002_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0010_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0050_03;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0058_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0058_04;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0059_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0060_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0061_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0061_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0062_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0063_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0064_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0064_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0065_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0066_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0067_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0067_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0068_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0069_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0070_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0070_02;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0071_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0072_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0073_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0074_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0132_01;
import drr.regulation.mas.rewrite.margin.validation.datarule.MASMarginReportDTCC_MAS_BR_0134_03;
import drr.regulation.mas.rewrite.margin.validation.exists.MASMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=MASMarginReport.class)
public class MASMarginReportMeta implements RosettaMetaData<MASMarginReport> {

	@Override
	public List<Validator<? super MASMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0001_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0002_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0010_02.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0050_03.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0058_02.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0058_04.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0059_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0060_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0061_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0061_02.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0062_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0063_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0064_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0064_02.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0065_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0066_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0067_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0067_02.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0068_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0069_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0070_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0070_02.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0071_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0072_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0073_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0074_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0132_01.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0134_03.class),
			factory.<MASMarginReport>create(MASMarginReportDTCC_MAS_BR_0001a_02.class)
		);
	}
	
	@Override
	public List<Function<? super MASMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super MASMarginReport> validator(ValidatorFactory factory) {
		return factory.<MASMarginReport>create(MASMarginReportValidator.class);
	}

	@Override
	public Validator<? super MASMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<MASMarginReport>create(MASMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super MASMarginReport> validator() {
		return new MASMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super MASMarginReport> typeFormatValidator() {
		return new MASMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MASMarginReport, Set<String>> onlyExistsValidator() {
		return new MASMarginReportOnlyExistsValidator();
	}
}
