package drr.regulation.jfsa.rewrite.valuation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.jfsa.rewrite.valuation.JFSAValuationReport;
import drr.regulation.jfsa.rewrite.valuation.validation.JFSAValuationReportTypeFormatValidator;
import drr.regulation.jfsa.rewrite.valuation.validation.JFSAValuationReportValidator;
import drr.regulation.jfsa.rewrite.valuation.validation.datarule.JFSAValuationReportDTCC_JFSA_VR_0004_01;
import drr.regulation.jfsa.rewrite.valuation.validation.datarule.JFSAValuationReportDTCC_JFSA_VR_0007_01;
import drr.regulation.jfsa.rewrite.valuation.validation.datarule.JFSAValuationReportDTCC_JFSA_VR_0008_01;
import drr.regulation.jfsa.rewrite.valuation.validation.exists.JFSAValuationReportOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=JFSAValuationReport.class)
public class JFSAValuationReportMeta implements RosettaMetaData<JFSAValuationReport> {

	@Override
	public List<Validator<? super JFSAValuationReport>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<JFSAValuationReport>create(JFSAValuationReportDTCC_JFSA_VR_0004_01.class),
			factory.<JFSAValuationReport>create(JFSAValuationReportDTCC_JFSA_VR_0007_01.class),
			factory.<JFSAValuationReport>create(JFSAValuationReportDTCC_JFSA_VR_0008_01.class)
		);
	}
	
	@Override
	public List<Function<? super JFSAValuationReport, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super JFSAValuationReport> validator(ValidatorFactory factory) {
		return factory.<JFSAValuationReport>create(JFSAValuationReportValidator.class);
	}

	@Override
	public Validator<? super JFSAValuationReport> typeFormatValidator(ValidatorFactory factory) {
		return factory.<JFSAValuationReport>create(JFSAValuationReportTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super JFSAValuationReport> validator() {
		return new JFSAValuationReportValidator();
	}

	@Deprecated
	@Override
	public Validator<? super JFSAValuationReport> typeFormatValidator() {
		return new JFSAValuationReportTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super JFSAValuationReport, Set<String>> onlyExistsValidator() {
		return new JFSAValuationReportOnlyExistsValidator();
	}
}
