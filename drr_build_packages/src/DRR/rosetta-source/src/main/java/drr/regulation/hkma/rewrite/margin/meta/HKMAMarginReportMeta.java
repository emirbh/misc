package drr.regulation.hkma.rewrite.margin.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.hkma.rewrite.margin.HKMAMarginReport;
import drr.regulation.hkma.rewrite.margin.validation.HKMAMarginReportTypeFormatValidator;
import drr.regulation.hkma.rewrite.margin.validation.HKMAMarginReportValidator;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0010;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0011;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0016;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0104;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0112_1;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0112_2;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0114;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0115;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0123;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0124;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0127;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0128;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0129;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0130;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0131;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0132;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0133;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0134;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0135;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0136;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0140;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0141;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0142;
import drr.regulation.hkma.rewrite.margin.validation.datarule.HKMAMarginReportDOC0143;
import drr.regulation.hkma.rewrite.margin.validation.exists.HKMAMarginReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=HKMAMarginReport.class)
public class HKMAMarginReportMeta implements RosettaMetaData<HKMAMarginReport> {

	@Override
	public List<Validator<? super HKMAMarginReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0010.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0011.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0016.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0143.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0128.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0129.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0130.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0131.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0132.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0133.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0134.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0135.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0140.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0141.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0104.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0112_1.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0112_2.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0114.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0115.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0136.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0123.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0124.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0142.class),
			factory.<HKMAMarginReport>create(HKMAMarginReportDOC0127.class)
		);
	}
	
	@Override
	public List<Function<? super HKMAMarginReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HKMAMarginReport> validator(ValidatorFactory factory) {
		return factory.<HKMAMarginReport>create(HKMAMarginReportValidator.class);
	}

	@Override
	public Validator<? super HKMAMarginReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HKMAMarginReport>create(HKMAMarginReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HKMAMarginReport> validator() {
		return new HKMAMarginReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HKMAMarginReport> typeFormatValidator() {
		return new HKMAMarginReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HKMAMarginReport, Set<String>> onlyExistsValidator() {
		return new HKMAMarginReportOnlyExistsValidator();
	}
}
