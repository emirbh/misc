package fpml.consolidated.valuation.fpmlreporting.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.consolidated.valuation.fpmlreporting.ReportContents;
import fpml.consolidated.valuation.fpmlreporting.validation.ReportContentsTypeFormatValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.ReportContentsValidator;
import fpml.consolidated.valuation.fpmlreporting.validation.exists.ReportContentsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 2.1.1
 */
@RosettaMeta(model=ReportContents.class)
public class ReportContentsMeta implements RosettaMetaData<ReportContents> {

	@Override
	public List<Validator<? super ReportContents>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReportContents, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ReportContents> validator(ValidatorFactory factory) {
		return factory.<ReportContents>create(ReportContentsValidator.class);
	}

	@Override
	public Validator<? super ReportContents> typeFormatValidator(ValidatorFactory factory) {
		return factory.<ReportContents>create(ReportContentsTypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super ReportContents> validator() {
		return new ReportContentsValidator();
	}

	@Deprecated
	@Override
	public Validator<? super ReportContents> typeFormatValidator() {
		return new ReportContentsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReportContents, Set<String>> onlyExistsValidator() {
		return new ReportContentsOnlyExistsValidator();
	}
}
