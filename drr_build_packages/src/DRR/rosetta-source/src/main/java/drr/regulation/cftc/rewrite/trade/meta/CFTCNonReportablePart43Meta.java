package drr.regulation.cftc.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart43;
import drr.regulation.cftc.rewrite.trade.validation.CFTCNonReportablePart43TypeFormatValidator;
import drr.regulation.cftc.rewrite.trade.validation.CFTCNonReportablePart43Validator;
import drr.regulation.cftc.rewrite.trade.validation.exists.CFTCNonReportablePart43OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCNonReportablePart43.class)
public class CFTCNonReportablePart43Meta implements RosettaMetaData<CFTCNonReportablePart43> {

	@Override
	public List<Validator<? super CFTCNonReportablePart43>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CFTCNonReportablePart43, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCNonReportablePart43> validator(ValidatorFactory factory) {
		return factory.<CFTCNonReportablePart43>create(CFTCNonReportablePart43Validator.class);
	}

	@Override
	public Validator<? super CFTCNonReportablePart43> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCNonReportablePart43>create(CFTCNonReportablePart43TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCNonReportablePart43> validator() {
		return new CFTCNonReportablePart43Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCNonReportablePart43> typeFormatValidator() {
		return new CFTCNonReportablePart43TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCNonReportablePart43, Set<String>> onlyExistsValidator() {
		return new CFTCNonReportablePart43OnlyExistsValidator();
	}
}
