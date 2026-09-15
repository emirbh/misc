package drr.regulation.jfsa.rewrite.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.jfsa.rewrite.margin.JFSAMarginReport;
import drr.regulation.jfsa.rewrite.margin.validation.JFSAMarginReportTypeFormatValidator;
import drr.regulation.jfsa.rewrite.margin.validation.JFSAMarginReportValidator;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0004_03;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0007_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0008_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0025_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0045_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0046_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0047_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0048_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0049_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0050_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0051_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0052_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0053_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0054_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0055_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0056_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0057_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0058_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0059_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0060_01;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0062_02;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0063_03;
import drr.regulation.jfsa.rewrite.margin.validation.datarule.JFSAMarginReportDTCC_JFSA_BR_0104_04;
import drr.regulation.jfsa.rewrite.margin.validation.exists.JFSAMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=JFSAMarginReport.class)
public class JFSAMarginReportMeta implements RosettaMetaData<JFSAMarginReport> {

	@Override
	public List<Validator<? super JFSAMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0004_03.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0007_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0008_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0025_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0045_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0046_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0047_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0048_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0049_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0050_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0051_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0052_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0053_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0054_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0055_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0056_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0057_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0058_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0059_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0060_01.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0062_02.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0063_03.class),
			factory.<JFSAMarginReport>create(JFSAMarginReportDTCC_JFSA_BR_0104_04.class)
		);
	}
	
	@Override
	public List<Function<? super JFSAMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super JFSAMarginReport> validator(ValidatorFactory factory) {
		return factory.<JFSAMarginReport>create(JFSAMarginReportValidator.class);
	}

	@Override
	public Validator<? super JFSAMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<JFSAMarginReport>create(JFSAMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super JFSAMarginReport> validator() {
		return new JFSAMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super JFSAMarginReport> typeFormatValidator() {
		return new JFSAMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super JFSAMarginReport, Set<String>> onlyExistsValidator() {
		return new JFSAMarginReportOnlyExistsValidator();
	}
}
