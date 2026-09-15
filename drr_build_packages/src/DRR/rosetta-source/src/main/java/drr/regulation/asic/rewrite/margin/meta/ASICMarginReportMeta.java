package drr.regulation.asic.rewrite.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.asic.rewrite.margin.ASICMarginReport;
import drr.regulation.asic.rewrite.margin.validation.ASICMarginReportTypeFormatValidator;
import drr.regulation.asic.rewrite.margin.validation.ASICMarginReportValidator;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_0013_02;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_1006_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_1007_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3001_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3006_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3009_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3010_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3010_02;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3011_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3011_02;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3012_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3013_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3014_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3014_02;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3015_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3016_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3017_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3017_02;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3018_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3019_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3020_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3021_01;
import drr.regulation.asic.rewrite.margin.validation.datarule.ASICMarginReportDTCC_ASIC_BR_3023_01;
import drr.regulation.asic.rewrite.margin.validation.exists.ASICMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=ASICMarginReport.class)
public class ASICMarginReportMeta implements RosettaMetaData<ASICMarginReport> {

	@Override
	public List<Validator<? super ASICMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_1006_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_1007_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3001_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3006_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3009_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3010_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3010_02.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3011_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3011_02.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3012_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3013_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3014_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3014_02.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3015_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3016_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3017_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3017_02.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3018_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3019_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3020_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3021_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_3023_01.class),
			factory.<ASICMarginReport>create(ASICMarginReportDTCC_ASIC_BR_0013_02.class)
		);
	}
	
	@Override
	public List<Function<? super ASICMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ASICMarginReport> validator(ValidatorFactory factory) {
		return factory.<ASICMarginReport>create(ASICMarginReportValidator.class);
	}

	@Override
	public Validator<? super ASICMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ASICMarginReport>create(ASICMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ASICMarginReport> validator() {
		return new ASICMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ASICMarginReport> typeFormatValidator() {
		return new ASICMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ASICMarginReport, Set<String>> onlyExistsValidator() {
		return new ASICMarginReportOnlyExistsValidator();
	}
}
