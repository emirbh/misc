package drr.regulation.hkma.rewrite.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.hkma.rewrite.valuation.HKMAValuationReport;
import drr.regulation.hkma.rewrite.valuation.validation.HKMAValuationReportTypeFormatValidator;
import drr.regulation.hkma.rewrite.valuation.validation.HKMAValuationReportValidator;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0010;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0011;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0016;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0039;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0040;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0114;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0115;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0127;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0136;
import drr.regulation.hkma.rewrite.valuation.validation.datarule.HKMAValuationReportDOC0137;
import drr.regulation.hkma.rewrite.valuation.validation.exists.HKMAValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=HKMAValuationReport.class)
public class HKMAValuationReportMeta implements RosettaMetaData<HKMAValuationReport> {

	@Override
	public List<Validator<? super HKMAValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0010.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0011.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0016.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0039.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0040.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0137.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0114.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0115.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0136.class),
			factory.<HKMAValuationReport>create(HKMAValuationReportDOC0127.class)
		);
	}
	
	@Override
	public List<Function<? super HKMAValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super HKMAValuationReport> validator(ValidatorFactory factory) {
		return factory.<HKMAValuationReport>create(HKMAValuationReportValidator.class);
	}

	@Override
	public Validator<? super HKMAValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<HKMAValuationReport>create(HKMAValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super HKMAValuationReport> validator() {
		return new HKMAValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super HKMAValuationReport> typeFormatValidator() {
		return new HKMAValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super HKMAValuationReport, Set<String>> onlyExistsValidator() {
		return new HKMAValuationReportOnlyExistsValidator();
	}
}
