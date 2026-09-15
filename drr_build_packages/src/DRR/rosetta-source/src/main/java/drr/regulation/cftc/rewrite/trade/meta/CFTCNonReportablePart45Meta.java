package drr.regulation.cftc.rewrite.trade.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import drr.regulation.cftc.rewrite.trade.CFTCNonReportablePart45;
import drr.regulation.cftc.rewrite.trade.validation.CFTCNonReportablePart45TypeFormatValidator;
import drr.regulation.cftc.rewrite.trade.validation.CFTCNonReportablePart45Validator;
import drr.regulation.cftc.rewrite.trade.validation.exists.CFTCNonReportablePart45OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 7.7.0
 */
@RosettaMeta(model=CFTCNonReportablePart45.class)
public class CFTCNonReportablePart45Meta implements RosettaMetaData<CFTCNonReportablePart45> {

	@Override
	public List<Validator<? super CFTCNonReportablePart45>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CFTCNonReportablePart45, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super CFTCNonReportablePart45> validator(ValidatorFactory factory) {
		return factory.<CFTCNonReportablePart45>create(CFTCNonReportablePart45Validator.class);
	}

	@Override
	public Validator<? super CFTCNonReportablePart45> typeFormatValidator(ValidatorFactory factory) {
		return factory.<CFTCNonReportablePart45>create(CFTCNonReportablePart45TypeFormatValidator.class);
	}

	@Deprecated
	@Override
	public Validator<? super CFTCNonReportablePart45> validator() {
		return new CFTCNonReportablePart45Validator();
	}

	@Deprecated
	@Override
	public Validator<? super CFTCNonReportablePart45> typeFormatValidator() {
		return new CFTCNonReportablePart45TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CFTCNonReportablePart45, Set<String>> onlyExistsValidator() {
		return new CFTCNonReportablePart45OnlyExistsValidator();
	}
}
